package org.housePredict.Repository;

import org.housePredict.Config.DBConfig;
import org.housePredict.Model.LandSizeModel;

public class LandSizeRepository extends DBConfig {
	public boolean isAddNewLandSizeModel(LandSizeModel model) {
		try {
			stmt = conn.prepareStatement("insert into landsizemaster values('0',?)");
			stmt.setInt(1, model.getSqFeet());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			return false;
		}
	}

	public int getLandSizeIdByAreaSize(int areaSize) {
		try {
			stmt = conn.prepareStatement("select sqftid from landsizemaster where sqftsize=?");
			stmt.setInt(1, areaSize);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception ex) {
			return 0;
		}
	}
}
