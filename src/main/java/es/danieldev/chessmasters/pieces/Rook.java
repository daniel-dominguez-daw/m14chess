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
public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
		codeName = Piece.CodeName.ROOK;
	}

	@Override
	public List<BoardSlot> possibleMoves(Board b) {
		Color enemyColor = (color == Piece.Color.BLACK ? 
				Piece.Color.WHITE :
				Piece.Color.BLACK);
		List<BoardSlot> possibleMoves = new ArrayList<>();

		BoardSlot pieceSlot = getSlot();

		// left side
		Piece p;
		BoardSlot slot;
		int col = 0;
		while(true) {
			col--;
			slot = new BoardSlot(
					pieceSlot.getRow(), 
					pieceSlot.getCol() + col);

			if(b.isOutOfBounds(slot)) {
				break;
			}

			p = b.getPiece(slot);

			if (null == p || p.color.equals(enemyColor)) {
				possibleMoves.add(slot);
			} else {
				break;
			}
		}

		return possibleMoves;
	}
	
}
