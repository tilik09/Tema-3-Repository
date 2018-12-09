package com.myfirstmaven.test.HelloMaven;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>Add Employee</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		
		response.getWriter().println("<script>");
		response.getWriter().println("function validateForm() {");
		response.getWriter().println("var x = document.forms[\"PersonForm\"][\"name\"].value;");
		response.getWriter().println("var y = document.forms[\"PersonForm\"][\"email\"].value;");
		response.getWriter().println("if (x == \"\" || y == \"\"){alert(\"All fields are mandatory\");return false}");
		response.getWriter().println("if (validateEmail(y)){return true;}else{alert(\"Wrong email format\");return false;}");
		response.getWriter().println("}");
		
		response.getWriter().println("function validateEmail(email) {");
		response.getWriter().println("var re = /^(([^<>()[\\]\\\\.,;:\\s@\\\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\\\"]+)*)|(\\\".+\\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/;");
		response.getWriter().println("return re.test(email);");
		response.getWriter().println("}");
		
		
		
		response.getWriter().println("</script>");
		
		response.getWriter().println("<h1>Hello World only jetty</h1>");
		response.getWriter().println("<h1>Servlet</h1>");

		response.getWriter().println("<form name=\"PersonForm\" method=\"post\" action=\"\" onsubmit=\"return validateForm()\">");
		response.getWriter().println("<label>Name</label>");
		response.getWriter().println("<input type=\"text\" name=\"name\"/><br />");

		response.getWriter().println("<label>Email</label>");
		response.getWriter().println("<input type=\"text\" name=\"email\"/><br />");

		response.getWriter().println("<br />");
		response.getWriter().println("<input method=\"post\" type=\"submit\" value=\"Add Employee\">");
		response.getWriter().println("</form>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>Servlet</h1>");
		response.getWriter().println("<h1>Adding person to database:</h1>");
				
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        response.getWriter().println("<p1>" + name + "<p1><br />");
		response.getWriter().println("<p1>" + email + "<p1>");
       
        DataBaseConnection myConnection = new DataBaseConnection();
        myConnection.WriteToDatabase(name, email);
        
		response.getWriter().println("<br />");
		response.getWriter().println("<button type=\"button\"><a href=\"hello\">Return!</a></button>");

	}
}
