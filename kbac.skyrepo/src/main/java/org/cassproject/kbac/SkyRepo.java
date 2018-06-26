package org.cassproject.kbac;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcObject;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.schema.ebac.EbacEncryptedValue;
import com.eduworks.schema.ebac.EbacSignature;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSFunctionAdapter;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.functions.*;

@GlobalScope
public class SkyRepo {
	public static boolean skyrepoDebug = false;

	public static String elasticEndpoint = "http://localhost:9200";

	public static String owner() {
		return "@owner";
	}

	public static String context() {
		return "@context";
	}

	public static String type() {
		return "@type";
	}

	public static String reader() {
		return "@reader";
	}

	public static String id() {
		return "@id";
	}

	public static String signature() {
		return "@signature";
	}

	public static String getTypeFromObject(Object o) {
		String type = (String) JSObjectAdapter.$get(o, "@type");
		String context = (String) JSObjectAdapter.$get(o, "@context");
		if (type == null)
			return null;
		if (type.indexOf("http") != -1)
			return type;
		if (context == null)
			return type;
		if (context.endsWith("/"))
			return context + type;
		else
			return context + "/" + type;
	}

	/**
	 * Validate the signature sheet. Blow up if it is incorrect.
	 *
	 * @return
	 */
	public static Function0<Array<EbacSignature>> signatureSheet = new Function0<Array<EbacSignature>>() {
		@Override
		public Array<EbacSignature> $invoke() {
			Array sigSheet = null;

			//Check cache.
			sigSheet = (Array) JSObjectAdapter.$get(this, "signatureSheet");
			if (sigSheet != null) return sigSheet;
			sigSheet = new Array();

			//Pull signatures from POST.
			Object fromDatastream = JSFunctionAdapter.call(levr.fileFromDatastream, this, "signatureSheet", null);
			String stringFromDatastream = levr.fileToString(fromDatastream);

			if (stringFromDatastream != null)
				try {
					sigSheet = sigSheet.concat((Array) Global.JSON.parse(stringFromDatastream));
				} catch (Exception ex) {
				}

			//Pull signature from headers.
			Object hdrs = JSFunctionAdapter.call(levr.headers, this);
			String camelcaseSignatureSheet = (String) JSObjectAdapter.$get(hdrs, "signatureSheet");
			String lowercaseSignatureSheet = (String) JSObjectAdapter.$get(hdrs, "signaturesheet");

			if (camelcaseSignatureSheet != null)
				sigSheet = sigSheet.concat(Global.JSON.parse(camelcaseSignatureSheet));
			if (lowercaseSignatureSheet != null)
				sigSheet = sigSheet.concat(Global.JSON.parse(lowercaseSignatureSheet));

			for (int i = 0; i < sigSheet.$length(); i++) {
				EbacSignature signature = new EbacSignature();
				signature.copyFrom(sigSheet.$get(i));
				if (signature == null)
					levr.error("Missing Signature.", 496);

				if (getTypeFromObject(sigSheet.$get(i)) != "http://schema.cassproject.org/kbac/0.2/TimeLimitedSignature")
					levr.error("Invalid Signature Version.", 422);

				if (signature.expiry == null)
					levr.error("Missing expiry date.", 422);

				Integer now = levr.date(null, null, true);
				if (signature.expiry < now)
					levr.error("A Signature is Expired. My time is " + now + " and the signature expires at " + signature.expiry, 419);

				String signBytes = signature.signature;
				signature.signature = null;

				if (!EcRsaOaep.verify(EcPk.fromPem(signature.owner), signature.toJson(), signBytes))
					levr.error("Invalid Signature Detected: " + signature.toJson(), 451);
				sigSheet.$set(i, signature);
			}
			JSObjectAdapter.$put(this, "signatureSheet", sigSheet);
			return sigSheet;
		}
	};
	//skyrepo.crypto.rs2 done.
	//skyrepo.security.rs2 start.

	public static Boolean isEncryptedType(EcRemoteLinkedData obj) {
		return obj.isAny(new EbacEncryptedValue().getTypes());
	}

