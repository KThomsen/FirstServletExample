package dk.cphbusiness.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "SuperServlet",
    urlPatterns = {"/SuperServlet"}
    )
public class SuperServlet extends HttpServlet {  
  
  @Override
  protected void service(
      HttpServletRequest request,
      HttpServletResponse response
      ) throws ServletException, IOException {
    String text = "I am page scoped";
    String other = "I will be request scoped";
    request.setAttribute("other", other);
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet SuperServlet</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet SuperServlet at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
      }
    finally {      
      out.close();
      }
    }

  }
