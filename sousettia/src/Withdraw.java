import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BACKEND.Customer;
import BACKEND.CustomerwithAccount;
import BACKEND.PersonalAccountData;
import BACKEND.accountlist;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Withdraw  {

	JFrame frame = new JFrame();
	private JTextField txtBahtWD;
	JLabel lblAccountIdTF = new JLabel("Account ID:");
	JLabel lblBalanceTF = new JLabel("Balance:");
	public String email;


	public Withdraw(String email) throws IOException {
		this.email = email;
		setlblAccountDetail(email);
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void Withdrawpage() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 234, 245));
		frame.setVisible(true);
		frame.setBounds(400, 100, 706, 605);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panelTranfer = new JPanel();
		panelTranfer.setLayout(null);
		panelTranfer.setBackground(new Color(255, 196, 225));
		panelTranfer.setBounds(100, 34, 492, 143);
		frame.getContentPane().add(panelTranfer);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFrom.setFont(new Font("Alice", Font.BOLD, 25));
		lblFrom.setBounds(-86, 10, 169, 27);
		panelTranfer.add(lblFrom);
		
		lblAccountIdTF.setFont(new Font("Alice", Font.BOLD, 23));
		lblAccountIdTF.setBounds(54, 47, 400, 27);
		panelTranfer.add(lblAccountIdTF);
		
		lblBalanceTF.setFont(new Font("Alice", Font.BOLD, 23));
		lblBalanceTF.setBounds(54, 84, 400, 27);
		panelTranfer.add(lblBalanceTF);
		
		JLabel lblEnterAmount = new JLabel("Please enter the amount you wish to withdraw.");
		lblEnterAmount.setFont(new Font("Alice", Font.BOLD, 19));
		lblEnterAmount.setBounds(56, 255, 429, 27);
		frame.getContentPane().add(lblEnterAmount);
		
		txtBahtWD = new JTextField();
		txtBahtWD.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtBahtWD.getText().equals("0.00 Baht.")) {
					txtBahtWD.setText(null);
					txtBahtWD.requestFocus();
					txtBahtWD.setFont(new Font("Alice", Font.PLAIN, 15));
					txtBahtWD.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtBahtWD.getText().length()==0) {
					txtBahtWD.setFont(new Font("Alice", Font.ITALIC, 12));
					txtBahtWD.setForeground(Color.gray);
					txtBahtWD.setText("0.00 Baht.");
				}
			}
		});
		txtBahtWD.setFont(new Font("Tahoma", Font.PLAIN, 42));
		txtBahtWD.setText("0.00 Baht.");
		txtBahtWD.setForeground(Color.GRAY);
		txtBahtWD.setColumns(10);
		txtBahtWD.setBackground(new Color(255, 238, 247));
		txtBahtWD.setBounds(137, 307, 418, 103);
		frame.getContentPane().add(txtBahtWD);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isDouble(txtBahtWD.getText())){
					try {
						Customer cus = new Customer();
						cus.setEmail(email);
						cus.withdraw(Double.parseDouble(txtBahtWD.getText()));
						HomePage homepage = new HomePage(email);
						homepage.homepagePage();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else{
					System.out.println("WRONG");
				}
				frame.dispose();
			}
		});
		btnConfirm.setForeground(new Color(255, 132, 153));
		btnConfirm.setFont(new Font("Alice", Font.BOLD, 25));
		btnConfirm.setFocusable(false);
		btnConfirm.setBackground(Color.WHITE);
		btnConfirm.setBounds(135, 496, 146, 30);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomePage homepage = new HomePage(email);
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
		btnCancel.setBounds(378, 496, 118, 30);
		frame.getContentPane().add(btnCancel);
		
		ImageIcon image = new ImageIcon("icon/bank.png");
		frame.setIconImage(image.getImage());
	}
	public void setlblAccountDetail(String email) throws IOException{
		Customer cus = new Customer();
		//#region getAccountNumber
		File theFile = new File("DataStorage/CustomerwithAccount.json");
        Gson gson = new Gson();

        //Read Data From CWA
        ArrayList<CustomerwithAccount> theCustomerwithAccountList = new ArrayList<>();

        FileReader fileReader = new FileReader(theFile);
        Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
        theCustomerwithAccountList = gson.fromJson(fileReader, type);
        fileReader.close();

		cus.setEmail(email);
        ArrayList<accountlist> alar = new ArrayList<>();
        for (CustomerwithAccount c : theCustomerwithAccountList) {
            if(c.getEmail().equals(cus.getEmail())){
                for (accountlist a : c.getAccountlist()) {
                    alar.add(new accountlist(a.getAccount_no()));
                }
            }
        }
		String accountNumber = "";
		for (accountlist accountlist : alar) {
			accountNumber = accountlist.getAccount_no();
			break;
		}
		//#endregion
		try {
			FileReader AccountfileReader = new FileReader(new File("DataStorage/" + accountNumber + ".json"));
			PersonalAccountData pad = gson.fromJson(AccountfileReader, PersonalAccountData.class);

			lblAccountIdTF.setText("Account ID:  "+pad.getAccount_no());
			lblBalanceTF.setText("Balance:  " + String.format("%.2f",pad.getBalance()));
		} catch (IOException e) {
			//
		}
	}
	public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
