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

@WebServlet(name = "Shop", urlPatterns = {"/Shop"})
public class Shop extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    // Application object
    ServletContext application = getServletContext();
    Inventory inventory =
        (Inventory)application.getAttribute("inventory");
    // Session object
    HttpSession session = request.getSession();
    Basket basket = (Basket)session.getAttribute("basket");
    if (basket == null) {
      basket = new Basket();
//      basket.add(inventory.get(7));
//      basket.add(inventory.get(17));
      session.setAttribute("basket", basket);
      }
    PrintWriter out = response.getWriter();
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("  <head><title>Shop</title></head>");
      out.println("  <body>");
      out.println("    <h1>Butik</h1>");
      out.println("    <hr/>");
      out.println("    <table>");
      out.println("      <tr><th>#</th><th>Navn</th><th>Pris</th></tr>");
      for (Item item : basket.getItems()) {
        out.print("      <tr>");
        out.print("<td>"+item.getId()+"</td>");
        out.print("<td>"+item.getName()+"</td>");
        out.print("<td>"+item.getPrice()+"</td>");
        out.println("</tr>");
        }
      out.println("      </table>");
      out.println("    <form action='AddItem'>");
      RequestDispatcher dispathcer =
          request.getRequestDispatcher("ItemList");
      dispathcer.include(request, response);
      out.println("      <button type='submit'>Tilføj</button>");
      out.println("      </form>");
      out.println("    <a href='Main'>Gå tilbage til velkomstsiden</a>");
      out.println("    </body>");
      out.println("  </html>");
      }
    finally {      
      }
    }

  }
