/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters;

import es.danieldev.chessmasters.pieces.Pawn;
import es.danieldev.chessmasters.pieces.Piece;

/**
 *
 * @author zebnat
 */
public class Board {
	Piece[][] pieces = new Piece[8][8];

	public Board() {
		createBoard();
	}

	private void createBoard() {
		// @todo create black mix pieces

		// create black pawns
		for(int i = 0; i < 8; i++) {
			putPiece(new Pawn(Piece.Color.BLACK), new BoardSlot(1, i));
		}

		// create white pawns
		for(int i = 0; i < 8; i++) {
			putPiece(new Pawn(Piece.Color.WHITE), new BoardSlot(6, i));
		}

		// @todo create white mix pieces
	}

	private void putPiece(Piece p, BoardSlot slot) {
		pieces[slot.getRow()][slot.getCol()] = p;
		p.setSlot(slot);
	}
}
