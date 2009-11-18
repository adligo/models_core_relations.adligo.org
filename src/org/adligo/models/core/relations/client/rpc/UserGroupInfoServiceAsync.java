package org.adligo.models.core.relations.client.rpc;

import java.util.Collection;

import org.adligo.models.core.relations.client.UserGroup;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserGroupInfoServiceAsync {

	/**
	 * locate user groups based on parameters
	 * 
	 * @param params (I_TemplateParams xml String toXml fromXml)
	 */
	public void findUserGroups(String params, AsyncCallback<Collection<UserGroup>> callback);
}