	public static Function1<Object, Object> filterResults = new Function1<Object, Object>() {
		@Override
		public Object $invoke(Object o) {
			if (o == null)
				return o;
			if (EcArray.isArray(o)) {
				Array ary = (Array) o;
				for (int i = 0; i < ary.$length(); i++) {
					Object result = JSFunctionAdapter.call(filterResults, this, ary.$get(i), null);
					if (result == null) {
						ary.splice(i, 1);
						i--;
					} else
						ary.$set(i, result);
				}
				return ary;
			} else if (EcObject.isObject(o)) {
				EcRemoteLinkedData rld = new EcRemoteLinkedData(null, null);
				rld.copyFrom(o);
				if (isEncryptedType(rld)) {
					Array<EbacSignature> signatures = JSFunctionAdapter.call(signatureSheet, this);
					boolean foundSignature = false;
					for (int i = 0; i < signatures.$length(); i++)
						if (rld.toJson().indexOf(signatures.$get(i).owner) != -1) {
							foundSignature = true;
							break;
						}
//                        if (rld.hasOwner(EcPk.fromPem(signatures.$get(i).owner))) {
//                            foundSignature = true;
//                            break;
//                        } else if (rld.hasReader(EcPk.fromPem(signatures.$get(i).owner))) {
//                            foundSignature = true;
//                            break;
//                        }
					if (!foundSignature)
						return null;
				}
				Array<String> keys = EcObject.keys(o);
				for (int i = 0; i < keys.$length(); i++) {
					String key = keys.$get(i);
					JSObjectAdapter.$put(o, key, JSFunctionAdapter.call(filterResults, this, JSObjectAdapter.$get(o, key), null));
				}
				return rld.atIfy();
			} else
				return o;
		}
	};

	//skyrepo.security.rs2 done.
	//going to try to skip skyrepo.type.rs2
	public static String skyrepoUrlType(Object o) {
		return getTypeFromObject(o);
	}

	public static Function0<Object> elasticMapping = new Function0<Object>() {
		@Override
		public Object $invoke() {
			return levr.httpGet(elasticEndpoint + "/_mapping");
		}
	};
	public static Function0<Object> elasticSettings = new Function0<Object>() {
		@Override
		public Object $invoke() {
			return levr.httpGet(elasticEndpoint + "/_settings");
		}
	};

	//skyrepo.type.rs2 done.
	//skyrepo.db.rs2 begin.
	public static String inferTypeFromObj(Object o, String atType) {
		if (atType != null)
			return atType;
		String fullType = skyrepoUrlType(o);
		fullType = fullType.replace("http://", "");
		fullType = fullType.replace("https://", "");
		fullType = fullType.replace("/", ".");
		fullType = fullType.replace("/", ".");
		fullType = fullType.replace("/", ".");
		return fullType;
	}

	private static String inferTypeWithoutObj(String atType) {
		if (atType != null)
			return atType;
		return "_all";
	}

	private static String putUrl(Object o, String id, String version, String type) {
		String typeFromObj = inferTypeFromObj(o, type);

		String versionPart = null;
		if (version == null || version == "")
			versionPart = "?refresh=wait_for";
		else
			versionPart = "?version=" + version + "&version_type=external&refresh=true";

		String url = elasticEndpoint;
		url += "/" + typeFromObj.toLowerCase();
		url += "/" + typeFromObj;
		url += "/" + levr.urlEncode(id) + versionPart;
		if (skyrepoDebug) Global.console.log("Put:" + url);
		return url;
	}

	private static String putPermanentUrl(Object o, String id, String version, String type) {
		String typeFromObj = inferTypeFromObj(o, type);

		String versionPart = null;
		if (version == null || version == "")
			versionPart = "?refresh=true";
		else
			versionPart = "?version=" + version + "&version_type=external&refresh=true";

		String url = elasticEndpoint;
		url += "/permanent";
		url += "/permanent";
		url += "/" + levr.urlEncode(id) + "." + version + versionPart;

		if (skyrepoDebug) Global.console.log("PutPermanent:" + url);
		return url;
	}

	private static String getUrl(String index, String id, String version, String type) {
		String typeFromObj = inferTypeWithoutObj(type);

		String versionPart = null;
		if (version == null || version == "")
			versionPart = "";
		else
			versionPart = "?version=" + version + "&version_type=external";

		String url = elasticEndpoint;
		url += "/" + index;
		if (index == "permanent")
			url += "/permanent";
		else
			url += "/" + typeFromObj;
		if (index == "permanent")
			url += "/" + levr.urlEncode(id) + "." + version;
		else
			url += "/" + levr.urlEncode(id);

		if (skyrepoDebug) Global.console.log("Get:" + url);
		return url;
	}

