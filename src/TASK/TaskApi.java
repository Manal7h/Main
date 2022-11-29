package TASK;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class TaskApi {

	static void TaskMenue() {
		System.out.println("Please Choice one Option:");
		System.out.println("1- Consume API and Write File:");
		System.out.println("3- Search word from File:");
		System.out.println("4- Exite:");

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		boolean isExit = true;
		while (isExit) {
			Scanner sc = new Scanner(System.in);
			TaskMenue();
			int select = sc.nextInt();

			switch (select) {
			case 1:
				try {
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create("https://catfact.ninja/fact"))
						.build();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());	
				System.out.println("My Json is : " + response.body());
				String writeToFile = response.body();
					FileWriter file = new FileWriter("TaskAPI.txt");
					file.write(writeToFile.toString());
					file.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("JSON file created !!");
				
				break;

			case 4:
				System.out.println("Done");
				System.exit(0);
				break;

			}

		}
		isExit = false;

	}

}

//HttpClient client = HttpClient.newHttpClient();
//HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.coindesk.com/v1/bpi/currentprice.json")).build();
//
//HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//System.out.println("JSON is: "+response.body());
///*Write file*/
//  String writeToFile = response.body();
//
//  try {
//  FileWriter file = new FileWriter("test1.txt");
//  file.write(writeToFile.toString());
//  file.close();
//} catch (IOException e) {
//  // TODO Auto-generated catch block
//  e.printStackTrace();
//}
//System.out.println("JSON file created !!");
//
//}