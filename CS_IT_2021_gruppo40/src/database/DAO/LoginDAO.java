package database.DAO;

/**
 * Classe che si occupa di interfacciarsi con il database con lo scopo di acquisire o memorizzare informazioni relative al login
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import exception.DatabaseException;
import exception.DatabaseExceptionMessage;
import utility.Hash;

public class LoginDAO {

	/**
	 * Metodo che si relazione con il database andando a cercare utenti con quei dati identificativi
	 * @param username Username dell'utente dato in input
	 * @param password Password dell'utente dato in input
	 * @return ID dell'utente
	 * @throws DatabaseException
	 */
	public static int login(String username, String password) throws DatabaseException {
		String query = "SELECT \r\n" + 
				"    id\r\n" + 
				"FROM\r\n" + 
				"    Users\r\n" + 
				"WHERE\r\n" + 
				"    username = ? AND password = ?;";
		
		int result = -1;
		
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
			System.exit(0);		// temp
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, Hash.getMD5String(password));
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = resultSet.getInt("id");
				break;
			}
			
		} catch (SQLException e) {
			throw new DatabaseException(DatabaseExceptionMessage.DATABASE_QUERY_FAILED);
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
