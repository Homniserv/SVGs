package entities;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Pool {

	Point refNordOuest;

	List<Person> personsCollection = new ArrayList<Person>();

	/** rencontres de Droites */
	List<Match> matchCollection = new ArrayList<Match>();

	public List<Match> getMatchCollection() {
		return matchCollection;
	}

	public void setMatchCollection(List<Match> matchCollection) {
		this.matchCollection = matchCollection;
	}

	public List<Person> getPersonsCollection() {
		return personsCollection;
	}

	public void setPersonsCollection(List<Person> personsCollection) {
		this.personsCollection = personsCollection;
	}

	public Point getRefNordOuest() {
		return refNordOuest;
	}

	public void setRefNordOuest(Point refNordOuest) {
		this.refNordOuest = refNordOuest;
	}

	/**pos in the pool*/
	int personneGetPos(String persPseudo) {
		int personn = 0;
		boolean trouve = false;
		while ((!trouve) && (personn < this.getPersonsCollection().size())) {
			if (this.getPersonsCollection().get(personn).getPseudoTournoi().equals(persPseudo)) {
				trouve = true;
			}

			personn++;
		}
		personn--;
		return personn;
	}
	
	/**ref G de la Person
	 * properties file vs Spring configuration bean*/
	Point personneGetRefOuest(String persPseudo) {
		
	}
	
}
