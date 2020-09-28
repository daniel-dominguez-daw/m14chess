/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author zebnat
 */
public class ChessCoordinates {
	private String row;
	private String col;

	public ChessCoordinates(String row, String column) throws IllegalArgumentException {
		if(!allowedColumnLetter(column) || !allowedRowNumber(row)) {
			throw new IllegalArgumentException("Cannot create coordinates with row <" + row + "> col <"+ column + ">");

		}
	}

	private boolean allowedColumnLetter(String columnLetter) {
		Pattern pat = Pattern.compile("[A-Ha-h]");
		Matcher mat = pat.matcher(columnLetter);
		boolean found = mat.matches();

		return found;
	}

	private boolean allowedRowNumber(String rowNumber) {
		Pattern pat = Pattern.compile("[1-8]");
		Matcher mat = pat.matcher(rowNumber);
		boolean found = mat.matches();
		return found;
	}

	public BoardSlot toBoardSlot() {
		int row = 8 - Integer.parseInt(this.row);
		HashMap<String, Integer> colMap = new HashMap<String, Integer>();
		colMap.put("A", 0);
		colMap.put("B", 1);
		colMap.put("C", 2);
		colMap.put("D", 3);
		colMap.put("E", 4);
		colMap.put("F", 5);
		colMap.put("G", 6);
		colMap.put("H", 7);

		int col = colMap.get(this.col);
		return new BoardSlot(row, col);
	}
}
