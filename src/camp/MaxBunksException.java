package camp;

public class MaxBunksException extends RuntimeException{
	public MaxBunksException(){
		super("insufficient space for another bunk");
	}

}
