package carstore.servlets;

import carstore.controllers.CarStoreManager;
import carstore.models.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.09.2017
 */
public class ChangeSold extends HttpServlet {
    /**
     * Changes sold parameter of advertisement.
     * Updates advertisement in a database.It's possible by clicking
     * special button under advertisement's picture.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf((String) req.getSession().getAttribute("adv_id"));
        CarStoreManager man = CarStoreManager.getCONTROLLER();
        Advertisement adv = man.findById(id);
        if (adv.isSold()) {
            adv.setSold(false);
        } else {
            adv.setSold(true);
        }
        man.updateAdvertisement(adv);
        resp.getWriter().write("success");
    }
}
