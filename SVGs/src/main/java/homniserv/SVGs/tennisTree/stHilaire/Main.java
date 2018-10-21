package homniserv.SVGs.tennisTree.stHilaire;

import java.io.File;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class Main {
	private static URI getBaseURI() {
		// return
		// UriBuilder.fromUri("http://localhost:8080/com.vogella.jersey.first").build();
		return UriBuilder.fromUri("https://mon-espace-tennis.fft.fr/tournoi/82173737/1027765/decoupages").build();
	}

	/** http://www.vogella.com/tutorials/REST/article.html */
	private static void client() {
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());

		String response = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(Response.class)
				.toString();

		String plainAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
		String htmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);

		//System.out.println("RESPONSE=" + response);
		System.out.println("plainAnswer=" + plainAnswer);
		// System.out.println(xmlAnswer);
		System.out.println("htmlAnswer=" + htmlAnswer);
	}

	public static void main(String[] args) {

		System.out.println("txt files are");
		/** https://alvinalexander.com/blog/post/java/create-files-in-directory */

		// create a file that is really a directory
		// File aDirectory = new File("C:/temp");
		File aDirectory = new File("./src/main/java/homniserv/SVGs/tennisTree/stHilaire");

		// get a listing of all files in the directory
		String[] filesInDir = aDirectory.list();

		// sort the list of files (optional)
		// Arrays.sort(filesInDir);

		// have everything i need, just print it now
		for (int i = 0; i < filesInDir.length; i++) {
			String text = filesInDir[i];
			if (text.contains("txt")) {
				System.out.println("file: " + filesInDir[i]);
			}
		}

		client();
	}

}
