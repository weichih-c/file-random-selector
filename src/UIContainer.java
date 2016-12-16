import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.fastinfoset.stax.events.Util;

/**
 * @author weichih.c
 * 
 * This class is responsible of GUI display.
 *
 */
public class UIContainer extends JPanel {
	JLabel label1, label2, label3, label4, label5;
	JTextField sourceLocation;
	JTextField destinationLocation;
	JTextField selectNumber;
	JButton browseDir, browseDir2;
	JButton submit;
	JButton cancel;
	JPanel panelTop, panelCenter, panelCenter2, panelCenter3, panelBottom;
	JCheckBox compressCheck;
	JTextField zipFileName;
	JPanel namePanel, buttonPanel;
	
	public UIContainer(){
		setLayout(new GridLayout(5,1,0,10));
		initComponents();
		add(panelTop);
		add(panelCenter);
		add(panelCenter2);
		add(panelCenter3);
		add(panelBottom);
		
		panelTop.add(label1);
		panelTop.add(selectNumber);
		
		panelCenter.add(label2);
		panelCenter.add(sourceLocation);
		panelCenter.add(browseDir);
		
		panelCenter2.add(label3);
		panelCenter2.add(destinationLocation);
		panelCenter2.add(browseDir2);
		
		panelCenter3.add(compressCheck);
		panelCenter3.add(namePanel);
		
		panelBottom.add(buttonPanel);
		
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
				zipFileName.setText("");
			}
		});
		
		submit.addActionListener(new SubmitClickListener());	// submit button add listener
		
		compressCheck.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED){
					zipFileName.setEditable(false);
					zipFileName.setBackground(new Color(191,191,191));
				}
				else if(e.getStateChange() == ItemEvent.SELECTED){
					zipFileName.setEditable(true);
					zipFileName.setBackground(Color.WHITE);
				}
			}
			
		});
		
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
		
		compressCheck = new JCheckBox("是否壓縮打包檔案");
		compressCheck.setFont(new Font("Serif", Font.PLAIN, 16));
	
		label4 = new JLabel("壓縮檔名：");
		label4.setMinimumSize(new Dimension(80, 30));
		label4.setPreferredSize(new Dimension(80, 30));
		label4.setMaximumSize(new Dimension(80, 30));
		label4.setFont(new Font("Serif", Font.PLAIN, 16));
		
		zipFileName = new JTextField();
		zipFileName.setColumns(13);
		zipFileName.setEditable(false);
		zipFileName.setBackground(new Color(191,191,191));
		
		label5 = new JLabel(".zip");
		
		panelTop = new JPanel();
		panelTop.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelCenter2 = new JPanel();
		panelCenter2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelCenter3 = new JPanel();
		panelCenter3.setLayout(new GridLayout(1, 2));
		panelBottom = new JPanel();
		panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		namePanel.add(label4);
		namePanel.add(zipFileName);
		namePanel.add(label5);
		
		buttonPanel.add(submit);
		buttonPanel.add(cancel);
	}
	
	
	private class SubmitClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if( Util.isEmptyString( selectNumber.getText().trim() )){
				JOptionPane.showMessageDialog(null, "請輸入要選擇的檔案數量");
				return;
			}else if( !IntegerCheck.isInteger( selectNumber.getText().trim() ) ){
				JOptionPane.showMessageDialog(null, "選擇的數量欄位請輸入數字");
				return;
			}else if( Integer.parseInt( selectNumber.getText().trim()) <= 0 ){
				JOptionPane.showMessageDialog(null, "數量欄位請輸入正整數");
				return;
			}
			
			if( Util.isEmptyString( sourceLocation.getText().trim() )){
				JOptionPane.showMessageDialog(null, "請輸入檔案來源");
				return;
			}
			
			if( Util.isEmptyString( destinationLocation.getText().trim() )){
				JOptionPane.showMessageDialog(null, "請輸入存放位置");
				return;
			}
			
			FileTraversal fTraversal = new FileTraversal();	// new fTraversal to retrieve source dir
			FilePickup fPickup = new FilePickup();	// new fPickup to select files
			
			String srcPath = sourceLocation.getText();
			
			File sourceDir = new File(srcPath);
			if(!sourceDir.exists() || !sourceDir.isDirectory()){
				JOptionPane.showMessageDialog(null, "檔案來源無法讀取，請再次確認");
				return;
			}
			
			String destPath = destinationLocation.getText();
			File destinationPath = new File(destPath);
			if(!destinationPath.isDirectory()){
				destinationPath.mkdirs();
			}
			
			int num = Integer.parseInt( selectNumber.getText().trim() );
			
			LinkedList<File> fileList = fTraversal.listFilesForFolder(sourceDir);
			
			if(compressCheck.isSelected()){
				ZipUtil zipUtil = new ZipUtil();	// initial zipUtil
				String zipName = zipFileName.getText().trim();	// get ZipName
				if(Util.isEmptyString(zipName))
					zipName = "package.zip";
				else
					zipName = zipName + ".zip";
				
				String fileName = destinationPath.getPath() + File.separator + zipName;	// file save path
				File targetZip = new File(fileName);
				try {
					File tempDir = new File("temp");	// make a temp dir
					tempDir.mkdir();
					
					fPickup.randomSelectFile(fileList, tempDir, num);	// randomly selecting files and put to tempDir
					zipUtil.makeZip(tempDir, targetZip);	// make a zip according tempDir
					FileController fc = new FileController();	
					fc.removeFile(tempDir);	// deleting temp dir
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				fPickup.randomSelectFile(fileList, destinationPath, num);
				
			}
			
			JOptionPane.showMessageDialog(null, "已複製完成!");
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
