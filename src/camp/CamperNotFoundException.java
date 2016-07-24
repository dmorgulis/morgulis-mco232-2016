package camp;

public class CamperNotFoundException extends RuntimeException{
	public CamperNotFoundException(){
		super("camper not found");
	}

}
