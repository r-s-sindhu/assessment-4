package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();            
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid); 
        String pname=request.getParameter("name");
		String matches=request.getParameter("match");
		int match=Integer.parseInt(matches);
		String pscore=request.getParameter("score");
		int score=Integer.parseInt(pscore);
		String wickets=request.getParameter("wicket");
		int wicket=Integer.parseInt(wickets);
		String zero_out=request.getParameter("zero");
		int zero=Integer.parseInt(zero_out);
		String player_type=request.getParameter("player type");
		
		Player p1=new Player();
		p1.setId(id);
		p1.setName(pname);
		p1.setMatch(match);
		p1.setScore(score);
		p1.setWicket(wicket);
		p1.setZero_out(zero);
		p1.setPlayer_type(player_type);
	  
        int status=PlayerDao.update(p1);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }           
        out.close(); 
	}
}