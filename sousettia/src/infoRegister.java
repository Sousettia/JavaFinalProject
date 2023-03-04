import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BACKEND.Customer;

public class infoRegister extends Customer implements ActionListener {


	JFrame frame = new JFrame();
	JButton btnConfirm = new JButton("Confirm");
	JButton btnBack = new JButton("Back");
	private JTextField tfFname;
	private JTextField tfLname;
	private JTextField tfID;
	private JTextField tfAddress;
	private String email;
	private String password;
	
	public infoRegister(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public void infoRegisterPage() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(255, 215, 235));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(500, 120, 553, 538);
		
		ImageIcon image = new ImageIcon("bank.png");
		frame.setIconImage(image.getImage());
		
		
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
		tfAddress.setColumns(10);
		tfAddress.setBackground(new Color(255, 238, 247));
		tfAddress.setBounds(73, 341, 388, 29);
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
		btnConfirm.setBounds(122, 442, 141, 30);
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
		btnBack.setBounds(291, 442, 118, 30);
		frame.getContentPane().add(btnBack);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConfirm) {
			frame.dispose();
			
			try {
				if(super.idcheck(tfID.getText())){
					super.register(email,password,tfFname.getText(),tfLname.getText(),tfID.getText(),tfAddress.getText());
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
