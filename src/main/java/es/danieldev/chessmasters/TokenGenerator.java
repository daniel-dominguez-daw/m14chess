/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters;

import java.util.Random;

/**
 *
 * @author zebnat
 */
public class TokenGenerator {
	public static String generate(int characters) {
		char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'o',
		'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'O',
		'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
		};

		Random rand = new Random();
		int rng;

		String output = "";
		for (int i = 0; i < characters; i++) {
			rng = rand.nextInt(chars.length-1);
			output += chars[rng];
		}
		// todo change to stringBuffer

		return output;
	}
}
