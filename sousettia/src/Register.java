import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BACKEND.Customer;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Register implements ActionListener{
	
	private JTextField tfEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldCF;
	JFrame frame = new JFrame();
	JButton btnNext = new JButton("Next");
	JButton btnCancel = new JButton("Cancel");
	JLabel lblChkemail = new JLabel();
	JLabel lblChkpass = new JLabel();
	public void registerPage() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 215, 235));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		frame.setBounds(500, 120, 553, 538);
		ImageIcon image = new ImageIcon("icon/bank.png");
		frame.setIconImage(image.getImage());
		
		//lblregister
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Alice", Font.BOLD, 28));
		lblRegister.setBounds(210, 10, 118, 41);
		frame.getContentPane().add(lblRegister);
		
		//lblemail 
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Alice", Font.BOLD, 21));
		lblEmail.setBounds(73 ,69 ,69 ,30);
		frame.getContentPane().add(lblEmail);
		
		//Input Email
		tfEmail = new JTextField();
		tfEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfEmail.getText().equals("Enter gmail or hotmail")) {
					tfEmail.setText(null);
					tfEmail.requestFocus();
					tfEmail.setFont(new Font("Alice", Font.PLAIN, 15));
					tfEmail.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfEmail.getText().length()==0) {
					tfEmail.setFont(new Font("Alice", Font.ITALIC, 12));
					tfEmail.setForeground(Color.gray);
					tfEmail.setText("Enter gmail or hotmail");
				}
			}
		});
		tfEmail.setText("Enter gmail or hotmail");
		tfEmail.setBackground(new Color(255, 238, 247));
		tfEmail.setForeground(Color.gray);
		tfEmail.setBounds(73, 109, 388, 29);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		//Input password
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String password = new String(passwordField.getPassword());
				if(password.equals("Enter password")) {
					passwordField.setText(null);
					passwordField.requestFocus();
					passwordField.setFont(new Font("Alice", Font.PLAIN, 15));
					passwordField.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				String password = new String(passwordField.getPassword());
				if(password.length()==0) {
					passwordField.setFont(new Font("Alice", Font.ITALIC, 12));
					passwordField.setForeground(Color.gray);
					passwordField.setText("Enter password");
				}
			}
		});
		passwordField.setText("Enter password");
		passwordField.setForeground(Color.gray);
		passwordField.setBackground(new Color(255, 238, 247));
		passwordField.setBounds(73, 188, 388, 29);
		passwordField.setColumns(10);
		frame.getContentPane().add(passwordField);
		
		//lblpassword
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Alice", Font.BOLD, 21));
		lblPass.setBounds(73, 148, 107, 30);
		frame.getContentPane().add(lblPass);
		
		//lblCfpassword
		JLabel lblCpass = new JLabel("Confirm Password");
		lblCpass.setFont(new Font("Alice", Font.BOLD, 21));
		lblCpass.setBounds(73, 222, 198, 30);
		frame.getContentPane().add(lblCpass);
		
		//Input confirm password
		passwordFieldCF = new JPasswordField();
		passwordFieldCF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String password = new String(passwordFieldCF.getPassword());
				if(password.equals("Comfirm password")) {
					passwordFieldCF.setText(null);
					passwordFieldCF.requestFocus();
					passwordFieldCF.setFont(new Font("Alice", Font.PLAIN, 15));
					passwordFieldCF.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				String password = new String(passwordFieldCF.getPassword());
				if(password.length()==0) {
					passwordFieldCF.setFont(new Font("Alice", Font.ITALIC, 12));
					passwordFieldCF.setForeground(Color.gray);
					passwordFieldCF.setText("Comfirm password");
				}
			}
		});
		passwordFieldCF.setText("Comfirm password");
		passwordFieldCF.setColumns(10);
		passwordFieldCF.setForeground(Color.gray);
		passwordFieldCF.setBackground(new Color(255, 238, 247));
		passwordFieldCF.setBounds(73, 263, 388, 29);
		frame.getContentPane().add(passwordFieldCF);
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNext.setBackground(new Color(255, 227, 233));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNext.setBackground(Color.WHITE);
			}
		});
		
		//buttonnext
		btnNext.setFocusable(false);
		btnNext.addActionListener(this);
		btnNext.setBackground(Color.WHITE);
		btnNext.setForeground(new Color(255, 132, 153));
		btnNext.setFont(new Font("Alice", Font.BOLD, 25));
		btnNext.setBounds(126, 442, 118, 30);
		frame.getContentPane().add(btnNext);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setBackground(new Color(255, 227, 233));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setBackground(Color.WHITE);
			}
		});
		
		//buttoncancel
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setForeground(new Color(255, 132, 153));
		btnCancel.setFont(new Font("Alice", Font.BOLD, 25));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(264, 442, 118, 30);
		frame.getContentPane().add(btnCancel);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Customer customer = new Customer();
		
		if(e.getSource()==btnCancel) {
			frame.dispose();
			Login login = new Login();
			login.loginPage();
		}
		if(e.getSource()==btnNext) {
			customer.setEmail(tfEmail.getText());
			customer.setPassword(new String(passwordField.getPassword()));
			customer.setConfirmPassword(new String(passwordFieldCF.getPassword()));

			if(customer.register_enpcheck(customer.getEmail(),customer.getPassword(),customer.getConfirmPassword())){
				infoRegister inRegister = new infoRegister(customer.getEmail(),customer.getPassword());
				inRegister.infoRegisterPage();
				frame.dispose();
			}else{
				if(!customer.checkEmail()){
					lblChkemail = new JLabel("Try again, the email doesn't correct.");
					lblChkemail.setBounds(107, 392, 515, 30);
					frame.getContentPane().add(lblChkemail);
					lblChkemail.setFont(new Font("Alice", Font.BOLD, 17));
					lblChkemail.setForeground(Color.red);
					lblChkpass.setText(null);
				}else if(!customer.checkPassword()){
					lblChkpass = new JLabel("Try again, the passwords don't match.");
					lblChkpass.setBounds(107, 392, 515, 30);
					frame.getContentPane().add(lblChkpass);
					lblChkpass.setFont(new Font("Alice", Font.BOLD, 17));
					lblChkpass.setForeground(Color.red);
					lblChkemail.setText(null);
				}
			}
		}
	}
}
