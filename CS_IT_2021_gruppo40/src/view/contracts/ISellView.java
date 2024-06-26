package view.contracts;

import javax.swing.JComponent;

import controller.contracts.ISellController;

/**
 * Interfaccia della view che si occupa della parte di vendita
 * @author Alex
 *
 */
public interface ISellView {
	public JComponent getUserView();
	public JComponent getSellDetailView();
	public JComponent getRadioView();
	public JComponent getRadioTableView();
	
	public void setController(ISellController controller);
	public ISellController getController();
	
	public void insertSellSuccessful();
	public void insertSellFailed(String errorMessage);
}