	private static String deleteUrl(String id, String version, String type) {
		String typeFromObj = inferTypeWithoutObj(type);

		String url = elasticEndpoint;
		url += "/" + typeFromObj.toLowerCase();
		url += "/" + typeFromObj;
		url += "/" + levr.urlEncode(id);
		url += "?refresh=true";

		if (skyrepoDebug) Global.console.log("Delete:" + url);
		return url;
	}

	private static String skyrepoPutInternalTypeCheck(Boolean typeChecked, Object o, String type) {
		//Made private.
		if (typeChecked)
			return null;
		//skyRepoCheckType is used here. Trying to not include that in this version.
		return inferTypeFromObj(o, type);
	}

	public static String skyrepoPutInternalIndex(Object o, String id, String version, String type) {
		//skyrepoPutInternalTypeCheck(false,o,type);

		//TODO: Trim data that isn't relevant before putting it in the index.
		//ex: Fields that are too long (base64)
		//ex: Crypto data
		//TODO: Normalize data that should be normalized.
		//ex: Public keys (@owner, @reader)
		String url = putUrl(o, id, version, type);
		if (skyrepoDebug) Global.console.log(Global.JSON.stringify(o));
		return levr.httpPost(o, url, "application/json", false);
	}

	public static boolean permanentCreated = false;

	public static String skyrepoPutInternalPermanent(Object o, String id, String version, String type) {
		if (permanentCreated != true) {
			Object mappings = new Object();
			Object permNoIndex = new Object();
			Object doc = new Object();
			JSObjectAdapter.$put(mappings, "mappings", permNoIndex);
			JSObjectAdapter.$put(permNoIndex, "permanent", doc);
			JSObjectAdapter.$put(doc, "enabled", false);

			Object result = levr.httpPut(mappings, elasticEndpoint + "/permanent", "application/json");
			if (skyrepoDebug) Global.console.log(Global.JSON.stringify(result));
			//if ((Boolean) JSObjectAdapter.$get(result, "acknowledged") == true)
//            JSObjectAdapter.$put(permanentCreated, type, true);
			permanentCreated = true;
		}
		Object data = new Object();
		JSObjectAdapter.$put(data, "data", Global.JSON.stringify(o));
		String url = putPermanentUrl(o, id, version, type);
		Object out = levr.httpPost(data, url, "application/json", false);
		if (skyrepoDebug) Global.console.log(Global.JSON.stringify(out));
		return Global.JSON.stringify(out);
	}

	public static void skyrepoPutInternal(Object o, String id, String version, String type) {
		Object obj = skyrepoPutInternalIndex(o, id, version, type);
		if (skyrepoDebug) Global.console.log(Global.JSON.stringify(obj));
		version = (String) JSObjectAdapter.$get(obj, "_version");
		skyrepoPutInternalPermanent(o, id, version, type);
	}

	public static void skyRepoPutInternal(Object o, String id, String version, String type) {
		skyrepoPutInternal(o, id, version, type);
	}

	public static Object skyrepoGetIndexInternal(String index, String id, String version, String type) {
		if (skyrepoDebug) Global.console.log("Fetching from " + index + " : " + type + " / " + id + " / " + version);
		Object result = levr.httpGet(getUrl(index, id, version, type));
		return result;
	}

	public static Function3<String, String, String, Object> skyrepoGetIndex = new Function3<String, String, String, Object>() {
		@Override
		public Object $invoke(String id, String version, String type) {
			if (type != null && type != "") {
				Object result = skyrepoGetIndexInternal(type.toLowerCase(), id, version, type);
				return result;
			} else {
				String microSearchUrl = elasticEndpoint + "/_search?version&q=_id:" + id + "";
				Object microSearch = levr.httpGet(microSearchUrl);
				if (skyrepoDebug) Global.console.log(microSearchUrl);
				Object hitshits = JSObjectAdapter.$get(microSearch, "hits");
				Array<Object> hits = (Array<Object>) (Object) JSObjectAdapter.$get(hitshits, "hits");
				if (hits.$length() == 0)
					return null;
				Object hit = hits.$get(0);
				return hit;
			}
		}
	};

