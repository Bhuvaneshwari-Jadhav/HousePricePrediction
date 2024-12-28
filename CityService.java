package org.housePredict.Service;

import java.util.List;

import org.housePredict.Model.CityMasterModel;
import org.housePredict.Repository.CityRepository;

public class CityService {
	CityRepository cityRepo=new CityRepository();
	public boolean isAddCity(CityMasterModel model)
	{
		return cityRepo.isAddCity(model);		
	}
	public List<CityMasterModel> getAllCities()
	{
		return cityRepo.getAllCities();
	}
	public int getCityIdByName(String cityname)
	{
		return cityRepo.getCityIdByName(cityname);
	}
}
