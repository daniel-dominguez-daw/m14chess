/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters;

import es.danieldev.chessmasters.pieces.Piece;

/**
 *
 * @author zebnat
 */
public class Match {
	private static enum State {
		WAITINGFORPLAYERS,
		ONGOING,
		FINISHED
	}

	private String name;
	private Player blackPlayer;
	private Player whitePlayer;
	private State status;
	private Player turn;
	private Board board;

	public Match() {
		// generate a name automagically
		name = TokenGenerator.generate(10);
		status = State.WAITINGFORPLAYERS;
	}

	public void changeTurn() {
		if(status == State.ONGOING && turn != null) {
			turn = (turn.equals(blackPlayer) ? whitePlayer : blackPlayer);
		}
	}

	public void setWhitePlayer(Player p) {
		if(status == State.WAITINGFORPLAYERS) {
			p.setPlayingAs(Piece.Color.WHITE);
			whitePlayer = p;
			shouldInitializeMatch();
		}
	}

	public void setBlackPlayer(Player p) {
		if(status == State.WAITINGFORPLAYERS) {
			p.setPlayingAs(Piece.Color.BLACK);
			blackPlayer = p;
			shouldInitializeMatch();
		}
	}

	private void shouldInitializeMatch() {
		if (whitePlayer != null && blackPlayer != null) {
			turn = whitePlayer;
			status = State.ONGOING;
		}
	}

	public void finishMatch() {
		if(status == State.ONGOING) {
			status = State.FINISHED;
		}
	}
}