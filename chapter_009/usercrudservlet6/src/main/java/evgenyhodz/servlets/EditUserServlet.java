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
 * @since 04.06.2017
 */
public class EditUserServlet extends HttpServlet {
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
        req.getRequestDispatcher("/WEB-INF/actions/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role tmp;
        String id = req.getParameter("role_id");
        String login = req.getParameter("txtlogin");
        if(id == null){
            tmp = controller.getUser(login).getRole();
        } else {
            tmp = controller.findRoleById(Integer.valueOf(id));
        }
        controller.update(new User(
                req.getParameter("txtusername"),
                login,
                req.getParameter("txtemail"),
                LocalDate.now(),
                tmp));
        resp.sendRedirect(String.format("%s/default", req.getContextPath()));
    }
}
