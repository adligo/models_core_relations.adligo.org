package org.adligo.models.core.relations.client.rpc;

import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("do/DomainEditService")
public interface DomainEditService extends RemoteService {
	public SaveResponse saveDomainName(DomainName domainName);
}
