package part1;

public class BufferFullException extends Exception {
	
	private String message;

	BufferFullException(String m) {
		message = m;
	}
	
	public String toString() {
		return "BufferFullException[" + message + "]";
	}

}
