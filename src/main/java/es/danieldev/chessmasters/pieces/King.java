/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters.pieces;

import es.danieldev.chessmasters.Board;
import es.danieldev.chessmasters.BoardSlot;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zebnat
 */
public class King extends Piece {

	public King(Color color) {
		super(color);
		codeName = Piece.CodeName.KING;
	}

	@Override
	public List<BoardSlot> possibleMoves(Board b) {
		Color enemyColor = (color == Piece.Color.BLACK ? 
				Piece.Color.WHITE :
				Piece.Color.BLACK);
		
		List<BoardSlot> possibleSlots = new ArrayList<>();
		BoardSlot pieceSlot = getSlot();

		/**
		 * Slots we are going to test if you can move there fit in an array
		 * [7][0][1]
		 * [6][K][2]
		 * [5][4][3]
		 */
		BoardSlot[] testSlots = new BoardSlot[]{
				new BoardSlot(pieceSlot.getRow()-1, pieceSlot.getCol()),
				new BoardSlot(pieceSlot.getRow()-1, pieceSlot.getCol()+1),
				new BoardSlot(pieceSlot.getRow(), pieceSlot.getCol()+1),
				new BoardSlot(pieceSlot.getRow()+1, pieceSlot.getCol()+1),
				new BoardSlot(pieceSlot.getRow()+1, pieceSlot.getCol()),
				new BoardSlot(pieceSlot.getRow()+1, pieceSlot.getCol()-1),
				new BoardSlot(pieceSlot.getRow(), pieceSlot.getCol()-1),
				new BoardSlot(pieceSlot.getRow()-1, pieceSlot.getCol()-1)
		};

		Piece p;
		for (BoardSlot testSlot : testSlots) {
			if (! b.isOutOfBounds(testSlot)) {
				p = b.getPiece(testSlot);
				if (null == p || enemyColor == p.color) {
					possibleSlots.add(testSlot);
				}
			}
		}

		return possibleSlots;
	}

	@Override
	public boolean canTransform() {
		return false;
	}
	
}
