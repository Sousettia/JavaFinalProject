import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HomePage {

	JFrame frame = new JFrame();

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
	public void homepagePage() {
		//icon
		ImageIcon image = new ImageIcon("icon/bank.png");
		frame.setIconImage(image.getImage());
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 234, 245));
		frame.setVisible(true);
		frame.setBounds(100, 70, 1320, 720);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		JPanel menu2 = new JPanel();
		menu2.setBackground(new Color(255, 196, 225));
		menu2.setBounds(0, 0, 65, 694);
		frame.getContentPane().add(menu2);
		menu2.setLayout(null);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(true);
				jp2.setVisible(false);
				jp3.setVisible(false);
				jp4.setVisible(false);
			}
		});
		
		btnHome.setBackground(new Color(255, 196, 225));
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBounds(0, 118, 65, 65);
		menu2.add(btnHome);
		btnBookbank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(true);
				jp3.setVisible(false);
				jp4.setVisible(false);
			}
		});
		
		btnBookbank.setForeground(Color.WHITE);
		btnBookbank.setBackground(new Color(255, 196, 225));
		btnBookbank.setBounds(0, 206, 65, 65);
		menu2.add(btnBookbank);
		btnTransfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(false);
				jp3.setVisible(true);
				jp4.setVisible(false);
			}
		});
		
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setBackground(new Color(255, 196, 225));
		btnTransfer.setBounds(0, 299, 65, 65);
		menu2.add(btnTransfer);
		btnCurrency.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp1.setVisible(false);
				jp2.setVisible(false);
				jp3.setVisible(false);
				jp4.setVisible(true);
			}
		});
		
		btnCurrency.setForeground(Color.WHITE);
		btnCurrency.setBackground(new Color(255, 196, 225));
		btnCurrency.setBounds(0, 389, 65, 65);
		menu2.add(btnCurrency);
		
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
		
		JPanel menu1 = new JPanel();
		menu1.setLayout(null);
		menu1.setBackground(new Color(255, 196, 225));
		menu1.setBounds(63, 0, 1243, 67);
		frame.getContentPane().add(menu1);
		
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
		
		
		
	}

}
