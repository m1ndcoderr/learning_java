package usersdatabase.servlets;

import usersdatabase.DBController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 12.08.2017
 */
public class DeleteRole extends HttpServlet {
    /**
     * Delete from database by role ID.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("role_id");
        if (roleId == null) {
            req.getSession().setAttribute("error_message", "<p>Role ID field was empty.</p>");
            resp.getWriter().write("error");
        } else {
            DBController.getController().deleteRole(Integer.valueOf(roleId));
            resp.getWriter().write("adminpage");
        }
    }
}
