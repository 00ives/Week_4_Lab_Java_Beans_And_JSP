package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            String title = "";
            String content = "";
  
        try{
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            
            BufferedReader input = new BufferedReader(new FileReader(path));
            title = input.readLine();
            content = input.readLine();
            input.close();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
            
            Note noteFromFile = new Note(title,content);

            request.setAttribute("note", noteFromFile);
            
            
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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String contentText = request.getParameter("contentText");
        String titleText = request.getParameter("titleText");
        
//        if (!titleText.equals("")){
//           String[] titleTextsplit = titleText.split("\\r\\n");
//        for (int i = 0; i < titleTextsplit.length; i++) {
//            
//        }
//        }
        
        Note noteSaved = new Note(titleText,contentText);
        boolean viewNote = true;
        
        request.setAttribute("viewNote", viewNote);
        request.setAttribute("note", noteSaved);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        output.println(noteSaved.getTitle());
        output.println(noteSaved.getContent());
        output.close();
        
        getServletContext()
                .getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        
    }

}
