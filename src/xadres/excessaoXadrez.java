package xadres;

public class excessaoXadrez extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public excessaoXadrez (String msg) {
		super(msg);
	}
}
