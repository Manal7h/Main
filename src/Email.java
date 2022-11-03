import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Email {
	
	Set<String> uniqueEmailSet = new HashSet<String>();
	ArrayList<String> emailArrayList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	public static Stack<String> stk = new Stack<>();
	
	public void EmailS() {
		
		
		Boolean x= true;
		while(x) {
		System.out.println("Enter your Email: ");
		String stuEmail = sc.next();
		stk.push(stuEmail);
		emailArrayList.add(stuEmail);
		System.out.println("1 if you want cont, 0 if not");
		Integer d = sc.nextInt();
		if(d == 0) {
			x = false;
			
			}
		
		}

		for (String email : emailArrayList) {
			if (uniqueEmailSet.add(email) == false) {
				System.out.println("Duplicate this email" +" -->" + email);
			}	
		}
		
	}
}
