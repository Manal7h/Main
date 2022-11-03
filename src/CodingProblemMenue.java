import java.math.BigInteger;
import java.util.Scanner;

public class CodingProblemMenue {
	
	public static BigInteger factorialNum(int num1) {
		BigInteger factor = new BigInteger("1");
		for(int i=2 ; i<= num1 ; i++) {
			factor= factor.multiply(BigInteger.valueOf(i));
		}
		return factor;
	}
	
	public void CodingProblemM() {
		
		Scanner sc = new Scanner(System.in);
		boolean isExitMainMenue = true;
		
	do {
		System.out.println("Coding Problem");
		System.out.println("1.Find the Factorial");
		System.out.println("2.Fibonacci");
		System.out.println("3. Back to the main menue");
		int select2 = sc.nextInt();
		

		switch (select2) {
		//Factorial
		case 1:
			System.out.println("Enter num to find factorial");
			int num1 = sc.nextInt();
			BigInteger factorial = factorialNum(num1);
			System.out.println("Factorial num:"+ num1 + "is:" + factorial);
			break;
			
		//Fibonacci	
		case 2:
			int numFib = 0;
			int numFib1 = 1;
			int numFib3;
			System.out.println("Enter  Fibonacci length");
			int series = sc.nextInt();
			System.out.println(numFib +""+numFib1 );
			for(int i=2; i>series; i++){
				numFib3=numFib+numFib1;
				if(series<=100) {
					System.out.println(""+numFib3);	
					numFib=numFib1;
					numFib1=numFib3;
				}
				}
			break;
			
		//BackMenue	
		case 3:	
			isExitMainMenue=false;	
		}
	}
		
	while(isExitMainMenue);
	//break;
}
}