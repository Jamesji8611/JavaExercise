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
		
		jl[0] = new JLabel(new ImageIcon("Images/Pig.jpg")); //显示/NotePad/Images下的图片
		jl[1] = new JLabel(new ImageIcon("src/com/getFile/Pig.jpg"));//获取/NotePad/src/com/getFile/Pig.jpg下的图片
		jl[2] = new JLabel(new ImageIcon("src/Images/Pig.jpg"));//获取/NotePad/src/Images/Pig.jpg下的图片
		//此处NotePad是工程根目录,ImageIcon搜索的是以NotePad为基础向下搜索
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
