package org.housePredict.Service;

import org.housePredict.Model.LandSizeModel;
import org.housePredict.Repository.LandSizeRepository;

public class LandSizeService {
	LandSizeRepository landRepo = new LandSizeRepository();

	public boolean isAddNewLandSize(LandSizeModel model) {
		return landRepo.isAddNewLandSizeModel(model);
	}
	public int getLandSizeIdByAreaSize(int areaSize)
	{
		return landRepo.getLandSizeIdByAreaSize(areaSize);
	}
}
