package camp;

import java.util.ArrayList;

public class Camp {
	private String campName;
	private Bunk[] bunks;
	private int numBunks;
	private ArrayList<Person> persons;
	
	public Camp (String campName,int maxBunks){
		this.campName = campName;
		this.bunks =new Bunk[maxBunks]; 
		this.numBunks =0; 
		this.persons =new ArrayList<Person>();
		
		
	}
	
	public void addCounselor(String firstname, String lastName, String hireDate, Double salary){
		Counselor c = findCounselor(firstname, lastName);
		if (c == null){
		    persons.add(new Counselor(firstname, lastName, hireDate,salary));
		}
		else {
			throw new DuplicateDataException();
		}
	}
	
	public void addCamper(String firstname, String lastName,String dateofBirth){
		Camper c = findCamper(firstname, lastName);
		if (c == null){
		  persons.add(new Camper(firstname, lastName, dateofBirth));
		}
		else{
			throw new DuplicateDataException();
		}
	}
	
	private Counselor findCounselor(String firstName, String lastName){
		for(Person p : persons){
			if (p instanceof Counselor){
				//check if the names match
				if (p.getFirstName().equals(firstName)&&
						p.getLastName().equals(lastName)
						){
					//found the Counselor
					return (Counselor)p;
				}
	        }  
		}
		return null; //didn't find a Counselor with this name
	}
	
	public void addBunk(String bunkName,String firstName, String lastName)throws 
	CounselorNotFoundException,MaxBunksException{
		//find the counselor in the list
		Counselor c = findCounselor(firstName,lastName);
		if (c==null){
			throw new CounselorNotFoundException();
		}
		else{
					//found the Counselor , now check if you can add a Bunk
					if(numBunks < bunks.length){
					   bunks[numBunks++ ] = new Bunk(bunkName,c);
					   return ;
					}
					else{
						throw new MaxBunksException();
					}
				}
		}
		
		

	
	private Bunk findBunk(String bunkName){
		for (int i=0;i< numBunks;i++){
			if (bunks[i].getBunkName().equals(bunkName)){
				//found the right bunk
				return bunks[i];
			}
		}
		return null;  //couldn't find the bunk
	}
	
	private Camper findCamper(String firstName, String lastName){
		for (Person p : persons){
			if (p instanceof Camper){
				//check if the names match
				if (p.getFirstName().equals(firstName)
					&&
					p.getLastName().equals(lastName)
				){
					
					return (Camper)p;
				}
			}
		}
		return null;   //no Camper with this name
	}
	
	public void placeCamper(String firstName, String lastName, String bunkName)
	throws BunkNotFoundException,CamperNotFoundException{
		//find the right Bunk
		Bunk theBunk = findBunk(bunkName);
		if (theBunk == null){
			//couldn't find the bunk
			throw new BunkNotFoundException();
		}
		//find the Camper in the list
		Camper c = findCamper(firstName, lastName);
		if (c == null ){
			throw new CamperNotFoundException();
		}
		else{
			theBunk.addCamper(c);
		}
			
	}
	
	
	public void modifySalary(String firstName, String lastName, Double salary){
		//find the Counselor
		Counselor c = findCounselor(firstName, lastName);
		if (c== null){
			throw new CounselorNotFoundException();
		}
		else{
		//modify the salary
			c.setSalary(salary);
		}
	}
	
	public void addAllergy (String firstName, String lastName, String allergy){
		//find a Camper
		Camper c = findCamper(firstName, lastName);
		if (c== null){
			throw new CamperNotFoundException();
		}
		else{
			//add the allergy to the Camper's list of allergies
			c.addAllergy(allergy);
		}
	}
	
	public String toString(){
		StringBuffer info = new StringBuffer();
		info.append("\nCamp: ");
		info.append(campName);
		info.append(" Number of Bunks " +this.numBunks + " " );
		info.append(" Bunks: ");
		for (int i=0;i< numBunks; i++ ){
			info.append(bunks[i].toString());
		}
		info.append( "\n All Camp Persons ");
		info.append(persons.toString());
		return info.toString();
	}

}
