/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cpbuiness.servlets;

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

/**
 *
 * @author kthomsen
 */
@WebServlet(name = "ItemList", urlPatterns = {"/ItemList"})
public class ItemList extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        ServletContext application = getServletContext();
        Inventory inventory = (Inventory)application.getAttribute("inventory");
       PrintWriter out = response.getWriter();
        
        try {
          out.println("<select name='item'>");
          for(Item item : inventory.getItems())
          {
          out.println("<option value='"+item.getId()+"'>"+item.toString()+"</option>");
          }
          out.println("</select>");
                   
                   
                   
                  
        } finally {            
          
        }
    }
}
