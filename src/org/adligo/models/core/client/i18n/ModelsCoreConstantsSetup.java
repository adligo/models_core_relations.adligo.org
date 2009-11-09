package org.adligo.models.core.client.i18n;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.models.core.client.ConstantsFactory;
import com.google.gwt.core.client.GWT;

public class ModelsCoreConstantsSetup {
	private static boolean init = false;
	
	public static void init() {
		if (!init) {
			init = true;
			ConstantsFactory.INSTANCE.put(I_DomainNameValidationConstants.class,
					new I_Invoker() {
						I_DomainNameValidationConstants csts;
						
						@Override
						public Object invoke(Object valueObject) {
							if (csts == null) {
								csts = GWT.create(I_GwtDomainNameValidationConstants.class);
							}
							return csts;
						}
					});
			ConstantsFactory.INSTANCE.put(I_UserValidationConstants.class,
					new I_Invoker() {
						I_UserValidationConstants csts;
						
						@Override
						public Object invoke(Object valueObject) {
							if (csts == null) {
								csts = GWT.create(I_GwtUserValidationConstants.class);
							}
							return csts;
						}
					});
			ConstantsFactory.INSTANCE.put(I_EmailValidationConstants.class,
					new I_Invoker() {
						I_EmailValidationConstants csts;
						
						@Override
						public Object invoke(Object valueObject) {
							if (csts == null) {
								csts = GWT.create(I_GwtEmailValidationConstants.class);
							}
							return csts;
						}
					});
		}
	}
	
}
