import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BACKEND.CustomerwithAccount;
import BACKEND.PersonalAccountData;
import BACKEND.accountlist;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class confirmAccount  {

	private JFrame frame = new JFrame();
	private JLabel lblAccount = new JLabel("Account ID:");
	private JLabel lblAccountType = new JLabel("Account Type:");
	private JLabel lblBalance = new JLabel("Balance:");
	private String email;
	private String account_no;

	public confirmAccount(String email, String account_no) throws IOException {
		this.email = email;
		this.account_no = account_no;
		setlblAccountDetail();
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

	/**
	 * @wbp.parser.entryPoint
	 */
	public void confirmAccountpage() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 234, 245));
		frame.setVisible(true);
		frame.setBounds(400, 100, 706, 605);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panelColor = new JPanel();
		panelColor.setLayout(null);
		panelColor.setBackground(new Color(255, 223, 239));
		panelColor.setBounds(0, 0, 692, 86);
		frame.getContentPane().add(panelColor);
		
		JLabel lblOpenAcc = new JLabel("Opened an Saving account");
		lblOpenAcc.setFont(new Font("Alice", Font.BOLD, 30));
		lblOpenAcc.setBounds(153, 24, 450, 41);
		panelColor.add(lblOpenAcc);
		
		JLabel lblTwo = new JLabel("Account Detail ");
		lblTwo.setForeground(new Color(255, 155, 205));
		lblTwo.setFont(new Font("Alice", Font.BOLD, 33));
		lblTwo.setBounds(34, 134, 365, 33);
		frame.getContentPane().add(lblTwo);
	
		lblAccount.setFont(new Font("Alice", Font.BOLD, 23));
		lblAccount.setBounds(64, 204, 400, 33);
		frame.getContentPane().add(lblAccount);
		
		lblAccountType.setFont(new Font("Alice", Font.BOLD, 23));
		lblAccountType.setBounds(64, 251, 400, 33);
		frame.getContentPane().add(lblAccountType);
		
		lblBalance.setFont(new Font("Alice", Font.BOLD, 23));
		lblBalance.setBounds(64, 298, 400, 33);
		frame.getContentPane().add(lblBalance);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
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
		btnConfirm.setForeground(new Color(255, 132, 153));
		btnConfirm.setFont(new Font("Alice", Font.BOLD, 25));
		btnConfirm.setFocusable(false);
		btnConfirm.setBackground(Color.WHITE);
		btnConfirm.setBounds(273, 487, 146, 30);
		frame.getContentPane().add(btnConfirm);
		
		ImageIcon image = new ImageIcon("icon/bank.png");
		frame.setIconImage(image.getImage());
	}
	public void setlblAccountDetail() throws IOException{
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
			if(c.getEmail().equals(getEmail())){
				for (accountlist a : c.getAccountlist()) {
					alar.add(new accountlist(a.getAccount_no()));
				}
			}
		}
		FileReader AccountfileReader = new FileReader(new File("DataStorage/" + account_no + ".json"));
		PersonalAccountData pad = gson.fromJson(AccountfileReader, PersonalAccountData.class);
		
		lblAccount.setText("Account ID:  "+pad.getAccount_no());
		lblBalance.setText("Balance:  " + String.format("%.2f",pad.getBalance()));
		lblAccountType.setText("Account Type:  " + pad.getAccount_type());
	}
}