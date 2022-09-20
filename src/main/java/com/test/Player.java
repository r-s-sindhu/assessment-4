package com.test;

public class Player {
	private int id;
    private String name;
    private int match;
    private int score;
    private int wicket;
    private int zero_out;
    private String player_type;
    private double avg;
    
	public Player(int id, String name, int match, int score, int wicket, int zero_out, String player_type,double avg) {
		this.id=id;
		this.name=name;
		this.match=match;
		this.score=score;
		this.wicket=wicket;
		this.zero_out=zero_out;
		this.player_type=player_type;
		this.avg=avg;
	}
	public Player()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMatch() {
		return match;
	}
	public void setMatch(int match) {
		this.match = match;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getWicket() {
		return wicket;
	}
	public void setWicket(int wicket) {
		this.wicket = wicket;
	}
	public int getZero_out() {
		return zero_out;
	}
	public void setZero_out(int zero_out) {
		this.zero_out = zero_out;
	}
	public String getPlayer_type() {
		return player_type;
	}
	public void setPlayer_type(String player_type) {
		this.player_type = player_type;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}
