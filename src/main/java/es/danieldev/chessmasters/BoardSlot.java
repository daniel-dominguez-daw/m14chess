/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters;

/**
 *
 * @author zebnat
 */
public class BoardSlot {
	private int row;
	private int col;
	
	public BoardSlot(int row, int col) {
		this.row = safeCoordinate(row);
		this.col = safeCoordinate(col);
	}

	private int safeCoordinate(int coordinate) {
		if (coordinate < 0) {
			return 0;
		} else if(coordinate > 7) {
			return 7;
		}

		return coordinate;
	}

	public ChessCoordinates toChessCoordinates() {
		String rowNumber = Integer.toString(8 - this.row);

		char[] letters = new char[]{
			'a',
			'b',
			'c',
			'd',
			'e',
			'f',
			'g',
			'h'
		};

		String colLetter = Character.toString(letters[this.col]).toUpperCase();
		return new ChessCoordinates(rowNumber, colLetter);
	}
}
