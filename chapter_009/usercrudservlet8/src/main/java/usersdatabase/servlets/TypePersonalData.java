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
 * @since 13.08.2017
 */
public class TypePersonalData extends HttpServlet {
    /**
     * Finds all data about current user logged in.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = DBController.getController().getUser((String) req.getSession().getAttribute("login"));
        resp.setContentType("text/html");
        resp.getWriter().write("<h3>Username: " + user.getName() + "</h3>"
                + "<h3>Login: " + user.getLogin() + "</h3>"
                + "<h3>Email: " + user.getEmail() + "</h3>"
                + "<h3>Role: " + user.getRole().getName() + "</h3>"
                + "<h3>Country: " + user.getCountry() + "</h3>"
                + "<h3>City: " + user.getCity() + "</h3>"
                + "<h3>Creation date: " + user.getCreateDate().toString() + "</h3>");
    }
}
