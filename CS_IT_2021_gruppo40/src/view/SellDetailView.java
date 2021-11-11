package view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class SellDetailView extends AbstractView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5674436431961903553L;
	/**
	 * 
	 */
	
	private JTextField numRadio;
	private JTextField date;
	private JTextField price;
	
	/*
	 * Temporaneamente disabilitati
	 * Probabilmente info di user e radio saranno date dalle altre rispettive viste
	private JTextField user;
	private JTextField radio;
	*/
	
	public SellDetailView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
	}

	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 355, 130);
		this.setBorder(new TitledBorder(null, "Dettagli Vendita", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	}

	@Override
	public void initComponents() {
		numRadio = new JTextField();
		date = new JTextField();
		price = new JTextField();
		
		/*
		user = new JTextField();
		radio = new JTextField();
		*/
		
		JLabel numRadioLabel;
		JLabel dateLabel;
		JLabel priceLabel;
		
		/*
		JLabel userLabel;
		JLabel radioLabel;
		*/
		
		numRadioLabel = new JLabel("Numero radio");
		numRadioLabel.setBounds(12, 37, 100, 10);
		this.add(numRadioLabel);
		
		dateLabel = new JLabel("Data");
		dateLabel.setBounds(12, 77, 100, 10);
		this.add(dateLabel);

		priceLabel = new JLabel("Prezzo");
		priceLabel.setBounds(152, 37, 100, 10);
		this.add(priceLabel);

		/*
		userLabel = new JLabel("Utente");
		userLabel.setBounds(150, 50, 100, 10);
		this.add(userLabel);

		radioLabel = new JLabel("Radio");
		radioLabel.setBounds(10, 100, 100, 10);
		this.add(radioLabel);
		*/
	}

	@Override
	public void addComponents() {
		this.add(numRadio);
		this.add(date);
		this.add(price);
		
		/*
		this.add(user);
		this.add(radio);
		*/
	}

	@Override
	public void setPositionComponents() {
		numRadio.setBounds(12, 47, 100, 20);
		date.setBounds(12, 87, 100, 20);
		price.setBounds(152, 47, 100, 20);
		
		/*
		user.setBounds(150, 60, 100, 20);
		radio.setBounds(10, 110, 100, 20);
		*/
	}
	
}
