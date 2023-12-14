package Model.Servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.InsertItem;

@WebServlet("/removeItem")
public class removeItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("deleteId"));
		InsertItem service = new InsertItem();
		int res=service.deleteItem(request.getParameter("deleteId"));
		
		
		if(res==1) {
			request.setAttribute("errors_success", 1);
		}else {
			request.setAttribute("errors_success", 0);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewItem.jsp");
		dispatcher.forward(request, response);
		doGet(request, response);
	}

}
