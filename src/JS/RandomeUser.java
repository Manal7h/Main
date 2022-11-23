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
	public static void main(String[] args) {
		
		System.out.println("Enter num user: ");
		Scanner sc = new Scanner(System.in);
		Integer results = sc.nextInt();	
		
			System.out.println("Which Password you want to appear:");
			String password = sc.next();
			System.out.println("Enter Seed:");
			String seed = sc.next();
			System.out.println("Enter Page num:");
			Integer page = sc.nextInt();
	
			
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://randomuser.me/api/?password="+password+ "&seed=" +seed +"?page="+page))
			.method("GET", HttpRequest.BodyPublishers.noBody())
			.build();
	HttpResponse<String> response = null;
	try {
		response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println(response.body());
	ApiJS data=new Gson().fromJson(response.body(),ApiJS.class);
	
	if(results==0) {
		
		
	}
	for (int i = 0; i < results; i++) { 
	System.out.println("This is Json Data:");
	System.out.println("Info-Results:" +" "+ data.getInfo().getResults());
	System.out.println("Info-Version:" +" "+ data.getInfo().getVersion());
	System.out.println("Results-Gender:" +" "+ data.getResults().get(0).getGender());
	System.out.println("Results-Password:" +" "+ data.getResults().get(0).getLogin().getPassword());
	System.out.println("Info-Seed:" +" "+ data.getInfo().getSeed());
	System.out.println("Info-Page:" +" "+ data.getInfo().getPage());
	}

}
}