/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters.pieces;

import es.danieldev.chessmasters.Board;
import es.danieldev.chessmasters.BoardSlot;
import es.danieldev.chessmasters.OutOfBoardBoundsException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zebnat
 */
public final class Pawn extends Piece {

	public Pawn(Color color) {
		super(color);
		codeName = Piece.CodeName.PAWN;
	}

	@Override
	public List<BoardSlot> possibleMoves(Board b) {
		int forward = (color == Piece.Color.BLACK ? 1 : -1);
		BoardSlot pieceSlot = getSlot();

		List<BoardSlot> l = new ArrayList<>();

		// Can move 2 cells when starting
		if((color == Piece.Color.BLACK && pieceSlot.getRow() == 1) || 
				color == Piece.Color.WHITE && pieceSlot.getRow() == 6) {

			BoardSlot startingMovingTwo = new BoardSlot(
			pieceSlot.getRow() + forward*2, 
			pieceSlot.getCol());

			l.add(startingMovingTwo);
			
			// @todo check if there is a piece or not in that slot
		}

		// move forward slot position
		try {
			BoardSlot forwardSlot = new BoardSlot(
					pieceSlot.getRow() + forward, 
					pieceSlot.getCol());
			l.add(forwardSlot);
		} catch(OutOfBoardBoundsException e) {
		}

		// move diagonal if enemy piece there
		/*
		Piece pieceDiagonalOne;
		Piece pieceDiagonalTwo;
		try {
			BoardSlot diagonalOne = new BoardSlot(
					pieceSlot.getRow() + forward,
					pieceSlot.getCol() - 1);

			Piece p = b.getPiece(diagonalOne);
		} catch(OutOfBoardBoundsException e) {

		}

		BoardSlot diagonalTwo = new BoardSlot(
				pieceSlot.getRow() + forward,
				pieceSlot.getCol() + 1);

		*/

		return l;
	}
}
