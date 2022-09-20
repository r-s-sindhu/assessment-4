package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); 
		
        PrintWriter out=response.getWriter();  
        
        out.println("<center><h1>Update Player</h1></center>"); 
        
        String sid=request.getParameter("id");         
        int id=Integer.parseInt(sid);            
        Player p=PlayerDao.getPlayerById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<center>");
        out.print("<table style='font-size:20px'>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+p.getId()+"' style='font-size:20px'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+p.getName()+"' style='font-size:20px'/></td></tr>");  
        out.print("<tr><td>Matches:</td><td><input type='number' name='match' value='"+p.getMatch()+"' style='font-size:20px'/></td></tr>");  
        out.print("<tr><td>Score:</td><td><input type='number' name='score' value='"+p.getScore()+"' style='font-size:20px'/></td></tr>");
        out.print("<tr><td>Wicket:</td><td><input type='number' name='wicket' value='"+p.getWicket()+"' style='font-size:20px'/></td></tr>");
        out.print("<tr><td>Zero Out:</td><td><input type='number' name='zero' value='"+p.getZero_out()+"' style='font-size:20px'/></td></tr>");
        out.print("<tr><td>Player Type:</td><td>");  
        out.print("<select name='player type' style='width:150px'>");  
        out.print("<option value='Bowler'>Bowler</option>");  
        out.print("<option value='Batsman'>Batsman</option>");  
        out.print("<option value='Wicket-Keeper'>Wicket-Keeper</option>");  
        out.print("<option value='All-Rounder'>All-Rounder</option>");  
        out.print("</select>");  
        out.print("</td></tr>"); 
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save ' style='font-size:15px'/></td></tr>");  
        out.print("</table>");  
        out.print("</center>");
        out.print("</form>");  
          
        out.close();
	}

}