	public static Object skyrepoGetPermanent(String id, String version, String type) {
		Object result = skyrepoGetIndexInternal("permanent", id, version, type);
		return result;

	}

	public static Function3<String, String, String, Object> skyrepoGetInternal = new Function3<String, String, String, Object>() {
		@Override
		public Object $invoke(String id, String version, String type) {
			Object versionRetrievalObject = null;
			if (version == null) {
				versionRetrievalObject =
						JSFunctionAdapter.call(skyrepoGetIndex, this, id, version, type, null);
				if (versionRetrievalObject != null)
					version = (String) JSObjectAdapter.$get(versionRetrievalObject, "_version");
				if (versionRetrievalObject != null)
					type = (String) JSObjectAdapter.$get(versionRetrievalObject, "_type");
			}

			if (version == null)
				return null;

			//TODO: Validate inputs
			Object result = skyrepoGetPermanent(id, version, type);
			if (result == null)
				return null;
			if (JSObjectAdapter.$get(result, "error") != null)
				return null;
			if ((Boolean) JSObjectAdapter.$get(result, "found") == true)
				return Global.JSON.parse((String) JSObjectAdapter.$get(JSObjectAdapter.$get(result, "_source"), "data"));

			if (skyrepoDebug)
				Global.console.log("Failed to find " + type + "/" + id + "/" + version + " -- trying degraded form from search index.");

			if (versionRetrievalObject != null)
				result = versionRetrievalObject;
			else
				result = JSFunctionAdapter.call(skyrepoGetIndex, this, id, version, type, null);

			if (result == null)
				return null;
			if (JSObjectAdapter.$get(result, "error") != null)
				return null;
			if ((Boolean) JSObjectAdapter.$get(result, "found") == true || JSObjectAdapter.$get(result, "_source") != null)
				return JSObjectAdapter.$get(result, "_source");
			return null;
		}
	};

	public static Function1<Object, Object> skyrepoGet = new Function1<Object, Object>() {
		@Override
		public Object $invoke(Object parseParams) {
			if (parseParams == null && EcObject.isObject(params.obj))
				parseParams = params.obj;
			if (parseParams == null)
			{
				parseParams = new Object();
				JSObjectAdapter.$put(parseParams,"id",params.id);
				JSObjectAdapter.$put(parseParams,"type",params.type);
				JSObjectAdapter.$put(parseParams,"version",params.version);
			}
			if (skyrepoDebug) Global.console.log(Global.JSON.stringify(parseParams));
			if (skyrepoDebug) Global.console.log(Global.JSON.stringify(params.obj));
			String id = (String) JSObjectAdapter.$get(parseParams, "id");
			String type = (String) JSObjectAdapter.$get(parseParams, "type");
			String version = (String) JSObjectAdapter.$get(parseParams, "version");
			return JSFunctionAdapter.call(skyrepoGetParsed, this, id, version, type, null);
		}
	};

	public static Function3<String, String, String, Object> skyrepoGetParsed = new Function3<String, String, String, Object>() {
		@Override
		public Object $invoke(String id, String version, String type) {
			Object result = JSFunctionAdapter.call(skyrepoGetInternal, this, id, version, type, null);
			if (result == null)
				return null;
			Object filtered = JSFunctionAdapter.call(filterResults, this, result, null);
			if (filtered == null)
				return null;
			if (EcObject.keys(filtered).$length() == 0)
				return null;
			return filtered;
		}
	};

