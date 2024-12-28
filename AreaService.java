package org.housePredict.Service;

import java.util.List;

import org.housePredict.Model.AreaMasterModel;
import org.housePredict.Model.AreaRepository;

public class AreaService 
{
	AreaRepository areaRepo=new AreaRepository();
   public boolean isAddNewArea(AreaMasterModel model)
   {
	return areaRepo.isAddNewArea(model);  
   }
   public List<AreaMasterModel> getAreaByCityNames()
   {
	   return areaRepo.getAreaByCityNames();
   }
   public List<String> areaList(int cityId)
   {
	   return areaRepo.areaList(cityId);
   }
   public int getAreaIdByName(String areaName)
   {
	   return areaRepo.getAreaIdByName(areaName);
   }
}
