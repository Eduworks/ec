package com.eduworks.schema.question;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;

public class Quiz extends CreativeWork
{
	public static String myType = "http://schema.eduworks.com/0.1/Quiz";

	public Quiz()
	{
		type = "Quiz";
		context = "http://schema.eduworks.com/0.1/";
	}

	public Array<String> question;

	/**
	 * Searches a repository for quizzes that match the search query 
	 * 
	 * @memberOf Quiz
	 * @method search
	 * @static
	 * @param {EcRepository} repo
	 * 			Repository to search using the query
	 * @param {String} query
	 * 			Query string to pass to the search web service
	 * @param {Callback1<Array<Quiz>> success
	 * 			Callback triggered after completing the search, returns the results
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error searching
	 * @param {Object} paramObj
	 * 			Parameter object for search
	 * 		@param start
	 * 		@param size
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<Quiz>> success, Callback1<String> failure, Object paramObj)
	{
		String queryAdd = "";
		queryAdd = new Quiz().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>()
		{
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1)
			{
				if (success != null)
				{
					Array<Quiz> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++)
					{
						Quiz comp = new Quiz();
						if (p1.$get(i).isAny(comp.getTypes()))
						{
							comp.copyFrom(p1.$get(i));
						}
						else if (p1.$get(i).isA(EcEncryptedValue.myType))
						{
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if (val.isAnEncrypted(Quiz.myType))
							{
								EcRemoteLinkedData obj = val.decryptIntoObject();
								comp.copyFrom(obj);
								EcEncryptedValue.encryptOnSave(comp.id, true);
							}
						}
						ret.$set(i, comp);
					}
					success.$invoke(ret);
				}
			}
		}, failure);
	}
}
