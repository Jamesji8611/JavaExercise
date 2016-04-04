package com.test2.javatest;

public class ImmutableTest {
	public static void main(String[] args){
		Name n = new Name("���", "��");
		Person p = new Person(n);
		PersonBetter pb = new PersonBetter(n);
		
		System.out.println("�޸�Nameǰ��Person��" + p.getName().getFamilyName() + p.getName().getFirstName());
		System.out.println("�޸�Nameǰ��PersonBetter��" + pb.getName().getFamilyName() + pb.getName().getFirstName());
		
		n.setFirstName("�˽�");
		System.out.println("�޸�Name���Person��" + p.getName().getFamilyName() + p.getName().getFirstName());
		System.out.println("�޸�Name���PersonBetter��" + pb.getName().getFamilyName() + pb.getName().getFirstName());
	}
	
}
class Name{
	private String firstName;
	private String familyName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	
	public Name(){
		this.firstName = "";
		this.familyName = "";
	}
	public Name(String firstName, String familyName){
		this.firstName = firstName;
		this.familyName = familyName;
	}
}

class Person{
	private final Name Name;
	
	public Person(Name Name){
		this.Name = Name;
	}
	public Name getName(){
		return Name;
	}
}

class PersonBetter{
	private final Name Name;
	
	public PersonBetter(Name Name){
		this.Name = new Name(Name.getFirstName(), Name.getFamilyName()); 
	}
	
	public Name getName(){
		return this.Name;
	}
}