package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.controller.ControllerType;
import business.usecase.IAddLibraryMember;
import business.controller.ControllerFactory;
import dataaccess.model.Address;
import dataaccess.model.LibraryMember;
import business.exception.InvalidMemberException;

public class AddMemberWindow extends JFrame implements LibWindow {
	private static final long serialVersionUID = 1L;
	public static final AddMemberWindow INSTANCE = new AddMemberWindow();
	IAddLibraryMember addLibraryMemberUseCase = ControllerFactory.getController(ControllerType.LibraryMember);

	private boolean isInitialized = false;

	private JPanel mainPanel = new JPanel();
	private JPanel topPanel = new JPanel();
	private JPanel outerMiddel = new JPanel();
	private JPanel lowerPanel;

	private JTextField txtMemberId;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhoneNumber;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtZipCode;
	private JTextField txtState;

	private JLabel lblMemberId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblPhoneNumber;
	private JLabel lblStreet;
	private JLabel lblCity;
	private JLabel lblZipCode;
	private JLabel lblState;

	private AddMemberWindow() {
	}

	@Override
	public void init() {
		this.initializeComponent();setBounds(1, 1, 930, 657);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Library System");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(81, 184, 196));
		this.setMinimumSize(new Dimension(930, 657));

		this.mainPanel.setLayout(new BorderLayout());
		this.defineTopPanel();
		this.defineOuterMiddle();
		this.defineLowerPanel();

		this.mainPanel.add(this.topPanel, BorderLayout.NORTH);
		this.mainPanel.add(this.outerMiddel, BorderLayout.CENTER);
		//this.mainPanel.add(this.lowerPanel, BorderLayout.SOUTH);

		
		this.mainPanel.setBackground(new Color(174, 242, 250));
		isInitialized = true;


		this.mainPanel.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		this.mainPanel.setBounds(1, 1, 930, 657);
		getContentPane().add(this.mainPanel);
	
		
	}

	public boolean isInitialized() {
		return isInitialized;
	}

	private void initializeComponent() {
		txtMemberId = new JTextField(20);
		txtFirstName = new JTextField(20);
		txtLastName = new JTextField(20);
		txtPhoneNumber = new JTextField(15);
		txtStreet = new JTextField(20);
		txtCity = new JTextField(20);
		txtZipCode = new JTextField(20);
		txtState = new JTextField(20);

		lblMemberId = new JLabel("Member ID");
		lblFirstName = new JLabel("First Name");
		lblLastName = new JLabel("Last Name");
		lblPhoneNumber = new JLabel("Phone Number");
		lblStreet = new JLabel("Street");
		lblCity = new JLabel("City");
		lblZipCode = new JLabel("Zip Code");
		lblState = new JLabel("State");
	}

	public void isInitialized(boolean val) {
		isInitialized = val;
	}

	public void defineTopPanel() {
		this.topPanel = new JPanel();
		topPanel.setBackground(new Color(81, 184, 196));
		JLabel addMemberLabel = new JLabel("Add Library Member");
		Util.adjustLabelFont(addMemberLabel, Color.WHITE, true);
		this.topPanel.setLayout(new FlowLayout(0));
		this.topPanel.add(addMemberLabel);
	}

	public void defineOuterMiddle() {
		this.outerMiddel = new JPanel();
		this.outerMiddel.setLayout(new BorderLayout());

		JPanel middlePanel = new JPanel();
		middlePanel.setBackground(new Color(174, 242, 250));
		FlowLayout fl = new FlowLayout(1, 25, 25);

		middlePanel.setLayout(fl);

		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		leftPanel.setBackground(new Color(174, 242, 250));
		rightPanel.setBackground(new Color(174, 242, 250));

		leftPanel.setLayout(new BoxLayout(leftPanel, 1));
		rightPanel.setLayout(new BoxLayout(rightPanel, 1));

		leftPanel.add(lblMemberId);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

		leftPanel.add(lblFirstName);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

		leftPanel.add(lblLastName);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

		leftPanel.add(lblPhoneNumber);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

		leftPanel.add(lblStreet);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

		leftPanel.add(lblCity);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

		leftPanel.add(lblZipCode);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

		leftPanel.add(lblState);

		rightPanel.add(txtMemberId);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		rightPanel.add(txtFirstName);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		rightPanel.add(txtLastName);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		rightPanel.add(txtPhoneNumber);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		rightPanel.add(txtStreet);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		rightPanel.add(txtCity);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		rightPanel.add(txtZipCode);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		rightPanel.add(txtState);

		middlePanel.add(leftPanel);
		middlePanel.add(rightPanel);

		JButton backToMainButn = new JButton("HOME");
		backToMainButn.addActionListener(new BackToMainListener());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(174, 242, 250));
		buttonPanel.add(backToMainButn);

		JButton btnAddMember = new JButton("ADD");
		attachAddMemberButtonListener(btnAddMember);
		buttonPanel.add(btnAddMember);

		JButton btnClear = new JButton("CANCEL");
		btnClear.addActionListener(e -> { clearInput();});
		buttonPanel.add(btnClear);

		this.outerMiddel.add(middlePanel, BorderLayout.NORTH);
		this.outerMiddel.add(buttonPanel, BorderLayout.CENTER);


	}

	private void attachAddMemberButtonListener(JButton btn) {
		btn.addActionListener((evt) -> {
			if (validateInput()) {
				try {
					addLibraryMemberUseCase.addLibraryMember(bindObject());
					JOptionPane.showMessageDialog(this, "Member added successfully.");
				} catch (InvalidMemberException e) {
					JOptionPane.showMessageDialog(this, e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	private LibraryMember bindObject() {
		Address address = new Address(txtStreet.getText(), txtCity.getText(), txtState.getText(), txtZipCode.getText());
		LibraryMember member = new LibraryMember(txtMemberId.getText(), txtFirstName.getText(), txtLastName.getText(),
				txtPhoneNumber.getText(), address);
		return member;
	}

	private void clearInput() {
		txtStreet.setText("");
		txtCity.setText("");
		txtState.setText("");
		txtZipCode.setText("");
		txtMemberId.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		txtPhoneNumber.setText("");
	}

	private boolean validateInput() {
		if (txtMemberId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Invalid Member Id");
			return false;
		}

		if (txtFirstName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Invalid First Name");
			return false;
		}

		if (txtLastName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Invalid Last Name");
			return false;
		}

		if (txtPhoneNumber.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Invalid Phone Number");
			return false;
		}

		return true;
	}

	public void defineLowerPanel() {
		JButton backToMainButn = new JButton("HOME");
		backToMainButn.addActionListener(new BackToMainListener());
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		lowerPanel.add(backToMainButn);
		
		JButton btnAddMember = new JButton("ADD");
		attachAddMemberButtonListener(btnAddMember);
		lowerPanel.add(btnAddMember);
		
		JButton btnClear = new JButton("CANCEL");
		btnClear.addActionListener(e -> { clearInput();});
		lowerPanel.add(btnClear);

//		JPanel addBookButtonPanel = new JPanel();
//		addBookButtonPanel.setLayout(new FlowLayout(1));
//		addBookButtonPanel.add(btnAddMember);
		// this.outerMiddel.add(addBookButtonPanel, BorderLayout.CENTER);

	}

	class BackToMainListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			UIController.hideAllWindows();
			MainView.INSTANCE.setVisible(true);
		}
	}

}
