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
public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
		codeName = Piece.CodeName.KNIGHT;
	}

	@Override
	public List<BoardSlot> possibleMoves(Board b) {
		Color enemyColor = (color == Piece.Color.BLACK ? 
				Piece.Color.WHITE :
				Piece.Color.BLACK);
		
		List<BoardSlot> possibleSlots = new ArrayList<>();
		BoardSlot pieceSlot = getSlot();

		BoardSlot[] testSlots = {
			new BoardSlot(pieceSlot.getRow() + 1, pieceSlot.getCol() - 2),
			new BoardSlot(pieceSlot.getRow() - 1, pieceSlot.getCol() - 2),
			new BoardSlot(pieceSlot.getRow() - 2, pieceSlot.getCol() - 1),
			new BoardSlot(pieceSlot.getRow() - 2, pieceSlot.getCol() + 1),
			new BoardSlot(pieceSlot.getRow() - 1, pieceSlot.getCol() + 2),
			new BoardSlot(pieceSlot.getRow() + 1, pieceSlot.getCol() + 2),
			new BoardSlot(pieceSlot.getRow() + 2, pieceSlot.getCol() - 1),
			new BoardSlot(pieceSlot.getRow() + 2, pieceSlot.getCol() + 1),
		};

		for (BoardSlot sl : testSlots) {
			if(! b.isOutOfBounds(sl)) {
				Piece target = b.getPiece(sl);
				if (null == target || target.color == enemyColor) {
					possibleSlots.add(sl);
				}
			}
		}

		/*
		BoardSlot leftDown = new BoardSlot(pieceSlot.getRow() + 1,
							pieceSlot.getCol() - 2);

		if(! b.isOutOfBounds(leftDown)) {
			Piece target = b.getPiece(leftDown);
			if (null == target || target.color == enemyColor) {
				possibleSlots.add(leftDown);
			}
		}


		BoardSlot leftUp = new BoardSlot(pieceSlot.getRow() - 1,
							pieceSlot.getCol() - 2);

		if(! b.isOutOfBounds(leftUp)) {
			Piece target = b.getPiece(leftUp);
			if (null == target || target.color == enemyColor) {
				possibleSlots.add(leftUp);
			}
		}

		BoardSlot upLeft = new BoardSlot(pieceSlot.getRow() - 2,
							pieceSlot.getCol() - 1);

		if(! b.isOutOfBounds(upLeft)) {
			Piece target = b.getPiece(upLeft);
			if (null == target || target.color == enemyColor) {
				possibleSlots.add(upLeft);
			}
		}

		BoardSlot upRight = new BoardSlot(pieceSlot.getRow() - 2,
							pieceSlot.getCol() + 1);

		if(! b.isOutOfBounds(upRight)) {
			Piece target = b.getPiece(upRight);
			if (null == target || target.color == enemyColor) {
				possibleSlots.add(upRight);
			}
		}

		BoardSlot rightUp = new BoardSlot(pieceSlot.getRow() - 1,
							pieceSlot.getCol() + 2);

		if(! b.isOutOfBounds(rightUp)) {
			Piece target = b.getPiece(rightUp);
			if (null == target || target.color == enemyColor) {
				possibleSlots.add(rightUp);
			}
		}

		BoardSlot rightDown = new BoardSlot(pieceSlot.getRow() + 1,
							pieceSlot.getCol() + 2);

		if(! b.isOutOfBounds(rightDown)) {
			Piece target = b.getPiece(rightDown);
			if (null == target || target.color == enemyColor) {
				possibleSlots.add(rightDown);
			}
		}

		BoardSlot downLeft = new BoardSlot(pieceSlot.getRow() + 2,
							pieceSlot.getCol() - 1);

		if(! b.isOutOfBounds(downLeft)) {
			Piece target = b.getPiece(downLeft);
			if (null == target || target.color == enemyColor) {
				possibleSlots.add(downLeft);
			}
		}

		BoardSlot downRight = new BoardSlot(pieceSlot.getRow() + 2,
							pieceSlot.getCol() + 1);

		if(! b.isOutOfBounds(downRight)) {
			Piece target = b.getPiece(downRight);
			if (null == target || target.color == enemyColor) {
				possibleSlots.add(downRight);
			}
		}
*/

		return possibleSlots;
	}

	@Override
	public boolean canTransform() {
		return false;
	}
}
