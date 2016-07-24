package camp;

import java.time.LocalDate;

public class Counselor extends Person{
	private LocalDate hireDate;
	private Double salary;
	
	public Counselor(String firstName, String lastName, String hireDate, Double salary){
		super(firstName,lastName);
	    this.hireDate = LocalDate.parse(hireDate);
	    this.salary = salary;
			
	}
	
	public void setSalary(Double salary){
		this.salary = salary;
	}
	
	public Double getSalary(){
		return salary;
	}
	
	public String toString(){
		return super.toString() + " Counselor Hire Date: " + hireDate.toString();
	}

}
