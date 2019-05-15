package tennisTournoiSchemas;

import java.awt.Point;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import entities.Match;
import entities.Person;
import entities.Pool;
import homniserv.SVGs.tennisTree.stHilaire.MainTennisStHilaire;
import presentation.ConfigurationBean;
import presentation.MatchSide;
import presentation.Strategy;

public class MainTennisTournoiSchemas {
//	List<Person> personsCollection = new ArrayList<Person>();
	List<Pool> poolsCollection = new ArrayList<Pool>();
	ApplicationContext context = null;
//	public List<Person> getPersonsCollection() {
//		return personsCollection;
//	}

//	public void setPersonsCollection(List<Person> personsCollection) {
//		this.personsCollection = personsCollection;
//	}

	public List<Pool> getPoolsCollection() {
		return poolsCollection;
	}

	public void setPoolsCollection(List<Pool> poolsCollection) {
		this.poolsCollection = poolsCollection;
	}

	public static void main(String[] args) {
		/**
		 * https://www.tutorialspoint.com/spring/spring_applicationcontext_container.htm
		 */
//		ApplicationContext context = new FileSystemXmlApplicationContext
//		         ("C:/Users/ZARA/workspace/HelloSpring/src/Beans.xml");
//		
		MainTennisTournoiSchemas mainTennisTournoiSchemas = new MainTennisTournoiSchemas();
		mainTennisTournoiSchemas.context = new FileSystemXmlApplicationContext(
				"/SVGs/src/main/resources/applicationContext.xml");

		Strategy stategy = Strategy.POOLS;
		Pool pool1 = new Pool();
		List<Person> personsCollection = new ArrayList<Person>();
		Person p1 = new Person("Number6");
		Person p2 = new Person("Hakim");
		Person p3 = new Person("Sandrine");
		Person p4 = new Person("Jasmin");
		Person p5 = new Person("Anthony");
		Person p6 = new Person("Peter");

		Person p11 = new Person("Geoffroy");
		Person p12 = new Person("LaPomme");
		Person p13 = new Person("Dominique");
		Person p14 = new Person("Yoann");
		personsCollection.add(p1);
		personsCollection.add(p2);
		personsCollection.add(p3);
		personsCollection.add(p4);
		personsCollection.add(p5);
		personsCollection.add(p6);

		Pool pool2 = new Pool();
		List<Person> personsCollection2 = new ArrayList<Person>();
		personsCollection2.add(p11);
		personsCollection2.add(p12);
		personsCollection2.add(p13);
		personsCollection2.add(p14);

		pool1.setPersonsCollection(personsCollection);
		pool2.setPersonsCollection(personsCollection2);

		// streams + lambdas
		List<Pool> poolsCollection = new ArrayList<Pool>();

		mainTennisTournoiSchemas.setPoolsCollection(poolsCollection);

		List<Match> matchsCollection = new ArrayList<Match>();/** ici ordonné ; TODO par personsCollection */
		List<Match> matchsCollection2 = new ArrayList<Match>();/** ici ordonné ; TODO par personsCollection */

		Match match1 = new Match(p1, p2, 3, 6, MatchSide.RIGHT);
		Match match2 = new Match(p3, p4, 3, 6, MatchSide.RIGHT);
		Match match3 = new Match(p5, p6, 6, 4, MatchSide.RIGHT);

		Match match4 = new Match(p1, p3, 6, 3, MatchSide.LEFT);
		Match match5 = new Match(p2, p5, 6, 7, MatchSide.LEFT);
		Match match6 = new Match(p4, p6, 1, 6, MatchSide.LEFT);

		matchsCollection.add(match1);
		matchsCollection.add(match2);
		matchsCollection.add(match3);

		matchsCollection.add(match4);
		matchsCollection.add(match5);
		matchsCollection.add(match6);

		Match match21 = new Match(p11, p12, 5, 7, MatchSide.RIGHT);
		Match match22 = new Match(p13, p14, 6, 3, MatchSide.RIGHT);

		Match match41 = new Match(p11, p13, 6, 2, MatchSide.LEFT);
		Match match42 = new Match(p12, p14, 6, 3, MatchSide.LEFT);

		matchsCollection2.add(match21);
		matchsCollection2.add(match22);

		matchsCollection2.add(match41);
		matchsCollection2.add(match42);

		pool1.setMatchCollection(matchsCollection);
		pool2.setMatchCollection(matchsCollection2);

		poolsCollection.add(pool1);
		poolsCollection.add(pool2);
		mainTennisTournoiSchemas.mixTournament();
	}

