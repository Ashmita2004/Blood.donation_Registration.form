package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Donor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/register")
public class Donor_servlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");		
		String blood_group = req.getParameter("blood_group");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender"); 
		
		PrintWriter out = resp.getWriter();
		
		Donor d = new Donor();
		d.setName(name);
		d.setEmail(email);
		d.setContact(contact);
		d.setBlood_group(blood_group);
		d.setAddress(address);
		d.setGender(gender);
		
		try {
		int responce = d.addDonor();
		if(responce == 1 ) {
			out.println("Registration Successfull");
		}
		else {
			out.println("Registration Failed");
		}
	}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
