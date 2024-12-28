package org.housePredict.Client;
import java.util.*;

import org.housePredict.Model.AreaMasterModel;
import org.housePredict.Model.CityMasterModel;
import org.housePredict.Model.LandSizeModel;
import org.housePredict.Model.PropertyMasterModel;
import org.housePredict.Service.AreaService;
import org.housePredict.Service.CityService;
import org.housePredict.Service.LandSizeService;
import org.housePredict.Service.PredictionService;
import org.housePredict.Service.PropertyService;
public class PredictionClientApplication {

	public static void main(String[] args) {
		CityService cs=new CityService();
		AreaService aservice=new AreaService();
		LandSizeService lService=new LandSizeService();
		PropertyService pservice=new PropertyService();
		PredictionService predService=new PredictionService();
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("\n1: Add new City");
			System.out.println("2: View all city");
			System.out.println("3: Add city area");
			System.out.println("4: Show all area by city name");
			System.out.println("5: Add new LandArea ");
			System.out.println("6: Enter property details ");
			System.out.println("7: predict property price area wise ");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				sc.nextLine();
				System.out.println("Enter city name");
				String cityName=sc.nextLine();
				CityMasterModel model=new CityMasterModel();
				model.setName(cityName);
				boolean b=cs.isAddCity(model);
				if(b)
				{
					System.out.println("New city Added successfully.....");
				}
				else
				{
					System.out.println("Some problem is there .......");
				}
				break;
			case 2:
				System.out.println("All data of city.....");
				List<CityMasterModel> list=cs.getAllCities();
				for(CityMasterModel c:list)
				{
					System.out.println(c.getCityId()+"\t"+c.getName());
				}
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter city name");
				cityName=sc.nextLine();
				int result=cs.getCityIdByName(cityName);
				System.out.println("Result is ....."+result);
				if(result==0)
				{
					System.out.println("City Not present....\n Do you want to add this city....");
					String confirm=sc.nextLine();
					if(confirm.equals("yes"))
					{
					model=new CityMasterModel();
					model.setName(cityName);
				    b=cs.isAddCity(model);
					if(b)
					{
						System.out.println("New city Added successfully.....");
					}
					else
					{
						System.out.println("Some problem is there .......");
					}
					}
				}
				else if(result!=0)
				{
					System.out.println("Enetr area name.");
					String areaName=sc.nextLine();
					System.out.println("Enter pincode");
					String pincode=sc.nextLine();
					AreaMasterModel areaModel=new AreaMasterModel();
					areaModel.setAreaName(areaName);
					areaModel.setCityId(result);
					areaModel.setPincode(pincode);
					b=aservice.isAddNewArea(areaModel);
					if(b)
					{
						System.out.println("New area added");
					}
					else
					{
						System.out.println("Area not added....");
					}
				}
				else
				{
					System.out.println("there is some exception");
				}
				break;
			case 4:
				System.out.println("show all area with city name");
				List<AreaMasterModel>arealist=aservice.getAreaByCityNames();
				for(AreaMasterModel m:arealist)
				{
					System.out.println(m.getName()+"\t"+m.getAreaName()+"\t"+m.getPincode());
				}
				break;
			case 5:
				System.out.println("Enter New land area size");
				int landArea=sc.nextInt();
				LandSizeModel landModel=new LandSizeModel();
				landModel.setSqFeet(landArea);
				b=lService.isAddNewLandSize(landModel);
				if(b)
				{
					System.out.println("new land area added");
				}
				else
				{
					System.out.println("some problem is there");
				}
				break;
			case 6:
				sc.nextLine();
				System.out.println("Enter city name");
				cityName=sc.nextLine();
				result=cs.getCityIdByName(cityName);
				List<String> areaNames=aservice.areaList(result);
				System.out.println("Input area name from given list ");
				for(String aname:areaNames)
				{
					System.out.println(aname);
				}
				System.out.println("Enter Area name");
				String areaName=sc.nextLine();
				int areaId=aservice.getAreaIdByName(areaName);
				System.out.println("area name id is "+areaId);
				System.out.println("Enter land size");
				int landSize=sc.nextInt();
				int sqftid=lService.getLandSizeIdByAreaSize(landSize);
				System.out.println("Area size id "+sqftid);
				sc.nextLine();
				System.out.println("Enter property name");
				String pname=sc.nextLine();
				System.out.println("Enter property address");
				String paddress=sc.nextLine();
				System.out.println("Enetr property price");
				int price=sc.nextInt();
				PropertyMasterModel propModel=new PropertyMasterModel();
				propModel.setName(pname);
				propModel.setAddress(paddress);
				propModel.setPrice(price);
				propModel.setId(areaId);
				b=pservice.isAddNewProperty(propModel, sqftid);
				
				if(b)
				{
					System.out.println("new Property added successfully....");
				}
				else
				{
					System.out.println("some problem is there....");
				}
				break;
			case 7:
				sc.nextLine();
				System.out.println("Enter city name");
				cityName=sc.nextLine();
				result=cs.getCityIdByName(cityName);
				areaNames = aservice.areaList(result);
				System.out.println("Input area name from given list ");
				for(String aname:areaNames) {
					System.out.println(aname);
				}
				System.out.println("Enter area name");
			    areaName=sc.nextLine();
			    System.out.println("Enter your expected land size ");
			    int expectedLandSize=sc.nextInt();
			    int y=predService.getPredictionPrice(expectedLandSize);
			    System.out.println("HeyUser your house predicted price is "+y);
				break;
			default:
				System.out.println("Invalid choice");
			}
		}while(true);
	}

}
