package dk.cphbusiness.servlets;

import com.sun.xml.ws.api.policy.PolicyResolver;
import dk.cphbusiness.model.Inventory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    ServletContext application = getServletContext();
    Inventory inventory =
        (Inventory)application.getAttribute("inventory");
    if (inventory == null) {
      inventory = new Inventory();
      application.setAttribute("inventory", inventory);
      }
    PrintWriter out = response.getWriter();
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("  <head><title>Welcome</title></head>");
      out.println("  <body>");
      out.println("    <h1>Velkommen</h1>");
      out.println("    <p>Butikken har nu "+inventory.getItems().size()+" varer!</p>");
      
      out.println("    <hr/>");
      out.println("    <a href='Shop'>Gå til butikken</a>");
      out.println("    </body>");
      out.println("  </html>");
      }
    finally {      
      }
    }

  }
