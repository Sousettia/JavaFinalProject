import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Register implements ActionListener  {
	
	private JTextField tfEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldCF;
	JFrame frame = new JFrame();
	JButton btnNext = new JButton("Next");
	JButton btnCancel = new JButton("Cancel");
	public void registerPage() {
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
		tfEmail.setBackground(new Color(255, 255, 255));
		tfEmail.setBounds(73, 109, 388, 29);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		//Input password
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
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
		passwordFieldCF.setColumns(10);
		passwordFieldCF.setBackground(Color.WHITE);
		passwordFieldCF.setBounds(73, 263, 388, 29);
		frame.getContentPane().add(passwordFieldCF);
		
		//buttonnext
		btnNext.setFocusable(false);
		btnNext.addActionListener(this);
		btnNext.setBackground(Color.WHITE);
		btnNext.setForeground(new Color(255, 132, 153));
		btnNext.setFont(new Font("Alice", Font.BOLD, 25));
		btnNext.setBounds(126, 442, 118, 30);
		frame.getContentPane().add(btnNext);
		
		//buttoncancel
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setForeground(new Color(255, 132, 153));
		btnCancel.setFont(new Font("Alice", Font.BOLD, 25));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(264, 442, 118, 30);
		frame.getContentPane().add(btnCancel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 215, 235));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(500, 120, 553, 538);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCancel) {
			frame.dispose();
			Login login = new Login();
			login.loginPage();
		}
		if(e.getSource()==btnNext) {
			frame.dispose();
			infoRegister inRegister = new infoRegister();
			inRegister.infoRegisterPage();
		}
	}
}
