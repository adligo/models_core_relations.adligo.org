package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DomainEditServiceAsync {
	public void saveDomainName(DomainName domainName, AsyncCallback<SaveResponse> callback);
}
