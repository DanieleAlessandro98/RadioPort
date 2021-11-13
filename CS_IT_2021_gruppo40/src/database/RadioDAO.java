package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Brand;
import model.IRadioModel;
import model.RadioModel;
import model.Type;

public class RadioDAO {

	public static List<IRadioModel> getRadiosData() {
		String query = "SELECT r.id, r.size, r.color, r.optional, r.antenna, b.name AS brand_name, t.name AS type_name\r\n" + 
				"FROM Radios r\r\n" + 
				"JOIN Brands b ON r.brand = b.id\r\n" + 
				"JOIN Types t ON r.type = t.id;";
		
		List<IRadioModel> result = new ArrayList<>();
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(new RadioModel(
						resultSet.getInt("id"),
						Brand.valueOf(resultSet.getString("brand_name")),
						Type.valueOf(resultSet.getString("type_name")),
						resultSet.getInt("size"),
						resultSet.getString("color"),
						resultSet.getString("optional"),
						resultSet.getString("antenna")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}