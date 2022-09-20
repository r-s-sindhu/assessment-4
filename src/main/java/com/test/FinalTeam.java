package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinalTeam")
public class FinalTeam extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");	
        PrintWriter out=response.getWriter();       
        out.println("<a href='index.html'>Add New Player</a>");       
        out.println("<center><h1 style='color:purple'>Selected Team List</h1></center>");          
        List<Player> list=PlayerDao.getSelectedPlayers();          
        out.print("<table border='1' width='100%'");        
        out.print("<tr><th>Id</th><th>Name</th><th>Matches</th><th>Score</th><th>Wicket</th><th>Zero Out</th><th>Player Type</th><th>Average</th></tr>");        
        for(Player p:list)
        {  
         out.print("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td>"+p.getMatch()+"</td><td>"+p.getScore()+"</td><td>"+p.getWicket()+"</td><td>"+p.getZero_out()+"</td><td>"+p.getPlayer_type()+"</td><td>"+p.getAvg()+"</td></tr>");  
        }  
        out.print("</table>");            
        out.close(); 
	}
}
