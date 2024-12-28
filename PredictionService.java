package org.housePredict.Service;

import org.housePredict.Repository.PredictionRepository;
import java.util.*;
public class PredictionService {
	PredictionRepository predRepo = new PredictionRepository();
	public int getMinOf()
	{
		return predRepo.getMinOfX();
	}
	public int getPredictionPrice(int expectedLandSize)
	{
		int minOfX=predRepo.getMinOfX();
		int minOfY=predRepo.getMinOfY();
		System.out.println("Min of x is : "+minOfX);
		System.out.println("Min of y is : "+minOfY);
		
		List<Integer> valuesOfX=predRepo.getValuesOfX();
		List<Integer> dOfX=new ArrayList<Integer>();
		for(Integer valOfX:valuesOfX)
		{
			int dVal=valOfX-minOfX;
			dOfX.add(dVal);
		}
		System.out.println("Deviation of X is :"+dOfX);
		
		List<Integer> valuesOfY=predRepo.getValuesOfY();
		List<Integer>dOfY=new ArrayList<Integer>();
	
		for(Integer valOfY:valuesOfY)
		{
			int d=valOfY-minOfY;
			dOfY.add(d);
		}
		System.out.println("deviation of Y "+dOfY);
		List<Integer>prodOfDXandY=new ArrayList<Integer>();
		for(int i=0;i<=valuesOfY.size();i++)
		{
			int dValOfX=dOfX.get(i);
			int dValOfY=dOfY.get(i);
			
		}
		return 0;
	}
	
}
