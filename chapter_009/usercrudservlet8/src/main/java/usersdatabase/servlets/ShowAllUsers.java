package usersdatabase.servlets;

import usersdatabase.DBController;
import usersdatabase.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 30.07.2017
 */
public class ShowAllUsers extends HttpServlet {
    /**
     * Shows all user in database.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hmtl = "<table><tr><th>Username</th><th>Login</th><th>Email</th>"
                + "<th>Create date</th><th>Role</th><th>Country</th><th>City</th></tr>";
        for (User user : DBController.getController().get()) {
            hmtl = hmtl + "<tr><td>" + user.getName() + "</td><td>" + user.getLogin() + "</td><td>"
                    + user.getEmail() + "</td><td>" + user.getCreateDate().toString()
                    + "</td><td>" + user.getRole().getName() + "</td><td>"
                    + user.getCountry() + "</td><td>" + user.getCity() + "</td></tr>";
        }
        hmtl = hmtl + "</table>";
        resp.setContentType("text/html");
        resp.getWriter().write(hmtl);
    }
}
