package org.adligo.models.core.relations.client.rpc;

import java.util.Collection;

import org.adligo.models.core.relations.client.UserRelations;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserInfoServiceAsync {
	/**
	 * locate a users based on parameters
	 * 
	 * @param params (I_TemplateParams xml String toXml fromXml)
	 */
	public void findUsers(String params, AsyncCallback<Collection<UserRelations>> callback);

}
