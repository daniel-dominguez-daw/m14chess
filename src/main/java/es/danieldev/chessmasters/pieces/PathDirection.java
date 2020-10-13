/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters.pieces;

import es.danieldev.chessmasters.pieces.LinearPathCalculator.Direction;

/**
 *
 * @author zebnat
 */
public class PathDirection {
	private Direction rowDirection;
	private Direction colDirection;

	public PathDirection(Direction rowDir, Direction colDir) {
		rowDirection = rowDir;
		colDirection = colDir;
	}

	public Direction getRowDirection() {
		return rowDirection;
	}

	public Direction getColDirection() {
		return colDirection;
	}
}
