package TASK;

import java.io.Serializable;

public class JsonTask implements Serializable{
	
	private String fact;
	private int length;
	
	
	public String getFact() {
		return fact;
	}
	public void setFact(String fact) {
		this.fact = fact;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	

}