	public static Function1<Object, Object> skyrepoPut = new Function1<Object, Object>() {
		@Override
		public Object $invoke(Object parseParams) {
			if (parseParams == null && params.id != null && params.id != "")
			{
				parseParams = new Object();
				JSObjectAdapter.$put(parseParams,"id",params.id);
				JSObjectAdapter.$put(parseParams,"type",params.type);
				JSObjectAdapter.$put(parseParams,"version",params.version);
				JSObjectAdapter.$put(parseParams,"obj",params.obj);
			}
			if (skyrepoDebug) Global.console.log("put pp:"+Global.JSON.stringify(parseParams));
			if (skyrepoDebug) Global.console.log("put obj:"+Global.JSON.stringify(params.obj));
			if (parseParams == null && EcObject.isObject(params.obj))
				parseParams = params.obj;
			Object obj = (String) JSObjectAdapter.$get(parseParams, "obj");
			if (!EcObject.isObject(obj))
				obj = Global.JSON.parse((String) obj);
			String id = (String) JSObjectAdapter.$get(parseParams, "id");
			String type = (String) JSObjectAdapter.$get(parseParams, "type");
			String version = (String) JSObjectAdapter.$get(parseParams, "version");
			return JSFunctionAdapter.call(skyrepoPutParsed, this, obj, id, version, type, null);
		}
	};

	public static Callback4<Object, String, String, String> skyrepoPutParsed = new Callback4<Object, String, String, String>() {
		@Override
		public void $invoke(Object o, String id, String version, String type) {
			if (o == null)
				return;
			JSFunctionAdapter.call(validateSignatures, this, id, version, type, "Only an owner of an object may change it.");
//		EcRemoteLinkedData d = new EcRemoteLinkedData(null,null);
//		d.copyFrom(o);
//		if (!d.verify())
//			levr.error("Data does not validate. Only validatable data can be saved.",401);
			skyrepoPutInternal(o, id, version, type);
		}
	};

	private static Callback4<String, String, String, String> validateSignatures = new Callback4<String, String, String, String>() {
		@Override
		public void $invoke(String id, String version, String type, String errorMessage) {
			Object oldGet = JSFunctionAdapter.call(skyrepoGetParsed, this, id, version, type, null);
			if (oldGet == null)
				return;

			EcRemoteLinkedData oldObj = new EcRemoteLinkedData(null, null);
			oldObj.copyFrom(oldGet);
			if (oldObj.owner != null && oldObj.owner.$length() > 0) {
				//The old object had an owner. We need to make sure we have a signature sheet for that person.
				Array<EbacSignature> signatures = JSFunctionAdapter.call(signatureSheet, this);
				boolean success = false;
				for (int i = 0; i < signatures.$length(); i++) {
					if (oldObj.hasOwner(EcPk.fromPem(signatures.$get(i).owner))) {
						success = true;
						break;
					}
				}
				//If success is true, we can go ahead. If false, we need to error.
				if (!success)
					levr.error(errorMessage, 401);
			}
		}
	};

	public static String skyrepoDeleteInternalIndex(String id, String version, String type) {
		//TODO: Validate inputs.
		//skyrepoPutInternalTypeCheck(false,o,type);

		String url = deleteUrl(id, version, type);
		return levr.httpDelete(url);
	}

	public static String skyrepoDeleteInternalPermanent(String id, String version, String type) {
		//TODO: Delete the data IFF it has no version (isRegistered).
		return null;
	}

	public static Callback3<String, String, String> skyrepoDelete = new Callback3<String, String, String>() {
		@Override
		public void $invoke(String id, String version, String type) {
			JSFunctionAdapter.call(validateSignatures, this, id, version, type, "Only an owner of an object may delete it.");
			skyrepoDeleteInternalIndex(id, version, type);
			skyrepoDeleteInternalPermanent(id, version, type);
		}
	};

