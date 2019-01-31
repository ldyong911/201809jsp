package kr.or.ddit.rangers.model;

public class RangerVO {
	private String name; //이름(영문)
	private String alias; //별명(한글)
	private int age; //나이
	
	public RangerVO(){
	}
	
	public RangerVO(String name, String alias, int age){
		this.name = name;
		this.alias = alias;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "RangerVO [name=" + name + ", alias=" + alias + ", age=" + age + "]";
	}
}