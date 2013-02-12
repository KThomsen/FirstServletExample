package dk.cpbuiness.servlets;

import dk.cphbusiness.model.Inventory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ServletContext application = getServletContext();
        Inventory inventory = (Inventory)application.getAttribute("inventory");
        
        if(inventory == null)
        {
            inventory = new Inventory();
            application.setAttribute("inventory", inventory);
        }
        
        PrintWriter out = response.getWriter();
        try {
           out.println("<!DOCTYPE html>");
           out.println("<head><title>Velkommen</title></head>");
           out.println("<body><h1>Velkommen</h1><p>Butikken har nu "+inventory.getItems().size()+" varer på lager.</p><hr /><a href='Shop' target='_self'>Gå til butikken</a></body>");
           out.println("</html>");
        } finally {            
            out.close();
        }
    }
}
