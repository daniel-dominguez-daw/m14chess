/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters;

import es.danieldev.chessmasters.pieces.Piece.Color;

/**
 *
 * @author zebnat
 */
public class Player {
	private String tokenId;
	private String name;
	private Color playingAs;

	public Player(String name){
		tokenId = TokenGenerator.generate(40);
		this.name = name;
	}

	public void setPlayingAs(Color playingAs) {
		this.playingAs = playingAs;
	}
	
}
