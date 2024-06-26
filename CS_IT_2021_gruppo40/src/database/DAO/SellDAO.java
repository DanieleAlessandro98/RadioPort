package database.DAO;

/**
 * Classe che si occupa di interfacciarsi con il database con lo scopo di acquisire o memorizzare informazioni relative alla vendita
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;
import exception.DatabaseException;
import exception.DatabaseExceptionMessage;
import model.contracts.IRadioModel;
import model.contracts.ISellDetailModel;
import model.contracts.IUserModel;
import utility.DateFormat;

public class SellDAO {
	
	/**
	 * Metodo che si relazione con il database andando a memorizzare la vendita
	 * @param user Dati dell'utente
	 * @param radio Radio selezionata
	 * @param sellDetail Dettagli della vendita
	 * @throws DatabaseException
	 */
	public static void insertSell(IUserModel user, IRadioModel radio, ISellDetailModel sellDetail) throws DatabaseException {
		String query = "INSERT INTO Sells (num_radio, date, price, user_id, radio_id) VALUES (?, ?, ?, ?, ?);";
		
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
			System.exit(0);		// temp
		}
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, sellDetail.getNumRadio());
			statement.setTimestamp(2, DateFormat.convertTimestampToSQLFormat(sellDetail.getDate()));
			statement.setDouble(3, sellDetail.getPrice());
			statement.setInt(4, user.getID());
			statement.setInt(5, radio.getID());
						
			statement.execute();
			
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
	}
	
}
