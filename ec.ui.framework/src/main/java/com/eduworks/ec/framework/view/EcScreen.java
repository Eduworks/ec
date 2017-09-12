package com.eduworks.ec.framework.view;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcObject;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.dom.Attr;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.dom.HTMLCollection;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.jquery.GlobalJQuery;
import org.stjs.javascript.jquery.JQueryCore;

/**
 * Subclass of view that is specific for a screen, providing a display name that
 * will be shown in the URL bar and that can be used on startup to check if the
 * URL is asking for a certain page on startup.
 *
 * @author devlin.junker@eduworks.com
 * @module com.eduworks.ec.ui
 * @class EcScreen
 * @extends EcView
 */
public abstract class EcScreen extends EcView {
	/**
	 * Name that identifies a certain type of screen, shown in the URL bar to
	 * help the user understand the page that they are on and used during
	 * startup to decide whether or not to load a specific page on startup.
	 *
	 * @property displayName
	 * @type string
	 */
	public String displayName = "";
	public Callback1<String> failure = null;

	;
	Object nameToTemplate = null;

	/**
	 * Getter for the display name
	 *
	 * @return The display name for the screen
	 * @memberOf EcScreen
	 * @method getDisplayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	public void setData(Object data) {

	}

	public void autoFill(final JQueryCore scope, Object obj) {
		Map<String, Object> props = JSObjectAdapter.$properties(obj);

		for (String key : props) {
			fillInnerString(scope, obj, key);
		}
		for (String key : props) {
			fillInnerStringReferences(scope, obj, key);
		}
		for (String key : props) {
			fillInnerArray(scope, obj, key);
		}
	}

	public void fillInnerString(final JQueryCore scope, final Object dataObj, String key) {
		if (key.contains("/") || key.contains(":") || key.contains("@"))
			return;
		Map<String, Object> a = JSObjectAdapter.$properties(dataObj);

		Object v = a.$get(key);
		String textTypes = "[ec-field='" + key + "']";
		if (JSGlobal.typeof(v) == "string") {
			JQueryCore textFieldTypes = scope.find(textTypes);
			JQueryCore attrFieldTypes = scope.find("[ec-attr-" + key + "]");
			textFieldTypes.text(v).val(v);

			String attrValue = (String) attrFieldTypes.attr("ec-attr-" + key + "");
			String writeKey = key;
			if (attrValue != null && attrValue != "")
				writeKey = attrValue;

			attrFieldTypes.attr(writeKey, v);
			attrFieldTypes.attr(writeKey.toLowerCase(), v);

			if (scope.is("[ec-field='" + key + "']"))
				scope.text(v);
			if (scope.is("[ec-attr-" + key + "]")) {
				scope.attr(writeKey, v);
				scope.attr(writeKey.toLowerCase(), v);
			}
		}
		if (JSGlobal.typeof(v) == "function") {
			if ((Integer) JSObjectAdapter.$get(v, "length") == 0) {
				JQueryCore textFieldTypes = scope.find(textTypes);
				JQueryCore attrFieldTypes = scope.find("[ec-attr-" + key + "]");

				String attrValue = (String) scope.attr("ec-attr-" + key + "");
				String writeKey = key;
				if (attrValue != null && attrValue != "")
					writeKey = attrValue;

				if (textFieldTypes.length() + attrFieldTypes.length() > 0) {
					v = JSFunctionAdapter.apply(v, dataObj, new Array(0));

					textFieldTypes.text(v).val(v);
					attrFieldTypes.attr(writeKey, v);
					attrFieldTypes.attr(writeKey.toLowerCase(), v);
				}
			}
		}
	}

	public void fillInnerStringReferences(final JQueryCore scope, final Object dataObj, String key) {
		if (key.contains("/") || key.contains(":") || key.contains("@"))
			return;
		Map<String, Object> a = JSObjectAdapter.$properties(dataObj);

		Object v = a.$get(key);
		if (JSGlobal.typeof(v) == "string") {
			String s = (String) v;
			JQueryCore referenceTypes = scope.find("[ec-reference='" + key + "']");
			if (referenceTypes.length() > 0) {
				if (s.startsWith("http")) {
					// We are a reference to an object
					EcRemoteLinkedData p1 = EcRepository.getBlocking(s);
					autoFill(referenceTypes, p1);
				}
			}
		}
		if (JSGlobal.typeof(v) == "function") {
		}
	}

	public void fillInnerArray(final JQueryCore scope, final Object dataObj, final String key) {
		if (key.contains("/") || key.contains(":") || key.contains("@"))
			return;
		final Map<String, Object> props = JSObjectAdapter.$properties(dataObj);

		Object v = props.$get(key);
		if (EcArray.isArray(v)) {
			JQueryCore containers = scope.find("[ec-container~='" + key + "']");
			for (int idx = 0; idx < containers.length(); idx++) {
				JQueryCore container = containers.eq(idx);
				Array<String> array = (Array<String>) v;
				for (int i = 0; i < array.$length(); i++) {
					fillInnerArrayContainer(scope, dataObj, key, props, container, array, i);
				}
			}
		}
	}

	public void fillInnerArrayContainer(final JQueryCore scope, final Object dataObj, final String key, final Map<String, Object> props,
	                                    final JQueryCore container, Array<String> array, int i) {
		String arrayValue = array.$get(i);
		if (JSGlobal.typeof(arrayValue) == "string" && arrayValue.toLowerCase().startsWith("http")) {
			// We are a reference to an object
			EcRemoteLinkedData p1 = EcRepository.getBlocking(arrayValue);
			if (shouldFillInnerArray(props, container, p1)) {
				JQueryCore newContainer = null;
				newContainer = container.find("[ec-template='" + key + "'][id='" + JSObjectAdapter.$get(p1, "id") + "']");
				if (newContainer.length() == 0)
					newContainer = autoAppend(container, key);
				autoFill(newContainer, p1);
				for (String k2 : props) {
					fillInnerArray(newContainer, dataObj, k2);
				}
			}
		} else if (EcObject.isObject(arrayValue)) {
			JQueryCore c = autoAppend(scope, key);
			autoFill(c, arrayValue);
		} else if (arrayValue.trim().startsWith("{")) {
			JQueryCore c = autoAppend(scope, key);
			autoFill(c, JSGlobal.JSON.parse(arrayValue));
		} else {
			JQueryCore c = autoAppend(scope, key);
			c.text(arrayValue);
		}
	}

	public Boolean shouldFillInnerArray(Map<String, Object> a, JQueryCore container, EcRemoteLinkedData p1) {
		HTMLCollection<Attr> attributes = container.$get(0).attributes;
		boolean found = false;
		boolean ok = false;
		for (int j = 0; j < attributes.length; j++) {
			Attr attr = attributes.$get(j);
			if (attr.name.startsWith("ec-condition-")) {
				found = true;
				Array<String> parts = JSStringAdapter.split(attr.name.replace("ec-condition-", ""), "-");
				String parentKey = parts.$get(0);
				String childKey = parts.$get(1);
				Object parentValue = container.attr(parentKey);
				Object childValue = JSObjectAdapter.$get(p1, childKey);
				if (JSGlobal.typeof(childValue) == "function")
					childValue = JSFunctionAdapter.apply(childValue, p1, new Array(0));
				if (parentValue == childValue)
					ok = true;
			}
		}
		if (!found)
			return true;
		if (found && !ok)
			return false;
		if (found && ok)
			return true;
		return false;
	}

	public void autoRemove(JQueryCore<?> from, String template) {
		from.find("[ec-template='" + template + "']").remove();
	}

	public JQueryCore<?> autoAppend(JQueryCore<?> from, String template) {
		if (JSObjectAdapter.$get(nameToTemplate, template) == null)
			return from;
		if (from.is("[ec-container~='" + template + "']")) {
			return from.append((String) JSObjectAdapter.$get(nameToTemplate, template)).children().last();
		}
		return from.find("[ec-container~='" + template + "']").append((String) JSObjectAdapter.$get(nameToTemplate, template)).children().last();
	}

	public void autoConfigure(JQueryCore<?> jQueryCore) {
		if (nameToTemplate == null)
			nameToTemplate = new Object();
		final EcScreen me = this;
		jQueryCore.find("[ec-template]").each(new Callback2<Integer, Element>() {
			@Override
			public void $invoke(Integer p1, Element p2) {
				me.autoConfigure(GlobalJQuery.$(p2));
				if (JSObjectAdapter.$get(me.nameToTemplate, p2.getAttribute("ec-template")) == null) {
					JSObjectAdapter.$put(me.nameToTemplate, p2.getAttribute("ec-template"), JSObjectAdapter.$get(p2, "outerHTML"));
					p2.parentNode.removeChild(p2);
				}
			}
		});
	}

}
