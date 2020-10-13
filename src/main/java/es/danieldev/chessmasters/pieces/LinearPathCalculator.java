/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters.pieces;

import es.danieldev.chessmasters.Board;
import es.danieldev.chessmasters.BoardSlot;
import es.danieldev.chessmasters.pieces.Piece.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zebnat
 */
public class LinearPathCalculator {
	private Board board;
	private BoardSlot currentSlot;
	private Color enemyColor;

	public enum Direction {
		ASCENDING,
		DESCENDING,
		STATIC
	}

	public LinearPathCalculator(Board b, BoardSlot currentSlot, Color enemyColor) {
		this.board = b;
		this.currentSlot = currentSlot;
		this.enemyColor = enemyColor;
	}

	public List<BoardSlot> calculatePathLine(Direction rowDirection, Direction colDirection){
		List<BoardSlot> slots = new ArrayList<>();

		Piece p;
		BoardSlot slot;
		int row = 0;
		int col = 0;
		while(true) {
			if(rowDirection == Direction.ASCENDING) {
				row++;
			}

			if(rowDirection == Direction.DESCENDING) {
				row--;
			}

			if(colDirection == Direction.ASCENDING) {
				col++;
			}

			if(colDirection == Direction.DESCENDING) {
				col--;
			}
			

			slot = new BoardSlot(
					currentSlot.getRow() + row, 
					currentSlot.getCol() + col);

			if(board.isOutOfBounds(slot)) {
				break;
			}

			p = board.getPiece(slot);

			if (null == p) {
				slots.add(slot);
			} else if(p.color.equals(enemyColor)) {
				slots.add(slot);
				break;
			} else {
				break;
			}
		}

		return slots;
	}
}
