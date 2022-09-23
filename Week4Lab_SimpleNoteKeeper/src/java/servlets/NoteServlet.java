package servlets;

import java.io.BufferedReader;
import java.io.FileReader;
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

        if (editNoteLink != null) {

            getServletContext()
                    .getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);

        } else {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader input = new BufferedReader(new FileReader(path));

            String title = input.readLine();
            String content = input.readLine();

            request.setAttribute("title", title);
            request.setAttribute("content", content);

            getServletContext()
                    .getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contentText = request.getParameter("contentText");
        String titleTezt = request.getParameter("titleText");

        getServletContext()
                .getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

}
