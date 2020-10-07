/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters;

import es.danieldev.chessmasters.pieces.Bishop;
import es.danieldev.chessmasters.pieces.King;
import es.danieldev.chessmasters.pieces.Knight;
import es.danieldev.chessmasters.pieces.Pawn;
import es.danieldev.chessmasters.pieces.Piece;
import es.danieldev.chessmasters.pieces.Queen;
import es.danieldev.chessmasters.pieces.Rook;
import java.util.List;

/**
 *
 * @author zebnat
 */
public class Board {
	private final Piece[][] pieces = new Piece[8][8];

	public Board() {
		createBoard();
	}

	private void createBoard() {
		//setupKnightTestingField();
		setupKingTestingField();
	}

	private void createBlackPawns() {
		// create black pawns
		for(int i = 0; i < 8; i++) {
			putPiece(new Pawn(Piece.Color.BLACK), new BoardSlot(1, i));
		}
	}

	private void createWhitePawns() {
		// create white pawns
		for(int i = 0; i < 8; i++) {
			putPiece(new Pawn(Piece.Color.WHITE), new BoardSlot(6, i));
		}
	}

	private void putPiece(Piece p, BoardSlot slot) {
		pieces[slot.getRow()][slot.getCol()] = p;
		p.setSlot(slot);
	}

	public List<BoardSlot> calculateAvailableMovements(BoardSlot from) {
		Piece pieceToMove = pieces[from.getRow()][from.getCol()];
		if(null == pieceToMove)
			return null;
		
		return pieceToMove.possibleMoves(this);
	}

	public Piece getPiece(BoardSlot slot) {
		return pieces[slot.getRow()][slot.getCol()];
	}

	public boolean isOutOfBounds(BoardSlot slot) {
		int x = slot.getRow();
		int y = slot.getCol();
		if (x < 0 || x > 7)
			return true;
		if (y < 0 || y > 7)
			return true;

		return false;
	}

	private void setupStartField() {
		// create black mix pieces
		putPiece(new Rook(Piece.Color.BLACK), new BoardSlot(0, 0));
		putPiece(new Knight(Piece.Color.BLACK), new BoardSlot(0, 1));
		putPiece(new Bishop(Piece.Color.BLACK), new BoardSlot(0, 2));
		putPiece(new King(Piece.Color.BLACK), new BoardSlot(0, 3));
		putPiece(new Queen(Piece.Color.BLACK), new BoardSlot(0, 4));
		putPiece(new Bishop(Piece.Color.BLACK), new BoardSlot(0, 5));
		putPiece(new Knight(Piece.Color.BLACK), new BoardSlot(0, 6));
		putPiece(new Rook(Piece.Color.BLACK), new BoardSlot(0, 7));

		createBlackPawns();

		createWhitePawns();

		// create white mix pieces
		putPiece(new Rook(Piece.Color.WHITE), new BoardSlot(7, 0));
		putPiece(new Knight(Piece.Color.WHITE), new BoardSlot(7, 1));
		putPiece(new Bishop(Piece.Color.WHITE), new BoardSlot(7, 2));
		putPiece(new King(Piece.Color.WHITE), new BoardSlot(7, 3));
		putPiece(new Queen(Piece.Color.WHITE), new BoardSlot(7, 4));
		putPiece(new Bishop(Piece.Color.WHITE), new BoardSlot(7, 5));
		putPiece(new Knight(Piece.Color.WHITE), new BoardSlot(7, 6));
		putPiece(new Rook(Piece.Color.WHITE), new BoardSlot(7, 7));

	}

