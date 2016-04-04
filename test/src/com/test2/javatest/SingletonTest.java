package com.test2.javatest;
/**
 * 
 * @author James
 * @funciton 单例类 Singleton
 *
 */
public class SingletonTest {
	public static void main(String[] args){
		
		Singleton T1 = Singleton.Create();
		Singleton T2 = Singleton.Create();
		System.out.println("创建的T1和T2是否指向同一个实例？ " + (T1 == T2 ?true:false));
		System.out.println("*********************************************");
		Singleton.Drop();
		System.out.println("T1 = " + T1 + " T2 = " + T2);
		System.out.println("*********************************************");
		T1 = Singleton.Create();
		System.out.println("重新创建了T1:");
		Singleton T3 = Singleton.Create();
		System.out.println("重新创建的T1和T2是否指向同一个实例？ " + (T1 == T2 ?true:false));
		System.out.println("重新创建的T1和新创建T3是否指向同一个实例？ " + (T1 == T3 ?true:false));
	}
}
class Singleton{
	private static Singleton SingleT; //创建一个静态的缓存用以保存以创建的实例
	private Singleton(){
		System.out.println("创建一个private的Constructor，以保证外来类和方法无法创建实例");
	}
	public static Singleton Create(){
		if(SingleT == null){
			SingleT = new Singleton();
			System.out.println("如果该类没有创建过实例，则Singleton is null，则创建一个实例");
		}else{//如果已经创建过实例，则Singleton is not null,直接返回SingleT 即已经创建过的实例
			System.out.println("该类已经创建过实例，返回创建过的实例SingleT");
		}
		return SingleT;
	}
	public static void Drop(){
		System.out.println("释放掉创建过的实例！");
		SingleT = null;
	}
}
