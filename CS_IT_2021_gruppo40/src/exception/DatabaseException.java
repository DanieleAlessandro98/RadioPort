package exception;

/**
 * Classe che si occupa di gestire e/o catturare eventuali errori/eccezioni che possono presentarsi per quanto riguarda il database
 * @author Alex
 *
 */
public class DatabaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8656071017872734015L;
	/**
	 * 
	 */
	
	public DatabaseException() {}
	
	public DatabaseException(String msg) {
		super(msg);
	}
	
}
