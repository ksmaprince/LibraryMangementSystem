package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import business.usecase.*;
import business.controller.*;
import business.model.*;


public class PrintCheckOutRecordWindow extends JFrame implements LibWindow {

	private static final long serialVersionUID = 1L;
	public static final PrintCheckOutRecordWindow INSTANCE = new PrintCheckOutRecordWindow();
	private JPanel contentPane;

	private PrintCheckOutRecordWindow() {
	}

	IPrintCheckOutRecord printCheckOutBookUseCase = ControllerFactory.getController(ControllerType.CheckOutBook);
	private boolean isInitialized = false;

	JTextField txtMemberID;
	JTable jt;

	public void checkOutBook() {
		if(txtMemberID != null) {

			if(jt != null) {
				DefaultTableModel model2 = (DefaultTableModel) jt.getModel();
				model2.setRowCount(0);
			}
			return;
		}

		setResizable(false);
		setTitle("Library System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 930, 657);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(81, 184, 196));
		
		JPanel panelCheckoutFields = new JPanel();
		panelCheckoutFields.setLayout(null);
		panelCheckoutFields.setSize(930, 657);

		this.setMinimumSize(new Dimension(930, 657));

		JLabel lblMemberID = new JLabel("Member ID");
		lblMemberID.setBounds(25, 45, 150, 20);
		txtMemberID = new JTextField(10);
		txtMemberID.setBounds(120, 45, 150, 20);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(120, 75, 150, 20);
		addCheckIDListener(btnSearch);

		JButton btnBackToMain = new JButton("HOME");

		addBackButtonListener(btnBackToMain);

		JPanel pnlButtons = new JPanel();
		pnlButtons.add(btnBackToMain);
		pnlButtons.add(btnSearch);
		pnlButtons.setBackground(new Color(255, 255, 255,180));
		pnlButtons.setBounds(20, 40, 890, 35);


		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Member Id");
		model.addColumn("Member Name");
		model.addColumn("ISBN");
		model.addColumn("Book Name");
		model.addColumn("Checkout Date");
		model.addColumn("Due Date");

		jt = new JTable(model);

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(20, 100, 890, 450);
		panelCheckoutFields.add(sp);

		// Print CheckoutRecord

		panelCheckoutFields.add(lblMemberID);
		panelCheckoutFields.add(txtMemberID);

		panelCheckoutFields.add(pnlButtons, BorderLayout.CENTER);

		panelCheckoutFields.setBackground(new Color(244, 244, 244,180));
		panelCheckoutFields.setBounds(0, 1, 930, 657);
		getContentPane().add(panelCheckoutFields);

	}

	private void addCheckIDListener(JButton butn) {
		butn.addActionListener(evt -> {
			String memberID = txtMemberID.getText().trim();

			if (memberID.length() == 0) {
				JOptionPane.showMessageDialog(this, "Member ID required", "Search Failed", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					displayCheckoutInfo();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, e.getMessage(), "Search Failed!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private void addBackButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			UIController.hideAllWindows();
			MainView.INSTANCE.setVisible(true);
		});
	}

	private void displayCheckoutInfo() {
		CheckOutRecord cr = printCheckOutBookUseCase.getCheckOutRecord(txtMemberID.getText());
		if (cr == null)
			return;

		DefaultTableModel model2 = (DefaultTableModel) jt.getModel();
		model2.setRowCount(0);

		for (CheckOutRecordEntry entry : cr.getCheckOutRecordEntries()) {
			model2.addRow(new Object[] { cr.getMember().getMemberId(), cr.getMember().getFullName(),
					entry.getBookCopy().getBook().getIsbn(), entry.getBookCopy().getBook().getTitle(),
					entry.getCheckOutDate().toString(), entry.getDueDate().toString() });

		}

	}

	public boolean isInitialized() {
		return this.isInitialized;
	}

	public void isInitialized(boolean val) {
		this.isInitialized = val;
	}

	@Override
	public void init() {
		checkOutBook();
	}

}
