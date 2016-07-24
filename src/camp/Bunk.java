package camp;

import java.util.ArrayList;

public class Bunk {
	private String bunkName;
	private Counselor counselor;
	private ArrayList<Camper> campers;
	
	
	public Bunk(String bunkName,Counselor c ){
		this.bunkName = bunkName;
		this.counselor = c;  //shallow copy
		this.campers = new ArrayList<Camper>();
	}
	
	public void assignCounselor(Counselor c){
		this.counselor  = c;  //shallow copy
		
	}
	
	public void addCamper(Camper c){
		if (!campers.contains(c)){
		  campers.add(c);
				  
		}
	}
	
    public void removeCamper(Camper c){
    	campers.remove(c);
    }
    
    public String getBunkName(){
    	return bunkName;
    }
    
    public String toString(){
    	StringBuffer info = new StringBuffer();
    	info.append("\nBunk ");
    	info.append(bunkName);
    	info.append("  " + counselor.toString());
    	info.append("  Campers    " + campers.toString());
    	
    	return info.toString();
    }
    
    public static void main(String[] args){
    	Counselor c = new Counselor ("Ahuva","Lieber","2015-04-25",2000.00);
    	Bunk aBunk = new Bunk("Best Bunk",c);
    	System.out.println(aBunk);
    	c.setLastName("Fine");
    	System.out.println(aBunk);
    	Camper camper = new Camper ("Judy","Klein","2005-08-19");
    	aBunk.addCamper (camper);
    	aBunk.addCamper(new Camper("Hindy","Roth","2005-06-25"));
    	aBunk.addCamper(new Camper("Hindy","Roth","2005-06-25") );
    	
    	System.out.println(aBunk);
    }
}


