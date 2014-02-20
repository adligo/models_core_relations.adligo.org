package org.adligo.models.core_relations.shared.util;

import java.util.Collection;

import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core_relations.shared.ids.I_LongIdentifier;
import org.adligo.models.core_relations.shared.ids.I_StringIdentifier;
import org.adligo.models.core_relations.shared.ids.I_VersionedLongIdentifier;
import org.adligo.models.params.shared.I_TemplateParams;
import org.adligo.models.params.shared.Param;
import org.adligo.models.params.shared.Params;
import org.adligo.models.params.shared.ParamsFactory;
import org.adligo.models.params.shared.SqlOperators;

public class SIDParamFactory {

	public static final String VERSION = "version";

	public static I_TemplateParams byId(I_StorageIdentifier p) {
		try {
			return byId((I_LongIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			return byId((I_VersionedLongIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			return byId((I_StringIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		return null;
	}
	
	private static I_TemplateParams byId(I_LongIdentifier p) {
		Long id = p.getId();
		return ParamsFactory.byId(id.longValue());
	}
	
	private static I_TemplateParams byId(I_StringIdentifier p) {
		String id = p.getKey();
		return ParamsFactory.byId(id);
	}
	
	private static I_TemplateParams byId(I_VersionedLongIdentifier p) {
		Params params = new Params();
		params.addParam(ParamsFactory.DEFAULT);
		Params whereParams = new Params();
		params.addParam(ParamsFactory.WHERE, whereParams);
		
		Long id = p.getId();
		if (id == null) {
			whereParams.addParam(ParamsFactory.ID, SqlOperators.IS_NULL);
		} else {
			whereParams.addParam(ParamsFactory.ID, SqlOperators.EQUALS, id.longValue());
		}
		
		Integer version = p.getVersion();
		if (version == null) {
			whereParams.addParam(VERSION, SqlOperators.IS_NULL);
		} else {
			whereParams.addParam(VERSION, SqlOperators.EQUALS, version.intValue());
		}
		return params;
	}
	

	public static void addIdParameter(Params parent, String paramName, I_StorageIdentifier p) {
		try {
			addIdParameter(parent, paramName, (I_LongIdentifier) p);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			addIdParameter(parent, paramName, (I_StringIdentifier) p);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			addIdParameter(parent, paramName, (I_VersionedLongIdentifier) p);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
	}
	
	public static void addIdParameter(Params parent, String paramName, I_StorageIdentifier p, I_TemplateParams child) {
		try {
			addIdParameter(parent, paramName, (I_LongIdentifier) p, child);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			addIdParameter(parent, paramName, (I_StringIdentifier) p, child);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			addIdParameter(parent, paramName, (I_VersionedLongIdentifier) p, child);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
	}
	/**
	 * 
	 * @param parent the parent parameters (whereParams usually)
	 * @param paramName 
	 * @param p
	 */
	public static void addIdParameter(Params parent, String paramName, I_LongIdentifier p) {
		Long id = p.getId();
		if (id == null) {
			parent.addParam(paramName, SqlOperators.IS_NULL);
		} else {
			parent.addParam(paramName, SqlOperators.EQUALS, id.longValue());
		}
	}
	
	public static void addIdParameter(Params parent, String paramName, I_LongIdentifier p, I_TemplateParams childParams) {
		Long id = p.getId();
		if (id == null) {
			Param param = parent.addParam(paramName, SqlOperators.IS_NULL);
			param.setParams(childParams);
		} else {
			Param param = parent.addParam(paramName, SqlOperators.EQUALS, id.longValue());
			param.setParams(childParams);
		}
	}
	/**
	 * 
	 * @param parent the parent parameters (whereParams usually)
	 * @param paramName 
	 * @param p
	 */
	public static void addIdParameter(Params parent, String paramName, I_StringIdentifier p) {
		String id = p.getKey();
		if (id == null) {
			parent.addParam(paramName, SqlOperators.IS_NULL);
		} else {
			parent.addParam(paramName, SqlOperators.EQUALS, id);
		}
	}
	
	public static void addIdParameter(Params parent, String paramName, I_StringIdentifier p, I_TemplateParams child) {
		String id = p.getKey();
		if (id == null) {
			Param param = parent.addParam(paramName, SqlOperators.IS_NULL);
			param.setParams(child);
		} else {
			Param param = parent.addParam(paramName, SqlOperators.EQUALS, id);
			param.setParams(child);
		}
		
	}
	
	public static void addIdParameter(Params parent, String idParamName, String valueParamName,  I_VersionedLongIdentifier p) {
		Long id = p.getId();
		if (id == null) {
			parent.addParam(idParamName, SqlOperators.IS_NULL);
		} else {
			parent.addParam(idParamName, SqlOperators.EQUALS, id.longValue());
		}
		
		Integer version = p.getVersion();
		if (version == null) {
			parent.addParam(valueParamName, SqlOperators.IS_NULL);
		} else {
			parent.addParam(valueParamName, SqlOperators.EQUALS, version.intValue());
		}
	}
	
	public static void addIdParameter(Params parent, String idParamName, String valueParamName,  I_VersionedLongIdentifier p, I_TemplateParams child) {
		Long id = p.getId();
		if (id == null) {
			Param param = parent.addParam(idParamName, SqlOperators.IS_NULL);
			param.setParams(child);
		} else {
			Param param = parent.addParam(idParamName, SqlOperators.EQUALS, id.longValue());
			param.setParams(child);
		}
		
		Integer version = p.getVersion();
		if (version == null) {
			Param param = parent.addParam(valueParamName, SqlOperators.IS_NULL);
			param.setParams(child);
		} else {
			Param param = parent.addParam(valueParamName, SqlOperators.EQUALS, version.intValue());
			param.setParams(child);
		}
	}
	
	public static Object getIdParameter(I_LongIdentifier p) {
		return p.getId();
	}
	
	/**
	 * 
	 * @param parent the parent parameters (whereParams usually)
	 * @param paramName 
	 * @param p
	 */
	public static Object getIdParameter(I_StringIdentifier p) {
		return p.getKey();
	}
	
	public static Object getIdParameter(I_StorageIdentifier p) {
		try {
			return getIdParameter((I_LongIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			return getIdParameter((I_StringIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		throw new IllegalArgumentException("Unable to obtain a single object id for " + p);
	}

	/**
	 * Note no generics or annotations for jme compatibility
	 * @param parent
	 * @param paramName
	 * @param p a colletion of I_StorageIdentifier
	 */
	public static void addIdParametersInClauses(Params parent, String paramName, Collection<I_StorageIdentifier> p) {
		Param childParam = parent.addParam(paramName,SqlOperators.IN);
		
	    for (I_StorageIdentifier id: p) {
			Object obj = SIDParamFactory.getIdParameter(id);
			try {
				childParam.addValue((Long) obj);
			} catch (ClassCastException x) {
				try {
					childParam.addValue((String) obj);
				} catch (ClassCastException g) {
					throw new RuntimeException(g);
				}
			}
		}
	}
}
