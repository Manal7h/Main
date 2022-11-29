package FILE;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteFile {
	
	
	static void MenueMain(){
		System.out.println("Please Choice one Option:");
		System.out.println("1- Read File:");
		System.out.println("2- Search word from File:");
		System.out.println("3- Create Directory:");
		System.out.println("4- Exite:");
	}
	
	
	public static void main(String[] args) throws IOException {
		boolean isExit = true;
		while (isExit) {
			Scanner sc = new Scanner(System.in);
			
			MenueMain();
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				try {
					File myObj = new File("C:\\Users\\user018\\eclipse-workspace\\Test\\API.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						System.out.println(data);
					}
					myReader.close();
				}
				catch (Exception e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				
				break;
				
				//case 2:
				//https://www.candidjava.com/tutorial/program-to-search-word-in-a-file/
				//break;
				
			case 3:	
			     System.out.println("Enter the name of the desired a directory: ");
			     String nameofDirctory = sc.next();
			     //Creating a File object
			     File file = new File("C://"+nameofDirctory);
			     //Creating the directory
			     boolean bool = file.mkdir();
			     if(bool){
			        System.out.println("Directory created successfully");
			     }else{
			        System.out.println("Sorry couldn’t create specified directory");
			     }
				
				break;
				
			case 4:
				 System.out.println("Done");
				 System.exit(0);
				break;
			}
			
		}
		isExit=false;
	}

}
