package camp;

public class CounselorNotFoundException extends RuntimeException{
	public CounselorNotFoundException(){
		super ("counselor not found");
	}

}
