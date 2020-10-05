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
public final class Pawn extends Piece {

	public Pawn(Color color) {
		super(color);
		codeName = Piece.CodeName.PAWN;
	}

	@Override
	public List<BoardSlot> possibleMoves(Board b) {
		List<BoardSlot> l = new ArrayList<>();
		l.add(new BoardSlot(5, 6));
		l.add(new BoardSlot(6, 7));

		return l;
	}
}
