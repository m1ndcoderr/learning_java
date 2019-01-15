package evgenyhodz.servlets;

import evgenyhodz.DBController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 07.07.2017
 */
public class CreateRoleServlet extends HttpServlet {
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
        req.getRequestDispatcher("/WEB-INF/actions/createrole.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.addRole(req.getParameter("role"));
        resp.sendRedirect(String.format("%s/default", req.getContextPath()));
    }
}
