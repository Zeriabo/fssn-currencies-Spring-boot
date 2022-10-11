package com.fssn.models;

import java.util.HashMap;

public class PersonalIdentityCode {

	public static Character getCharacter(int number) {
		HashMap<Integer, Character> hmap = new HashMap<Integer, Character>();
		hmap.put(0, '0');
		hmap.put(1, '1');
		hmap.put(2, '2');
		hmap.put(3, '3');
		hmap.put(4, '4');
		hmap.put(5, '5');
		hmap.put(6, '6');
		hmap.put(7, '7');
		hmap.put(8, '8');
		hmap.put(9, '9');
		hmap.put(10, 'A');
		hmap.put(11, 'B');
		hmap.put(12, 'C');
		hmap.put(13, 'D');
		hmap.put(14, 'E');
		hmap.put(15, 'F');
		hmap.put(16, 'H');
		hmap.put(17, 'J');
		hmap.put(18, 'K');
		hmap.put(19, 'L');
		hmap.put(20, 'M');
		hmap.put(21, 'N');
		hmap.put(22, 'P');
		hmap.put(23, 'R');
		hmap.put(24, 'S');
		hmap.put(25, 'T');
		hmap.put(26, 'U');
		hmap.put(27, 'V');
		hmap.put(28, 'W');
		hmap.put(29, 'X');
		hmap.put(30, 'Y');

		return hmap.get(number);

	}

}