/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters.pieces;

import es.danieldev.chessmasters.Board;
import es.danieldev.chessmasters.BoardSlot;
import es.danieldev.chessmasters.pieces.LinearPathCalculator.Direction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zebnat
 */
public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
		codeName = Piece.CodeName.QUEEN;
	}

	@Override
	public List<BoardSlot> possibleMoves(Board b) {
		Color enemyColor = calcEnemyColor();
		List<BoardSlot> possibleMoves = new ArrayList<>();

		LinearPathCalculator calculator = new LinearPathCalculator(
				b, getSlot(), enemyColor);

		PathDirection[] directions = {
			new PathDirection(Direction.STATIC, Direction.DESCENDING),
			new PathDirection(Direction.STATIC, Direction.ASCENDING),
			new PathDirection(Direction.DESCENDING, Direction.STATIC),
			new PathDirection(Direction.ASCENDING, Direction.STATIC),
			new PathDirection(Direction.ASCENDING, Direction.ASCENDING),
			new PathDirection(Direction.DESCENDING, Direction.DESCENDING),
			new PathDirection(Direction.DESCENDING, Direction.ASCENDING),
			new PathDirection(Direction.ASCENDING, Direction.DESCENDING),
		};

		List<BoardSlot> slotDirections;
		for (PathDirection path : directions) {
			slotDirections = calculator.calculatePathLine(
					path.getRowDirection(), path.getColDirection()
			);
			possibleMoves.addAll(slotDirections);
		}

		return possibleMoves;
	}

	@Override
	public boolean canTransform() {
		return false;
	}
	
}
