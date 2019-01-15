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
 * @since 03.06.2017
 */
public class CreateUserServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            controller.add(new User(name, login, email, LocalDate.now()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s/jsp/create.jsp", req.getContextPath()));
    }
}
