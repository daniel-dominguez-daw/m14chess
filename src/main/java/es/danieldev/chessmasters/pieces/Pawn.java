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
		Color enemyColor = (color == Piece.Color.BLACK ? 
				Piece.Color.WHITE :
				Piece.Color.BLACK);

		BoardSlot pieceSlot = getSlot();

		List<BoardSlot> l = new ArrayList<>();


		// move forward slot position
		BoardSlot forwardSlot = new BoardSlot(
				pieceSlot.getRow() + forward, 
				pieceSlot.getCol());

		if(! b.isOutOfBounds(forwardSlot) && b.getPiece(forwardSlot) == null) {
			l.add(forwardSlot);

			// Can move 2 cells when starting
			if((color == Piece.Color.BLACK && pieceSlot.getRow() == 1) || 
					color == Piece.Color.WHITE && pieceSlot.getRow() == 6) {

				BoardSlot startingMovingTwo = new BoardSlot(
				pieceSlot.getRow() + forward*2, 
				pieceSlot.getCol());


				if(b.getPiece(startingMovingTwo) == null)
					l.add(startingMovingTwo);
				
			}
		}

		// move diagonal if enemy piece there
		Piece pieceDiagonalOne;
		Piece pieceDiagonalTwo;
		BoardSlot diagonalOne = new BoardSlot(
				pieceSlot.getRow() + forward,
				pieceSlot.getCol() - 1);

		BoardSlot diagonalTwo = new BoardSlot(
				pieceSlot.getRow() + forward,
				pieceSlot.getCol() + 1);

		if(! b.isOutOfBounds(diagonalOne)) {
			pieceDiagonalOne = b.getPiece(diagonalOne);
			if (pieceDiagonalOne != null) {
				if (pieceDiagonalOne.color.equals(enemyColor)) {
					// There is an enemy in this diagonal
					l.add(diagonalOne);
				}
			}
		}

		if(! b.isOutOfBounds(diagonalTwo)) {
			pieceDiagonalTwo = b.getPiece(diagonalTwo);
			if (pieceDiagonalTwo != null) {
				if (pieceDiagonalTwo.color.equals(enemyColor)) {
					// There is an enemy in this diagonal
					l.add(diagonalTwo);
				}
			}
		}

		return l;
	}
}
