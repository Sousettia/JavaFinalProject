import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BACKEND.Customer;

import javax.swing.JButton;

public class CreateAccount{

	private String email;
	private String account_no;
	public CreateAccount(String email, String account_no) throws IOException {
		this.email = email;
		this.account_no = account_no;
		setlblCustomerDetail(email);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	JFrame frame = new JFrame();
	JPanel panelFirst = new JPanel();
	JLabel lblName = new JLabel("Name:");
	JLabel lblDatebirth = new JLabel("Date of Birth:");
	JLabel lblEmail = new JLabel("Email:");
	JLabel lblTel = new JLabel("Phone:");
	JLabel lblAddress = new JLabel("Address:");

	/**
	 * Create the frame.
	 * @wbp.parser.entryPoint
	 */
	public void CreateaccountPopup() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 234, 245));
		frame.setVisible(true);
		frame.setBounds(400, 100, 706, 605);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		ImageIcon image = new ImageIcon("icon/bank.png");
		frame.setIconImage(image.getImage());
		
		JPanel panelColor = new JPanel();
		panelColor.setBackground(new Color(255, 223, 239));
		panelColor.setBounds(0, 0, 692, 86);
		frame.getContentPane().add(panelColor);
		panelColor.setLayout(null);
		
		JLabel lblOpenAcc = new JLabel("Opening an Saving account");
		lblOpenAcc.setBounds(153, 24, 400, 41);
		panelColor.add(lblOpenAcc);
		lblOpenAcc.setFont(new Font("Alice", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 234, 245));
		panel.setBounds(0, 86, 692, 472);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panelFirst.setLayout(null);
		panelFirst.setBackground(new Color(255, 234, 245));
		panelFirst.setBounds(0, 0, 692, 472);
		panel.add(panelFirst);
		
		JLabel lblOne = new JLabel("Customer Detail ");
		lblOne.setForeground(new Color(255, 155, 205));
		lblOne.setFont(new Font("Alice", Font.BOLD, 33));
		lblOne.setBounds(44, 32, 365, 33);
		panelFirst.add(lblOne);
		
		lblName.setFont(new Font("Alice", Font.BOLD, 23));
		lblName.setBounds(67, 95, 400, 33);
		panelFirst.add(lblName);
		
		lblDatebirth.setFont(new Font("Alice", Font.BOLD, 23));
		lblDatebirth.setBounds(67, 142, 400, 33);
		panelFirst.add(lblDatebirth);
		
		lblEmail.setFont(new Font("Alice", Font.BOLD, 23));
		lblEmail.setBounds(67, 189, 400, 33);
		panelFirst.add(lblEmail);
		
		lblTel.setFont(new Font("Alice", Font.BOLD, 23));
		lblTel.setBounds(67, 236, 400, 33);
		panelFirst.add(lblTel);
		
		lblAddress.setFont(new Font("Alice", Font.BOLD, 23));
		lblAddress.setBounds(67, 283, 400, 33);
		panelFirst.add(lblAddress);
		
		JButton btnConfirm = new JButton("Confirm"); 
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					confirmAccount confirmAccount = new confirmAccount(email,account_no);
					confirmAccount.confirmAccountpage();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnConfirm.setForeground(new Color(255, 132, 153));
		btnConfirm.setFont(new Font("Alice", Font.BOLD, 25));
		btnConfirm.setFocusable(false);
		btnConfirm.setBackground(Color.WHITE);
		btnConfirm.setBounds(173, 408, 146, 30);
		panelFirst.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomePage homepage = new HomePage(email,account_no);
					homepage.homepagePage();
					frame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCancel.setForeground(new Color(255, 132, 153));
		btnCancel.setFont(new Font("Alice", Font.BOLD, 25));
		btnCancel.setFocusable(false);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(365, 408, 118, 30);
		panelFirst.add(btnCancel);
	}
	public void setlblCustomerDetail(String email) throws IOException{
		File theFile = new File("DataStorage/Customer.json");
        ArrayList<Customer> theList;
		FileReader fileReader = new FileReader(theFile);
		Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
		Gson gson = new Gson();
		theList = gson.fromJson(fileReader, type);
		fileReader.close();

		Customer cus = new Customer();
		cus.setEmail(email);
		for (Customer c : theList) {
			if(c.getEmail().equals(cus.getEmail())){
				lblName.setText("Name :  " + c.getFirstName() + " " + c.getLastName());
				lblDatebirth.setText("Birth :  " + c.getDmy());
				lblTel.setText("Phone :  " + c.getPhone());
				lblAddress.setText("Address :  " + c.getAddress());
				lblEmail.setText("Email :  " + c.getEmail());
			}
		}
	}
}