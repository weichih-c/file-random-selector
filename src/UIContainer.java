import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @author weichih.c
 * 
 * This class is responsible of GUI display.
 *
 */
public class UIContainer extends JPanel {
	JLabel label1;
	JTextField directoryLocation;
	JTextField selectNumber;
	JButton browseDir;
	JButton submit;
	JButton cancel;
	JPanel panelTop, panelCenter, panelBottom;
	
	public UIContainer(){
		setLayout(new GridLayout(3,1,0,10));
		initComponents();
		add(panelTop);
		add(panelCenter);
		add(panelBottom);
		
		panelTop.add(label1);
		panelTop.add(selectNumber);
		
		panelCenter.add(directoryLocation);
		panelCenter.add(browseDir);
		
		panelBottom.add(submit);
		panelBottom.add(cancel);
	}
	
	private void initComponents(){
		label1 = new JLabel("請輸入要打包幾個檔案");
		label1.setMinimumSize(new Dimension(300, 30));
		label1.setPreferredSize(new Dimension(300, 30));
		label1.setMaximumSize(new Dimension(300,30));
		label1.setFont(new Font("Serif", Font.PLAIN, 16));
		
		directoryLocation = new JTextField();
		directoryLocation.setColumns(22);
		directoryLocation.setBackground(Color.WHITE);
		
		selectNumber = new JTextField();
		selectNumber.setColumns(5);
		selectNumber.setBackground(Color.WHITE);

		browseDir = new JButton("瀏覽資料夾");
		submit = new JButton("確定打包");
		cancel = new JButton("取消");
		panelTop = new JPanel();
		panelTop.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelBottom = new JPanel();
		panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	public static void main(String args[]) {
		JFrame demoFrame = new JFrame();
		demoFrame.setSize(400, 135);
		UIContainer ui = new UIContainer();
		demoFrame.add(ui);
		demoFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		demoFrame.setTitle("隨機檔案打包器");
		demoFrame.pack();
		demoFrame.setLocationRelativeTo(null);
		demoFrame.setVisible(true);
    }

}
