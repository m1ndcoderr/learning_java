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
public class DataChecker extends HttpServlet {
    /**
     * Checks: 1) if some user is logged in and 2) if a picture is downloaded.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isLoggedIn = req.getSession().getAttribute("user") != null;
        if (!isLoggedIn) {
            resp.getWriter().write("null_user");
        }
        boolean allDataIn = req.getSession().getAttribute("image") != null;
        if (allDataIn) {
            resp.getWriter().write("data_in");
        }
    }
}
