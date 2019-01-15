package evgenyhodz.servlets;

import evgenyhodz.DBController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 04.06.2017
 */
public class DeleteUserServlet extends HttpServlet {
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
        req.setAttribute("user", controller.findByLogin(req.getParameter("login")));
        req.getRequestDispatcher("/WEB-INF/actions/delete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.delete(req.getParameter("txtlogin"));
        resp.sendRedirect(String.format("%s/default", req.getContextPath()));
    }
}
