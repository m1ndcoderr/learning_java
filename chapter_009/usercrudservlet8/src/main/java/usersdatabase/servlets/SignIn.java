package usersdatabase.servlets;

import usersdatabase.DBController;
import usersdatabase.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.07.2017
 */
public class SignIn extends HttpServlet {
    /**
     * Makes sign in if user's account is already exists in database.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String login = req.getParameter("login");
        User user = DBController.getController().getUser(login);
        if (username != null && login != null && user != null) {
            session.setAttribute("role", user.getRole().getName());
            String rolename = (String) session.getAttribute("role");
            if (rolename.equals("admin")) {
                resp.getWriter().write("adminpage");
            } else if (rolename.equals("just_user")) {
                resp.getWriter().write("userpage");
            }
            session.setAttribute("username", username);
            session.setAttribute("login", login);
        } else {
            req.getSession().setAttribute("error_message",
                    "<p>Username or Login field was empty or such user doesn't exist in the database.</p>");
            resp.getWriter().write("error");
        }
    }
}