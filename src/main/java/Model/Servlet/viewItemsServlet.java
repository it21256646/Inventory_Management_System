package Model.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Item;
import Service.InsertItem;

@WebServlet("/AllItem")
public class viewItemsServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ArrayList<Item> itemList =InsertItem.getItems();
		
		for (Item item : itemList) {
			System.out.println(item.getItemID());
			System.out.println(item.getQty());
			System.out.println(item.getUnitPrice());
			System.out.println(item.getDescription());
		}
		
		itemList = (ArrayList<Item>)request.getAttribute("AllItemsServlet");
	}
}
