package com.qsp;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayResult extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			double w =(Double) req.getAttribute("weight");
			double h =(Double) req.getAttribute("height");
			double result =(Double) req.getAttribute("result");
			
			PrintWriter writer = resp.getWriter();
			
			if(result<18)
				writer.print("<html><body><h1>Under Weight</h1></body></html>");
			else if(result>=18 && result<25)
				writer.print("<html><body><h1>Normal Weight</h1></body></html>");
			else if(result>=25 && result<30)
				writer.print("<html><body><h1>Over Weight</h1></body></html>");
			else
				writer.print("<html><body><h1>Obese</h1></body></html>");

			
	}

}
