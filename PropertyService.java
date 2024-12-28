package org.housePredict.Service;

import org.housePredict.Model.PropertyMasterModel;
import org.housePredict.Model.PropertyRepository;

public class PropertyService {
	PropertyRepository propRepo=new PropertyRepository();
	
	public boolean isAddNewProperty(PropertyMasterModel model,int sqftid)
	{
		return propRepo.isAddNewProperty(model,sqftid);
	}
}
