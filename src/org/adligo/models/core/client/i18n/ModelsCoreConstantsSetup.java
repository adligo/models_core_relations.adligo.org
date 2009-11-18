package org.adligo.models.core.client.i18n;

import java.util.HashMap;
import java.util.Map;

import org.adligo.i.adi.client.I18nConstantsFactory;
import org.adligo.i.adi.client.I_Invoker;
import org.adligo.models.core.client.I_ModelsCoreConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

public class ModelsCoreConstantsSetup {
	private static boolean init = false;
	
	public static void init() {
		if (!init) {
			init = true;
			I18nConstantsFactory.INSTANCE.put(I_ModelsCoreConstants.class,
					new I_Invoker() {
						I_GwtModelsCoreConstants csts;
						
						@Override
						public Object invoke(Object valueObject) {
							if (csts == null) {
								csts = GWT.create(I_GwtModelsCoreConstants.class);
							}
							return csts;
						}
					});
			I18nConstantsFactory.INSTANCE.setDefalutFactory(new I_Invoker() {
				private Map<Class<?>,Constants> map = new HashMap<Class<?>,Constants>();
				
				@Override
				public Object invoke(Object valueObject) {
					Constants obj = map.get(valueObject);
					if (obj == null) {
						obj = (Constants) GWT.create((Class<?>) valueObject);
						map.put((Class<?>) valueObject, obj);
					}
					return obj;
				}
			});
		}
	}
	
}
