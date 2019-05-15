package entities;

import presentation.MatchSide;

public class Match {
	Person p1, p2;
	Integer p1score, p2score;
	MatchSide matchSide;
	/** # code hexadecimal */
	String color;
	
//	public Match(int i, int j) {
//		// TODO Auto-generated constructor stub
//	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * TODO cut presentation MatchSide from service Here they are mixed....bad
	 **/
	public Match(Person p1, Person p2, int p1scoree, int p2scoree, MatchSide draw) {
		this.p1 = p1;
		this.p2 = p2;
		this.p1score = p1scoree;
		this.p2score = p2scoree;
		this.matchSide = draw;
	}

	public Person getP1() {
		return p1;
	}

	public void setP1(Person p1) {
		this.p1 = p1;
	}

	public Person getP2() {
		return p2;
	}

	public void setP2(Person p2) {
		this.p2 = p2;
	}

	public Integer getP1score() {
		return p1score;
	}

	public void setP1score(Integer p1score) {
		this.p1score = p1score;
	}

	public Integer getP2score() {
		return p2score;
	}

	public void setP2score(Integer p2score) {
		this.p2score = p2score;
	}

	public MatchSide getMatchSide() {
		return matchSide;
	}

	public void setMatchSide(MatchSide matchSide) {
		this.matchSide = matchSide;
	}

//	public void Match(Integer p1scoree, Integer p2scoree) {
//		this.p1score = p1scoree;
//		this.p2score = p2scoree;
//	}

}
