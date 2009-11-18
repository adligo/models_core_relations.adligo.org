package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationRequest;
import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationResponse;

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
	public AuthenticationResponse login(AuthenticationRequest req);
	
	/**
	 * logs the user out of the system
	 * 
	 */
	public void logout();
	
	/**
	 * the list of DomainNames should come with the config
	 * see the GwtCacheConstants in the gwt_util project
	 */
}

