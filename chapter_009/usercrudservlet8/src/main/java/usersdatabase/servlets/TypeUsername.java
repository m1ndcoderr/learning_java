package usersdatabase.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.08.2017
 */
public class TypeUsername extends HttpServlet {
    /**
     * Types username of current logged in user at the top of userpage.html.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h1 style=\"padding-top: 5%\">Greetings, "
                + req.getSession().getAttribute("username") + "</h1>");
    }
}
