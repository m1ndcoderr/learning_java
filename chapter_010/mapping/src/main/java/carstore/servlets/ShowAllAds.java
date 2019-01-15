package carstore.servlets;

import carstore.controllers.CarStoreManager;
import carstore.models.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.08.2017
 */
public class ShowAllAds extends HttpServlet {
    /**
     * Returns list of all advertisements.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlResponse = "<div class=\"row\">";
        int count = 0;
        ArrayList<Advertisement> list = CarStoreManager.getCONTROLLER().getAllAds();
        for (Advertisement adv : list) {
            htmlResponse = htmlResponse + "<div class=\"col-md-4 center-block\">\n"
                    + "<h2>" + adv.getCar().getBrand().getName() + " "
                    + adv.getCar().getModel().getModel() + "</h2>\n"
                    + "<p><img src=\"" + adv.getImage().getUrl() + "\"></p>\n"
                    + "<p><a class=\"btn btn-secondary\"  "
                    + "role=\"button\" id=\"" + adv.getId()
                    + "\" onclick=\"redirect_by_id()\">View details</a></p>\n" + "</div>";
            count++;
            if (count == 3) {
                htmlResponse = htmlResponse + "</div><div class=\"row\">";
                count = 0;
            }
        }
        htmlResponse = htmlResponse + "</div>";
        resp.getWriter().write(htmlResponse);
    }
}
