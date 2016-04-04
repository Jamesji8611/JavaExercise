package com.notePad;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotePad extends JFrame implements ActionListener{
	
	JTextArea jta = null;
	JScrollPane jsp = null;
	JMenuBar jmb = null;
	JMenu jm = null;
	JMenuItem jmi1 = null;
	JMenuItem jmi2 = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad np = new NotePad();
	}
	
	public NotePad(){
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jmb = new JMenuBar();
		jm = new JMenu("File(F)");
		jm.setMnemonic('F');//设置助记符
		jmi1 = new JMenuItem("Open(O)", new ImageIcon("Images/smallTiger.jpg"));
		jmi1.setMnemonic('O');
		jmi2 = new JMenuItem("Save(s)", new ImageIcon("Images/SmallTiger.png"));
		jmi2.setMnemonic('S');
		
		jmb.add(jm);
		jm.add(jmi1);
		jm.add(jmi2);
		
		jmi1.addActionListener(this);
		jmi1.setActionCommand("Open");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("Save");
		
		this.add(jsp);
		this.add(jmb, BorderLayout.NORTH);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			this.setIconImage(ImageIO.read( new File("D:/MyJavacode/NotePad/Images/smallTiger.jpg")));
			//this.setIconImage(ImageIO.read(this.getClass().getResource("/NotePad/Images/smallTiger.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setTitle("NotePad");
		this.setLocationRelativeTo(null);//设置窗口居中
		
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent g) {
		// TODO Auto-generated method stub
		if(g.getActionCommand().equalsIgnoreCase("OPEN")){
			System.out.println("Open File");
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Please Choose the File...");
			jfc.showOpenDialog(null);
			
			jfc.setVisible(true);//显示
			
			String filePath = jfc.getSelectedFile().getAbsolutePath();
			FileReader fr = null;
			BufferedReader br = null;
			
			try{
				fr = new FileReader(filePath);
				br = new BufferedReader(fr);
				
				String s="", allContent="";
				
				while((s = br.readLine()) != null){
					allContent += (s+"\r\n");
				}
				
				jta.setText(allContent);
				
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				try{
					br.close();
					fr.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}else if(g.getActionCommand().equalsIgnoreCase("SAVE")){
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Please Choose the File...");
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			
			String filePath = jfc.getSelectedFile().getAbsolutePath();
			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
				fw = new FileWriter(filePath);
				bw = new BufferedWriter(fw);
				
				String s = this.jta.getText();
				bw.write(s);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try{
					bw.close();
					fw.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
	}

}