	public static Function5<String, Integer, Integer, String, String, Object> searchObj = new Function5<String, Integer, Integer, String, String, Object>() {
		@Override
		public Object $invoke(String q, Integer start, Integer size, String sort, String track_scores) {
			Object s = new Object();
			if (start != null)
				JSObjectAdapter.$put(s, "from", start);
			if (size != null)
				JSObjectAdapter.$put(s, "size", size);
			if (sort != null)
				JSObjectAdapter.$put(s, "sort", Global.JSON.parse(sort));

			JSObjectAdapter.$put(s, "version", true);

			Object query = new Object();
			JSObjectAdapter.$put(s, "query", query);
			Object bool = new Object();
			JSObjectAdapter.$put(query, "bool", bool);
			Object must = new Object();
			JSObjectAdapter.$put(bool, "must", must);
			Object query_string = new Object();
			JSObjectAdapter.$put(must, "query_string", query_string);

			Array<EbacSignature> signatures = JSFunctionAdapter.call(signatureSheet, this);

			if (signatures.$length() == 0 && q.indexOf("@reader") != -1)
				levr.error("Readers only exist in encrypted data. Please provide signatures to allow access to resources.", null);
			else if (q.indexOf("@reader") != -1)
			{
				if (signatures != null && signatures.$length() > 0) {
					String q2 = "";
					for (int i = 0; i < signatures.$length(); i++) {
						if (i > 0)
							q2 += " OR ";
						q2 += "\"" + signatures.$get(i).owner + "\"";
					}

					q = "("+q+") AND ("+q2+")";
				}
			}

			JSObjectAdapter.$put(query_string, "query", q);

			if (signatures != null && signatures.$length() > 0) {
				String q2 = "";
				for (int i = 0; i < signatures.$length(); i++) {
					if (i > 0)
						q2 += " OR ";
					q2 += "\"" + signatures.$get(i).owner + "\"";
				}

				Object should = new Object();
				JSObjectAdapter.$put(bool, "should", should);
				Object query_string2 = new Object();
				JSObjectAdapter.$put(should, "query_string", query_string2);
				JSObjectAdapter.$put(query_string2, "query", q2);
			}
			return s;
		}
	};

	public static String searchUrl(String urlRemainder) {
		String url = elasticEndpoint;
		if (urlRemainder != null && urlRemainder != "")
			url += urlRemainder;
		else
			url += "/*,-permanent";
		url += "/_search";
		if (skyrepoDebug) Global.console.log(url);
		return url;
	}

	public static Function6<String, String, Integer, Integer, String, String, Array> skyrepoSearch = new Function6<String, String, Integer, Integer, String, String, Array>() {
		@Override
		public Array $invoke(String q, String urlRemainder, Integer start, Integer size, String sort, String track_scores) {
			Object searchParameters =
					JSFunctionAdapter.call(searchObj, this, q, start, size, sort, track_scores);
			if (skyrepoDebug) Global.console.log(Global.JSON.stringify(searchParameters));
			Object results = levr.httpPost(searchParameters,
					searchUrl(urlRemainder),
					"application/json",
					false
			);
			if (skyrepoDebug) Global.console.log(Global.JSON.stringify(results));
			if (JSObjectAdapter.$get(results, "error") != null) {
				Array root_cause = (Array) JSObjectAdapter.$get(JSObjectAdapter.$get(results, "error"), "root_cause");
				if (root_cause.$length() > 0) {
					Object reasonObj = root_cause.$get(0);
					Object reason = JSObjectAdapter.$get(reasonObj, "reason");
					if (reason != null)
						levr.error((String) reason, (Integer) JSObjectAdapter.$get(results, "status"));
				}
			}
			Object hits = JSObjectAdapter.$get(results, "hits");
			hits = JSObjectAdapter.$get(hits, "hits");
			Array<Object> searchResults = (Array<Object>) hits;
			for (int i = 0; i < searchResults.$length(); i++) {
				Object searchResult = searchResults.$get(i);
				String type = inferTypeFromObj(JSObjectAdapter.$get(searchResult, "_source"), null);
				String id = (String) JSObjectAdapter.$get(searchResult, "_id");
				String version = (String) JSObjectAdapter.$get(searchResult, "_version");
				searchResults.$set(i, JSFunctionAdapter.call(skyrepoGetInternal, this, id, version, type, null));
			}
			return (Array) JSFunctionAdapter.call(filterResults, this, searchResults, null);
		}
	};

	//skyrepo.db.rs2 is done.
	//skyrepo.rs2 start.

	public static Function1<String, Object> queryParse = new Function1<String, Object>() {
		@Override
		public Object $invoke(String urlRemainder) {
			if (urlRemainder == null && params.urlRemainder != null)
				urlRemainder = params.urlRemainder;
			if (urlRemainder == null)
				levr.error("No resource specified.", 404);
			Array<String> split = (Array<String>) (Object) urlRemainder.split("/");
			Object result = new Object();
			if (split.$length() >= 2)
				JSObjectAdapter.$put(result, "id", split.$get(1));
			if (split.$length() >= 3) {
				JSObjectAdapter.$put(result, "type", split.$get(1));
				JSObjectAdapter.$put(result, "id", split.$get(2));
			}
			if (split.$length() == 4)
				JSObjectAdapter.$put(result, "version", split.$get(3));
			return result;
		}

	};

