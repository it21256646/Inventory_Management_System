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

@WebServlet("/updateItem")
public class updateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Item item =  new Item();

		item.setItemID(request.getParameter("itemcode"));
		item.setQty(Integer.parseInt(request.getParameter("qty")));
		item.setUnitPrice(Float.parseFloat(request.getParameter("price")));
		item.setDescription(request.getParameter("desc"));
		
		String itemCode = request.getParameter("itemcode");
		int qty = Integer.parseInt(request.getParameter("qty"));
		float price = Float.parseFloat(request.getParameter("price"));
		String desc = request.getParameter("desc");
		System.out.println(itemCode+""+qty+""+price+""+desc);
		InsertItem s = new InsertItem();
		boolean res=s.updateItem(itemCode,qty,price,desc);
		
		if(res==true) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewItem.jsp");
			request.setAttribute("errors_success", 0);
			dispatcher.forward(request, response);
		}else if(res==false) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewItem.jsp");
			request.setAttribute("errors_success", 1);
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}

}
