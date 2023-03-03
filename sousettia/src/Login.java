import java.awt.Color;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import BACKEND.Customer;
import BACKEND.HintTextField;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login implements ActionListener  {

	private JTextField tfEmail;
	private JPasswordField passwordField;
	JFrame frame = new JFrame();
	JButton btnLogin = new JButton("LOGIN");
	JButton btnRegister = new JButton("REGISTER");
	
	//create a frame
	public void loginPage() {
		
		//logo image
		ImageIcon image = new ImageIcon("icon/bank.png");
		frame.setIconImage(image.getImage());
		
		//email 
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Alice", Font.BOLD, 21));
		lblEmail.setBounds(205 ,311 ,79 ,30);
		frame.getContentPane().add(lblEmail);
		
		//password
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Alice", Font.BOLD, 21));
		lblPassword.setBounds(157, 391, 155, 30);
		frame.getContentPane().add(lblPassword);
		
		//swan image
		ImageIcon icon = new ImageIcon("icon/137852811086 (1).png");
		JLabel Icon = new JLabel();
		Icon.setBounds(5,5,0,0);
		Icon.setIcon(icon);
		
		
		//panel for image
		JPanel panel = new JPanel();
		panel.setBounds(244,31,252,226);
		panel.add(Icon);
		frame.getContentPane().add(panel);
		
		//loginbtn
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(this);
		btnLogin.setForeground(new Color(255, 132, 153));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Alice", Font.BOLD, 27));
		btnLogin.setBounds(205, 488, 133, 38);
		frame.getContentPane().add(btnLogin);
		
		//registerbtn
		btnRegister.setFocusable(false);
		btnRegister.addActionListener(this);
		btnRegister.setForeground(new Color(255, 132, 153));
		btnRegister.setFont(new Font("Alice", Font.BOLD, 27));
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setBounds(404, 488, 191, 38);
		frame.getContentPane().add(btnRegister);
		
		//input email
		tfEmail = new HintTextField("Enter gmail or hotmail");
		tfEmail.setFont(new Font("Alice", Font.PLAIN, 15));
		tfEmail.setBackground(new Color(255, 238, 247));
		tfEmail.setBounds(290, 316, 261, 29);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		//input password
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 238, 247));
		passwordField.setBounds(290, 391, 261, 29);
		passwordField.setColumns(10);
		frame.getContentPane().add(passwordField);
		
		JLabel lblWe = new JLabel("Welcome!",SwingConstants.CENTER);
		lblWe.setFont(new Font("Alice", Font.BOLD, 17));
		lblWe.setBounds(169, 449, 394, 30);
		frame.getContentPane().add(lblWe);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 196, 225));
		frame.setVisible(true);
		frame.setBounds(400, 120, 754, 605);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Customer customer = new Customer();

		if(e.getSource()==btnRegister) {
			frame.dispose();
			Register register = new Register();
			register.registerPage();
		}
		
		if(e.getSource()==btnLogin) {
			frame.dispose();
			String email = tfEmail.getText();
			String password = new String(passwordField.getPassword());
			try {
				if(customer.login(email,password)){
					HomePage homepage = new HomePage();
					homepage.homepagePage();
				}else{
					//เตือนข้อผิดพลาด
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
