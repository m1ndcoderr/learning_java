package usersdatabase.servlets;

import usersdatabase.DBController;
import usersdatabase.models.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 12.08.2017
 */
public class EditRole extends HttpServlet {
    /**
     * Edits the user depending on the user's role in the system.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBController controller = DBController.getController();
        int id = Integer.parseInt(req.getParameter("role_id"));
        if (controller.findRoleById(id) != null) {
            controller.updateRole(new Role(id, req.getParameter("rolename")));
            resp.getWriter().write("adminpage");
        } else {
            req.getSession().setAttribute("error_message",
                    "<p>There is no such role ID in database. Please, check your input.</p>");
            resp.getWriter().write("error");
        }
    }
}