	/** @deprecated,was to learn */
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
		int nbPersTOTmax = 0;
		int nbPersTOTmin = 0;
		int nbPers = 0;
		ConfigurationBean widthPool = (ConfigurationBean) context.getBean("helloWorld");
		widthPool.getWidthPool();
		
		// StringBuffer sb = new StringBuffer();
		String svgTennisTournoisSchemas = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
				+ "<svg width=\"1000\" height=\"1000\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n";
		/** background blanc */
		svgTennisTournoisSchemas += "<rect width=\"1000\" height=\"1000\" style=\"fill:rgb(255,255,255);stroke-width:0;stroke:rgb(255,255,255)\" />\n";
		/** Partie 1 ellipse */
		for (int ellipsePool = 0; ellipsePool <= (this.getPoolsCollection().size()); ellipsePool++) {
			svgTennisTournoisSchemas += "<ellipse cx=\"65\" cy=\"" + (20 + 1 * 50 + ellipsePool * 50 * 3)
					+ "\" rx=\"30\" ry=\"60\" style=\"fill:rgb(0,255,0)\"/>\n";

			int nbPersInPool = this.getPoolsCollection().get(ellipsePool).getPersonsCollection().size();

			nbPersTOTmax += nbPersInPool;
			/** Partie 1 noms */
			for (int k = 0; k < nbPersInPool; k++) {

				// TODO fields by accessor
				svgTennisTournoisSchemas += "<text x=\"50\" y=\"" + (20 + nbPers * 50) + "\" fill=\"black\">"
						+ this.getPoolsCollection().get(ellipsePool).getPersonsCollection().get(k).getPseudoTournoi() + ""
						+ (k) + "</text>\n";
				nbPers++;
			}

			
			
			/** Partie 1 rencontres association matchs*/
			System.out.println("pool=" + ellipsePool);
			// TODO fields by accessor
			// svgTennisTournoisSchemas += "<text x=\"50\" y=\"" + (20 + k * 50) + "\"
			// fill=\"black\">" +this.association.get(k).pseudo+""+ (k) + "</text>";
			/** rencontr1 0 vs 1 D */
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (ellipsePool * 150 + (20 + 0 * 50)) + "\" x2=\"100\" y2=\""
					+ (ellipsePool * 150 + (20 + 0.5 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"red\"></line>\n";
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (ellipsePool * 150 + (20 + 1 * 50)) + "\" x2=\"100\" y2=\""
					+ (ellipsePool * 150 + (20 + 0.5 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"red\"></line>\n";

			/** rencontr1 1 vs 2 D */
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (ellipsePool * 150 + (20 + 1 * 50)) + "\" x2=\"100\" y2=\""
					+ (ellipsePool * 150 + (20 + 1.5 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"green\"></line>\n";
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (ellipsePool * 150 + (20 + 2 * 50)) + "\" x2=\"100\" y2=\""
					+ (ellipsePool * 150 + (20 + 1.5 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"green\"></line>\n";

			/** rencontr2 0 vs 2 G */
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (ellipsePool * 150 + (20 + 0 * 50)) + "\" x2=\"40\" y2=\""
					+ (ellipsePool * 150 + (20 + 1 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"blue\"></line>\n";
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (ellipsePool * 150 + (20 + 2 * 50)) + "\" x2=\"40\" y2=\""
					+ (ellipsePool * 150 + (20 + 1 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"blue\"></line>\n";
			/**associations par match*/
			for(Match match:this.getPoolsCollection().get(ellipsePool).getMatchCollection()) {
			if(match.getMatchSide()==MatchSide.LEFT) {
				this.getPoolAbsX()+this.getPersonRelativePoolX()	;//match.getP1()
				this.getPoolAbsY()+this.getPersonRelativePoolY(match.getP2())
				
				this.getPoolAbsX()+this.getPersonRelativePoolX()-((ConfigurationBean)this.context.getBean("configurationBean")).getMarginNameX()	;//match.getP1()
				(this.getPoolAbsY()+this.getPersonRelativePoolY(match.getP2())
			+
			this.getPoolAbsY()+this.getPersonRelativePoolY(match.getP2())
			)/2;
			}else {
				this.getPoolAbsX()+this.getPersonRelativePoolX()	;//match.getP1()
				this.getPoolAbsY()+this.getPersonRelativePoolY(match.getP2())
				
				
			}
			

			/** rencontr2 0 vs 2 G */
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (ellipsePool * 150 + (20 + 0 * 50)) + "\" x2=\"40\" y2=\""
					+ (ellipsePool * 150 + (20 + 1 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"blue\"></line>\n";
			svgTennisTournoisSchemas += "<line x1=\"70\" y1=\"" + (ellipsePool * 150 + (20 + 2 * 50)) + "\" x2=\"40\" y2=\""
					+ (ellipsePool * 150 + (20 + 1 * 50)) + "\" style=\"stroke-width: 5px;\" stroke=\"blue\"></line>\n";
	}
			nbPersTOTmin += nbPersInPool;
		}

		

	
		/** Partie 1 scores */
		/** label Partie 1 */
		/** treeAscendant Partie 2 */
		/** label Partie 2 */
		svgTennisTournoisSchemas += "\n</svg>";
		/** TODO by Spring bean */
		MainTennisStHilaire main3 = new MainTennisStHilaire();
		main3.saveToFile(svgTennisTournoisSchemas, "tennisTournoisSchemas.svg");
	}

	public List<Person> randomizeList(List<Person> ll) {
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
//		Person p = new Person("Peter");
//		personsCollection.add(p);
//		p = new Person("Sco");
//		personsCollection.add(p);
//		p = new Person("Karis");
//		personsCollection.add(p);
//		p = new Person("Number");
//		personsCollection.add(p);
		/**
		 * id jour vs no item ; streams OR map
		 * https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
		 * parallel
		 */
		// personsCollection = Arrays.asList(p1, p2);
//		Integer longueur = personsCollection.size();

		// entity number

		List randomizedList = this.randomizeList(personsCollectionGet());
		// for (int k = 0; k < randomizedList.size(); k++) {
		//
		// }
		System.out.println(this.toString(randomizedList));
		// this.svgCreate();
		this.svgSchema();
	}

	public List<Person> personsCollectionGet() {
		List<Pool> poolCollection = this.getPoolsCollection();
		List<Person> personCollection = new ArrayList<Person>();
		for (Pool p : poolCollection) {
			personCollection.addAll(p.getPersonsCollection());
		}
		return personCollection;
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

	/***/
	public void poolSystem() {

	}

	/***/
	public void treeSystem() {

	}

	/* paste poolSystem+treeSystem **/
	public void patchworking() {

	}

	/***/
	public void create() {

	}

	/***/
	public void add() {

	}

	/***/
	public void rotate90() {

	}

	/***/
	public Point absoluteTree2matrix(int eltInAbsolute) {

		return new Point(0, 0);
	}

	/***/
	public void matrixTree2absolute() {

	}

	/** takes a screenshot of the svg for Google Image indexation */
	public void jpgGenerate() {

	}

	/**
	 * X pos in its Pool depends of Person order in the list
	 */
	float getPersonRelativePoolX() {
		return ((ConfigurationBean) this.context.getBean("configurationBean")).getPersonRelativePoolX();
	}

	float getPersonRelativePoolY(Person person) {
		return this.getPersonOrder(person)
				* ((ConfigurationBean) this.context.getBean("configurationBean")).getInterPerson();
	}

	/** Person pos in its pool */
	int getPersonOrder(Person perss) {
		boolean trouve = false;
		int pool = 0;
		while ((!trouve) && (pool < this.poolsCollection.size())) {
			Pool poolObj = this.poolsCollection.get(pool);
			int perso = 0;
			while ((!trouve) && (perso < poolObj.getPersonsCollection().size())) {
				int pos = poolObj.getPersonsCollection().indexOf(perss);
				if (pos >= 0) {
					trouve = true;
					return pos;
				}
				perso++;
			}
			pool++;
		}
		return -1;/** never reached, just for syntax hightlight prevention */
	}

	int getPoolOrder(Pool pooll) {
		boolean trouve = false;
		int pool = 0;
		while ((!trouve) && (pool < this.poolsCollection.size())) {
			// Pool poolObj = this.poolsCollection.get(pool);
			int pos = this.getPoolsCollection().indexOf(pooll);
			if (pos >= 0) {
				trouve = true;
				return pos;
			}

			pool++;
		}
		return -1;/** never reached, just for syntax hightlight prevention */
	}

	float getPoolAbsX() {
		return ((ConfigurationBean) this.context.getBean("configurationBean")).getPoolX();
	}

	float getPoolAbsY(Pool pool) {
		return ((ConfigurationBean) this.context.getBean("configurationBean")).getPoolX();

	}
}
