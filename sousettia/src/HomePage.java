import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Timer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BACKEND.Customer;
import BACKEND.CustomerwithAccount;
import BACKEND.DataFinanceNews;
import BACKEND.FinanceNews;
import BACKEND.accountlist;
import BACKEND.transaction;
import BACKEND.PersonalAccountData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HomePage {

	JFrame frame = new JFrame();
	Timer tm1,tm2,tm3;
	int pl1 = 65;
	ImageIcon imageButton1 = new ImageIcon("icon/Home Icon.png");
	ImageIcon imageButton2 = new ImageIcon("icon/R_1.png");
	ImageIcon imageButton3 = new ImageIcon("icon/R.png");
	ImageIcon imageButton4 = new ImageIcon("icon/OIP.png");
	ImageIcon imageButton5 = new ImageIcon("icon/menu.png");
	JButton btnHome = new JButton(imageButton1);
	JButton btnBookbank = new JButton(imageButton2);
	JButton btnTransfer = new JButton(imageButton3);
	JButton btnCurrency = new JButton(imageButton4);
	JButton btnMenu = new JButton(imageButton5);
	JList<transaction> list = new JList<>();
	DefaultListModel<transaction> model = new DefaultListModel<>();
    JPanel panel2 = new JPanel();
	JComboBox<String> cb1 = new JComboBox<String>();
    JComboBox<String> cb2 = new JComboBox<String>();
	JPanel panelTransaction = new JPanel();
	JPanel panell = new JPanel();
	JLabel label = new JLabel();
	JSplitPane splitPane = new JSplitPane();
	JPanel panelTranfer_1 = new JPanel();
	private final JPanel gatherPanel = new JPanel();
	private final JPanel jp1 = new JPanel();
	private final JPanel jp2 = new JPanel();
	private final JPanel jp3 = new JPanel();
	private final JPanel jp4 = new JPanel();
	private final JPanel DropoutMenu = new JPanel();
	private final JButton btnHome_2 = new JButton("HOME");
	private final JButton btnBookbank_2 = new JButton("BOOKBANK");
	private final JButton btnTransfer_2 = new JButton("TRANSFER");
	private final JButton btnCurrency_2 = new JButton("CURRENCY");

	private final JLabel lblCustomerDetail = new JLabel("Customer Detail",SwingConstants.CENTER);
	private JLabel lblName = new JLabel("Name:");
	private JLabel lblDateOfBirth = new JLabel("Birth:");
	private JLabel lblPhoneNumber = new JLabel("Phone:");
	private JLabel lblAddress = new JLabel("Address:");
	private JLabel lblEmail = new JLabel("Email:");
	Customer cus = new Customer();
	private final JLabel lblAccountDetail = new JLabel("Account Detail",SwingConstants.CENTER);
	private JLabel lblAccountId = new JLabel("Account ID:");
	private JLabel lblAccountType = new JLabel("Account Type:");
	private JLabel lblBalance = new JLabel("Balance:");

	private JLabel lblFrom = new JLabel("From");
	private JLabel lblAccountIdTF = new JLabel("Account ID:");
	private JLabel lblBalanceTF = new JLabel("Balance:");
	
	private final JLabel lblTransaction = new JLabel("Transaction", SwingConstants.LEFT);
	private final JButton btnCreateaccount = new JButton("CREATEACCOUNT");
	private final JButton btnLogout = new JButton("LOG OUT");

	private final JPanel customerPanel = new JPanel();
	private final JButton btnTransferBank = new JButton("Transfer");
	private final JLabel lblChangeAccount = new JLabel("Change Account", SwingConstants.LEFT);
	private JComboBox<String> comboBox = new JComboBox<>();
	private final JLabel lblBackground = new JLabel("");
    private final JLabel lblBackground2 = new JLabel("");
	private JTextField tfAccount;
	private JTextField tfAmount;
	private JTextField tfComment;
	private String email;
	private String account_no;

	private final JPanel panel1 = new JPanel();
    private final JLabel lblphoto2 = new JLabel("");
    private final JLabel lblOpen = new JLabel("Open:");
    private final JLabel lblHigh = new JLabel("High:");
    private final JLabel lblLow = new JLabel("Low:");
    private final JLabel lblClose = new JLabel("Close:");
    private final JLabel lblVolume = new JLabel("Volume:");
    private final JLabel lblSymbol = new JLabel("Symbol:");
    private final JLabel lblDate = new JLabel("Date:");
    private final JLabel lblTitle = new JLabel("Title:");
    private final JLabel lblUrl = new JLabel("Url:");
    private final JLabel lblDescription = new JLabel("Description:");
    private final JLabel lblPublished = new JLabel("Published at:");
	private final JTextArea textAreaTitle = new JTextArea("");
	private final JTextArea textAreaDescription = new JTextArea("");
    private final JLabel lblphoto1 = new JLabel("");

	private JTextField tfBaht;
    private final JLabel lblbaht = new JLabel("THB - Thai Baht");
    private final JPanel panelTh_1 = new JPanel();
    private final JPanel panel_1 = new JPanel();
    private final JLabel lblBird = new JLabel("");
	
	public HomePage(String email, String account_no) throws IOException {
		this.email = email;
		this.account_no = account_no;
		setlblAccountDetail();
		setlblCustomerDetail();
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void setlblCustomerDetail() throws IOException{

		File theFile = new File("DataStorage/Customer.json");
        ArrayList<Customer> theList;
		FileReader fileReader = new FileReader(theFile);
		Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
		Gson gson = new Gson();
		theList = gson.fromJson(fileReader, type);
		fileReader.close();

		cus.setEmail(email);
		for (Customer c : theList) {
			if(c.getEmail().equals(cus.getEmail())){
				lblName.setText("Name :  " + c.getFirstName() + " " + c.getLastName());
				lblDateOfBirth.setText("Birth :  " + c.getDmy());
				lblPhoneNumber.setText("Phone :  " + c.getPhone());
				lblAddress.setText("Address :  " + c.getAddress());
				lblEmail.setText("Email :  " + c.getEmail());
			}
		}
	}
	public void setlblAccountDetail() throws IOException{
	
		try {
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
			FileReader AccountfileReader = new FileReader(new File("DataStorage/" + account_no + ".json"));
			PersonalAccountData pad = gson.fromJson(AccountfileReader, PersonalAccountData.class);
			
			lblAccountId.setText("Account ID:  "+pad.getAccount_no());
			lblBalance.setText("Balance:  " + String.format("%.2f",pad.getBalance()));
			lblAccountType.setText("Account Type:  " + pad.getAccount_type());

			lblAccountIdTF.setText("Account ID:  "+pad.getAccount_no());
			lblBalanceTF.setText("Balance:  " + String.format("%.2f",pad.getBalance()));
		} catch (IOException e) {
			lblAccountId.setText("");
			lblBalance.setText("");
			lblAccountType.setText("");

			lblAccountIdTF.setText("Please Create Account First");
			lblAccountIdTF.setForeground(Color.red);
			lblBalanceTF.setText("");
			
			e.printStackTrace();
		}
	}
	public void homepagePage() throws IOException {
		//icon
		ImageIcon image = new ImageIcon("icon/bank.png");
		frame.setIconImage(image.getImage());
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 196, 225));
		frame.setVisible(true);
		frame.setBounds(100, 70, 1320, 720);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
		
		DropoutMenu.setLayout(null);
		DropoutMenu.setBackground(new Color(255, 196, 225));
		DropoutMenu.setBounds(1181, 0, 115, 65);
		
		
		frame.getContentPane().add(DropoutMenu);
		btnHome_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome_2.setFont(new Font("Alice", Font.BOLD, 12));
		btnHome_2.setBounds(-13, 67, 128, 37);
		btnHome_2.setBorderPainted(false);
		btnHome_2.setForeground(new Color(255, 247, 251));
		btnHome_2.setBackground(new Color(255, 196, 225));
		DropoutMenu.add(btnHome_2);
		btnHome_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(true);
				jp2.setVisible(false);
				jp3.setVisible(false);
				jp4.setVisible(false);
				btnHome.setBackground(new Color(255, 232, 243));
				btnBookbank.setBackground(new Color(255, 196, 225));
				btnTransfer.setBackground(new Color(255, 196, 225));
				btnCurrency.setBackground(new Color(255, 196, 225));
			}
		});
		btnBookbank_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnBookbank_2.setFont(new Font("Alice", Font.BOLD, 12));
		btnBookbank_2.setBounds(-13, 109, 128, 37);
		btnBookbank_2.setForeground(new Color(255, 247, 251));
		btnBookbank_2.setBorderPainted(false);
		btnBookbank_2.setBackground(new Color(255, 196, 225));
		DropoutMenu.add(btnBookbank_2);
		btnBookbank_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(true);
				jp3.setVisible(false);
				jp4.setVisible(false);
				btnHome.setBackground(new Color(255, 196, 225));
				btnBookbank.setBackground(new Color(255, 232, 243));
				btnTransfer.setBackground(new Color(255, 196, 225));
				btnCurrency.setBackground(new Color(255, 196, 225));
			}
		});
		btnTransfer_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		btnTransfer_2.setFont(new Font("Alice", Font.BOLD, 12));
		btnTransfer_2.setForeground(new Color(255, 247, 251));
		btnTransfer_2.setBackground(new Color(255, 196, 225));
		btnTransfer_2.setBounds(-13, 151, 128, 37);
		btnTransfer_2.setBorderPainted(false);
		DropoutMenu.add(btnTransfer_2);
		btnTransfer_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(false);
				jp3.setVisible(true);
				jp4.setVisible(false);
				btnHome.setBackground(new Color(255, 196, 225));
				btnBookbank.setBackground(new Color(255, 196, 225));
				btnTransfer.setBackground(new Color(255, 232, 243));
				btnCurrency.setBackground(new Color(255, 196, 225));
			}
		});
		btnCurrency_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnCurrency_2.setFont(new Font("Alice", Font.BOLD, 12));
		btnCurrency_2.setForeground(new Color(255, 247, 251));
		btnCurrency_2.setBackground(new Color(255, 196, 225));
		btnCurrency_2.setBounds(-13, 193, 128, 37);
		btnCurrency_2.setBorderPainted(false);
		DropoutMenu.add(btnCurrency_2);
		btnMenu.setForeground(Color.BLACK);
		btnMenu.setFont(new Font("Alice", Font.BOLD, 10));
		btnMenu.setBackground(new Color(255, 196, 225));
		btnMenu.setBounds(10, 0, 95, 63);
		btnMenu.setBorderPainted(false);
		
		
		DropoutMenu.add(btnMenu);
		btnCreateaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Customer cus = new Customer();
					cus.CreateAccount(email);
					if(account_no.isEmpty()){
						accountnumberFirstSet();
					}
					CreateAccount create = new CreateAccount(email,account_no);
					create.CreateaccountPopup();
					frame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCreateaccount.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreateaccount.setForeground(new Color(255, 247, 251));
		btnCreateaccount.setFont(new Font("Alice", Font.BOLD, 12));
		btnCreateaccount.setBackground(new Color(255, 196, 225));
		btnCreateaccount.setBorderPainted(false);
		btnCreateaccount.setBounds(-13, 255, 149, 37);
		
		DropoutMenu.add(btnCreateaccount);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
					Login login = new Login();
					login.loginPage();
			}
		});
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setForeground(new Color(255, 247, 251));
		btnLogout.setFont(new Font("Alice", Font.BOLD, 12));
		btnLogout.setBorderPainted(false);
		btnLogout.setBackground(new Color(255, 196, 225));
		btnLogout.setBounds(-13, 297, 128, 37);
		
		DropoutMenu.add(btnLogout);
		btnCurrency_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(false);
				jp3.setVisible(false);
				jp4.setVisible(true);
				btnHome.setBackground(new Color(255, 196, 225));
				btnBookbank.setBackground(new Color(255, 196, 225));
				btnTransfer.setBackground(new Color(255, 196, 225));
				btnCurrency.setBackground(new Color(255, 232, 243));
			}
		});
		
		JPanel menu2 = new JPanel();
		menu2.setBackground(new Color(255, 196, 225));
		menu2.setBounds(0, 0, 65, 694);
		frame.getContentPane().add(menu2);
		menu2.setLayout(null);
		
		btnHome.setBackground(new Color(255, 232, 243));
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBounds(0, 118, 65, 65);
		btnHome.setBorderPainted(false);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(true);
				jp2.setVisible(false);
				jp3.setVisible(false);
				jp4.setVisible(false);
				btnHome.setBackground(new Color(255, 232, 243));
				btnBookbank.setBackground(new Color(255, 196, 225));
				btnTransfer.setBackground(new Color(255, 196, 225));
				btnCurrency.setBackground(new Color(255, 196, 225));
			}
		});
		menu2.add(btnHome);
		
		btnBookbank.setForeground(Color.WHITE);
		btnBookbank.setBackground(new Color(255, 196, 225));
		btnBookbank.setBounds(0, 206, 65, 65);
		btnBookbank.setBorderPainted(false);
		menu2.add(btnBookbank);
		btnBookbank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(true);
				jp3.setVisible(false);
				jp4.setVisible(false);
				btnHome.setBackground(new Color(255, 196, 225));
				btnBookbank.setBackground(new Color(255, 232, 243));
				btnTransfer.setBackground(new Color(255, 196, 225));
				btnCurrency.setBackground(new Color(255, 196, 225));
			}
		});
		
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setBackground(new Color(255, 196, 225));
		btnTransfer.setBounds(0, 299, 65, 65);
		btnTransfer.setBorderPainted(false);
		menu2.add(btnTransfer);
		btnTransfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(false);
				jp3.setVisible(true);
				jp4.setVisible(false);
				btnHome.setBackground(new Color(255, 196, 225));
				btnBookbank.setBackground(new Color(255, 196, 225));
				btnTransfer.setBackground(new Color(255, 232, 243));
				btnCurrency.setBackground(new Color(255, 196, 225));
			}
		});
		
		btnCurrency.setForeground(Color.WHITE);
		btnCurrency.setBackground(new Color(255, 196, 225));
		btnCurrency.setBounds(0, 389, 65, 65);
		btnCurrency.setBorderPainted(false);
		menu2.add(btnCurrency);
		btnCurrency.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(false);
				jp3.setVisible(false);
				jp4.setVisible(true);
				btnHome.setBackground(new Color(255, 196, 225));
				btnBookbank.setBackground(new Color(255, 196, 225));
				btnTransfer.setBackground(new Color(255, 196, 225));
				btnCurrency.setBackground(new Color(255, 232, 243));
			}
		});
		
		ImageIcon icon = new ImageIcon("icon/Re.png");
		JLabel Icon = new JLabel();
		Icon.setBounds(5,5,0,0);
		Icon.setIcon(icon);
		//panel for image
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 65, 67);
		panel.setBackground(new Color(255, 196, 225));
		menu2.add(panel);
		panel.add(Icon);
		
		ImageIcon image6 = new ImageIcon("icon/Goose.png");
		panelTranfer_1.setLayout(null);
		JLabel Icon2 = new JLabel();
		Icon2.setBounds(5,5,0,0);
		Icon2.setIcon(image6);
		
		JPanel photo = new JPanel();
		photo.setBounds(-11, 47, 220, 168);
		photo.setBackground(new Color(255, 234, 245));
		panelTranfer_1.add(photo);
		photo.add(Icon2);
		
		
		gatherPanel.setBounds(63, 65, 1243, 618);
		
		frame.getContentPane().add(gatherPanel);
		gatherPanel.setLayout(null);
		jp1.setBackground(new Color(255, 255, 128));
		jp1.setBounds(0, -94, 1243, 729);
		
		gatherPanel.add(jp1);
		jp2.setBackground(new Color(255, 234, 245));
		jp2.setBounds(0, 0, 1243, 618);
		
		gatherPanel.add(jp2);
		jp2.setLayout(null);

		ShowTransaction();

		panelTransaction.setBackground(new Color(255, 234, 245));
		panelTransaction.setBounds(107, 399, 589, 239);
		
		jp2.add(panelTransaction);
		panelTransaction.setLayout(null);
		list.setModel(model);
		splitPane.setBounds(10, 26, 569, 92);
		
		splitPane.setLeftComponent(new JScrollPane(list));
		label.setFont(new Font("Alice", Font.PLAIN, 25));
		panell.add(label);
		splitPane.setRightComponent(panell);
		panelTransaction.add(splitPane);
		
		lblTransaction.setBounds(95, 352, 240, 37);
		jp2.add(lblTransaction);
		lblTransaction.setForeground(new Color(255, 111, 183));
		lblTransaction.setFont(new Font("Alice", Font.BOLD, 31));
		
		jp3.setBackground(new Color(255, 234, 245));
		jp3.setBounds(0, 0, 1243, 618);
		
		gatherPanel.add(jp3);
		jp3.setLayout(null);
		
		JPanel panelTranfer = new JPanel();
		panelTranfer.setBackground(new Color(255, 196, 225));
		panelTranfer.setBounds(375, 42, 492, 143);
		jp3.add(panelTranfer);
		panelTranfer.setLayout(null);
		
		lblFrom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFrom.setBounds(-86, 10, 169, 27);
		lblFrom.setFont(new Font("Alice", Font.BOLD, 25));
		panelTranfer.add(lblFrom);
		lblAccountIdTF.setFont(new Font("Alice", Font.BOLD, 23));
		lblAccountIdTF.setBounds(54, 47, 400, 27);
		
		panelTranfer.add(lblAccountIdTF);
		lblBalanceTF.setFont(new Font("Alice", Font.BOLD, 23));
		lblBalanceTF.setBounds(54, 84, 400, 27);
		
		panelTranfer.add(lblBalanceTF);
		panelTranfer_1.setBackground(new Color(255, 234, 245));
		panelTranfer_1.setBounds(200, 270, 1000, 303);
		jp3.add(panelTranfer_1);
		
		JLabel lblGoto = new JLabel("Go to");
		lblGoto.setBounds(-62, 10, 169, 27);
		lblGoto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGoto.setFont(new Font("Alice", Font.BOLD, 25));
		panelTranfer_1.add(lblGoto);
		
		JLabel lblAccountIdTF_1 = new JLabel("Account ID:");
		lblAccountIdTF_1.setBounds(214, 70, 169, 27);
		lblAccountIdTF_1.setFont(new Font("Alice", Font.BOLD, 23));
		panelTranfer_1.add(lblAccountIdTF_1);
		
		JLabel lblBalanceTF_1 = new JLabel("Balance:");
		lblBalanceTF_1.setBounds(214, 114, 169, 27);
		lblBalanceTF_1.setFont(new Font("Alice", Font.BOLD, 23));
		panelTranfer_1.add(lblBalanceTF_1);
		
		JLabel lblComment = new JLabel("Comment:");
		lblComment.setBounds(214, 158, 169, 27);
		lblComment.setHorizontalAlignment(SwingConstants.LEFT);
		lblComment.setFont(new Font("Alice", Font.BOLD, 23));
		panelTranfer_1.add(lblComment);
		
		panelTranfer_1.add(photo);
		
		tfAccount = new JTextField();
		tfAccount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfAccount.getText().equals("Please Type Account ID")) {
					tfAccount.setText(null);
					tfAccount.requestFocus();
					tfAccount.setFont(new Font("Alice", Font.PLAIN, 15));
					tfAccount.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfAccount.getText().length()==0) {
					tfAccount.setFont(new Font("Alice", Font.ITALIC, 12));
					tfAccount.setForeground(Color.gray);
					tfAccount.setText("Please Type Account ID");
				}
			}
		});
		tfAccount.setText("Please Type Account ID");
		tfAccount.setForeground(Color.GRAY);
		tfAccount.setFont(new Font("Alice", Font.ITALIC, 12));
		tfAccount.setColumns(10);
		tfAccount.setBackground(new Color(255, 255, 255));
		tfAccount.setBounds(352, 73, 308, 29);
		panelTranfer_1.add(tfAccount);
		
		tfAmount = new JTextField();
		tfAmount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfAmount.getText().equals("Please Type a Balance")) {
					tfAmount.setText(null);
					tfAmount.requestFocus();
					tfAmount.setFont(new Font("Alice", Font.PLAIN, 15));
					tfAmount.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfAmount.getText().length()==0) {
					tfAmount.setFont(new Font("Alice", Font.ITALIC, 12));
					tfAmount.setForeground(Color.gray);
					tfAmount.setText("Please Type a Balance");
				}
			}
		});
		tfAmount.setText("Please Type a Balance");
		tfAmount.setForeground(Color.GRAY);
		tfAmount.setFont(new Font("Alice", Font.ITALIC, 12));
		tfAmount.setColumns(10);
		tfAmount.setBackground(new Color(255, 255, 255));
		tfAmount.setBounds(352, 117, 308, 29);
		panelTranfer_1.add(tfAmount);
		
		tfComment = new JTextField();
		tfComment.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfComment.getText().equals("Comment Here")) {
					tfComment.setText(null);
					tfComment.requestFocus();
					tfComment.setFont(new Font("Alice", Font.PLAIN, 15));
					tfComment.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfComment.getText().length()==0) {
					tfComment.setFont(new Font("Alice", Font.ITALIC, 12));
					tfComment.setForeground(Color.gray);
					tfComment.setText("Comment Here");
				}
			}
		});
		tfComment.setText("Comment Here");
		tfComment.setForeground(Color.GRAY);
		tfComment.setFont(new Font("Alice", Font.ITALIC, 12));
		tfComment.setColumns(10);
		tfComment.setBackground(new Color(255, 255, 255));
		tfComment.setBounds(352, 161, 308, 29);
		panelTranfer_1.add(tfComment);
		
		jp4.setBackground(new Color(255, 234, 245));
		jp4.setBounds(0, 0, 1243, 618);
		
		gatherPanel.add(jp4);
		jp4.setLayout(null);
		
		JPanel panelColor = new JPanel();
		panelColor.setLayout(null);
		panelColor.setBackground(new Color(255, 223, 239));
		panelColor.setBounds(275, 68, 692, 86);
		jp4.add(panelColor);
		
		JLabel lblCurrency = new JLabel("Currency Exchange",SwingConstants.CENTER);
		lblCurrency.setFont(new Font("Alice", Font.BOLD, 36));
		lblCurrency.setBounds(153, 24, 385, 41);
		panelColor.add(lblCurrency);
		
		JPanel panelTh = new JPanel();
		panelTh.setBackground(new Color(255, 234, 245));
		panelTh.setBounds(163, 234, 383, 115);
		jp4.add(panelTh);
		panelTh.setLayout(null);
		
		tfBaht = new JTextField();
		tfBaht.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfBaht.getText().equals("0.00 ")) {
					tfBaht.setText(null);
					tfBaht.requestFocus();
					tfBaht.setFont(new Font("Alice", Font.PLAIN, 42));
					tfBaht.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfBaht.getText().length()==0) {
					tfBaht.setFont(new Font("Alice", Font.PLAIN, 42));
					tfBaht.setForeground(Color.gray);
					tfBaht.setText("0.00 ");
				}
			}
		});
		tfBaht.setBounds(10, 37, 366, 68);
		panelTh.add(tfBaht);
		tfBaht.setText("0.00 ");
		tfBaht.setForeground(Color.GRAY);
		tfBaht.setFont(new Font("Alice", Font.PLAIN, 42));
		tfBaht.setColumns(10);
		tfBaht.setBackground(new Color(255, 255, 255));
		
		JPanel bahtPanel = new JPanel();
		bahtPanel.setBackground(new Color(192, 192, 192));
		bahtPanel.setBounds(10, 10, 366, 28);
		panelTh.add(bahtPanel);
		bahtPanel.setLayout(null);
		lblbaht.setFont(new Font("Alice", Font.BOLD, 20));
		lblbaht.setBounds(10, 10, 158, 13);
		
		bahtPanel.add(lblbaht);
		
		JLabel IconArrow = new JLabel();
		ImageIcon imageArrow = new ImageIcon("icon/R.png");
		IconArrow.setBounds(5,5,0,0);
		IconArrow.setIcon(imageArrow);
		
		JPanel photoArrow = new JPanel();
		photoArrow.setBounds(556, 249, 126, 64);
		jp4.add(photoArrow);
		photoArrow.setBackground(new Color(255, 234, 245));
		photoArrow.add(IconArrow);
		panelTh_1.setLayout(null);
		panelTh_1.setBackground(new Color(255, 234, 245));
		panelTh_1.setBounds(692, 234, 383, 115);
		
		jp4.add(panelTh_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 37, 366, 69);
		panelTh_1.add(panel_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBackground(new Color(192, 192, 192));
		comboBox_1.setBounds(10, 10, 366, 28);
		panelTh_1.add(comboBox_1);
		
		JButton btnExchange = new JButton("Exchange");
		btnExchange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnExchange.setForeground(new Color(0, 0, 0));
		btnExchange.setFont(new Font("Alice", Font.BOLD, 25));
		btnExchange.setFocusable(false);
		btnExchange.setBackground(new Color(255, 196, 225));
		btnExchange.setBounds(530, 502, 182, 51);
		jp4.add(btnExchange);
		lblBird.setIcon(new ImageIcon("icon/ProjectFinal_1.png"));
		lblBird.setBounds(540, 268, 608, 435);
		
		jp4.add(lblBird);
		
		gatherPanel.add(jp4);

		JButton btnDeposit = new JButton("Deposit");
        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					Deposit deposit = new Deposit(email,account_no);
               		deposit.DepositPage();
					frame.dispose();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
            }
        });
        btnDeposit.setBounds(967, 62, 156, 30);
        jp3.add(btnDeposit);
        btnDeposit.setForeground(new Color(255, 132, 153));
        btnDeposit.setFont(new Font("Alice", Font.BOLD, 25));
        btnDeposit.setFocusable(false);
        btnDeposit.setBackground(Color.WHITE);
        
        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					Withdraw withdraw = new Withdraw(email,account_no);
               		withdraw.Withdrawpage();
					frame.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
            }
        });
        btnWithdraw.setBounds(967, 155, 156, 30);
        jp3.add(btnWithdraw);
        btnWithdraw.setForeground(new Color(255, 132, 153));
        btnWithdraw.setFont(new Font("Alice", Font.BOLD, 25));
        btnWithdraw.setFocusable(false);
        btnWithdraw.setBackground(Color.WHITE);

		lblChangeAccount.setForeground(new Color(255, 111, 183));
        lblChangeAccount.setFont(new Font("Alice", Font.BOLD, 31));
		lblChangeAccount.setBounds(745, 352, 450, 37);
		jp2.add(lblChangeAccount);
		
		tm1 = new Timer(10, new ActionListener() {
			   
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   if(pl1 > 345)
				    {
					   
					   tm1.stop();
				    }
				   else{
				    	DropoutMenu.setSize(DropoutMenu.getWidth(),pl1);
				    	pl1 += 70;
				    }
			   }
		});
		customerPanel.setBackground(new Color(255, 234, 245));
		customerPanel.setBounds(24, 0, 1219, 316);
		
		jp2.add(customerPanel);
		customerPanel.setLayout(null);
		lblCustomerDetail.setBounds(109, 59, 404, 33);
		customerPanel.add(lblCustomerDetail);
		lblCustomerDetail.setForeground(new Color(0, 0, 0));
		lblCustomerDetail.setFont(new Font("Alice", Font.BOLD, 31));
		lblName.setBounds(81, 106, 400, 33);
		customerPanel.add(lblName);
		lblName.setFont(new Font("Alice", Font.BOLD, 23));
		lblDateOfBirth.setBounds(81, 137, 400, 33);
		customerPanel.add(lblDateOfBirth);
		lblDateOfBirth.setFont(new Font("Alice", Font.BOLD, 23));
		lblPhoneNumber.setBounds(81, 168, 400, 33);
		customerPanel.add(lblPhoneNumber);
		lblPhoneNumber.setFont(new Font("Alice", Font.BOLD, 23));
		lblAddress.setBounds(81, 199, 400, 33);
		customerPanel.add(lblAddress);
		lblAddress.setFont(new Font("Alice", Font.BOLD, 23));
		lblEmail.setBounds(81, 230, 400, 33);
		customerPanel.add(lblEmail);
		lblEmail.setFont(new Font("Alice", Font.BOLD, 23));
		lblBackground.setIcon(new ImageIcon("icon/gooseAgain1_3.png"));
        lblBackground.setBounds(-55, -19, 698, 635);
		
		customerPanel.add(lblBackground);
		lblAccountDetail.setBounds(628, 59, 500, 33);
		customerPanel.add(lblAccountDetail);
		lblAccountDetail.setBackground(new Color(255, 255, 255));
		lblAccountDetail.setForeground(new Color(0, 0, 0));
		lblAccountDetail.setFont(new Font("Alice", Font.BOLD, 31));
		lblAccountId.setBounds(675, 104, 400, 33);
		customerPanel.add(lblAccountId);
		lblAccountId.setFont(new Font("Alice", Font.BOLD, 23));
		lblAccountType.setBounds(675, 135, 400, 33);
		customerPanel.add(lblAccountType);
		lblAccountType.setFont(new Font("Alice", Font.BOLD, 23));
		lblBalance.setBounds(675, 166, 400, 33);
		customerPanel.add(lblBalance);
		lblBalance.setFont(new Font("Alice", Font.BOLD, 23));
		lblBackground2.setIcon(new ImageIcon("icon/gooseAgain2_1.png"));
        lblBackground2.setBounds(244, -19, 943, 635);
		
		customerPanel.add(lblBackground2);
		
		jp1.setBackground(new Color(251, 252, 211));
		jp1.setBounds(2, 0, 1241, 616);
		
		gatherPanel.add(jp1);
		jp1.setLayout(null);
		panel1.setBackground(new Color(255, 215, 234));
		panel1.setBounds(20, 10, 1212, 307);
		
		jp1.add(panel1);
		panel1.setLayout(null);
		ShowFinanceNews();
		lblTitle.setFont(new Font("Alice", Font.BOLD, 19));
		lblTitle.setBounds(52, 31, 169, 27);
		panel1.add(lblTitle);

		textAreaTitle.setFont(new Font("Alice", Font.BOLD, 19));
		textAreaTitle.setBounds(130, 31, 800, 80);
		panel1.add(textAreaTitle);
		
		lblUrl.setFont(new Font("Alice", Font.BOLD, 19));
		lblUrl.setBounds(52, 88, 1100, 27);
		
		panel1.add(lblUrl);
		lblDescription.setFont(new Font("Alice", Font.BOLD, 19));
		lblDescription.setBounds(52, 145, 169, 27);
		textAreaDescription.setFont(new Font("Alice", Font.BOLD, 19));
		textAreaDescription.setBounds(200, 145, 800, 80);
		panel1.add(textAreaDescription);
		
		panel1.add(lblDescription);
		lblPublished.setFont(new Font("Alice", Font.BOLD, 19));
		lblPublished.setBounds(52, 202, 800, 27);
		
		panel1.add(lblPublished);
		lblphoto2.setBounds(576, 28, 608, 279);
		panel1.add(lblphoto2);
		lblphoto2.setIcon(new ImageIcon("icon/photo2_1.png"));
		panel2.setLayout(null);
		panel2.setBackground(new Color(255, 215, 234));
		panel2.setBounds(20, 327, 1212, 289);
		
		jp1.add(panel2);
		cb2.setBackground(new Color(128, 128, 192));
		cb2.setBounds(0, 0, 1212, 21);
		panel2.add(cb2);
		lblOpen.setFont(new Font("Alice", Font.BOLD, 19));
		lblOpen.setBounds(52, 31, 169, 27);
		
		panel2.add(lblOpen);
		lblHigh.setFont(new Font("Alice", Font.BOLD, 19));
		lblHigh.setBounds(52, 63, 169, 27);
		
		panel2.add(lblHigh);
		lblLow.setFont(new Font("Alice", Font.BOLD, 19));
		lblLow.setBounds(52, 95, 169, 27);
		
		panel2.add(lblLow);
		lblClose.setFont(new Font("Alice", Font.BOLD, 19));
		lblClose.setBounds(52, 127, 169, 27);
		
		panel2.add(lblClose);
		lblVolume.setFont(new Font("Alice", Font.BOLD, 19));
		lblVolume.setBounds(52, 159, 169, 27);
		
		panel2.add(lblVolume);
		lblSymbol.setFont(new Font("Alice", Font.BOLD, 19));
		lblSymbol.setBounds(52, 191, 169, 27);
		
		panel2.add(lblSymbol);
		lblDate.setFont(new Font("Alice", Font.BOLD, 19));
		lblDate.setBounds(52, 223, 169, 27);
		
		panel2.add(lblDate);
		lblphoto1.setBounds(594, -51, 798, 411);
		panel2.add(lblphoto1);
		lblphoto1.setIcon(new ImageIcon("icon/photo2_2_1.png"));

		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tm1.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
			    
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
			    DropoutMenu.setSize(DropoutMenu.getWidth(),pl1);
			}
			
			
		});
		btnHome_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
			    
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
				DropoutMenu.setSize(DropoutMenu.getWidth(),pl1);
				
			}
		});
		btnBookbank_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
			    
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
				DropoutMenu.setSize(DropoutMenu.getWidth(),pl1);
				
			}
		});
		btnTransfer_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
			    
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
				DropoutMenu.setSize(DropoutMenu.getWidth(),pl1);
				
			}
		});
		btnCurrency_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
			    
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				tm1.stop();
			    pl1 = 65;
				DropoutMenu.setSize(DropoutMenu.getWidth(),pl1);
				
			}
		});
		

		btnTransferBank.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try {
					Customer cus = new Customer();
					cus.setEmail(email);
					if(cus.transfercheck(tfAccount.getText(),tfAmount.getText(),tfComment.getText()) == "NICE"){
						cus.tranfer(account_no, Double.parseDouble(tfAmount.getText()), tfAccount.getText());
						Transfer transfer = new Transfer(email,account_no,tfAccount.getText(),tfAmount.getText(),tfComment.getText());
						transfer.TransferPage();
						frame.dispose();
					}else{
						System.out.println(cus.transfercheck(tfAccount.getText(),tfAmount.getText(),tfComment.getText()));
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        }); 
        btnTransferBank.setForeground(new Color(255, 132, 153));
        btnTransferBank.setFont(new Font("Alice", Font.BOLD, 25));
        btnTransferBank.setFocusable(false);
        btnTransferBank.setBackground(Color.WHITE);
        btnTransferBank.setBounds(740, 99, 195, 74);

        panelTranfer_1.add(btnTransferBank);

		changeAccountComboBox();
	}
	public void ShowTransaction() throws IOException{
		//#region getAccountNumber
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

		//#endregion
		try {
			FileReader AccountfileReader = new FileReader(new File("DataStorage/" + account_no + ".json"));
			PersonalAccountData pad = gson.fromJson(AccountfileReader, PersonalAccountData.class);
            
            for (transaction t : pad.getTransaction()) {
                model.addElement(new transaction(t.getStatement(),t.getDestinationID(),t.getAmount()));
            }
			list.getSelectionModel().addListSelectionListener(e -> {
				transaction p = list.getSelectedValue();
				if(p.getStatement().equalsIgnoreCase("Withdraw") || p.getStatement().equalsIgnoreCase("Deposit")){
					label.setText(p.getStatement() + "::" + String.format("%.2f", p.getAmount()) + " Baht.");
				}else if (p.getStatement().equalsIgnoreCase("Receive")){
					label.setText("Receive From : " + p.getDestinationID() + "::"+ String.format("%.2f", p.getAmount()) + " Baht.");
				}
				else if (p.getStatement().equalsIgnoreCase("Transfer")){
					label.setText("Transfer To : " + p.getDestinationID() + "::"+ String.format("%.2f", p.getAmount()) + " Baht.");
				}else{
					label.setText("Welcome to WhiteSwan Bank!!");
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ShowFinanceNews() throws IOException{
		try {
			Gson gson = new Gson();
			FileReader fileReader = new FileReader(new File("DataStorage/FinanceNews.json"));
			FinanceNews fn = gson.fromJson(fileReader, FinanceNews.class);

			ArrayList<String> titleArrayList = new ArrayList<>();
			for(DataFinanceNews dfn : fn.getData()){
				titleArrayList.add(dfn.getTitle());
			}
			cb1.setModel(new DefaultComboBoxModel<String>(titleArrayList.toArray(new String[0])));
			cb1.setFont(new Font("Alice", Font.BOLD, 22));
			cb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==cb1) {
						for(DataFinanceNews dfn : fn.getData()){
							if(String.valueOf(cb1.getSelectedItem()).equals(dfn.getTitle())){
								textAreaProperties(textAreaTitle);
								textAreaProperties(textAreaDescription);
								textAreaTitle.setText(dfn.getTitle());
								textAreaDescription.setText(dfn.getDescription());
								lblUrl.setText("URL : " + dfn.getUrl());
								lblUrl.setForeground(Color.BLUE.darker());
								lblUrl.setCursor(new Cursor(Cursor.HAND_CURSOR));
						
								lblUrl.addMouseListener(new MouseAdapter() {
						
									@Override
									public void mouseClicked(MouseEvent e) {
										try {
											Desktop.getDesktop().browse(new URI(dfn.getUrl()));
										} catch (IOException | URISyntaxException e1) {
											e1.printStackTrace();
										}
									}
						
									@Override
									public void mouseExited(MouseEvent e) {
										lblUrl.setText("URL :  " + dfn.getUrl());
									}
						
									@Override
									public void mouseEntered(MouseEvent e) {
										lblUrl.setText("<html><a href=''>" + "URL : " + dfn.getUrl() + "</a></html>");
									}
						
								});
								lblPublished.setText("Publish at :  " + dfn.getPublished_at());

							}
						}
					}
				}
			});
			cb1.setBackground(new Color(128, 128, 192));
			cb1.setBounds(0, 0, 1212, 30);
			panel1.add(cb1);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void changeAccountComboBox() throws IOException, IndexOutOfBoundsException{
		try {
			File theFile = new File("DataStorage/CustomerwithAccount.json");
			ArrayList<CustomerwithAccount> theCustomerwithAccountList = new ArrayList<>();
			FileReader fileReader = new FileReader(theFile);
			Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
			Gson gson = new Gson();
			theCustomerwithAccountList = gson.fromJson(fileReader, type);
			fileReader.close();

			ArrayList<String> account_noArrayList = new ArrayList<>();
			for (CustomerwithAccount c : theCustomerwithAccountList) {
				if(c.getEmail().equals(getEmail())){
					for (accountlist a : c.getAccountlist()) {
						account_noArrayList.add(a.getAccount_no());
					}
				}
			}
			if(!account_no.equals(account_noArrayList.get(0))){
				Collections.swap(account_noArrayList, 0, account_noArrayList.indexOf(account_no));
			}
			comboBox.setModel(new DefaultComboBoxModel<String>(account_noArrayList.toArray(new String[0])));
			comboBox.setFont(new Font("Alice", Font.BOLD, 22));
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==comboBox) {
						try {
							HomePage homepage = new HomePage(email,String.valueOf(comboBox.getSelectedItem()));
							homepage.homepagePage();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						frame.dispose();
					}
				}
			});
			comboBox.setBounds(773, 428, 301, 80);
			jp2.add(comboBox);
		} catch (Exception e) {
			lblChangeAccount.setForeground(Color.red);
			lblChangeAccount.setText("Please Create Account First");
			e.printStackTrace();
		}
	}
	public void accountnumberFirstSet(){
		try {
			File theFile = new File("DataStorage/CustomerwithAccount.json");
			ArrayList<CustomerwithAccount> theCustomerwithAccountList = new ArrayList<>();

			FileReader fileReader = new FileReader(theFile);
			Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
			Gson gson = new Gson();
			theCustomerwithAccountList = gson.fromJson(fileReader, type);
			fileReader.close();

			ArrayList<String> account_no = new ArrayList<>();
			for (CustomerwithAccount c : theCustomerwithAccountList) {
				if(c.getEmail().equals(getEmail())){
					for (accountlist a : c.getAccountlist()) {
						account_no.add(a.getAccount_no());
					}
				}
			}
			if(account_no.size()==1){setAccount_no(account_no.get(0));}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private JTextArea textAreaProperties(JTextArea textArea) {
		textArea.setRows(2);
		textArea.setEditable(false);  
		textArea.setCursor(null);  
		textArea.setOpaque(false);  
		textArea.setFocusable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		return textArea;
	}
}
