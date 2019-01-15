package usersdatabase.servlets;

import usersdatabase.DBController;
import usersdatabase.models.Role;
import usersdatabase.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.07.2017
 */
public class SignUp extends HttpServlet {
    /**
     * Id of role of usual user.
     */
    private static final int USERID = 3;

    /**
     * Makes sign up by creating new account.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username_sign");
        String email = req.getParameter("email_sign");
        String login = req.getParameter("login_sign");
        if (username == null || email == null || login == null) {
            req.getSession().setAttribute("error_message",
                    "<p>Username, Login or Email field was empty. Please, check your input.</p>");
            resp.getWriter().write("error");
        } else if (DBController.getController().isEmailExists(email)) {
            req.getSession().setAttribute("error_message", "<p>Such email (" + email + ") is already exists.</p>");
            resp.getWriter().write("error");
        } else if (DBController.getController().getUser(login) != null) {
            req.getSession().setAttribute("error_message",
                    "<p>Login \"" + login + "\" is already exists. Please, choose another one.</p>");
            resp.getWriter().write("error");
        } else {
            User user = new User(username, login, email, null, null, LocalDate.now(), new Role(USERID, "just_user"));
            DBController.getController().add(user);
            HttpSession session = req.getSession();
            session.setAttribute("role", user.getRole().getName());
            session.setAttribute("username", username);
            session.setAttribute("login", login);
            resp.getWriter().write("userpage");
        }
    }
}
