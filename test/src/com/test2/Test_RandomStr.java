package com.test2;
import java.lang.Math;
/**
 * 
 * @author Administrator
 * @return ����һ����λ������ַ���
 *
 */

public class Test_RandomStr {
	public static void main(String[] args){
		String str1 = "";
		
		for(int i =0; i < 6; i++){
			double j = Math.random(); //����һ��0~1֮��������
			System.out.println("Random["+i+"]="+j);
			
			str1 += (char)((int)(j*26)+97); //����һ��97~122֮���char����
		}
		
		System.out.println(str1);
		float a = 5.6F;	//5.6������Ĭ��Ϊdouble�ͣ���Ҫ���F��ʾ���㣬����ǿ������ת��(Float)
		double b = 5.7;
		float c = a;
		float d = (float)b;	//bΪdouble�ͣ�����float�ͻ���ʧ���ȱ�����������Ҫǿ������ת��(Float)
		double e = a;	//aΪfloat�ͣ�����double�Ͳ�����ʧ����
		
		System.out.println("Hello!" + 'a' + 10); //��������Hello!a10
		System.out.println('a' + 10 + "Hello!"); //��������107Hello��
		
		System.out.println("�������"+ 10/0.0);
		System.out.println("�������"+ 10/-0.0);
		
	}
}
