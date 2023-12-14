package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBConnect;

import Model.Item;

public class InsertItem {
	private static Statement st = null;
	private static ResultSet rs = null;

	public boolean addItem(Item item) {
		Connection connection;
		PreparedStatement preparedStatement;
		boolean isSuccess = false;
		try {
			connection = DBConnect.getDBConnection();
			
			//insert value
			preparedStatement = connection.prepareStatement("insert into Item (itemID, qty , unitPrice, description  ) values (?,?,?,?)");
			preparedStatement.setString(1, item.getItemID());
			preparedStatement.setInt(2,item.getQty());
			preparedStatement.setFloat(3,(float) item.getUnitPrice());
			preparedStatement.setString(4,item.getDescription());
			
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				isSuccess = true;
			}

			else {
				isSuccess = false;
			}
			
		}catch (ClassNotFoundException | SQLException  e) 
		{
			System.out.println(e.getMessage());
			
		}
		
		return isSuccess;
		
	}
	//update
	public static boolean updateItem(String itemcode, int qty, float price, String desc) {
			boolean isSuccess = false;
			Connection connection;
			PreparedStatement preparedStatement;
			
		try {

			connection = DBConnect.getDBConnection();
			
			st = connection.createStatement();
			String sql = "update Item set itemID='" + itemcode + "',qty='" + qty + "',unitPrice='" + price + "',description='"
					+ desc + "' where itemID='" + itemcode + "'";
			int count = st.executeUpdate(sql);

			if (count > 0) {
				isSuccess = true;
			}

			else {
				isSuccess = false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isSuccess;
	}
	
	//getall
	public static ArrayList<Item> getItems() {
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM Item");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Item item = new Item();
				
				item.setItemID(resultSet.getString(1));
				item.setQty(resultSet.getInt(2));
				item.setUnitPrice(resultSet.getDouble(3));
				item.setDescription(resultSet.getString(4));
				
				
				itemList.add(item);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}
		
		return itemList;
	}
	//delete item
	public int deleteItem(String itemCode) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//delete item
			preparedStatement = connection.prepareStatement("DELETE FROM Item WHERE itemID=?");
			preparedStatement.setString(1, itemCode);
			preparedStatement.execute();

			return 1;
		
		}catch (ClassNotFoundException | SQLException  e) {
			return 0;
		}
	}
	
	
public ArrayList<Item> getItemss() {
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM Item");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Item item = new Item();
				
				item.setItemID(resultSet.getString(1));
				item.setQty(resultSet.getInt(2));
				item.setUnitPrice(resultSet.getFloat(3));
				item.setDescription(resultSet.getString(4));
				
				
				itemList.add(item);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}
		
		return itemList;
	}
//search 
public Item getItem(String itemID) {
	Connection connection;
	PreparedStatement preparedStatement;
	Item item = new Item();
	
	try {
		connection = DBConnect.getDBConnection();
		
		preparedStatement = connection.prepareStatement("SELECT * FROM Item where itemID=?");
		preparedStatement.setString(1, itemID);
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next())
		{

			item.setItemID(resultSet.getString(1));
			item.setQty(Integer.parseInt(resultSet.getString(2)));
			item.setUnitPrice(Float.parseFloat(resultSet.getString(3)));
			item.setDescription(resultSet.getString(4));
			
			
		}
		
	}catch (ClassNotFoundException | SQLException  e) {
		System.out.println(e.getMessage());
	}
	return item;
}

}
