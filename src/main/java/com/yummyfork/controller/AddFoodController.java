package com.yummyfork.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.yummyfork.dto.Food;
import com.yummyfork.services.FoodService;
@MultipartConfig
@WebServlet("/AddFoodController")
public class AddFoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FoodService fs;

	public AddFoodController() {
		super();
		fs = new FoodService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");
		response.setContentType("text/html");
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();

		if (operation != null && operation.equalsIgnoreCase("edit")) {

			int id = Integer.parseInt(request.getParameter("foodId"));
			Food f = fs.getFoodById(id);
			request.setAttribute("food", f);
			rd = request.getRequestDispatcher("UpdateFood.jsp");
			rd.forward(request, response);

		} else if (operation != null && operation.equalsIgnoreCase("delete")) {
			int foodId = Integer.parseInt(request.getParameter("foodId"));
			int deleteFlag = fs.deleteFood(foodId);
			if (deleteFlag > 0) {
				out.println("success deleting food");
				response.sendRedirect("AddFoodController");
			} else {
				out.println("error deleting food");
				rd = request.getRequestDispatcher("AddFoodController?operation=");
				rd.include(request, response);
			}

		} else {
			List<Food> foodList = fs.getAllFood();
			request.setAttribute("foodList", foodList);
			rd = request.getRequestDispatcher("FoodList.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd;

		response.setContentType("text/html");

		String operation = request.getParameter("operation");

		if (operation != null && operation.equalsIgnoreCase("addFood")) {

			Part file=request.getPart("image");
			String imageFileName=file.getSubmittedFileName(); 
			
			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String category = request.getParameter("category");

			Food f = new Food(name, price, quantity, category,imageFileName);
			
			int flag = fs.addFood(f);

			if (flag > 0) {
				request.setAttribute("addFoodStatus","Success to add food!!");
				rd = request.getRequestDispatcher("AddFood.jsp");
				rd.include(request, response);
			} else {
				request.setAttribute("addFoodStatus","Failed to add food!!");
				rd = request.getRequestDispatcher("AddFood.jsp");
				rd.include(request, response);
			}
			System.out.println("File :  "+file+" Selected Image File Name : "+imageFileName);
			
			String uploadPath="D:/Java Programs/YummyFork/src/main/webapp/Images/"+imageFileName;  // upload path where we have to upload our actual image
			
			System.out.println("Upload Path : "+uploadPath);
			
			// Uploading our selected image into the images folder
			
			try
			{
			
			FileOutputStream fos=new FileOutputStream(uploadPath);
			InputStream is=file.getInputStream();
			
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		} else if (operation != null && operation.equalsIgnoreCase("update")) {
			
			int id = Integer.parseInt(request.getParameter("foodId"));
			String name = request.getParameter("foodName");
			double price = Double.parseDouble(request.getParameter("foodPrice"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String category = request.getParameter("category");

			Food f = new Food(id, name, price, quantity, category);

			int flag = fs.updateFood(f);

			if (flag > 0) {
				response.sendRedirect("AddFoodController?operation=");
			} else {
				response.sendRedirect("AddFoodController?operation=");
			}
		} else if (operation != null && operation.equals("searchFood")) {

			String foodName = request.getParameter("search");

			List<Food> foodList = fs.getFoodByName(foodName);

			request.setAttribute("foodList", foodList);
			rd = request.getRequestDispatcher("ShowSearchFood.jsp");
			rd.forward(request, response);
			
		}

	}
}
