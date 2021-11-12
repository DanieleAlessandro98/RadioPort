package controller;

import model.IRadioTableModel;
import model.RadioTableModel;
import view.IRadioTableView;

public class RadioTableController extends AbstractController implements IRadioTableController {
	
	private IRadioTableModel model;
	private IRadioTableView view;
	
	public RadioTableController(IRadioTableView view) {
		this.model = new RadioTableModel();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}

	@Override
	public void initRadioTable() {
		view.initRadioTable(model.initRadioTable());
	}

	@Override
	public void showRadioTableActionListener() {
		view.setTableVisibility(true);
	}

	@Override
	public void selectRadioMouseListener(int radioID) {
		model.selectRadio(radioID);
		view.setTableVisibility(false);
	}
	
}
