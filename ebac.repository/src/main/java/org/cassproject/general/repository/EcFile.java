package org.cassproject.general.repository;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

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
		EcRepository.getAs(id,new EcFile(),success,failure);
	}

	public static EcFile getBlocking(String id) {
		return EcRepository.getBlockingAs(id,new EcFile());
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
	 * @memberOf EcFile
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcFile>> success, Callback1<String> failure, Object paramObj) {
		EcRepository.searchAs(repo, query, new Function0() {
			@Override
			public Object $invoke() {
				return new EcFile();
			}
		},(Callback1<Array>)(Object)success,failure,paramObj);
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
			String msg = "File Name can not be empty";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		EcRepository.save(this, success, failure);
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
	public void _delete(EcRepository repo, final Callback1<String> success, final Callback1<String> failure) {
		repo.DELETE(this, success, failure);
	}

}
