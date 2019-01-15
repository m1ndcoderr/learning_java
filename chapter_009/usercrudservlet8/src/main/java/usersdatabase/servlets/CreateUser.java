package usersdatabase.servlets;

import usersdatabase.DBController;
import usersdatabase.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 11.08.2017
 */
public class CreateUser extends HttpServlet {
    /**
     * Numbers to avoid magic number mistake from checkstyle plugin.
     */
    private static final int ZERO = 0, ONE = 1, TWO = 2, THREE = 3, FOUR = 4, FIVE = 5;

    /**
     * Creates user in database.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBController controller = DBController.getController();
        String[] params = {
                req.getParameter("username"),
                req.getParameter("login"),
                req.getParameter("email"),
                req.getParameter("country"),
                req.getParameter("city"),
                req.getParameter("role_id")
        };
        if (params[ZERO] != null && params[ONE] != null) {
            controller.add(new User(params[ZERO], params[ONE], params[TWO], params[THREE], params[FOUR],
                    LocalDate.now(), controller.findRoleById(Integer.parseInt(params[FIVE]))));
        }
    }
}
