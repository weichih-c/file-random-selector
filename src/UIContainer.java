import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	JLabel label1, label2, label3;
	JTextField sourceLocation;
	JTextField destinationLocation;
	JTextField selectNumber;
	JButton browseDir, browseDir2;
	JButton submit;
	JButton cancel;
	JPanel panelTop, panelCenter, panelCenter2, panelBottom;
	
	public UIContainer(){
		setLayout(new GridLayout(4,1,0,10));
		initComponents();
		add(panelTop);
		add(panelCenter);
		add(panelCenter2);
		add(panelBottom);
		
		panelTop.add(label1);
		panelTop.add(selectNumber);
		
		panelCenter.add(label2);
		panelCenter.add(sourceLocation);
		panelCenter.add(browseDir);
		
		panelCenter2.add(label3);
		panelCenter2.add(destinationLocation);
		panelCenter2.add(browseDir2);
		
		panelBottom.add(submit);
		panelBottom.add(cancel);
		
		browseDir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("選擇資料夾");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false); // disable the "All files" option.
				
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File f = chooser.getSelectedFile();
					sourceLocation.setText(f.getPath());
				}
			}
		});
		
		browseDir2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("選擇資料夾");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false); // disable the "All files" option.
				
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File f = chooser.getSelectedFile();
					destinationLocation.setText(f.getPath());
				}
			}
		});
		
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				selectNumber.setText("");
				sourceLocation.setText("");
				destinationLocation.setText("");
			}
		});
		
		submit.addActionListener(new SubmitClickListener());	// submit button add listener
	}
	
	private void initComponents(){
		Dimension dimension = new Dimension(250, 30);
		
		label1 = new JLabel("請輸入要打包幾個檔案（Number）");
		label1.setMinimumSize(dimension);
		label1.setPreferredSize(dimension);
		label1.setMaximumSize(dimension);
		label1.setFont(new Font("Serif", Font.PLAIN, 16));
		
		sourceLocation = new JTextField();
		sourceLocation.setColumns(18);
		sourceLocation.setBackground(Color.WHITE);
		
		selectNumber = new JTextField();
		selectNumber.setColumns(5);
		selectNumber.setBackground(Color.WHITE);

		browseDir = new JButton("瀏覽資料夾");
		browseDir2 = new JButton("瀏覽資料夾");
		submit = new JButton("確定打包");
		cancel = new JButton("重設");
		
		label2 = new JLabel("請選擇檔案來源位置（Source）");
		label2.setMinimumSize(dimension);
		label2.setPreferredSize(dimension);
		label2.setMaximumSize(dimension);
		label2.setFont(new Font("Serif", Font.PLAIN, 16));
		
		label3 = new JLabel("請選擇檔案存放位置（Destination）");
		label3.setMinimumSize(dimension);
		label3.setPreferredSize(dimension);
		label3.setMaximumSize(dimension);
		label3.setFont(new Font("Serif", Font.PLAIN, 16));
		
		destinationLocation = new JTextField();
		destinationLocation.setColumns(18);
		
		panelTop = new JPanel();
		panelTop.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelCenter2 = new JPanel();
		panelCenter2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelBottom = new JPanel();
		panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	
	private class SubmitClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	public static void main(String args[]) {
		JFrame demoFrame = new JFrame();
		demoFrame.setSize(500, 300);
		UIContainer ui = new UIContainer();
		demoFrame.add(ui);
		demoFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		demoFrame.setTitle("隨機檔案打包器");
		demoFrame.pack();
		demoFrame.setLocationRelativeTo(null);
		demoFrame.setVisible(true);
    }

}
