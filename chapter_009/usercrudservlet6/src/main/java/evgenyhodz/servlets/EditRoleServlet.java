package evgenyhodz.servlets;

import evgenyhodz.DBController;
import evgenyhodz.models.Role;
import evgenyhodz.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 07.07.2017
 */
public class EditRoleServlet extends HttpServlet {
    /**
     * DataBase Controller.
     */
    private final DBController controller = new DBController();

    /**
     * Getter.
     * @return this servlet's DBController.
     */
    public DBController getController() {
        return controller;
    }


    @Override
    public void init() throws ServletException {
        controller.loadProperties();
        controller.connect();
    }

    @Override
    public void destroy() {
        controller.disconnect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", controller.getRoles());
        req.getRequestDispatcher("/WEB-INF/actions/editrole.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("role_id"));
        if (controller.findRoleById(id) != null) {
            controller.updateRole(new Role(id, req.getParameter("role")));
            resp.sendRedirect(String.format("%s/default", req.getContextPath()));
        }
    }
}
