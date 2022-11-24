package JS;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;

public class RandomeUser implements Serializable {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Enter num user: ");
		Scanner sc = new Scanner(System.in);
		Integer results = sc.nextInt();	
		

	if(results==0){
		 HttpClient Client=HttpClient.newHttpClient();
		 HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://randomuser.me/api/?results=50"))
//				.("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = Client.send(request,HttpResponse.BodyHandlers.ofString()) ;
		System.out.println(response.body());
		ApiJS data=new Gson().fromJson(response.body(),ApiJS.class);
		for (Integer i = 0; i < response.body().length(); i++){
			System.out.println("This is Json Data:");
			System.out.println("Info-Results:" +" "+ data.getInfo().getResults());
			System.out.println("Info-Version:" +" "+ data.getInfo().getVersion());
			System.out.println("Results-Gender:" +" "+ data.getResults().get(i).getGender());
			System.out.println("Results-Password:" +" "+ data.getResults().get(i).getLogin().getPassword());
			System.out.println("Info-Seed:" +" "+ data.getInfo().getSeed());
			System.out.println("Info-Page:" +" "+ data.getInfo().getPage());
		}
	}
	
	else {
		System.out.println("Which Password you want to appear:");
    	String password = sc.next();
    	System.out.println("Enter Seed:");
    	String seed = sc.next();
    	System.out.println("Enter Page num:");
    	Integer page = sc.nextInt();
    	System.out.println("Enter nationality:");
    	String nat = sc.next();
    	
	    for (Integer i = 0; i < results; i++){
	    	
	    	HttpClient Client=HttpClient.newHttpClient();
	    	HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://randomuser.me/api/?results="+results+"&password="+password+"&seed"+seed+"&psge"+page+"&nat"+nat))
//					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
	    	HttpResponse<String> response =Client.send(request,HttpResponse.BodyHandlers.ofString());
	    	ApiJS data=new Gson().fromJson(response.body(),ApiJS.class);
	    	
	    	
	System.out.println("This is Json Data:");
	System.out.println("Info-Results:" +" "+ data.getInfo().getResults());
	System.out.println("Info-Version:" +" "+ data.getInfo().getVersion());
	System.out.println("Results-Gender:" +" "+ data.getResults().get(i).getGender());
	System.out.println("Results-Password:" +" "+ data.getResults().get(i).getLogin().getPassword());
	System.out.println("Info-Seed:" +" "+ data.getInfo().getSeed());
	System.out.println("Info-Page:" +" "+ data.getInfo().getPage());
	}
	}

}
}