	public static Function2<Object, Boolean, String> tryFormatOutput = new Function2<Object, Boolean, String>() {
		@Override
		public String $invoke(Object o, Boolean expand) {
			Object hdrs = JSFunctionAdapter.call(levr.headers, this);
			String accept = (String) JSObjectAdapter.$get(hdrs, "Accept");
			if (accept == null)
				accept = (String) JSObjectAdapter.$get(hdrs, "accept");
			if (accept == null)
				if (expand == true)
					return Global.JSON.stringify(levr.jsonLdExpand(o));
				else
					return Global.JSON.stringify(o);
			if (accept == "text/n4" || accept == "application/rdf+n4")
				return levr.jsonLdToNQuads(o);
			if (accept == "application/rdf+json")
				return levr.jsonLdToRdfJson(o);
			if (accept == "application/rdf+xml")
				return levr.jsonLdToRdfXml(o);
			if (accept == "application/x-turtle" || accept == "text/turtle")
				return levr.jsonLdToTurtle(o);
			return Global.JSON.stringify(o);
		}
	};

	public static Function0 endpointData = new Function0() {
		@Override
		public Object $invoke() {
			String q = params.q;
			String urlRemainder = params.urlRemainder;
			Integer start = 0;
			if (params.start != null)
				start = Global.parseInt(params.start);
			Integer size = 50;
			if (params.size != null)
				size = Global.parseInt(params.size);
			String sort = params.sort;
			String track_scores = params.track_scores;
			Object searchParams = JSFunctionAdapter.call(levr.fileFromDatastream, this, "searchParams", null);
			if (searchParams != null) {
				if (JSObjectAdapter.$get(searchParams, "q") != null)
					q = (String) JSObjectAdapter.$get(searchParams, "q");
				if (JSObjectAdapter.$get(searchParams, "start") != null)
					start = (Integer) JSObjectAdapter.$get(searchParams, "start");
				if (JSObjectAdapter.$get(searchParams, "size") != null)
					size = (Integer) JSObjectAdapter.$get(searchParams, "size");
				if (JSObjectAdapter.$get(searchParams, "sort") != null)
					sort = (String) JSObjectAdapter.$get(searchParams, "sort");
				if (JSObjectAdapter.$get(searchParams, "track_scores") != null)
					track_scores = (String) JSObjectAdapter.$get(searchParams, "track_scores");
			}
			if (size == null) size = 50;
			if (start == null) start = 0;
			if (q != null) {
				JSFunctionAdapter.call(levr.beforeGet, this);
				return Global.JSON.stringify((Object) JSFunctionAdapter.call(skyrepoSearch, this, q, urlRemainder, start, size, sort, track_scores));
			}

			String methodType = params.methodType;
			Object parseParams = JSFunctionAdapter.call(queryParse, this, urlRemainder, null);
			String id = (String) JSObjectAdapter.$get(parseParams, "id");
			String type = (String) JSObjectAdapter.$get(parseParams, "type");
			String version = (String) JSObjectAdapter.$get(parseParams, "version");
			if (methodType == "DELETE") {
				JSFunctionAdapter.call(skyrepoDelete, this, id, version, type);
				JSFunctionAdapter.call(levr.afterSave, this);
				return null;
			} else if (methodType == "POST") {
				Object o = Global.JSON.parse(levr.fileToString(JSFunctionAdapter.call(levr.fileFromDatastream, this, "data", null)));
				if (o == null || o == "") {
					JSFunctionAdapter.call(levr.beforeGet, this);
					o = JSFunctionAdapter.call(skyrepoGetParsed, this, id, version, type, null);
					if (o == null)
						levr.error("Object not found or you did not supply sufficient permissions to access the object.", 404);
					Boolean expand = params.expand != null;
					o = JSFunctionAdapter.call(tryFormatOutput, this, o, expand, null);
					return o;
				}
				JSFunctionAdapter.call(skyrepoPutParsed, this, o, id, version, type);
				JSFunctionAdapter.call(levr.afterSave, this);
				return null;
			} else if (methodType == "GET") {
				JSFunctionAdapter.call(levr.beforeGet, this);
				Object o = JSFunctionAdapter.call(skyrepoGetParsed, this, id, version, type, null);
				if (o == null)
					levr.error("Object not found or you did not supply sufficient permissions to access the object.", 404);
				Boolean expand = params.expand != null;
				o = JSFunctionAdapter.call(tryFormatOutput, this, o, expand, null);
				return o;
			}
			return null;
		}
	};

