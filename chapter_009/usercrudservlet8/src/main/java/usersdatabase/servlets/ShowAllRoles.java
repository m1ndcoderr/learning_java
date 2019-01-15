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
 * @since 30.07.2017
 */
public class ShowAllRoles extends HttpServlet {
    /**
     * Shows all roles in database.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hmtl = "<table><tr><th>Role ID</th><th>Role name</th></tr>";
        for (Role role : DBController.getController().getRoles()) {
            hmtl = hmtl + "<tr><td>" + role.getId() + "</td><td>" + role.getName() + "</td></tr>";
        }
        hmtl = hmtl + "</table>";
        resp.setContentType("text/html");
        resp.getWriter().write(hmtl);
    }
}
