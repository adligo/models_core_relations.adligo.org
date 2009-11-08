package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.client.I_User;
import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationRequest;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthenticationServiceAsync {

	
	/**
	 * try to login
	 * return null if failed
	 */
	public void login(AuthenticationRequest req, AsyncCallback<I_User> callback);
	
	/**
	 * logs the user out of the system
	 * 
	 */
	public void logout(AsyncCallback<Void> callback);
	
	/**
	 * the list of DomainNames should come with the config
	 * see the GwtCacheConstants in the gwt_util project
	 */
}

