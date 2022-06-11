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

//@WebServlet("/Modification") 


/**
 * Servlet implementation class Modification
 */
public class Modification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Enseignant e = new Enseignant();
		String nom, prenom, grade, id_user;
		int id;
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		grade = request.getParameter("grade");
		id_user = request.getParameter("id_user");
		PrintWriter out=response.getWriter();
		
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setGrade(grade);
		e.setId_user(id_user);
		
		int status=EnseignantDAO.update(e);
		if(status>0){
		out.print("<p>Record saved successfully!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		}else{
		out.print("Sorry! unable to save record");
		}
		out.close();
	}

}
