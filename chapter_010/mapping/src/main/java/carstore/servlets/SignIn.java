package carstore.servlets;

import carstore.controllers.CarStoreManager;
import carstore.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 31.08.2017
 */
public class SignIn extends HttpServlet {

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
        String username = req.getParameter("name"), password = req.getParameter("password");
        CarStoreManager man = CarStoreManager.getCONTROLLER();
        if (username != null && password != null) {
            User user = man.findUserByName(username);
            if (user != null && user.getPassword().equals(password)) {
                resp.getWriter().write("positive");
                req.getSession().setAttribute("user", user);
            } else {
                resp.getWriter().write("negative");
            }
        } else {
            resp.getWriter().write("negative");
        }
    }

    /**
     * Sending message to user.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write(req.getSession().getAttribute("error_or_success_message").toString());
    }
}
