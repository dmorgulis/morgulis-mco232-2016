package camp;



public class Person {
	private String firstName;
	private String lastName;
	
	public Person(String firstname, String lastname){
		this.firstName = firstname;
		this.lastName = lastname;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getFirstName (){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	public String getName(){
		return firstName + " " + lastName;
	}
	public String toString(){
		return "\nPerson " + firstName + " " + lastName;
	}
	
	public boolean equals(Object o){
		if (o == null){
			return false;
			
		}
		else{
			if (o instanceof Person){
				Person other = (Person)o; //typecast
				if (this.getFirstName().equals(other.getFirstName())
						&&
						this.getLastName().equals(other.getLastName())
						
						){
					return true; 
				}
				else{
					return false;
				}
			}
			else{
				//not an instance of a person
				return false;
			}
		}
	}

}
