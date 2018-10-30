package tennisTournoiSchemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import homniserv.SVGs.tennisTree.stHilaire.Main;

public class Main {
	List<Person> association;

	public static void main(String[] args) {
		// streams + lambdas

	}

	public void refiningTournament() {

	}

	public void poolsTournament() {

	}

	public List randomizeList(List ll) {
		List lll = ll;
		List list = new ArrayList();
		for (int j = 0; j <= (ll.size() - 1); j++) {
			/**
			 * https://stackoverflow.com/questions/14965326/how-to-randomly-select-a-integer-from-a-list-in-java
			 */
			Random random = new Random();
			int randomInt = random.nextInt(lll.size() - 1);
			list.add(ll.get(randomInt));
			lll.remove(randomInt);
		}
		return list;
	}

	/** demi et finales en refining final, avant...par pool */
	public void mixTournament() {
		Person p1 = new Person("Peter");
		Person p2 = new Person("Sco");
		/**
		 * id jour vs no item ; streams OR map
		 * https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
		 * parallel
		 */
		association = Arrays.asList(p1, p2);
		Integer longueur = association.size();

		// entity number

		List randomizedList = this.randomizeList(association);
		for(int k=0;k<randomizedList.size();k++) {
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());

		String response = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(Response.class)
				.toString();

		String plainAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
		String htmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);

		// System.out.println("RESPONSE=" + response);
		// System.out.println("plainAnswer=" + plainAnswer);
		System.out.println("plainAnswer=" + plainAnswer);

		/** TODO by Spring bean */
		Main main2 = new Main();
		main2.saveToFile(plainAnswer, "plainAnswer.txt");

		// System.out.println(xmlAnswer);

		// System.out.println("htmlAnswer=" + htmlAnswer);
		main2.saveToFile(htmlAnswer, "htmlAnswer.txt");

		String svgScores = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
				+ "<svg width=\"1000\" height=\"1000\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">"
				+ "<line x1=\"0\" y1=\"0\" x2=\"999\" y2=\"999\" style=\"stroke-width: 50px;\"></line>"
					+ "</svg>";
		//+ "<line stroke-dasharray=\"10, 5\" x1=\"182\" y1=\"10\" x2=\"350\" y2=\"10\" style=\"stroke-width: 6px;\"></line>"
		
		main2.saveToFile(svgScores, "scores.svg");
	}

	/***/
	public void arbitrageTournamentLive() {

	}

	/***/
	public void arbitrageTournamentFile() {

	}
}
