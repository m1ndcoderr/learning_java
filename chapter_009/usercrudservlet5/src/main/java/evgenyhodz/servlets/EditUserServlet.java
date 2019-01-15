package evgenyhodz.servlets;

import evgenyhodz.DBController;
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
        controller.update(new User(req.getParameter("txtusername"), req.getParameter("txtlogin"),
                req.getParameter("txtemail"), LocalDate.now()));
        resp.sendRedirect(String.format("%s/edit", req.getContextPath()));
    }
}
