package com.cookieg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstCookie extends HttpServlet
{

 
	private static final long serialVersionUID = 1L;

   public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
  {
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	
	  
	//create RequestDispatcher 
	
	 String name=req.getParameter("name");  
     String password=req.getParameter("password"); 
     
     System.out.println("hi i am here");
     
     if(password.equals("malik786")) 
     {
    	 
    	 //create cookie
    	 Cookie ck=new Cookie("name",name);
    	 res.addCookie(ck);
    	 out.print("You are successfully logged in!");
    	 out.print("<html><body><br><h2>Welcome</h2></body></html>, "+name);
    	 req.getRequestDispatcher("link.html").include(req,res);
     }
     else
     {
    	 out.print("sorry, username or password error!");
    	 out.print("<html><body><br><h2>Welcome</h2></body></html>, "+name);

         req.getRequestDispatcher("login.html").include(req, res); 
     }
     
    }
 

  }
