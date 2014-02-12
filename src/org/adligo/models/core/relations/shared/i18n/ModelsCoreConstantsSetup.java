package org.adligo.models.core.relations.shared.i18n;

import org.adligo.i.adi.shared.I18nConstantsFactory;
import org.adligo.i.adi.shared.I_Invoker;
import org.adligo.models.core.shared.I_ModelsCoreConstants;

import com.google.gwt.core.client.GWT;

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
		}
	}
	
}
