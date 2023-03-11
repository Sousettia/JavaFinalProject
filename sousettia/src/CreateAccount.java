import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class CreateAccount{

	JFrame frame = new JFrame();
	JPanel panelFirst = new JPanel();

	/**
	 * Create the frame.
	 * @wbp.parser.entryPoint
	 */
	public void CreateaccountPopup() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 234, 245));
		frame.setVisible(true);
		frame.setBounds(400, 100, 706, 605);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		ImageIcon image = new ImageIcon("icon/bank.png");
		frame.setIconImage(image.getImage());
		
		JPanel panelColor = new JPanel();
		panelColor.setBackground(new Color(255, 223, 239));
		panelColor.setBounds(0, 0, 692, 86);
		frame.getContentPane().add(panelColor);
		panelColor.setLayout(null);
		
		JLabel lblOpenAcc = new JLabel("Opening an Saving account");
		lblOpenAcc.setBounds(153, 24, 385, 41);
		panelColor.add(lblOpenAcc);
		lblOpenAcc.setFont(new Font("Alice", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 234, 245));
		panel.setBounds(0, 86, 692, 472);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panelFirst.setLayout(null);
		panelFirst.setBackground(new Color(255, 234, 245));
		panelFirst.setBounds(0, 0, 692, 472);
		panel.add(panelFirst);
		
		JLabel lblOne = new JLabel("Customer Detail ");
		lblOne.setForeground(new Color(255, 155, 205));
		lblOne.setFont(new Font("Alice", Font.BOLD, 33));
		lblOne.setBounds(44, 32, 365, 33);
		panelFirst.add(lblOne);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Alice", Font.BOLD, 23));
		lblName.setBounds(67, 95, 225, 33);
		panelFirst.add(lblName);
		
		JLabel lblDatebirth = new JLabel("Date of Birth:");
		lblDatebirth.setFont(new Font("Alice", Font.BOLD, 23));
		lblDatebirth.setBounds(67, 142, 225, 33);
		panelFirst.add(lblDatebirth);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Alice", Font.BOLD, 23));
		lblEmail.setBounds(67, 189, 225, 33);
		panelFirst.add(lblEmail);
		
		JLabel lblTel = new JLabel("Phone Number:");
		lblTel.setFont(new Font("Alice", Font.BOLD, 23));
		lblTel.setBounds(67, 236, 225, 33);
		panelFirst.add(lblTel);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Alice", Font.BOLD, 23));
		lblAddress.setBounds(67, 283, 225, 33);
		panelFirst.add(lblAddress);
		
		JButton btnNext = new JButton("Next");
		btnNext.setForeground(new Color(255, 132, 153));
		btnNext.setFont(new Font("Alice", Font.BOLD, 25));
		btnNext.setFocusable(false);
		btnNext.setBackground(Color.WHITE);
		btnNext.setBounds(173, 408, 118, 30);
		panelFirst.add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmAccount confirmAccount = new confirmAccount();
				confirmAccount.confirmAccountpage();
			}
		});
		btnCancel.setForeground(new Color(255, 132, 153));
		btnCancel.setFont(new Font("Alice", Font.BOLD, 25));
		btnCancel.setFocusable(false);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(365, 408, 118, 30);
		panelFirst.add(btnCancel);
		
	}

}