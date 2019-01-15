package carstore.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.09.2017
 */
public class Quit extends HttpServlet {
    /**
     * Removes all keeping attributes in session.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("user", null);
        req.getSession().setAttribute("car", null);
        req.getSession().setAttribute("adv_id", null);
        req.getSession().setAttribute("error_or_success_message", null);
        req.getSession().setAttribute("image", null);
        req.getSession().setAttribute("price", null);
        req.getSession().setAttribute("description", null);
    }
}
