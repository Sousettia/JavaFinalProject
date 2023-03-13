import java.awt.Color;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BACKEND.Customer;
import BACKEND.CustomerwithAccount;
import BACKEND.accountlist;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends Customer implements ActionListener {

	private JTextField tfEmail;
	private JPasswordField passwordField;
	JFrame frame = new JFrame();
	JButton btnLogin = new JButton("LOGIN");
	JButton btnRegister = new JButton("REGISTER");
	JLabel lblWe = new JLabel("Welcome!",SwingConstants.CENTER);
	
	//create a frame
	public void loginPage() {
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 196, 225));
		frame.setVisible(true);
		frame.setBounds(400, 120, 754, 605);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		//logo image
		ImageIcon image = new ImageIcon(getClass().getResource("icon/bank.png"));
		frame.setIconImage(image.getImage());
		
		//swan image
		ImageIcon icon = new ImageIcon(getClass().getResource("icon/137852811086 (1).png"));
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(255, 196, 225));
		panelLogin.setBounds(0, 0, 740, 568);
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		JLabel Icon = new JLabel();
		Icon.setBounds(5,5,0,0);
		Icon.setIcon(icon);
		
		
		//panel for image
		JPanel panel = new JPanel();
		panel.setBounds(243, 31, 252, 226);
		panelLogin.add(panel);
		panel.add(Icon);
		
		//email 
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(204, 311, 79, 30);
		panelLogin.add(lblEmail);
		lblEmail.setFont(new Font("Alice", Font.BOLD, 21));
		
		//input email
		tfEmail = new JTextField();
		tfEmail.setBounds(293, 315, 261, 29);
		panelLogin.add(tfEmail);
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
		tfEmail.setForeground(Color.gray);
		tfEmail.setFont(new Font("Alice", Font.PLAIN, 15));
		tfEmail.setBackground(new Color(255, 238, 247));
		tfEmail.setColumns(10);
		
		//password
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(156, 390, 155, 30);
		panelLogin.add(lblPassword);
		lblPassword.setFont(new Font("Alice", Font.BOLD, 21));
		
		//input password
		passwordField = new JPasswordField();
		passwordField.setBounds(293, 391, 261, 29);
		panelLogin.add(passwordField);
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
		passwordField.setColumns(10);
		
		lblWe.setBounds(172, 449, 394, 30);
		panelLogin.add(lblWe);
		lblWe.setFont(new Font("Alice", Font.BOLD, 17));
		btnLogin.setBounds(204, 489, 133, 38);
		panelLogin.add(btnLogin);
		
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(255, 227, 233));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(Color.WHITE);
			}
		});
		//loginbtn
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(this);
		btnLogin.setForeground(new Color(255, 132, 153));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Alice", Font.BOLD, 27));
		btnRegister.setBounds(405, 489, 191, 38);
		panelLogin.add(btnRegister);
		
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegister.setBackground(new Color(255, 227, 233));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegister.setBackground(Color.WHITE);
			}
		});
		//registerbtn
		btnRegister.setFocusable(false);
		btnRegister.addActionListener(this);
		btnRegister.setForeground(new Color(255, 132, 153));
		btnRegister.setFont(new Font("Alice", Font.BOLD, 27));
		btnRegister.setBackground(new Color(255, 255, 255));
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnRegister) {
			frame.dispose();
			Register register = new Register();
			register.registerPage();
		}
		
		if(e.getSource()==btnLogin) {
			try {
				if(super.login(tfEmail.getText(),new String(passwordField.getPassword()))){
					super.setEmail(tfEmail.getText());
					HomePage homepage = new HomePage(tfEmail.getText(),account_no());
					homepage.homepagePage();
					frame.dispose();
				}else{
					lblWe.setText("Sorry, but your password or email was incorrect.");
                    lblWe.setForeground(Color.red);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public String account_no() throws IOException{
		//#region getAccountNumber
		try {
			File theFile = new File("DataStorage/CustomerwithAccount.json");
			Gson gson = new Gson();

			//Read Data From CWA
			ArrayList<CustomerwithAccount> theCustomerwithAccountList = new ArrayList<>();

			FileReader fileReader = new FileReader(theFile);
			Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
			theCustomerwithAccountList = gson.fromJson(fileReader, type);
			fileReader.close();

			ArrayList<accountlist> alar = new ArrayList<>();
			for (CustomerwithAccount c : theCustomerwithAccountList) {
				if(c.getEmail().equals(tfEmail.getText())){
					for (accountlist a : c.getAccountlist()) {
						alar.add(new accountlist(a.getAccount_no()));
					}
				}
			}
			String DefaultaccountNumber = "";
			for (accountlist accountlist : alar) {
				DefaultaccountNumber = accountlist.getAccount_no();
				break;
			}

			return DefaultaccountNumber;
		} catch (Exception e) {
			e.printStackTrace();
			return "NULL";
		}
	}
}
