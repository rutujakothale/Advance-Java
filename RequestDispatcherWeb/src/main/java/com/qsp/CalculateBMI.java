package com.qsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/calculate")
public class CalculateBMI extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String weight = req.getParameter("weight");
		String height = req.getParameter("height");
		
		double weight1 = Double.parseDouble(weight);
		double height1 = Double.parseDouble(height);
		double res=weight1/(height1*height1);
		
		req.setAttribute("weight", weight1);
		req.setAttribute("height", height1);
		req.setAttribute("result",res );
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("display");
		requestDispatcher.forward(req, resp);
	}
}
