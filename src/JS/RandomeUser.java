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
		 HttpClient client = HttpClient.newHttpClient();
		    HttpRequest request = HttpRequest.newBuilder()
		    .uri(URI.create("https://randomuser.me/api/?results=50"))
		    .build();
		    HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
		    ApiJS data=new Gson().fromJson(response.body(),ApiJS.class);
		    
		    
		    
		    for(Integer i=0; i<= response.body().length();i++) {
			System.out.println("Email:        "+data.getResults().get(i).getEmail());
			System.out.println("gender:       "+data.getResults().get(i).getGender());
			System.out.println("nat:          "+data.getResults().get(i).getNat());
			System.out.println("password:     "+data.getResults().get(i).getLogin().getPassword());
			System.out.println("seed:         "+data.getInfo().getSeed());
			//System.out.println("results:      "+data.getInfo().getResults());
			System.out.println("page:         "+data.getInfo().getPage());
			System.out.println("**********************************************************\n \n \n");
		    }
	}
    	else {
//    	   
    		System.out.println("Enter gender: ");
    		String gender = sc.next();
    		System.out.println("Enter seed: ");
    		String seed = sc.next();
    		System.out.println("Enter nat: ");
    		String nat = sc.next();
    		System.out.println("Enter password: ");
    		String password = sc.next();
    		System.out.println("Enter page: ");
    		Integer page = sc.nextInt();
    		
    		System.out.println("enter 1 to exc or 2 to inc");
		    Integer choice = sc.nextInt();
        	if( choice==1) {
		    	 System.out.println("enter type you want to exc");
		    	 String exc = sc.next();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://randomuser.me/api/?results="+results+"&gender="+gender+"&password="+password+"&seed="+seed+ "&nat="+nat+ "&page="+page+"&exc="+exc))
		.build();
		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
		ApiJS data=new Gson().fromJson(response.body(),ApiJS.class);
		
		     

		
		for(Integer i=0; i<results ;i++) {
			if(data.getResults().get(i).getEmail()!=null) {
		System.out.println("Email:        "+data.getResults().get(i).getEmail());}
			
			if(data.getResults().get(i).getGender()!=null) {
		System.out.println("gender:       "+data.getResults().get(i).getGender());}
			
			if(data.getResults().get(i).getNat()!=null) {
		System.out.println("nat:          "+data.getResults().get(i).getNat());}
			
		if(data.getResults().get(i).getLogin()!=null && data.getResults().get(i).getLogin().getPassword()!=null) {
			System.out.println("password:     "+data.getResults().get(i).getLogin().getPassword());}
	
		if(data.getInfo().getSeed()!=null) {
			System.out.println("Seed:     "+data.getInfo().getSeed());}

		}
        	}
        	
        	else {
			System.out.println("enter type you want to inc");
			String inc = sc.next();
			HttpClient Client=HttpClient.newHttpClient();
	    	HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://randomuser.me/api/?results="+results+"&password="+password+"&seed="+seed+"&psge="+page+"&nat="+nat+"&inc="+inc))
//					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();

	    	HttpResponse<String> response =Client.send(request,HttpResponse.BodyHandlers.ofString());
	    	ApiJS data=new Gson().fromJson(response.body(),ApiJS.class);
			
			for(Integer i=0; i<results ;i++) {
				if(data.getResults().get(i).getEmail()!=null) {
			System.out.println("Email:        "+data.getResults().get(i).getEmail());}
				
				if(data.getResults().get(i).getGender()!=null) {
			System.out.println("gender:       "+data.getResults().get(i).getGender());}
				
				if(data.getResults().get(i).getNat()!=null) {
			System.out.println("nat:          "+data.getResults().get(i).getNat());}
				
			if(data.getResults().get(i).getLogin()!=null && data.getResults().get(i).getLogin().getPassword()!=null) {
				System.out.println("password:     "+data.getResults().get(i).getLogin().getPassword());}
		
			if(data.getInfo().getSeed()!=null) {
				System.out.println("Seed:     "+data.getInfo().getSeed());}
			
					}
        	 }
    	}
    }
	

  }
