package org.cassproject.general.repository;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;

/**
 * Implementation of a file with methods for communicating with repository services
 *
 * @author devlin.junker@eduworks.com
 * @module com.eduworks.ec
 * @class EcFile
 * @extends GeneralFile
 * @constructor
 */
public class EcFile extends GeneralFile {

	/**
	 * Factory method for creating a file with certain values
	 *
	 * @param {String} name
	 *                 Name of the file to be created
	 * @param {String} base64Data
	 *                 Base 64 encoded file data
	 * @param {String} mimeType
	 *                 MIME Type of the file
	 * @return {EcFile}
	 * The file created
	 * @memberOf EcFile
	 * @method create
	 * @static
	 */
	public static EcFile create(String name, String base64Data, String mimeType) {
		EcFile f = new EcFile();
		f.data = base64Data;
		f.name = name;
		f.mimeType = mimeType;

		return f;
	}

	/**
	 * Retrieves a file from the server specified by it's ID
	 *
	 * @param {String}            id
	 *                            ID of the file data to be retrieved
	 * @param {Callback1<EcFile>} success
	 *                            Callback triggered if successfully retrieved from the server,
	 *                            returns the retrieved file
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error occurs while retrieving file from server
	 * @memberOf EcFile
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<EcFile> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFile f = new EcFile();
				if (p1.isA(EcEncryptedValue.myType)) {
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();

					EcEncryptedValue.encryptOnSave(p1.id, true);
				}
				if (p1 != null && p1.isA(GeneralFile.myType)) {
					f.copyFrom(p1);

					if (success != null)
						success.$invoke(f);
				} else {
					if (failure != null)
						failure.$invoke("Resultant object is not a competency.");
					return;
				}
			}
		}, failure);
	}

	/**
	 * Searches the repository given for files that match the query passed in
	 *
	 * @param {EcRepository}       repo
	 *                             Repository to search for files
	 * @param {String}             query
	 *                             Query to user for search
	 * @param {Callback1<EcFile[]> success
	 *                             Callback triggered after search completes,
	 *                             returns results
	 * @param {Callback1<String>}  failure
	 *                             Callback triggered if error occurs while searching
	 * @param {Object}             paramObj
	 *                             Parameters to pass to search
	 * @param start
	 * @param size
	 * @memberOf EcFile
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcFile>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = "";

		queryAdd = new GeneralFile().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<EcFile> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++) {
						EcFile file = new EcFile();
						if (p1.$get(i).isAny(file.getTypes())) {
							file.copyFrom(p1.$get(i));
						} else if (p1.$get(i).isA(EcEncryptedValue.myType)) {
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if (val.isAnEncrypted(EcFile.myType)) {
								EcRemoteLinkedData obj = val.decryptIntoObject();
								file.copyFrom(obj);
								EcEncryptedValue.encryptOnSave(file.id, true);
							}
						}

						ret.$set(i, file);
					}

					success.$invoke(ret);
				}
			}
		}, failure);
	}

	/**
	 * Saves this file in the repository using the repository web services
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered if successfully saved
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error occurs while saving
	 * @memberOf EcFile
	 * @method save
	 */
	public void save(final Callback1<String> success, Callback1<String> failure) {
		if (this.name == null || this.name == "") {
			String msg = "Competency Name can not be empty";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		EcRepository._save(this, success, failure);
	}

	/**
	 * Deletes the file from the repository using repository web services
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered if successfully deleted
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error occurs while deleting
	 * @memberOf EcFile
	 * @method _delete
	 */
	public void _delete(final Callback1<String> success, final Callback1<String> failure) {
		EcRepository.DELETE(this, success, failure);
	}

}
