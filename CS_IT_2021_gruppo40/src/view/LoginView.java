package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.ILoginController;

public class LoginView extends AbstractView implements ILoginView {

	private JTextField usernameField;
	private JTextField passwordField;
	private JButton btnLogin;
	
	private ILoginController controller;
	
	public LoginView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
	}
	
	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 400, 600);
		this.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	@Override
	public void initComponents() {
		usernameField = new JTextField();
		passwordField = new JTextField();
		btnLogin = new JButton("Login");
		
		JLabel usernameLabel;
		JLabel passwordLabel;

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(12, 29, 100, 16);
		this.add(usernameLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(12, 86, 100, 16);
		this.add(passwordLabel);
	}

	@Override
	public void addComponents() {
		this.add(usernameField);
		this.add(passwordField);
		this.add(btnLogin);
	}

	@Override
	public void setPositionComponents() {
		usernameField.setBounds(12, 42, 100, 20);
		passwordField.setBounds(12, 101, 100, 20);
		btnLogin.setBounds(12, 141, 100, 20);
	}

	@Override
	public void setController(ILoginController controller) {
		this.controller = controller;
	}

	@Override
	public ILoginController getController() {
		return controller;
	}

}
