package Model.Servlet;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Item;
import Service.InsertItem;
import Service.InsertItem;

/**
 * Servlet implementation class insertEvent
 */
@WebServlet("/insertItem")
public class insertItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   /* public insertEvent() {
        super();
        // TODO Auto-generated constructor stub
    }*/


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Item item =  new Item();

		item.setItemID(request.getParameter("itemID"));
		item.setQty(Integer.parseInt(request.getParameter("qty")));
		item.setUnitPrice(Float.parseFloat(request.getParameter("unitPrice")));
		item.setDescription(request.getParameter("description"));
	
		
		InsertItem insert = new InsertItem();
		
		boolean res= insert.addItem(item);
		
		if(res==true) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewItem.jsp");
			request.setAttribute("errors_success", 0);
			dispatcher.forward(request, response);
			System.out.println();
		}else if(res==false) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successnot.jsp");
			request.setAttribute("errors_success", 1);
			dispatcher.forward(request, response);
		}
	}

}
