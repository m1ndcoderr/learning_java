package carstore.servlets;

import carstore.controllers.CarStoreManager;
import carstore.models.Advertisement;
import carstore.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 12.09.2017
 */
public class ShowCarDetails extends HttpServlet {
    /**
     * Draws a important part of car.html page: car description and some details. Sometimes draw additional button.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf((String) req.getSession().getAttribute("adv_id"));
        CarStoreManager man = CarStoreManager.getCONTROLLER();
        Advertisement adv = man.findById(id);
        String response = "<div class=\"container more_bottom_margin\">\n" + "<h1 class=\"my-4\">"
                + adv.getCar().getBrand().getName() + "\n" + "<small>"
                + adv.getCar().getModel().getModel() + "</small>\n" + "</h1>\n" + "<div class=\"row more_width\">\n"
                + "<div class=\"col-md-8\">\n" + "<img class=\"img-fluid\" src=\"" + adv.getImage().getUrl()
                + "\" alt=\"\">\n" + "<div class=\"change_sold_btn\" style=\"margin-top: 20px\">"
                + setSoldButton(req, adv) + "</div>" + "</div>\n" + "<div class=\"col-md-4\">\n"
                + "<h3 class=\"my-3\">Car Description:</h3>\n" + "<p>" + adv.getDescription()
                + "</p>\n" + "<p>Price: " + adv.getPrice() + " roubles</p>\n" + "<p>Date of creation: "
                + correctDateOutput(adv.getDate()) + "</p>\n" + "<div id=\"sold\">Sold: " + isSold(adv.isSold())
                + "</div>\n" + "<h3 class=\"my-3\">Details:</h3>\n" + "<ul>\n"
                + "<li>Body: " + adv.getCar().getBodyStyle().getBody() + "</li>\n"
                + "<li>Engine: " + adv.getCar().getEngine().getType() + ", "
                + adv.getCar().getEngine().getCapacity() + "</li>\n"
                + "<li>Transmission: " + adv.getCar().getTransmission().getType() + "</li>\n"
                + "<li>Drive: " + adv.getCar().getWheelDrive().getType() + "</li>\n"
                + "<li>Horse powers: " + adv.getCar().getHorsePowers() + "</li>\n"
                + "<li>Production year: " + adv.getCar().getProductionYear() + "</li>\n"
                + "<li>Mileage: " + adv.getCar().getMileage() + "</li>\n" + "<li>Color: "
                + adv.getCar().getColor() + "</li>\n" + "</ul>\n"
                + "<h3 class=\"my-3\">Owner:</h3>\n" + "<p>Name: " + adv.getUser().getName() + "</p>\n"
                + "<p>Email: " + adv.getUser().getEmail() + "</p>\n" + "<p>Phone: " + adv.getUser().getPhone()
                + "</p>\n" + "<p>Social: " + adv.getUser().getSocialUrl() + "</p>\n"
                + "</div>\n" + "</div>\n" + "</div>";
        resp.getWriter().write(response);
    }

    /**
     * Receives 'Yes' or 'No' depends on advertisement's boolean value.
     *
     * @param value boolean.
     * @return String answer.
     */
    private String isSold(boolean value) {
        String result;
        if (value) {
            result = "Yes";
        } else {
            result = "No";
        }
        return result;
    }

    /**
     * Corrects date output.
     *
     * @param timestamp advertisement's creation date.
     * @return String value.
     */
    private String correctDateOutput(Timestamp timestamp) {
        String result;
        if (timestamp == null) {
            result = "Unknown";
        } else {
            result = timestamp.toString();
        }
        return result;
    }

    /**
     * Draws a button which could change sold parameter of a car on page.
     *
     * @param req .
     * @param adv .
     * @return String value.
     */
    private String setSoldButton(HttpServletRequest req, Advertisement adv) {
        String result = "";
        User current = (User) req.getSession().getAttribute("user");
        if (current != null
                && current.getName().equals(adv.getUser().getName())
                && current.getPassword().equals(adv.getUser().getPassword())) {
            if (!adv.isSold()) {
                result = "<button type=\"button\" id=\"sold_btn\" "
                        + "class=\"btn btn-danger\">I sold this car</button>";
            } else {
                result = "<button type=\"button\" id=\"sold_btn\" "
                        + "class=\"btn btn-danger\">I'm still selling this car</button>";
            }
        }
        return result;
    }
}
