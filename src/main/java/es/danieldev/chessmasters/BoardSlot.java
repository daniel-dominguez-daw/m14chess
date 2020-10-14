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
public final class BoardSlot {
	private final int row;
	private final int col;
	
	public BoardSlot(int row, int col) /*throws OutOfBoardBoundsException*/ {
		/*
		safeCoordinate(row);
		safeCoordinate(col);
		*/
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	private void safeCoordinate(int coordinate) throws OutOfBoardBoundsException {
		if(coordinate < 0 || coordinate > 7) {
			throw new OutOfBoardBoundsException(
					"Coordinates out of bounds.", 
					new Exception());
		}
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

	public String toString() {
		return String.format("BoardSlot[row: %d, col: %d]", row, col);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof BoardSlot))
			return false;

		BoardSlot other = (BoardSlot)o;

		return (row == other.row && col == other.col);
	}
}
