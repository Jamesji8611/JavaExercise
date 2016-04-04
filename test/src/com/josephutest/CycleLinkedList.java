package com.josephutest;

public class CycleLinkedList {
	//������
	private Child firstChild;
	private Child tmpChild;
	
	public CycleLinkedList(int Num){
		//����������		
		for(int i = 1; i <= Num; i++){
			if(i == 1){
				Child ch = new Child();
				ch.setId(i);
				ch.setBeforeChild(ch);//������һ���ڵ�
				ch.setNextChild(ch);//������һ���ڵ�
				firstChild = ch;
				tmpChild = ch;
			}else{
				if(i != Num){//�������һ���ڵ�
					Child ch = new Child();
					ch.setId(i);
					ch.setBeforeChild(tmpChild);//������һ���ڵ�Ϊtmp
					ch.setNextChild(ch);//������һ���ڵ�
					tmpChild.setNextChild(ch);//������һ���ڵ����һ���ڵ�Ϊ��ǰ�ڵ�
					tmpChild = ch;
				}else{//���һ���ڵ�
					Child ch = new Child();
					ch.setId(i);
					ch.setBeforeChild(tmpChild);//������һ���ڵ�Ϊtmp
					tmpChild.setNextChild(ch);//������һ���ڵ����һ���ڵ�Ϊ��ǰ�ڵ�
					ch.setNextChild(firstChild);//������һ���ڵ�Ϊfirst
					firstChild.setBeforeChild(ch);//�����һ���ڵ��beforeΪ��ǰ�ڵ�
				}
				
			}
		}
	}
	
	
	
	public void showLinkedList(){
		System.out.println("������");
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
