package com.toscano.main;

import java.util.Random;

public class Hero {
	
	public String name, race, profession;
	
	public Hero(String name, String race, String profession) {
		
		this.name = name;
		this.race = race;
		this.profession = profession;
		
	}
	
	public void Describe() {
		
		Random r = new Random();
		
		String[] adjectives = {"Proud", "Honorable", "Savage", "Corrupt", "Fallen", "Attuned"};
		String adjective = adjectives[ r.nextInt(adjectives.length) ];
		
		System.out.println(this.name + ", the " + adjective + " " + this.race + " " + this.profession);
		
	}

}
