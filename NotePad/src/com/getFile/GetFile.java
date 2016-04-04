package com.getFile;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GetFile extends JFrame{
	
	JLabel[] jl = null;
	
	public static void main(String[] args){
		GetFile gf = new GetFile();
	}
	
	public GetFile(){
		jl = new JLabel[4];
		for(int i = 0; i < jl.length; i++){
			jl[i] = new JLabel();
		}
		
		jl[0] = new JLabel(new ImageIcon("Images/Pig.jpg")); //��ʾ/NotePad/Images�µ�ͼƬ
		jl[1] = new JLabel(new ImageIcon("src/com/getFile/Pig.jpg"));//��ȡ/NotePad/src/com/getFile/Pig.jpg�µ�ͼƬ
		jl[2] = new JLabel(new ImageIcon("src/Images/Pig.jpg"));//��ȡ/NotePad/src/Images/Pig.jpg�µ�ͼƬ
		//�˴�NotePad�ǹ��̸�Ŀ¼,ImageIcon����������NotePadΪ������������
		Image image = null;
		try {
			image = ImageIO.read(new File("Images/Pig.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//jl[3] = new JLabel((Icon)image);
		
		this.setLayout(new GridLayout(jl.length, 2));
		//jl[0].setIcon(new ImageIcon("/Images/Pig.jpg"));
		
		for(int i = 0; i < jl.length; i++){
			this.add(jl[i]);
		}
				
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("Images/Pig.jpg").getImage());
		
		this.setVisible(true);
	}
}
