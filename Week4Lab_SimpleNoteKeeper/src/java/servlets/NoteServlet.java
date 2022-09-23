package servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author ivorl
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String editNoteLink = request.getParameter("edit");
  
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader input = new BufferedReader(new FileReader(path));
            
            String title = input.readLine();
            String content = input.readLine();
            
            Note noteFromFile = new Note(title,content);

            request.setAttribute("noteFromFile", noteFromFile);
            
//            request.setAttribute("title", title);
//            request.setAttribute("content", content);
            
        if (editNoteLink != null) {

            getServletContext()
                    .getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);

        } else {
            
            boolean firstLoad = true;
            request.setAttribute("firstLoad", firstLoad);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
            firstLoad = false;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String contentText = request.getParameter("contentText");
        String titleText = request.getParameter("titleText");
        
        Note noteSaved = new Note(titleText,contentText);
        boolean viewNote = true;
        
        request.setAttribute("viewNote", viewNote);
        request.setAttribute("noteSaved", noteSaved);
        
        getServletContext()
                .getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        
        viewNote = false;
    }

}
