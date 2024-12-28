package org.housePredict.Repository;

import org.housePredict.Config.DBConfig;
import java.util.*;
public class PredictionRepository extends DBConfig{
	List<Integer> valuesOfX;
	List<Integer> valuesOfY;
  public int getMinOfX(){
	  try {
		 stmt=conn.prepareStatement("select avg(sqftsize) from landsizemaster");
		 rs=stmt.executeQuery();
		 return rs.next()?rs.getInt(1):0;
	  }
	  catch(Exception e)
	  {
		  return 0;
	  }
  }
  public int getMinOfY() {
		try {
			stmt=conn.prepareStatement("select avg(price) from propertyhistoricalprices");
			rs=stmt.executeQuery();
			return rs.next()?rs.getInt(1):0;
		}
		catch(Exception ex)
		{
			return 0;
		}
	}
  public List<Integer> getValuesOfX()
  {
	  valuesOfX=new ArrayList<Integer>();
	  try {
		  stmt=conn.prepareStatement("select sqftsize from landsizemaster");
		  rs=stmt.executeQuery();
		  while(rs.next())
		  {
			  valuesOfX.add(rs.getInt(1));
		  }
		  return valuesOfX.size()>0?valuesOfX:null;
	  }
	  catch(Exception ex)
	  {
		  return null;
	  }
	  
  }
  public List<Integer> getValuesOfY(){
	  valuesOfY=new ArrayList<Integer>();
	  try {
		  stmt= conn.prepareStatement("select price from propertyhistoricalprices");
		  rs=stmt.executeQuery();
		  while(rs.next())
		  {
			  valuesOfY.add(rs.getInt(1));
		  }
		  return valuesOfY.size()>0?valuesOfY:null;
	  }
	  catch(Exception ex)
	  {
		  return null;
	  }
  }
}
