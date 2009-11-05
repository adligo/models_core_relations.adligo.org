package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.client.I_User;
import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationRequest;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("do/AuthenticationService")
public interface AuthenticationService extends RemoteService {

	
	/**
	 * try to login
	 * return null if failed
	 * 
	 * @return
	 */
	public I_User login(AuthenticationRequest req);
	
	/**
	 * logs the user out of the system
	 * 
	 */
	public void logout();
	
	/**
	 * the list of domains should come with the config
	 * see the GwtCacheConstants in the gwt_util project
	 */
}

