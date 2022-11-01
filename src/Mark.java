
public class Mark implements IMark {
	private int math;
	private int enghlish;
	
	public void pass() {
		System.out.println("You Pass");
	}

	public void setMath(int mark) {
		if (mark > 0 & mark < 100) {
			math = mark;
		} else {
			System.out.println("Please set mark between 0 and 100");
		}
	}

	public int getMath() {

		return math;
	}

	public void setEnglish(int mark) {
		if (mark > 0 & mark < 100) {
			enghlish = mark;
		} else {
			System.out.println("Please set mark between 0 and 100");
		}
	}

	public int getEnghlish() {
		return enghlish;
	}
}
