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

import homniserv.SVGs.tennisTree.stHilaire.MainTennisStHilaire;

public class MainTennisTournoiSchemas {
	List<Person> association = new ArrayList<>();

	public void svgCreate() {
		String svgTennisTournoisSchemas = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
				+ "<svg width=\"1000\" height=\"1000\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n"
				+ "<line x1=\"0\" y1=\"0\" x2=\"999\" y2=\"999\" style=\"stroke-width: 5px;\" stroke=\"blue\">\n</line>"
				+ "<circle cx=\"50\" cy=\"50\" r=\"40\" style=\"stroke-width: 2px;\" stroke=\"blue\" fill=\"red\" />"
				+ "<ellipse cx=\"240\" cy=\"100\" rx=\"220\" ry=\"30\" style=\"fill:purple\" />"
				+ "<text x=\"50\" y=\"50\" fill=\"black\">I love SVG!</text>" + "\n</svg>";
		/** TODO by Spring bean */
		MainTennisStHilaire main3 = new MainTennisStHilaire();
		main3.saveToFile(svgTennisTournoisSchemas, "tennisTournoisSchemas.svg");
	}

	public void svgSchema() {
		// StringBuffer sb = new StringBuffer();
		String svgTennisTournoisSchemas = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
				+ "<svg width=\"1000\" height=\"1000\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n";
		/** background blanc */
		svgTennisTournoisSchemas += "<rect width=\"1000\" height=\"1000\" style=\"fill:rgb(255,255,255);stroke-width:0;stroke:rgb(255,255,255)\" />\n";
		/** Partie 1 ellipse */
		for (int ellipse = 0; ellipse <= ((this.association.size() / 3)); ellipse++) {
			svgTennisTournoisSchemas += "<ellipse cx=\"65\" cy=\"" + (20 + 1 * 50 + ellipse * 50 * 3)
					+ "\" rx=\"30\" ry=\"60\" style=\"fill:rgb(0,255,0)\"/>\n";
		}
		/** Partie 1 noms */
		for (int k = 0; k < this.association.size(); k++) {
			// TODO fields by accessor
			svgTennisTournoisSchemas += "<text x=\"50\" y=\"" + (20 + k * 50) + "\" fill=\"black\">"
					+ this.association.get(k).pseudo + "" + (k) + "</text>\n";
		}

		/** Partie 1 rencontres */
		// for (int pool = 0; pool < this.association.size(); pool++) {
		for (int pool = 0; pool <= 1; pool++) {
			System.out.println("pool=" + pool);
			// TODO fields by accessor
			// svgTennisTournoisSchemas += "<text x=\"50\" y=\"" + (20 + k * 50) + "\"
			// fill=\"black\">" +this.association.get(k).pseudo+""+ (k) + "</text>";
			/** rencontr1 0 vs 1 D */
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (pool * 150 + (20 + 0 * 50)) + "\" x2=\"100\" y2=\""
					+ (pool * 150 + (20 + 0.5 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"red\"></line>\n";
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (pool * 150 + (20 + 1 * 50)) + "\" x2=\"100\" y2=\""
					+ (pool * 150 + (20 + 0.5 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"red\"></line>\n";

			/** rencontr1 1 vs 2 D */
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (pool * 150 + (20 + 1 * 50)) + "\" x2=\"100\" y2=\""
					+ (pool * 150 + (20 + 1.5 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"green\"></line>\n";
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (pool * 150 + (20 + 2 * 50)) + "\" x2=\"100\" y2=\""
					+( pool * 150 + (20 + 1.5 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"green\"></line>\n";

			/** rencontr2 0 vs 2 G */
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (pool * 150 + (20 + 0 * 50)) + "\" x2=\"40\" y2=\""
					+( pool * 150 + (20 + 1 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"blue\"></line>\n";
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (pool * 150 + (20 + 2 * 50)) + "\" x2=\"40\" y2=\""
					+( pool * 150 + (20 + 1 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"blue\"></line>\n";

		}
		/** Partie 1 scores */
		/** label Partie 1 */

		svgTennisTournoisSchemas += "\n</svg>";
		/** TODO by Spring bean */
		MainTennisStHilaire main3 = new MainTennisStHilaire();
		main3.saveToFile(svgTennisTournoisSchemas, "tennisTournoisSchemas.svg");
	}

	public List randomizeList(List<Person> ll) {
		List<Person> lll = new ArrayList<>(ll);

		List list = new ArrayList();
		System.out.println("lll size=" + lll.size());
		System.out.println("lll 0=" + lll.get(0));
		/** 1 because 0 incompatible with random.nextInt() */
		for (int indexMax = lll.size() - 1; indexMax <= 1; indexMax++) {
			System.out.println("indexMax=" + indexMax);
			/**
			 * https://stackoverflow.com/questions/14965326/how-to-randomly-select-a-integer-from-a-list-in-java
			 */
			Random random = new Random();
			int randomInt = random.nextInt(indexMax + 1);
			list.add(lll.get(randomInt));
			System.out.println("randomInt=" + randomInt);
			System.out.println("lll size=" + lll.size());
			lll.remove(randomInt);
		}
		/** left : last unique element in the lll */
		list.add(lll.get(0));
		lll.remove(0);
		System.out.println("list size=" + list.size());
		this.toString();
		return list;
		// return null;
	}

	public StringBuffer toString(List<Person> ll2) {
		StringBuffer str = new StringBuffer();
		for (Person p : ll2) {
			// System.out.println(l);
			str.append(p.toString());
		}
		return str;
	}

	/** demi et finales en refining final, avant...par pool */
	public void mixTournament() {
		Person p = new Person("Peter");
		association.add(p);
		p = new Person("Sco");
		association.add(p);
		p = new Person("Karis");
		association.add(p);
		p = new Person("Number");
		association.add(p);
		/**
		 * id jour vs no item ; streams OR map
		 * https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
		 * parallel
		 */
		// association = Arrays.asList(p1, p2);
		Integer longueur = association.size();

		// entity number

		List randomizedList = this.randomizeList(association);
		// for (int k = 0; k < randomizedList.size(); k++) {
		//
		// }
		System.out.println(this.toString(randomizedList));
		// this.svgCreate();
		this.svgSchema();
	}

	public static void main(String[] args) {
		// streams + lambdas
		MainTennisTournoiSchemas mainTennisTournoiSchemas = new MainTennisTournoiSchemas();
		mainTennisTournoiSchemas.mixTournament();
	}

	public void refiningTournament() {

	}

	public void poolsTournament() {

	}

	/***/
	public void arbitrageTournamentLive() {

	}

	/***/
	public void arbitrageTournamentFile() {

	}
}
