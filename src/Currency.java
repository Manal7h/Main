import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Currency {
	
	double feesAmount = 0;
	double amountCal = 0;
	double amount;
	
	Map<String, Double> currencyMap = new HashMap<>();
	Map<String, Map<String, Double>> comparisioMap = new HashMap<>();
	public static Stack<String> stk = new Stack<>();
	Scanner sc = new Scanner(System.in);
	
	public void currencyN() {
		
	String currencyName="";
	System.out.println("Enter student name who want to convert:");
	String studentConversiName = sc.next();
	stk.push(studentConversiName);
	System.out.println("Choose currency you want to convert" + "1. KUD" + "2. AED" + "3. USD");
	int currency = sc.nextInt();
	String m=Integer.toString(currency);
	stk.push(m);
	System.out.println("please insert fees amount");
	feesAmount = sc.nextDouble();
	String s1 = Double.toString(feesAmount);
	stk.push(s1);
	
	if(currency == 1) {
		amountCal= feesAmount *0.80;
		Math.round(amountCal);
		currencyName = "KUD";
	}
	else if(currency == 2) {
		amountCal= feesAmount *9.54;
		currencyName = "AED";
		
	}
	
	else if(currency == 3) {
		amountCal= feesAmount *2.60;
		currencyName = "USD";
		
	}
	
	currencyMap.put(currencyName, amountCal);
	comparisioMap.put(studentConversiName, currencyMap);
	System.out.println(currencyMap);
	System.out.println(comparisioMap);
	
	//break;
}
}
