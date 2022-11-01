import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.*;

public class Main {
	
	public static Stack<String> stk = new Stack<>();
		
	static Student[] enterStudent(Student std[]) {
		
		//Serialization&File
		FileOutputStream fileOut = null ;
		ObjectOutputStream out = null;

	
		// stack define
		int num = std.length;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < num; i++) {
			std[i] = new Student();
			
			//Student Name
			System.out.println("Enter Student Name");
			//try {
			String studentName = sc.nextLine();
			std[i].setStName(studentName);
			stk.push(studentName);
			//}
			//catch(Exception e) {
			//	System.out.println("Exception : "+ e.getMessage()); 	
			//}
			
			//Mark
			//boolean markTrue = true;
			///while(markTrue) {
			//try {
			System.out.println("Enter Mark for Math");
			Integer m1 = sc.nextInt();
			String m = Integer.toString(m1);
			//int m1 = Integer.toString(m);
			stk.push(m);
			//}
			//catch(Exception e) {
			//System.out.println("Exception : "+ e.getMessage());
			//}
			
			//Mark
			System.out.println("Enter Mark for English");
			// String e = sc.nextLine();
			Integer m2 = sc.nextInt();
			String e = Integer.toString(m2);
			// int m2 = Integer.parseInt(e);
			stk.push(e);
			
			

			Set<String> uniqueEmailSet = new HashSet<String>();
			ArrayList<String> emailArrayList = new ArrayList<>();
			
			
			//Email
			System.out.println("Enter Email: ");
			String stuEmail = sc.next();
			stk.push(stuEmail);
			uniqueEmailSet.add(stuEmail);
			emailArrayList.add(stuEmail);
			
			
			
			//Serialization&File
			try {
				
				fileOut= new FileOutputStream("manal.txt");
				out=new ObjectOutputStream(new FileOutputStream("manal.txt"));
				out.writeObject(stk);
				//out.close();
				//out.writeObject(std[i]);
				out.flush();
				out.close();
				System.out.println("Object serialized and save in manal.txt");
				}
			
			catch(Exception e1) {
				System.out.println(e1);	
				}


			Cours cours = new Cours();
			Mark mark = new Mark();
			
			
			School school = new School();
			Student student = new Student();
			

			student.setStName(studentName);
			mark.setMath(m1);
			mark.setEnglish(m2);
			cours.setMark(mark);
			std[i].setCours(cours);
			student.setCours(cours);
			school.setStudent(student);
			student.setStudentEmail(stuEmail);
			//student.work();
			
			

			System.out.println("Student in School:" + student.getStName() + "\n" + "Math Mark is "
					+ student.getCours().getMark().getMath());
			System.out.println("Enghlish Mark is:" + student.getCours().getMark().getEnghlish() + " " + student.getStudentEmail());
			mark.pass();
			

		}

		return std;
	}//Student
	
	//print
	static void printList(Student studentList[]) {
		for (int i = 0; i < studentList.length; i++) {
			System.out.println("Student name :" + studentList[i].getStName() + " " + "Math Mark is:" + studentList[i].getCours().getMark().getMath());
			System.out.println("Enghlish Mark is:" + studentList[i].getCours().getMark().getEnghlish());
		}
	}

	//Exit
	static void Exit() {
		System.out.println("Exit");
	}
	
	
	//Factorial 
	public static BigInteger factorialNum(int num1) {
		BigInteger factor = new BigInteger("1");
		for(int i=2 ; i<= num1 ; i++) {
			factor= factor.multiply(BigInteger.valueOf(i));
		}
		return factor;
	}

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isExit = true;
		boolean isExitMainMenue = true;

		System.out.println("Enter Number of Student you want:");
		Scanner sci = new Scanner(System.in);

		int num = sci.nextInt();
		Student std[] = new Student[num];

		//HashSet
		Set<String> uniqueEmailSet = new HashSet<String>(); //Set doesn't accept duplicated values 
		ArrayList<String> emailArrayList = new ArrayList<>();
		
		
		double feesAmount = 0;
		double amountCal = 0;
		double amount;
		boolean isExitLogin=true;
		//boolean isExitProgram=true;
		

		//UserName&PassWord
		while(isExitLogin) { //use to go inside the loop once the condition true
			try {
			System.out.println(" please Enter username");
			String loginUserName=sc.next();
			
			System.out.println(" please Enter Password");
		    String loginPassword=sc.next();
		
		
				String UserName= "Manal";
				String Password = "1997";
			
				if(loginUserName.matches(UserName) && loginPassword.matches(Password)) {
					System.out.println("valid userName and password");
			
					//else if (!loginUserName.equals("Manal") && !loginPassword.equals("1997")) {
					//System.out.println("Invalid userName and password pls try again");
					//boolean cheack=loginUserName.equals(userName); //true
					//if(cheack==true && loginPassword==password ) {
				
			
		do {
			System.out.println("");
			System.out.println("_________________**Welcome**____________________");
			System.out.println("");
			System.out.println("        Select Option        ");
			System.out.println("     [1].Enter Student       ");
			System.out.println("     [2].Print List          ");
			System.out.println("     [3].show history        ");
			System.out.println("     [4].Email               ");
			System.out.println("     [5].Currency            ");
			System.out.println("     [6].Coding Problem Menue");
			System.out.println("     [7].Exit"                );
			int select = sc.nextInt();
			//int option = Integer.parseInt(select);

			switch (select) {
			case 1:
				std = enterStudent(std);
				break;

			case 2:
				printList(std);
				
				//Serialization&File
				try {
					
				ObjectInputStream fileIn= new ObjectInputStream(new FileInputStream("manal.txt"));
				Stack<String> stk2= (Stack<String>)fileIn.readObject();
				System.out.println("stk2"+ stk2);
				fileIn.close();
				}
				catch(Exception e) {
				
					System.out.println(e);
				}
				
				break;
				
			case 3:
				while (stk.empty() == false) {
					System.out.println("The history is : " + stk.pop());
				}
				break;

			case 4:
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
				
				
				break;

			case 5:
				//Map
				Map<String, Double> currencyMap = new HashMap<>();
				Map<String, Map<String, Double>> comparisioMap = new HashMap<>();
				
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
				
				break;
				
			case 6:
			    
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
				break;
			
			case 7:
				isExit=false;
				break;
			}
		}//Do
		
		while(isExit);
		
				}//if userName&passWord
				

				else if (!loginUserName.matches(UserName) && !loginPassword.matches(Password));
				{
				}
				System.out.println("Invalid userName and password pls try again");		
				
			}//try*userName
		
				
			catch(Exception e) {
				System.out.println("Exception : "+ e.getMessage()); 	
			}

				}//while(isExitLogin)

			}//main 
}//Main
		
