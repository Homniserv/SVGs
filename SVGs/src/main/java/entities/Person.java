package entities;

public class Person {
	Integer id;
	String pseudoTournoi;
	String pseudoOVS;
	String prenom;
	/** # code hexadecimal */
	String color;
	//float relativePoolX;/**above level*/
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPseudoTournoi() {
		return pseudoTournoi;
	}

	public void setPseudoTournoi(String pseudoTournoi) {
		this.pseudoTournoi = pseudoTournoi;
	}

	public String getPseudoOVS() {
		return pseudoOVS;
	}

	public void setPseudoOVS(String pseudoOVS) {
		this.pseudoOVS = pseudoOVS;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Person(String pseudoo) {
		this.pseudoTournoi = pseudoo;
		String pseudoTournoi;
	}

	public String toString() {
		return this.pseudoTournoi;
	}
}
