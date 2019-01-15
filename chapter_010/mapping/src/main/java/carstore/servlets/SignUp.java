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
public class SignUp extends HttpServlet {
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
        String username = req.getParameter("name"),
                password = req.getParameter("password"),
                email = req.getParameter("email"),
                phone = req.getParameter("phone"),
                url = req.getParameter("url");
        if (username == null || email == null || password == null || phone == null || url == null) {
            resp.getWriter().write("null_data");
        } else {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhone(phone);
            user.setSocialUrl(url);
            CarStoreManager.getCONTROLLER().addUser(user);
            resp.getWriter().write("success");
            req.getSession().setAttribute("user", user);
        }
    }
}