	public static Function0 endpointMultiGet = new Function0() {
		@Override
		public Object $invoke() {
			Array ary = (Array) Global.JSON.parse(levr.fileToString(JSFunctionAdapter.call(levr.fileFromDatastream, this, "data", null)));
			Array results = new Array();
			if (ary != null) {
				for (int i = 0; i < ary.$length(); i++) {
					String urlRemainder = (String) ary.$get(i);
					Object parseParams = JSFunctionAdapter.call(queryParse, this, urlRemainder, null);
					String id = (String) JSObjectAdapter.$get(parseParams, "id");
					String type = (String) JSObjectAdapter.$get(parseParams, "type");
					String version = (String) JSObjectAdapter.$get(parseParams, "version");
					try {
						Object o = JSFunctionAdapter.call(skyrepoGetParsed, this, id, version, type, null);
						if (o != null)
							results.push(o);
					} catch (Exception ex) {
					}
				}
			}
			return Global.JSON.stringify(results);
		}
	};

	public static Function0 skyRepoSearch = new Function0() {
		@Override
		public Object $invoke() {
			String q = params.q;
			String urlRemainder = params.urlRemainder;
			Integer start = 0;
			if (params.start != null)
				start = Global.parseInt(params.start);
			Integer size = 50;
			if (params.size != null)
				size = Global.parseInt(params.size);
			String sort = params.sort;
			String track_scores = params.track_scores;
			Object searchParams = Global.JSON.parse(levr.fileToString(JSFunctionAdapter.call(levr.fileFromDatastream, this, "searchParams", null)));
			if (searchParams != null) {
				if (JSObjectAdapter.$get(searchParams, "q") != null)
					q = (String) JSObjectAdapter.$get(searchParams, "q");
				if (JSObjectAdapter.$get(searchParams, "start") != null)
					start = (Integer) JSObjectAdapter.$get(searchParams, "start");
				if (JSObjectAdapter.$get(searchParams, "size") != null)
					size = (Integer) JSObjectAdapter.$get(searchParams, "size");
				if (JSObjectAdapter.$get(searchParams, "sort") != null)
					sort = (String) JSObjectAdapter.$get(searchParams, "sort");
				if (JSObjectAdapter.$get(searchParams, "track_scores") != null)
					track_scores = (String) JSObjectAdapter.$get(searchParams, "track_scores");
			}
			String data = levr.fileToString(JSFunctionAdapter.call(levr.fileFromDatastream, this, "data", null));
			if (data != null && data != "")
				q = data;
			if (q == null || q == "")
				q = "*";
			return Global.JSON.stringify((Object) JSFunctionAdapter.call(skyrepoSearch, this, q, urlRemainder, start, size, sort, track_scores));
		}
	};

	public static Function0 endpointSearch = new Function0() {
		@Override
		public Object $invoke() {
			return JSFunctionAdapter.call(skyRepoSearch, this);
		}
	};

	public static Function0 endpointAdmin = new Function0() {
		@Override
		public Object $invoke() {
			return Global.JSON.stringify(skyrepoAdminList());
		}
	};

	//skyrepo.rs2 done
	//skyrepo.admin.rs2 start
	public static String skyrepoAdminPpk() {
		if (!levr.fileExists("skyAdmin.pem"))
			levr.fileSave(EcPpk.fromPem(levr.rsaGenerate()).toPem(), "skyAdmin.pem");
		return levr.fileToString(levr.fileLoad("skyAdmin.pem"));
	}

	public static Array<String> skyrepoAdminList() {
		Array<String> array = new Array();
		array.push(skyrepoAdminPpk());
		return array;
	}

	static {
		levr.bindWebService("/data", endpointData);
		levr.bindWebService("/sky/repo/search", skyRepoSearch);
		levr.bindWebService("/sky/repo/multiGet", endpointMultiGet);
		levr.bindWebService("/sky/repo/admin", endpointAdmin);
	}
}