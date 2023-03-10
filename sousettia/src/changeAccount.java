import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class changeAccount  {
    JFrame frame = new JFrame();
    /**
     * @wbp.parser.entryPoint
     */
    public void changeAccountpage() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255, 234, 245));
        frame.setVisible(true);
        frame.setBounds(400, 100, 706, 605);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        
        ImageIcon image = new ImageIcon("icon/bank.png");
        frame.setIconImage(image.getImage());
    }


}