import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
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
	private final JPanel panel_1 = new JPanel();
	private final JPanel jp1 = new JPanel();
	private final JPanel jp2 = new JPanel();
	private final JPanel jp3 = new JPanel();
	private final JPanel jp4 = new JPanel();
	private final JPanel DropoutMenu = new JPanel();
	private final JButton btnHome_2 = new JButton("HOME");
	private final JButton btnBookbank_2 = new JButton("BOOKBANK");
	private final JButton btnTransfer_2 = new JButton("TRANSFER");
	private final JButton btnCurrency_2 = new JButton("CURRENCY");
	JButton btnMenu = new JButton(imageButton5);
	/**
	 * @wbp.parser.entryPoint
	 */
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
		
		DropoutMenu.setLayout(null);
		DropoutMenu.setBackground(new Color(255, 196, 225));
		DropoutMenu.setBounds(1181, 0, 115, 66);
		
		
		frame.getContentPane().add(DropoutMenu);
		btnHome_2.setFont(new Font("Alice", Font.BOLD, 10));
		btnHome_2.setBounds(10, 67, 95, 47);
		btnHome_2.setForeground(Color.BLACK);
		btnHome_2.setBackground(new Color(255, 232, 243));
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
		
		btnBookbank_2.setFont(new Font("Alice", Font.BOLD, 10));
		btnBookbank_2.setBounds(10, 124, 95, 47);
		btnBookbank_2.setForeground(Color.BLACK);
		btnBookbank_2.setBackground(new Color(255, 232, 243));
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
		
		
		btnTransfer_2.setFont(new Font("Alice", Font.BOLD, 10));
		btnTransfer_2.setForeground(Color.BLACK);
		btnTransfer_2.setBackground(new Color(255, 232, 243));
		btnTransfer_2.setBounds(10, 181, 95, 47);
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
		
		btnCurrency_2.setFont(new Font("Alice", Font.BOLD, 10));
		btnCurrency_2.setForeground(Color.BLACK);
		btnCurrency_2.setBackground(new Color(255, 232, 243));
		btnCurrency_2.setBounds(10, 238, 95, 47);
		DropoutMenu.add(btnCurrency_2);
		btnMenu.setForeground(Color.BLACK);
		btnMenu.setFont(new Font("Alice", Font.BOLD, 10));
		btnMenu.setBackground(new Color(255, 232, 243));
		btnMenu.setBounds(10, 0, 95, 63);
		btnMenu.setBorderPainted(false);
		
		
		DropoutMenu.add(btnMenu);
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
		
		
		panel_1.setBounds(63, 65, 1243, 618);
		
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		jp1.setBackground(new Color(255, 255, 128));
		jp1.setBounds(0, -94, 1243, 729);
		
		panel_1.add(jp1);
		jp2.setBackground(new Color(255, 234, 245));
		jp2.setBounds(0, 0, 1243, 618);
		
		panel_1.add(jp2);
		jp3.setBackground(new Color(255, 128, 128));
		jp3.setBounds(0, 0, 1243, 618);
		
		panel_1.add(jp3);
		jp4.setBackground(new Color(128, 255, 128));
		jp4.setBounds(0, 0, 1243, 618);
		
		panel_1.add(jp4);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(1043, 10, 115, 45);
		frame.getContentPane().add(btnLogin);
		btnLogin.setFont(new Font("Alice", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				Login login = new Login();
				login.loginPage();
				
			}
		});
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(226, 226, 226));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(255, 255, 255));
			}
		});
		
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
