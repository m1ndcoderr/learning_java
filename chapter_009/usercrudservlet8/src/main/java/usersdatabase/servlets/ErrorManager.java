package usersdatabase.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.08.2017
 */
public class ErrorManager extends HttpServlet {
    /**
     * Sends a message to error.html.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String message = (String) req.getSession().getAttribute("error_message");
        if (message != null) {
            resp.getWriter().write(message);
        } else {
            resp.getWriter().write("<p>Unknown type of error.</p>");
        }
    }
}
