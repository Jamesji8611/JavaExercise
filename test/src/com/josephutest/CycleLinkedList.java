package com.josephutest;

public class CycleLinkedList {
	//环链表
	private Child firstChild;
	private Child tmpChild;
	
	public CycleLinkedList(int Num){
		//创建环链表		
		for(int i = 1; i <= Num; i++){
			if(i == 1){
				Child ch = new Child();
				ch.setId(i);
				ch.setBeforeChild(ch);//定义上一个节点
				ch.setNextChild(ch);//定义下一个节点
				firstChild = ch;
				tmpChild = ch;
			}else{
				if(i != Num){//不是最后一个节点
					Child ch = new Child();
					ch.setId(i);
					ch.setBeforeChild(tmpChild);//定义上一个节点为tmp
					ch.setNextChild(ch);//定义下一个节点
					tmpChild.setNextChild(ch);//定义上一个节点的下一个节点为当前节点
					tmpChild = ch;
				}else{//最后一个节点
					Child ch = new Child();
					ch.setId(i);
					ch.setBeforeChild(tmpChild);//定义上一个节点为tmp
					tmpChild.setNextChild(ch);//定义上一个节点的下一个节点为当前节点
					ch.setNextChild(firstChild);//定义下一个节点为first
					firstChild.setBeforeChild(ch);//定义第一个节点的before为当前节点
				}
				
			}
		}
	}
	
	
	
	public void showLinkedList(){
		System.out.println("环链表");
		Child tmp = firstChild;
		int i = 1;
		do{
			System.out.println("LinkedList[" + i + "].id= " + tmp.getId() 
					+ " beforeChild= " + tmp.getBeforeChild().getId() + " nextChild= " + tmp.getNextChild().getId() );
			tmp = tmp.getNextChild();
			i++;
		}while(tmp != firstChild);
	}
	
	public static void main(String[] args){
		CycleLinkedList l = new CycleLinkedList(8);
		l.showLinkedList();
	}

}