	private void setupPawnTestingField(){
		// create black mix pieces
		putPiece(new Rook(Piece.Color.BLACK), new BoardSlot(0, 0));
		putPiece(new Knight(Piece.Color.BLACK), new BoardSlot(0, 1));
		putPiece(new Bishop(Piece.Color.BLACK), new BoardSlot(0, 2));
		putPiece(new King(Piece.Color.BLACK), new BoardSlot(0, 3));
		putPiece(new Queen(Piece.Color.BLACK), new BoardSlot(0, 4));
		putPiece(new Bishop(Piece.Color.BLACK), new BoardSlot(0, 5));
		putPiece(new Knight(Piece.Color.BLACK), new BoardSlot(0, 6));
		putPiece(new Rook(Piece.Color.BLACK), new BoardSlot(0, 7));

		createBlackPawns();

		// testing purposes block
		putPiece(new Pawn(Piece.Color.BLACK), new BoardSlot(2, 3));
		putPiece(new Pawn(Piece.Color.BLACK), new BoardSlot(3, 3));
		putPiece(new Pawn(Piece.Color.BLACK), new BoardSlot(5, 4));
		putPiece(new Pawn(Piece.Color.BLACK), new BoardSlot(5, 4));
		putPiece(new Pawn(Piece.Color.BLACK), new BoardSlot(5, 7));
		putPiece(new Pawn(Piece.Color.WHITE), new BoardSlot(2, 1));
		// end testing

		createWhitePawns();

		// create white mix pieces
		putPiece(new Rook(Piece.Color.WHITE), new BoardSlot(7, 0));
		putPiece(new Knight(Piece.Color.WHITE), new BoardSlot(7, 1));
		putPiece(new Bishop(Piece.Color.WHITE), new BoardSlot(7, 2));
		putPiece(new King(Piece.Color.WHITE), new BoardSlot(7, 3));
		putPiece(new Queen(Piece.Color.WHITE), new BoardSlot(7, 4));
		putPiece(new Bishop(Piece.Color.WHITE), new BoardSlot(7, 5));
		putPiece(new Knight(Piece.Color.WHITE), new BoardSlot(7, 6));
		putPiece(new Rook(Piece.Color.WHITE), new BoardSlot(7, 7));
	}

	private void setupKnightTestingField() {
		// create black mix pieces
		putPiece(new Rook(Piece.Color.BLACK), new BoardSlot(0, 0));
		putPiece(new Knight(Piece.Color.BLACK), new BoardSlot(2, 2));
		putPiece(new Bishop(Piece.Color.BLACK), new BoardSlot(0, 2));
		putPiece(new King(Piece.Color.BLACK), new BoardSlot(0, 3));
		putPiece(new Queen(Piece.Color.BLACK), new BoardSlot(0, 4));
		putPiece(new Bishop(Piece.Color.BLACK), new BoardSlot(0, 5));
		putPiece(new Knight(Piece.Color.BLACK), new BoardSlot(4, 4));
		putPiece(new Rook(Piece.Color.BLACK), new BoardSlot(0, 7));

		createBlackPawns();

		createWhitePawns();

		// create white mix pieces
		putPiece(new Rook(Piece.Color.WHITE), new BoardSlot(7, 0));
		putPiece(new Knight(Piece.Color.WHITE), new BoardSlot(3, 3));
		putPiece(new Bishop(Piece.Color.WHITE), new BoardSlot(7, 2));
		putPiece(new King(Piece.Color.WHITE), new BoardSlot(7, 3));
		putPiece(new Queen(Piece.Color.WHITE), new BoardSlot(7, 4));
		putPiece(new Bishop(Piece.Color.WHITE), new BoardSlot(7, 5));
		putPiece(new Knight(Piece.Color.WHITE), new BoardSlot(7, 6));
		putPiece(new Rook(Piece.Color.WHITE), new BoardSlot(7, 7));
	}

	private void setupKingTestingField() {
		// create black mix pieces
		putPiece(new Rook(Piece.Color.BLACK), new BoardSlot(0, 0));
		putPiece(new Knight(Piece.Color.BLACK), new BoardSlot(0, 1));
		putPiece(new Bishop(Piece.Color.BLACK), new BoardSlot(0, 2));
		putPiece(new King(Piece.Color.BLACK), new BoardSlot(5, 5));
		putPiece(new Queen(Piece.Color.BLACK), new BoardSlot(0, 4));
		putPiece(new Bishop(Piece.Color.BLACK), new BoardSlot(0, 5));
		putPiece(new Knight(Piece.Color.BLACK), new BoardSlot(4, 4));
		putPiece(new Rook(Piece.Color.BLACK), new BoardSlot(0, 7));

		createBlackPawns();

		createWhitePawns();

		// create white mix pieces
		putPiece(new Rook(Piece.Color.WHITE), new BoardSlot(7, 0));
		putPiece(new Knight(Piece.Color.WHITE), new BoardSlot(7, 1));
		putPiece(new Bishop(Piece.Color.WHITE), new BoardSlot(7, 2));
		putPiece(new King(Piece.Color.WHITE), new BoardSlot(4, 5));
		putPiece(new Queen(Piece.Color.WHITE), new BoardSlot(7, 4));
		putPiece(new Bishop(Piece.Color.WHITE), new BoardSlot(7, 5));
		putPiece(new Knight(Piece.Color.WHITE), new BoardSlot(7, 6));
		putPiece(new Rook(Piece.Color.WHITE), new BoardSlot(7, 7));
	}
}
