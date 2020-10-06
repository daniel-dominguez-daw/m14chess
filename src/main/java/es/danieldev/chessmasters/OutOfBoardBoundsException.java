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
public class OutOfBoardBoundsException extends RuntimeException {
	public OutOfBoardBoundsException(String errorMessage, Throwable ex){
		super(errorMessage, ex);
	}
}
