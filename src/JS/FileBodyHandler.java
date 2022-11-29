package JS;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class FileBodyHandler {

	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://randomuser.me/api/"))
                .GET() // GET is default
                .build();

        var fileName = "src/resources/index.html";

        HttpResponse response = client.send(request,
                HttpResponse.BodyHandlers.ofFile(Paths.get(fileName)));

        System.out.println(response.statusCode());
	}

}
