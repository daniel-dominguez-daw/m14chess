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
public abstract class Piece implements Cloneable {

	public enum Color {
		WHITE,
		BLACK
	}

	public enum CodeName {
		PAWN,
		ROOK,
		KNIGHT,
		BISHOP,
		KING,
		QUEEN
	}

	protected Color color;
	protected CodeName codeName;
	private BoardSlot slot;

	public Piece(Color color) {
		this.color = color;
	}

	public abstract List<BoardSlot> possibleMoves(Board b);

	public BoardSlot getSlot() {
		return slot;
	}

	public void setSlot(BoardSlot s) {
		this.slot = s;
	}

	public Color calcEnemyColor() {
		Color enemyColor = (color == Piece.Color.BLACK ? 
				Piece.Color.WHITE :
				Piece.Color.BLACK);
		return enemyColor;
	}

	public abstract boolean canTransform();

	public Object clone() throws CloneNotSupportedException {
		return (Piece) super.clone();
	}
}
