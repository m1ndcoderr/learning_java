package evgenyhodz.servlets;

import evgenyhodz.DBController;
import evgenyhodz.models.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.07.2017
 */
public class EditRoleServlet extends HttpServlet {
    /**
     * Forward to default.jsp.
     *
     * @param req  - request from client to server.
     * @param resp - response to client from server.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", DBController.getController().getRoles());
        req.getRequestDispatcher("/WEB-INF/actions/default.jsp").forward(req, resp);
    }

    /**
     * Send request to edit role.
     *
     * @param req  - request from client to server.
     * @param resp - response to client from server.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBController controller = DBController.getController();
        int id = Integer.parseInt(req.getParameter("role_id"));
        if (controller.findRoleById(id) != null) {
            controller.updateRole(new Role(id, req.getParameter("role")));
            resp.sendRedirect(String.format("%s/default", req.getContextPath()));
        }
    }
}
