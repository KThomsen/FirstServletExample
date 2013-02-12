package dk.cphbusiness.servlets;

import dk.cphbusiness.model.Inventory;
import dk.cphbusiness.model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ItemList", urlPatterns = {"/ItemList"})
public class ItemList extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    ServletContext application = getServletContext();
    Inventory inventory =
        (Inventory)application.getAttribute("inventory");
    out.println("<select name='item'>");
    for (Item item : inventory.getItems()) {
      out.println("  <option value='"+item.getId()+"'>"+item+"</option>");
      }
    out.println("  </select>");
    
    }

  }
