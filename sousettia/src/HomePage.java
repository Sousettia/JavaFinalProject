import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.Timer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BACKEND.Customer;
import BACKEND.CustomerwithAccount;
import BACKEND.Product;
import BACKEND.accountlist;
import BACKEND.PersonalAccountData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
	JList<Product> list = new JList<>();
	DefaultListModel<Product> model = new DefaultListModel<>();
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

	private JLabel lblAccountIdTF = new JLabel("Account ID:");
	private JLabel lblBalanceTF = new JLabel("Balance:");
	
	private final JLabel lblTransaction = new JLabel("Transaction", SwingConstants.LEFT);
	private final JButton btnCreateaccount = new JButton("CREATEACCOUNT");
	private final JButton btnLogout = new JButton("LOG OUT");
	private JTextField tfAccount;
	private JTextField tfBalance;
	private JTextField tfComment;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void setlblCustomerDetail(String email) throws IOException{

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
	public void setlblAccountDetail(String email) throws IOException{
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
			
			lblAccountId.setText("Account ID:  "+pad.getAccount_no());
			lblBalance.setText("Balance:  " + String.format("%.2f",pad.getBalance()));
			lblAccountType.setText("Account Type:  " + pad.getAccount_type());

			lblAccountIdTF.setText("Account ID:  "+pad.getAccount_no());
			lblBalanceTF.setText("Balance:  " + String.format("%.2f",pad.getBalance()));
		} catch (IOException e) {
			//
		}
	}

	public void homepagePage() {
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
				CreateAccount create = new CreateAccount();
				create.CreateaccountPopup();
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
		lblCustomerDetail.setForeground(new Color(255, 111, 183));
		lblCustomerDetail.setBounds(0, 23, 404, 33);
		lblCustomerDetail.setFont(new Font("Alice", Font.BOLD, 31));
		
		jp2.add(lblCustomerDetail);
		lblName.setFont(new Font("Alice", Font.BOLD, 23));
		lblName.setBounds(46, 66, 400, 33);
		
		jp2.add(lblName);
		lblDateOfBirth.setFont(new Font("Alice", Font.BOLD, 23));
		lblDateOfBirth.setBounds(46, 97, 400, 33);
		
		jp2.add(lblDateOfBirth);
		lblPhoneNumber.setFont(new Font("Alice", Font.BOLD, 23));
		lblPhoneNumber.setBounds(46, 128, 400, 33);
		
		jp2.add(lblPhoneNumber);
		lblAddress.setFont(new Font("Alice", Font.BOLD, 23));
		lblAddress.setBounds(46, 159, 400, 33);
		
		jp2.add(lblAddress);
		lblEmail.setFont(new Font("Alice", Font.BOLD, 23));
		lblEmail.setBounds(46, 221, 400, 33);
		
		jp2.add(lblEmail);
		lblAccountDetail.setBackground(new Color(255, 255, 255));
		lblAccountDetail.setForeground(new Color(255, 111, 183));
		lblAccountDetail.setFont(new Font("Alice", Font.BOLD, 31));
		lblAccountDetail.setBounds(466, 23, 400, 33);
		
		jp2.add(lblAccountDetail);
		lblAccountId.setFont(new Font("Alice", Font.BOLD, 23));
		lblAccountId.setBounds(512, 66, 400, 33);
		
		jp2.add(lblAccountId);
		lblAccountType.setFont(new Font("Alice", Font.BOLD, 23));
		lblAccountType.setBounds(512, 97, 400, 33);
		
		jp2.add(lblAccountType);
		lblBalance.setFont(new Font("Alice", Font.BOLD, 23));
		lblBalance.setBounds(512, 128, 400, 33);
		
		jp2.add(lblBalance);
		
		model.addElement(new Product("Add money......................"));
		model.addElement(new Product("Add money......................"));
		
		list.getSelectionModel().addListSelectionListener(e -> {
			Product p = list.getSelectedValue();
			label.setText(" 500 baht.");
		});
		panelTransaction.setBackground(new Color(255, 234, 245));
		panelTransaction.setBounds(35, 383, 622, 225);
		
		jp2.add(panelTransaction);
		panelTransaction.setLayout(null);
		list.setModel(model);
		splitPane.setBounds(10, 5, 612, 210);
		
		splitPane.setLeftComponent(new JScrollPane(list));
		panell.add(label);
		splitPane.setRightComponent(panell);
		panelTransaction.add(splitPane);
		
		lblTransaction.setBounds(35, 288, 240, 37);
		jp2.add(lblTransaction);
		lblTransaction.setForeground(new Color(255, 111, 183));
		lblTransaction.setFont(new Font("Alice", Font.BOLD, 31));
		
		JButton btnChangeaccount = new JButton("ChangeAccount");
		btnChangeaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeAccount change = new changeAccount();
				change.changeAccountpage();
				
			}
		});
		btnChangeaccount.setForeground(new Color(255, 132, 153));
		btnChangeaccount.setFont(new Font("Alice", Font.BOLD, 25));
		btnChangeaccount.setFocusable(false);
		btnChangeaccount.setBackground(Color.WHITE);
		btnChangeaccount.setBounds(880, 43, 225, 81);
		jp2.add(btnChangeaccount);
		jp3.setBackground(new Color(255, 234, 245));
		jp3.setBounds(0, 0, 1243, 618);
		
		gatherPanel.add(jp3);
		jp3.setLayout(null);
		
		JPanel panelTranfer = new JPanel();
		panelTranfer.setBackground(new Color(255, 196, 225));
		panelTranfer.setBounds(375, 42, 492, 143);
		jp3.add(panelTranfer);
		panelTranfer.setLayout(null);
		
		JLabel lblFrom = new JLabel("From");
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
		panelTranfer_1.setBounds(200, 270, 854, 303);
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
		
		tfBalance = new JTextField();
		tfBalance.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfBalance.getText().equals("Please Type a Balance")) {
					tfBalance.setText(null);
					tfBalance.requestFocus();
					tfBalance.setFont(new Font("Alice", Font.PLAIN, 15));
					tfBalance.setForeground(Color.black);	
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfBalance.getText().length()==0) {
					tfBalance.setFont(new Font("Alice", Font.ITALIC, 12));
					tfBalance.setForeground(Color.gray);
					tfBalance.setText("Please Type a Balance");
				}
			}
		});
		tfBalance.setText("Please Type a Balance");
		tfBalance.setForeground(Color.GRAY);
		tfBalance.setFont(new Font("Alice", Font.ITALIC, 12));
		tfBalance.setColumns(10);
		tfBalance.setBackground(new Color(255, 255, 255));
		tfBalance.setBounds(352, 117, 308, 29);
		panelTranfer_1.add(tfBalance);
		
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
		jp4.setBackground(new Color(128, 255, 128));
		jp4.setBounds(0, 0, 1243, 618);
		
		gatherPanel.add(jp4);
		
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
		
	}
}
