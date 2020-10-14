/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.danieldev.chessmasters.servlets;

import com.google.gson.Gson;
import es.danieldev.chessmasters.Board;
import es.danieldev.chessmasters.BoardSlot;
import es.danieldev.chessmasters.pieces.Piece;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zebnat
 */
public class MoveTo extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		
		ServletContext context = getServletContext();
		Object o = context.getAttribute("gameboard");
		if(o == null) {
			o = new Board();
			context.setAttribute("gameboard", o);
		}
		
		Board b = (Board) o;

		int rowFrom = (int) Integer.parseInt(request.getParameter("rowFrom"));
		int colFrom = (int) Integer.parseInt(request.getParameter("colFrom"));
		int rowTo = (int) Integer.parseInt(request.getParameter("rowTo"));
		int colTo = (int) Integer.parseInt(request.getParameter("colTo"));
		BoardSlot slotFrom = new BoardSlot(rowFrom, colFrom);
		Piece pieceToMove = b.getPiece(slotFrom);
		BoardSlot slotTo = new BoardSlot(rowTo, colTo);

		if (b.isOutOfBounds(slotTo)) {
			response.setStatus(406);// 406 Not Acceptable
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			HashMap<String, String> map = new HashMap<>();
			map.put("code", "406");
			map.put("error", "You can't move to that position");
			String json = new Gson().toJson(map);

			try (PrintWriter out = response.getWriter()) {
				out.print(json);
				out.flush();
			}
			return;
		}

		// @todo handle out of bounds error (trying to get a piece out of board)
		if (null == pieceToMove) {
			// @todo refactor this into ApiError class
			response.setStatus(406);// 406 Not Acceptable
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			HashMap<String, String> map = new HashMap<>();
			map.put("code", "406");
			map.put("error", "Piece not found in that slot");
			String json = new Gson().toJson(map);

			try (PrintWriter out = response.getWriter()) {
				out.print(json);
				out.flush();
			}
			return;
		}

		final List<BoardSlot> slots = pieceToMove.possibleMoves(b);
		// check if our move is valid
		if(! slots.contains(slotTo)){
			// error invalid move there
			// @todo refactor this into ApiError class
			response.setStatus(406);// 406 Not Acceptable
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			HashMap<String, String> map = new HashMap<>();
			map.put("code", "406");
			map.put("error", "You can't move there! Frontend hijacked?");
			map.put("data", "slotFrom: " + slotFrom + "slotTo: " + slotTo + " slots: " + slots);

			String json = new Gson().toJson(map);

			try (PrintWriter out = response.getWriter()) {
				out.print(json);
				out.flush();
			}
			return;
		}

		// put piece in the proper slot
		b.movePiece(pieceToMove, slotFrom, slotTo);
		
		// return board state
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String json = new Gson().toJson(b);

		try (PrintWriter out = response.getWriter()) {
			out.print(json);
			out.flush();
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
