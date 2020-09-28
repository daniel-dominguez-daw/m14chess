/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters.pieces;

import es.danieldev.chessmasters.Board;
import es.danieldev.chessmasters.BoardSlot;
import java.util.List;

/**
 *
 * @author zebnat
 */
public abstract class Piece {
	private BoardSlot slot;

	public abstract List<BoardSlot> possibleMoves(Board b);

	public abstract String toCodeName();

	public void setSlot(BoardSlot s) {
		this.slot = s;
	}
}
