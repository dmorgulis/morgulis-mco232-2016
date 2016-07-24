package camp;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Camper extends Person{
	
	private ArrayList<Allergy> allergies;
	private LocalDate dateOfBirth;
	
	public Camper (String firstName, String lastName, String dateOfBirth){
	 super(firstName,lastName);
	 this.dateOfBirth = LocalDate.parse(dateOfBirth);
	 allergies = new ArrayList<Allergy>();
	}
	
	public int getAge(){
		//calculate how old in complete years the Camper currently is
		Period elapsedTime = dateOfBirth.until(LocalDate.now());	
		return  elapsedTime.getYears();
		
	}
	
	public void addAllergy (String allergy){
		if (!allergies.contains(Allergy.valueOf(allergy))){
			allergies.add(Allergy.valueOf(allergy));
		}
		//otherwise simply ignore the request
		
	}
	
	public void removeAllergy (String allergy){
		allergies.remove(Allergy.valueOf(allergy));
	}
	
	public String toString(){
		StringBuffer info = new StringBuffer();
		info.append(super.toString());
		info.append(" Camper Birthdate ");
		info.append(dateOfBirth.toString() );
		if (allergies.isEmpty()){
			info.append(" NO KNOWN ALLERGIES");
			
		}
		else{
			info.append(" ALLERGIES ");
			info.append(allergies.toString());
		}
		return info.toString();
				 
	}

}
