package org.housePredict.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.housePredict.Config.DBConfig;
import org.housePredict.Model.PropertyMasterModel;

public class PropertyRepository extends DBConfig {
	public boolean isAddNewProperty(PropertyMasterModel model, int sqftid) {
		try {
			stmt = conn.prepareStatement("insert into propertymaster values('0',?,?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getAddress());
			stmt.setInt(3, model.getId());
			stmt.setInt(4, sqftid);
			int value = stmt.executeUpdate();
			if (value > 0) {
				stmt = conn.prepareStatement(
						"insert into propertyhistoricalprices values('0',(select max(pid) from propertymaster),?,(select curdate()))");
				stmt.setInt(1, model.getPrice());
				value = stmt.executeUpdate();
				return value > 0 ? true : false;
			} else {
				return false;
			}

		} catch (Exception ex) {
			return false;
		}
	}
}
