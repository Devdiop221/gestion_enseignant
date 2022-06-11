package model.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Enseignant;
import model.EnseignantDAO;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/Traitement") 


/**
 * Servlet implementation class Traitement
 */
public class Traitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Traitement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Enseignant enseignant = new Enseignant();
		String nom, prenom, grade, id_user;
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		grade = request.getParameter("grade");
		id_user = request.getParameter("id_user");
		PrintWriter out=response.getWriter();
		
		enseignant.setNom(nom);
		enseignant.setPrenom(prenom);
		enseignant.setGrade(grade);
		enseignant.setId_user(id_user);
		int status=EnseignantDAO.save(enseignant);
		if(status>0){
		out.print("<p>Record saved successfully!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		}else{
		out.print("Sorry! unable to save record");
		}
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
