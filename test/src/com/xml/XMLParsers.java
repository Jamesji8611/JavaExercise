package com.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class XMLParsers {
	public static void main(String[] args){
		//File f = new File("D:/MyJavacode/JavaExercise/test/src/com/xml/newxml.xml");
		File f = new File("src/com/xml/newxml.xml");
		DocumentBuilder builder = null;  //
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try{
			builder = dbf.newDocumentBuilder();
			Document document = builder.parse(f);
			Element root = document.getDocumentElement();
			System.out.println("Root element: " + root.getNodeName());
			
			NodeList childList = root.getChildNodes();
			
			for(int i=0; i<childList.getLength(); i++){
				Node node = childList.item(i);
				if("name".equals(node.getNodeName())){
					System.out.println("Name:" + node.getTextContent());
				}else if("peoples".equals(node.getNodeName())){
					System.out.println("Peoples List");
					NodeList peopleList = node.getChildNodes();
					for(int k=0; k<peopleList.getLength(); k++){
						Node people = peopleList.item(k);
						if("people".equals(people.getNodeName())){
							System.out.println("找到一个人:" + people.getAttributes().getNamedItem("item").getNodeValue());
							
							NodeList nodedetail = people.getChildNodes();
							for(int j=0; j<nodedetail.getLength(); j++){
								Node detail = nodedetail.item(j);
								if("id".equals(detail.getNodeName())){
									System.out.println("ID: " + detail.getTextContent());
								}else if("name".equals(detail.getNodeName())){
									System.out.println("Name: " + detail.getTextContent());
								}else if("age".equals(detail.getNodeName())){
									System.out.println("Age: " + detail.getTextContent());
								}else if("sex".equals(detail.getNodeName())){
									System.out.println("Sex: " + detail.getTextContent());
								}
							}
						}
						
					}
				}
			}
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
