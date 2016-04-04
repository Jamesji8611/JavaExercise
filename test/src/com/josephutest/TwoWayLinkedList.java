package com.josephutest;

public class TwoWayLinkedList {
	//˫������
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
		System.out.println("������");
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
		/*��ӽڵ�,����n�����ڵڼ����ڵ���������,m��������ӽڵ������*/
		Child tmp = firstChild;
		Child t = new Child();
		for(int i =1; i < n; i++){
			tmp = tmp.getNextChild();
			if(tmp.getNextChild() == null){
				//tmp = lastChild;
				break;
			}
		}
		t.setId(m);//���������Ľڵ�
		t.setBeforeChild(tmp);//�����ڵ�beforeָ��tmp
		if(tmp == lastChild){
			t.setNextChild(null);//�����ڵ�nextָ��null
			tmp.setNextChild(t);//tmp��next�ڵ�ָ�������ڵ�
			lastChild = t;//last�ڵ�Ϊ�����ڵ�
		}else{
			t.setNextChild(tmp.getNextChild());//�����ڵ�nextָ���һ���ڵ�
			tmp.getNextChild().setBeforeChild(t);//tmp��һ���ڵ��beforeָ�������ڵ�
			tmp.setNextChild(t);//tmp��next�ڵ�ָ�������ڵ�
		}
	}
	
	public void delChild(int n){
		/*ɾ���ڵ�*/
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
