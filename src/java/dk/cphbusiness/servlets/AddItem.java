package dk.cphbusiness.servlets;

import dk.cphbusiness.model.Basket;
import dk.cphbusiness.model.Inventory;
import dk.cphbusiness.model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddItem", urlPatterns = {"/AddItem"})
public class AddItem extends HttpServlet {

  @Override
  protected void service(
      HttpServletRequest request,
      HttpServletResponse response
      ) throws ServletException, IOException {
    String itemText = request.getParameter("item");
    long itemId = Long.parseLong(itemText);
    
    ServletContext application = getServletContext();
    Inventory inventory =
        (Inventory)application.getAttribute("inventory");
    HttpSession session = request.getSession();
    Basket basket = (Basket)session.getAttribute("basket");
    
    Item item = inventory.get(itemId);
    basket.add(item);
    RequestDispatcher dispatcher;
    if (basket.getItems().size() >= 5)
        dispatcher = request.getRequestDispatcher("Shop.jsp");
    else dispatcher = request.getRequestDispatcher("Shop");
    dispatcher.forward(request, response);
    }

  
}
