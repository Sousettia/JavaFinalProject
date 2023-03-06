import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.toedter.calendar.JDateChooser;

import BACKEND.Customer;

public class infoRegister extends Customer implements ActionListener {

	JFrame frame = new JFrame();
	JScrollPane scrollPane = new JScrollPane();
	JButton btnConfirm = new JButton("Confirm");
	JButton btnBack = new JButton("Back");
	JRadioButton genderMale = new JRadioButton("Male");
	JRadioButton genderFemale = new JRadioButton("Female");
	private JTextField tfFname;
	private JTextField tfLname;
	private JTextField tfID;
	private JTextField tfAddress;
	Calendar cld = Calendar.getInstance();
	private JTextField tfPostCode;
	private JTextField tfPhoneNumber;
	private String email;
	private String password;
	private String datestr;
	
	public infoRegister(String email, String password){
		this.email = email;
		this.password = password;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void infoRegisterPage() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(255, 215, 235));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(250, 120, 807, 538);
		
		ImageIcon image = new ImageIcon("bank.png");
		frame.setIconImage(image.getImage());
		
		
		//lblregister
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Alice", Font.BOLD, 28));
		lblRegister.setBounds(337, 23, 118, 41);
		frame.getContentPane().add(lblRegister);
				
		//lblFname 
		JLabel lblFname = new JLabel("Firstname");
		lblFname.setFont(new Font("Alice", Font.BOLD, 21));
		lblFname.setBounds(73 ,69 ,118 ,30);
		frame.getContentPane().add(lblFname);
				
