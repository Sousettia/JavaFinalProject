import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class infoRegister implements ActionListener {


	JFrame frame = new JFrame();
	JButton btnConfirm = new JButton("Confirm");
	JButton btnBack = new JButton("Back");
	private JTextField tfFname;
	private JTextField tfLname;
	private JTextField tfID;
	private JTextField tfAddress;
	
	public infoRegister() {
		ImageIcon image = new ImageIcon("bank.png");
		frame.setIconImage(image.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(255, 215, 235));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(500, 120, 553, 538);
		
		//lblregister
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Alice", Font.BOLD, 28));
		lblRegister.setBounds(210, 10, 118, 41);
		frame.getContentPane().add(lblRegister);
				
		//lblFname 
		JLabel lblFname = new JLabel("Firstname");
		lblFname.setFont(new Font("Alice", Font.BOLD, 21));
		lblFname.setBounds(73 ,69 ,118 ,30);
		frame.getContentPane().add(lblFname);
				
		//Input Fname
		tfFname = new JTextField();
		tfFname.setBackground(new Color(255, 238, 247));
		tfFname.setBounds(73, 109, 388, 29);
		frame.getContentPane().add(tfFname);
		tfFname.setColumns(10);
						
		//lblLname
		JLabel lblLname = new JLabel("Lastname");
		lblLname.setFont(new Font("Alice", Font.BOLD, 21));
		lblLname.setBounds(73, 148, 109, 30);
		frame.getContentPane().add(lblLname);
				
		
		//Input Lname
		tfLname = new JTextField();
		tfLname.setColumns(10);
		tfLname.setBackground(new Color(255, 238, 247));
		tfLname.setBounds(73, 188, 388, 29);
		frame.getContentPane().add(tfLname);
		
		//lblIDinfo
		JLabel lblIDinfo = new JLabel("Identification ID");
		lblIDinfo.setFont(new Font("Alice", Font.BOLD, 21));
		lblIDinfo.setBounds(73, 222, 180, 30);
		frame.getContentPane().add(lblIDinfo);
		
		//input Identification ID
		tfID = new JTextField();
		tfID.setColumns(10);
		tfID.setBackground(new Color(255, 238, 247));
		tfID.setBounds(73, 262, 388, 29);
		frame.getContentPane().add(tfID);
		
		//lblAddress
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Alice", Font.BOLD, 21));
		lblAddress.setBounds(73, 301, 180, 30);
		frame.getContentPane().add(lblAddress);
		
		//input address
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBackground(new Color(255, 238, 247));
		tfAddress.setBounds(73, 341, 388, 29);
		frame.getContentPane().add(tfAddress);
		
		//buttonConfirm
		btnConfirm.setFocusable(false);
		btnConfirm.addActionListener(this);
		btnConfirm.setBackground(Color.WHITE);
		btnConfirm.setForeground(new Color(255, 132, 153));
		btnConfirm.setFont(new Font("Alice", Font.BOLD, 25));
		btnConfirm.setBounds(122, 442, 141, 30);
		frame.getContentPane().add(btnConfirm);
				
		//buttonBack
		btnBack.setFocusable(false);
		btnBack.addActionListener(this);
		btnBack.setForeground(new Color(255, 132, 153));
		btnBack.setFont(new Font("Alice", Font.BOLD, 25));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(291, 442, 118, 30);
		frame.getContentPane().add(btnBack);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConfirm) {
			frame.dispose();
			Login login = new Login();
		}
		if(e.getSource()==btnBack) {
			frame.dispose();
			Register register = new Register();
		}
	}
}