//			for(Integer i=0; i<results ;i++) {
//   			 HttpClient client = HttpClient.newHttpClient();
//   			    HttpRequest request = HttpRequest.newBuilder()
//   			    .uri(URI.create("https://randomuser.me/api/?results=50"))
//   			    .build();
//   			    HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
//   			    ApiJS data=new Gson().fromJson(response.body(),ApiJS.class);
//   			    
//   			    
//   			    
//   			   
//   				System.out.println("Email:        "+data.getResults().get(i).getEmail());
//   				System.out.println("gender:       "+data.getResults().get(i).getGender());
//   				System.out.println("nat:          "+data.getResults().get(i).getNat());
//   				System.out.println("password:     "+data.getResults().get(i).getLogin().getPassword());
//   				System.out.println("seed:         "+data.getInfo().getSeed());
//   				System.out.println("results:      "+data.getInfo().getResults());
//   				System.out.println("page:         "+data.getInfo().getPage());
//   				System.out.println("**********************************************************\n \n \n");
//    		
//    		
//    		
////    		Done by faiza=========================================
//    		System.out.println("Which Password you want to appear:");
//        	String password = sc.next();
//        	HttpClient client = HttpClient.newHttpClient();
//    		HttpRequest request = HttpRequest.newBuilder()
//    		.uri(URI.create("https://randomuser.me/api/?password="+password))
//    		.build();
//    		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
//    		ApiJS data=new Gson().fromJson(response.body(),ApiJS.class);
//    		System.out.println("password:     "+data.getResults().get(0).getLogin().getPassword());
//        	
//        	
//        	
//        	
//        	System.out.println("Enter Seed:");
//        	String seed = sc.next();
//        	HttpClient client1 = HttpClient.newHttpClient();
//    		HttpRequest request1 = HttpRequest.newBuilder()
//    		.uri(URI.create("https://randomuser.me/api/?seed="+seed))
//    		.build();
//    		HttpResponse<String> response1 = client1.send(request1,HttpResponse.BodyHandlers.ofString());
//    		ApiJS data1=new Gson().fromJson(response.body(),ApiJS.class);
//    		System.out.println("seed:         "+data1.getInfo().getSeed());
//        	
//        	
//        	
//    
//        	System.out.println("Enter Page num:");
//        	Integer page = sc.nextInt();
//        	HttpClient client2 = HttpClient.newHttpClient();
//    		HttpRequest request2 = HttpRequest.newBuilder()
//    		.uri(URI.create("https://randomuser.me/api/?page="+page))
//    		.build();
//    		HttpResponse<String> response2 = client2.send(request2,HttpResponse.BodyHandlers.ofString());
//    		ApiJS data2=new Gson().fromJson(response2.body(),ApiJS.class);
//    		System.out.println("page:         "+data2.getInfo().getPage());
//        	
//        	
//        	System.out.println("Enter nationality:");
//        	String nat = sc.next();
//        	HttpClient client0 = HttpClient.newHttpClient();
//    		HttpRequest request0 = HttpRequest.newBuilder()
//    		.uri(URI.create("https://randomuser.me/api/?nat="+nat))
//    		.build();
//    		HttpResponse<String> response0 = client0.send(request0,HttpResponse.BodyHandlers.ofString());
//    		ApiJS data0=new Gson().fromJson(response0.body(),ApiJS.class);
//    		System.out.println("nat:          "+data0.getResults().get(0).getNat());
//        	
//        	
//        	
//        	System.out.println("Enter gender:");
//        	String gender = sc.next();
//        	HttpClient client4 = HttpClient.newHttpClient();
//    		HttpRequest request4 = HttpRequest.newBuilder()
//    		.uri(URI.create("https://randomuser.me/api/?gender="+gender))
//    		.build();
//    		HttpResponse<String> response4 = client4.send(request4,HttpResponse.BodyHandlers.ofString());
//    		ApiJS data4=new Gson().fromJson(response4.body(),ApiJS.class);
//    		System.out.println("gender:       "+data4.getResults().get(0).getGender());
//    		
//
//        	System.out.println("what you want to include?");
//        	System.out.println("email");
//        	System.out.println("cell");
//        	System.out.println("gender");
//        	System.out.println("nat");
//        	System.out.println("passward");
//        	String include = sc.next();
//        	HttpClient client3 = HttpClient.newHttpClient();
//    		HttpRequest request3 = HttpRequest.newBuilder()
//    		.uri(URI.create("https://randomuser.me/api/?inc="+include))
//    		.build();
//    		HttpResponse<String> response3 = client3.send(request3,HttpResponse.BodyHandlers.ofString());
//    		ApiJS data3=new Gson().fromJson(response3.body(),ApiJS.class);
//    		if(data3.getResults().get(0).getEmail()!=null) {
//    			System.out.println("Email:        "+data3.getResults().get(0).getEmail());}
//    				if(data3.getResults().get(0).getCell()!=null) {
//    			System.out.println("cell:         "+data3.getResults().get(0).getCell());}
//    			if(data3.getResults().get(0).getGender()!=null) {
//    			System.out.println("gender:       "+data3.getResults().get(0).getGender());}
//    			if(data3.getResults().get(0).getNat()!=null) {
//    			System.out.println("nat:          "+data3.getResults().get(0).getNat());}
//    			if(data3.getResults().get(0).getLogin().getPassword()!=null) {
//    				System.out.println("password:     "+data3.getResults().get(0).getLogin().getPassword());}
 		    
 		    
 		    
	
	   

