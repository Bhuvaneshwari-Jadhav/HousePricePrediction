package org.housePredict.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.housePredict.Config.DBConfig;
import org.housePredict.Model.CityMasterModel;
public class CityRepository extends DBConfig {
	List<CityMasterModel> list;
	public boolean isAddCity(CityMasterModel model)
	{
		try {
			
			stmt=conn.prepareStatement(" insert into citymaster values('0',?)");
			stmt.setString(1, model.getName());
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
			}
		catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
			return false;
		}
		
	}
	public List<CityMasterModel> getAllCities()
	{
		try {
			list=new ArrayList<CityMasterModel>();
			stmt=conn.prepareStatement("select *from citymaster");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CityMasterModel model=new CityMasterModel();
				model.setCityId(rs.getInt(1));
				model.setName(rs.getString(2));
				list.add(model);
			}
			return list.size()>0?list:null;
		}catch(Exception ex)
		{
			System.out.println("error is : "+ex);
			return null;
		}
	}
	public int getCityIdByName(String cityName)
	{
		try {
			stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1, cityName);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
				
			}
			
			else
			{
				return 0;
			}
		}
		catch(Exception ex)
		{
			return -1;
		}
	}
	
}
