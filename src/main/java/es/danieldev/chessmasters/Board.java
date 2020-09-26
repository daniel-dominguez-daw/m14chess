/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters;

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
		for(int i = 0; i < pieces.length; i++) {
			for(int j = 0; j < pieces[i].length; j++){
				pieces[i][j] = new Piece("rook");
			}
		}

	}
}
