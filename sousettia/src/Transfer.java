

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BACKEND.Customer;

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
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class Transfer {
	JFrame frame = new JFrame();
    private String email;
    private String account_no;
	private String destinationID;
	private String amount;
	private String comment;
	private JLabel lblName1 = new JLabel("Name:");
	private JLabel lblAccountId1 = new JLabel("Account ID:");
	private JLabel lblName2 = new JLabel("Name:");
	private JLabel lblAccountId2 = new JLabel("Account ID:");
	private JLabel lblgetAmount = new JLabel("", SwingConstants.RIGHT);
	private JLabel lblgetTrans = new JLabel("", SwingConstants.RIGHT);
	private JLabel lblComment = new JLabel("Comment");

    public Transfer(String email, String account_no, String destinationID, String amount, String comment) throws IOException {
		this.email = email;
		this.account_no = account_no;
		this.destinationID = destinationID;
		this.amount = amount;
		this.comment = comment;
		setlblReciept();
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

	public String getDestinationID() {
		return destinationID;
	}

	public void setDestinationID(String destinationID) {
		this.destinationID = destinationID;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

    /**
	 * @wbp.parser.entryPoint
	 */
	public void TransferPage() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 234, 245));
		frame.setVisible(true);
		frame.setBounds(400, 100, 706, 657);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panelColor = new JPanel();
		panelColor.setLayout(null);
		panelColor.setBackground(new Color(255, 223, 239));
		panelColor.setBounds(0, 0, 692, 86);
		frame.getContentPane().add(panelColor);
		
		JLabel lblTransfer = new JLabel("Transfer Completed!", SwingConstants.CENTER);
		lblTransfer.setFont(new Font("Alice", Font.BOLD, 30));
		lblTransfer.setBounds(153, 24, 385, 41);
		panelColor.add(lblTransfer);
		
		ImageIcon image6 = new ImageIcon("icon/Goose_2.png");
		JLabel Icon2 = new JLabel();
		Icon2.setBounds(5,5,0,0);
		Icon2.setIcon(image6);
		
		JPanel photo = new JPanel();
		photo.setBounds(76, 96, 137, 108);
		photo.setBackground(new Color(255, 234, 245));
		frame.getContentPane().add(photo);
		photo.add(Icon2);
		
		
		JLabel Icon3 = new JLabel();
		Icon3.setBounds(5,5,0,0);
		Icon3.setIcon(image6);
		
		JPanel photo_1 = new JPanel();
		photo_1.setBackground(new Color(255, 234, 245));
		photo_1.setBounds(76, 293, 137, 114);
		frame.getContentPane().add(photo_1);
		photo_1.add(Icon3);
		
		ImageIcon image7 = new ImageIcon("icon/R_2");
		JLabel Icon4 = new JLabel();
		Icon4.setBounds(5,5,0,0);
		Icon4.setIcon(image7);
		
		JPanel photo1 = new JPanel();
		photo1.setBounds(65, 214, 126, 64);
		photo1.setBackground(new Color(255, 234, 245));
		frame.getContentPane().add(photo1);
		photo1.add(Icon4);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setHorizontalAlignment(SwingConstants.LEFT);
		lblFrom.setFont(new Font("Alice", Font.BOLD, 25));
		lblFrom.setBounds(223, 108, 70, 27);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblGoTo = new JLabel("Go to");
		lblGoTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblGoTo.setFont(new Font("Alice", Font.BOLD, 25));
		lblGoTo.setBounds(223, 288, 70, 27);
		frame.getContentPane().add(lblGoTo);
		
		lblName1.setFont(new Font("Alice", Font.BOLD, 21));
		lblName1.setBounds(248, 140, 400, 27);
		frame.getContentPane().add(lblName1);
		
		lblAccountId1.setFont(new Font("Alice", Font.BOLD, 21));
		lblAccountId1.setBounds(248, 177, 400, 27);
		frame.getContentPane().add(lblAccountId1);
		
		lblName2.setFont(new Font("Alice", Font.BOLD, 21));
		lblName2.setBounds(248, 325, 400, 27);
		frame.getContentPane().add(lblName2);
		
		lblAccountId2.setFont(new Font("Alice", Font.BOLD, 21));
		lblAccountId2.setBounds(248, 362, 400, 27);
		frame.getContentPane().add(lblAccountId2);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Alice", Font.BOLD, 19));
		lblAmount.setBounds(44, 441, 300, 27);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblTransactionDate = new JLabel("Transaction date");
		lblTransactionDate.setFont(new Font("Alice", Font.BOLD, 19));
		lblTransactionDate.setBounds(44, 478, 169, 27);
		frame.getContentPane().add(lblTransactionDate);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                HomePage homepage;
				try {
					homepage = new HomePage(email,account_no);
					homepage.homepagePage();	
					frame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
			}
		});
		btnClose.setForeground(new Color(255, 132, 153));
		btnClose.setFont(new Font("Alice", Font.BOLD, 25));
		btnClose.setFocusable(false);
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(273, 554, 146, 30);
		frame.getContentPane().add(btnClose);
		
		lblgetAmount.setFont(new Font("Alice", Font.BOLD, 19));
		lblgetAmount.setBounds(400, 441, 255, 27);
		frame.getContentPane().add(lblgetAmount);
	
		lblgetTrans.setFont(new Font("Alice", Font.BOLD, 19));
		lblgetTrans.setBounds(400, 478, 255, 27);
		frame.getContentPane().add(lblgetTrans);

        lblComment.setFont(new Font("Alice", Font.BOLD, 19));
        lblComment.setBounds(44, 515, 400, 27);
        frame.getContentPane().add(lblComment);
		
		ImageIcon image = new ImageIcon("icon/bank.png");
		frame.setIconImage(image.getImage());
	}
	public void setlblReciept() throws IOException{
		user();
		receiver();
		lblgetAmount.setText(amount);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   		LocalDateTime now = LocalDateTime.now();  
		lblgetTrans.setText(dtf.format(now));
		lblComment.setText("Comment :  " + comment);
	}
	public void user() throws IOException{
		File theFile = new File("DataStorage/Customer.json");
        ArrayList<Customer> theList;
		FileReader fileReader = new FileReader(theFile);
		Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
		Gson gson = new Gson();
		theList = gson.fromJson(fileReader, type);
		fileReader.close();

		for (Customer c : theList) {
			if(c.getEmail().equals(getEmail())){
				lblName1.setText("Name :  " + c.getFirstName() + " " + c.getLastName());
			}
		}
		lblAccountId1.setText("Account ID :  " + account_no);
	
	}
	public void receiver()throws IOException{
		File theFile = new File("DataStorage/Customer.json");
        ArrayList<Customer> theList;
		FileReader fileReader = new FileReader(theFile);
		Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
		Gson gson = new Gson();
		theList = gson.fromJson(fileReader, type);
		fileReader.close();

		for (Customer c : theList) {
			if(c.getEmail().equals(getEmail())){
				lblName2.setText("Name :  " + c.getFirstName() + " " + c.getLastName());
			}
		}
		lblAccountId2.setText("Account ID :  " + destinationID);
	}
}
