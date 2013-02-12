/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cpbuiness.servlets;

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

/**
 *
 * @author kthomsen
 */
@WebServlet(name = "Shop", urlPatterns = {"/Shop"})
public class Shop extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext application = getServletContext();
        Inventory inventory = (Inventory)application.getAttribute("inventory");
        
        HttpSession session = request.getSession();
        Basket basket = (Basket)session.getAttribute("basket");
        
        if(basket == null)
        {
            basket = new Basket();
            session.setAttribute("basket", basket);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("ItemList");
        PrintWriter out = response.getWriter();
        try {
           out.println("<!DOCTYPE html>");
           out.println("<head><title>Butik</title></head>");
           out.println("<body><h1>Butik!</h1><p>Butikken har nu "+inventory.getItems().size()+" varer.<hr />");
           
           out.println("<table cellspacing='2' cellpadding='2' border='1' style='width: 400px;'>");
           out.println("<tr><td colspan='3'>Indkøbskurv</td></tr>");
           out.println("<tr><th>#</th><th style='text-align: left;'>Navn</th><th style='text-align: left;'>Pris</th></tr>");
           double sum = 0;
           for(Item item : basket.getItems())
           {
            out.println("<tr><td style='text-align: center;'>"+item.getId()+"</td><td>"+item.getName()+"</td><td>"+item.getPrice()+" DKK</td></tr>");
            sum += item.getPrice();
           }
           out.println("<tr><td></td><th style='text-align: left;'>Total:</th><th style='text-align: left;'>"+sum+" DKK</th></tr>");
           out.println("<tr><td colspan='3'><form action='AddItem' method='GET'>");
           dispatcher.include(request, response);
           out.println("<button type='Submit'/>Tilføj</button></form></td></tr>");
           out.println("</table>");
           out.println("<a href='Main' target='_self'>Gå til forsiden</a>");          
           out.println("</body>");
           out.println("</html>");
        } finally {            
           
        }
    }
}
