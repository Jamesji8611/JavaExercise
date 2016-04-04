package com.josephutest;

public class TwoWayLinkedList {
	//双向链表
	private Child firstChild = null;
	private Child lastChild = null;
	private Child tmpChild = null;
	
	public TwoWayLinkedList(int Num){
		for(int i = 1; i <= Num; i++){
			Child ch = new Child();
			ch.setId(i);
			ch.setBeforeChild(tmpChild);
			ch.setNextChild(tmpChild);
			if(i == 1){
				firstChild = ch;
			}else{
				tmpChild.setNextChild(ch);
			}
			tmpChild = ch;
			if(i == Num){
				ch.setNextChild(null);
				lastChild = ch;
			}			
		}
	}
	
	public void showLinkedList(){
		System.out.println("单链表");
		int j =1;
		Child tmp1 = firstChild;
		do{
			System.out.println("LinkedList[" + j + "].id= " + tmp1.getId() 
					+ " beforeChild= " + (tmp1.getBeforeChild() == null?"Null":tmp1.getBeforeChild().getId()) 
					+ " nextChild= " + (tmp1.getNextChild() == null?"Null":tmp1.getNextChild().getId()) );
			if(tmp1.getNextChild() == null){
				break;
			}
			tmp1 = tmp1.getNextChild();
			j++;
		}while(1 == 1);
	}
	
	public void addChild(int n, int m){
		/*添加节点,参数n代表在第几个节点后添加数据,m代表所添加节点的数据*/
		Child tmp = firstChild;
		Child t = new Child();
		for(int i =1; i < n; i++){
			tmp = tmp.getNextChild();
			if(tmp.getNextChild() == null){
				//tmp = lastChild;
				break;
			}
		}
		t.setId(m);//创建新增的节点
		t.setBeforeChild(tmp);//新增节点before指向tmp
		if(tmp == lastChild){
			t.setNextChild(null);//新增节点next指向null
			tmp.setNextChild(t);//tmp的next节点指向新增节点
			lastChild = t;//last节点为新增节点
		}else{
			t.setNextChild(tmp.getNextChild());//新增节点next指向后一个节点
			tmp.getNextChild().setBeforeChild(t);//tmp后一个节点的before指向新增节点
			tmp.setNextChild(t);//tmp的next节点指向新增节点
		}
	}
	
	public void delChild(int n){
		/*删除节点*/
		Child tmp = firstChild;
		for(int i = 1; i < n; i++){
			tmp = tmp.getNextChild();
			if(tmp == lastChild){
				//tmp = lastChild;
				break;
			}
		}
		if(tmp == lastChild){
			tmp.getBeforeChild().setNextChild(null);
			lastChild = tmp.getBeforeChild();
			tmp = null;
		}else{
			tmp.getBeforeChild().setNextChild(tmp.getNextChild());
			tmp.getNextChild().setBeforeChild(tmp.getBeforeChild());
			tmp = null;
		}
	}
	
	public static void main(String[] args){
		TwoWayLinkedList l = new TwoWayLinkedList(8);
		l.showLinkedList();
		l.addChild(10, 15);
		l.showLinkedList();
		l.addChild(16, 15);
		l.showLinkedList();
		l.addChild(16, 15);
		l.showLinkedList();
		l.delChild(4);
		l.showLinkedList();
		l.delChild(20);
		l.showLinkedList();
	}
}