		//Input Fname
		tfFname = new JTextField();
		tfFname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfFname.getText().equals("Enter Firstname")) {
					tfFname.setText(null);
					tfFname.requestFocus();
					tfFname.setFont(new Font("Alice", Font.PLAIN, 15));
					tfFname.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfFname.getText().length()==0) {
					tfFname.setFont(new Font("Alice", Font.ITALIC, 12));
					tfFname.setForeground(Color.gray);
					tfFname.setText("Enter Firstname");
				}
			}
		});
		tfFname.setText("Enter Firstname");
		tfFname.setForeground(Color.gray);
		tfFname.setFont(new Font("Alice", Font.ITALIC, 12));
		tfFname.setBackground(new Color(255, 238, 247));
		tfFname.setBounds(73, 109, 308, 29);
		frame.getContentPane().add(tfFname);
		tfFname.setColumns(10);
						
		//lblLname
		JLabel lblLname = new JLabel("Lastname");
		lblLname.setFont(new Font("Alice", Font.BOLD, 21));
		lblLname.setBounds(73, 148, 109, 30);
		frame.getContentPane().add(lblLname);
				
		
		//Input Lname
		tfLname = new JTextField();
		tfLname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfLname.getText().equals("Enter Lastname")) {
					tfLname.setText(null);
					tfLname.requestFocus();
					tfLname.setFont(new Font("Alice", Font.PLAIN, 15));
					tfLname.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfLname.getText().length()==0) {
					tfLname.setFont(new Font("Alice", Font.ITALIC, 12));
					tfLname.setForeground(Color.gray);
					tfLname.setText("Enter Lastname");
				}
			}
		});
		tfLname.setText("Enter Lastname");
		tfLname.setForeground(Color.gray);
		tfLname.setFont(new Font("Alice", Font.ITALIC, 12));
		tfLname.setColumns(10);
		tfLname.setBackground(new Color(255, 238, 247));
		tfLname.setBounds(73, 188, 308, 29);
		frame.getContentPane().add(tfLname);
		
		//lblIDinfo
		JLabel lblIDinfo = new JLabel("Identification ID");
		lblIDinfo.setFont(new Font("Alice", Font.BOLD, 21));
		lblIDinfo.setBounds(73, 222, 180, 30);
		frame.getContentPane().add(lblIDinfo);
		
		//input Identification ID
		tfID = new JTextField();
		tfID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfID.getText().equals("Enter Identification ID")) {
					tfID.setText(null);
					tfID.requestFocus();
					tfID.setFont(new Font("Alice", Font.PLAIN, 15));
					tfID.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfID.getText().length()==0) {
					tfID.setFont(new Font("Alice", Font.ITALIC, 12));
					tfID.setForeground(Color.gray);
					tfID.setText("Enter Identification ID");
				}
			}
		});
		tfID.setText("Enter Identification ID");
		tfID.setForeground(Color.gray);
		tfID.setFont(new Font("Alice", Font.ITALIC, 12));
		tfID.setColumns(10);
		tfID.setBackground(new Color(255, 238, 247));
		tfID.setBounds(73, 262, 308, 29);
		frame.getContentPane().add(tfID);
		
		//lblAddress
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Alice", Font.BOLD, 21));
		lblAddress.setBounds(73, 301, 180, 30);
		frame.getContentPane().add(lblAddress);
		
		//input address
		tfAddress = new JTextField();
		tfAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfAddress.getText().equals("Enter Address")) {
					tfAddress.setText(null);
					tfAddress.requestFocus();
					tfAddress.setFont(new Font("Alice", Font.PLAIN, 15));
					tfAddress.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfAddress.getText().length()==0) {
					tfAddress.setFont(new Font("Alice", Font.ITALIC, 12));
					tfAddress.setForeground(Color.gray);
					tfAddress.setText("Enter Address");
				}
			}
		});
		tfAddress.setText("Enter Address");
		tfAddress.setForeground(Color.gray);
		tfAddress.setFont(new Font("Alice", Font.ITALIC, 12));
		tfAddress.setColumns(10);
		tfAddress.setBackground(new Color(255, 238, 247));
		tfAddress.setBounds(73, 341, 308, 29);
		frame.getContentPane().add(tfAddress);
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfirm.setBackground(new Color(255, 227, 233));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConfirm.setBackground(Color.WHITE);
			}
		});
		
		//buttonConfirm
		btnConfirm.setFocusable(false);
		btnConfirm.addActionListener(this);
		btnConfirm.setBackground(Color.WHITE);
		btnConfirm.setForeground(new Color(255, 132, 153));
		btnConfirm.setFont(new Font("Alice", Font.BOLD, 25));
		btnConfirm.setBounds(222, 442, 141, 30);
		frame.getContentPane().add(btnConfirm);
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(new Color(255, 227, 233));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setBackground(Color.WHITE);
			}
		});
		//buttonBack
		btnBack.setFocusable(false);
		btnBack.addActionListener(this);
		btnBack.setForeground(new Color(255, 132, 153));
		btnBack.setFont(new Font("Alice", Font.BOLD, 25));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(431, 442, 118, 30);
		frame.getContentPane().add(btnBack);
		
		JLabel lblBirth = new JLabel("Date of Birth");
		lblBirth.setFont(new Font("Alice", Font.BOLD, 21));
		lblBirth.setBounds(431, 148, 141, 30);
		frame.getContentPane().add(lblBirth);
		
		JDateChooser dateChooser = new JDateChooser(cld.getTime());
		dateChooser.setBackground(new Color(255, 255, 255));
		dateChooser.setBounds(431, 188, 308, 29);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		datestr = new SimpleDateFormat("dd-MMM-yyyy").format(dateChooser.getDate());
		frame.getContentPane().add(dateChooser);
		
		JLabel lblPostalCode = new JLabel("Postal code");
		lblPostalCode.setFont(new Font("Alice", Font.BOLD, 21));
		lblPostalCode.setBounds(431, 222, 141, 30);
		frame.getContentPane().add(lblPostalCode);
		
		tfPostCode = new JTextField();
		tfPostCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfPostCode.getText().equals("Enter Postal Code")) {
					tfPostCode.setText(null);
					tfPostCode.requestFocus();
					tfPostCode.setFont(new Font("Alice", Font.PLAIN, 15));
					tfPostCode.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfPostCode.getText().length()==0) {
					tfPostCode.setFont(new Font("Alice", Font.ITALIC, 12));
					tfPostCode.setForeground(Color.gray);
					tfPostCode.setText("Enter Postal Code");
				}
			}
		});
		tfPostCode.setText("Enter Postal Code");
		tfPostCode.setFont(new Font("Alice", Font.ITALIC, 12));
		tfPostCode.setForeground(Color.GRAY);
		tfPostCode.setColumns(10);
		tfPostCode.setBackground(new Color(255, 238, 247));
		tfPostCode.setBounds(431, 262, 308, 29);
		frame.getContentPane().add(tfPostCode);
		
		JLabel lblPhoneNo = new JLabel("Phone number");
		lblPhoneNo.setFont(new Font("Alice", Font.BOLD, 21));
		lblPhoneNo.setBounds(431, 301, 164, 30);
		frame.getContentPane().add(lblPhoneNo);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfPhoneNumber.getText().equals("Enter Phone Number")) {
					tfPhoneNumber.setText(null);
					tfPhoneNumber.requestFocus();
					tfPhoneNumber.setFont(new Font("Alice", Font.PLAIN, 15));
					tfPhoneNumber.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfPhoneNumber.getText().length()==0) {
					tfPhoneNumber.setFont(new Font("Alice", Font.ITALIC, 12));
					tfPhoneNumber.setForeground(Color.gray);
					tfPhoneNumber.setText("Enter Phone Number");
				}
			}
		});
		tfPhoneNumber.setText("Enter Phone Number");
		tfPhoneNumber.setForeground(Color.GRAY);
		tfPhoneNumber.setFont(new Font("Alice", Font.ITALIC, 12));
		tfPhoneNumber.setColumns(10);
		tfPhoneNumber.setBackground(new Color(255, 238, 247));
		tfPhoneNumber.setBounds(431, 341, 308, 29);
		frame.getContentPane().add(tfPhoneNumber);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Alice", Font.BOLD, 21));
		lblGender.setBounds(431, 69, 141, 30);
		frame.getContentPane().add(lblGender);
		
		genderMale.setFont(new Font("Alice", Font.PLAIN, 18));
		genderMale.setBounds(431, 109, 141, 29);
		frame.getContentPane().add(genderMale);
		
		genderFemale.setFont(new Font("Alice", Font.PLAIN, 18));
		genderFemale.setBounds(593, 109, 141, 29);
		frame.getContentPane().add(genderFemale);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnConfirm) {
			frame.dispose();
			
			try {
				if(super.idcheck(tfID.getText())){
					
					super.register(email,password,tfFname.getText(),tfLname.getText(),tfID.getText(),tfAddress.getText());
					System.out.print(datestr);
					Login login = new Login();
					login.loginPage();

				}else{
					//เตือนข้อผิดพลาด รับค่าIDใหม่
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==btnBack) {
			frame.dispose();
			Register register = new Register();
			register.registerPage();
		}
	}
}