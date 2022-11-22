package JS;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class RandomeUser {
	public static void main(String[] args) {
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://randomuser.me/api"))
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
	

}
}