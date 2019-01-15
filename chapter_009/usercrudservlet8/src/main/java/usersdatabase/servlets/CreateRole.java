package usersdatabase.servlets;

import usersdatabase.DBController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 11.08.2017
 */
public class CreateRole extends HttpServlet {
    /**
     * Creates new role in database.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rolename = req.getParameter("rolename");
        if (rolename != null) {
            DBController.getController().addRole(rolename);
            resp.getWriter().write("adminpage");
        } else {
            req.getSession().setAttribute("error_message",
                    "<p>Role name field was empty. Type something there!</p>");
            resp.getWriter().write("error");
        }
    }
}
