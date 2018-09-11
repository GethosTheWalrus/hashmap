package com.toscano.main;

import com.toscano.HashMap.HashMap;

public class Main {
	
	public static void main(String[] args) {
		
		HashMap<Integer,Hero> h = new HashMap<Integer,Hero>();
		
		h.Put( 0, new Hero("Grommash Hellscream", "Orc", "Blademaster") );
		h.Put( 1, new Hero("Thrall son of Durotan", "Orc", "Farseer") );
		h.Put( 2, new Hero("Jaina Proudmoore", "Human", "Frost Mage") );
		h.Put( 3, new Hero("Arthas Menethil", "Undead", "Deathknight") );
		h.Put( 4, new Hero("Ner'Zhul", "Orc", "Lich King") );
		h.Put( 5, new Hero("Thalyssra", "Nightborne", "Arcanist") );
		h.Put( 6, new Hero("Sylvanas Windrunner", "Undead", "Dark Archer") );
		h.Put( 7, new Hero("Illadin Stormrage", "Night Elf", "Demon Hunter") );
		h.Put( 8, new Hero("Kael'thas Sunstrider", "Blood Elf", "Blood Mage") );
		h.Put( 9, new Hero("Aggramar", "Celestial", "Titan") );
								
		for( int i = 0; i < h.size; i++ ) {
			
			h.Get(i).Describe();
			
		}
		
	}

}
