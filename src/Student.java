import java.io.Serializable;


public class Student implements Serializable{
	private String stName;
	private Cours cours;
	String studentEmail;
	
//	@Override
//	public void work() {
//		System.out.println("Student Should Work");
//	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStName() {
		return stName;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

}
