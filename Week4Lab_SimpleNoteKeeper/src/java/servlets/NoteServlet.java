package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ivorl
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String editNoteLink = request.getParameter("edit");
//        System.out.println("the edit link is " + editNoteLink);
//        System.out.println( editNoteLink);
        
        if (editNoteLink != null){
        
        getServletContext()
                .getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        
        }else{
        getServletContext()
                .getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext()
                .getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
    }

}
