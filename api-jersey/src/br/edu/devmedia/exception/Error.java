package br.edu.devmedia.exception;

public class Error {
	
	private int status;

	private String message;

	public Error() { }

	public Error(int status, String message) {
		this.setStatus(status);
		this.setMessage(message);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}