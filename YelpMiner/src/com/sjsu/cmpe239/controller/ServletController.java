package com.sjsu.cmpe239.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjsu.cmpe239.dao.*;
import com.sjsu.cmpe239.dto.*;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchParameter = request.getParameter("businessText");
		System.out.println("searchParam ="+searchParameter);
		String cityText = request.getParameter("cityText");
		System.out.println("searchParam ="+cityText);

		if( searchParameter.equals("") || cityText.equals("")){
			ServletContext sc = this.getServletContext();			
			RequestDispatcher reqDispatcher = sc.getRequestDispatcher("/index.jsp");
			reqDispatcher.forward(request, response);
			
		}else{
			RapidMinerDao rd = new RapidMinerDao();

			searchParameter = searchParameter.concat(",").concat(cityText);
			ArrayList<RapidMinerDto> list = rd.search(searchParameter);
		
			System.out.println("result Map size>>"+ list.size());
			
			// print to make sure what output you shld see on the screen
			Iterator<RapidMinerDto> iterator = list.iterator();  

			while (iterator.hasNext()) { 
				RapidMinerDto rmd = (RapidMinerDto) iterator.next();  
				System.out.println("name= " + rmd.getBzname() +" rcount = "+ rmd.getReview_count() + "full address = "+  rmd.getFulladdress() + "stars = " + rmd.getReview_stars());
			}
			
			
			request.setAttribute("map", list);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
