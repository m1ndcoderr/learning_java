package carstore.servlets;

import carstore.controllers.CarStoreManager;
import carstore.models.Advertisement;
import carstore.models.Car;
import carstore.models.Image;
import carstore.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.09.2017
 */
public class AdvertisementCreator extends HttpServlet {
    /**
     * Receives all data required for creating advertisement.
     * Adds advertisement to database. Adds car and it's picture to database.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Car car = (Car) req.getSession().getAttribute("car");
        Image image = (Image) req.getSession().getAttribute("image");
        String description = (String) req.getSession().getAttribute("description");
        double price = Double.parseDouble((String) req.getSession().getAttribute("price"));
        Timestamp date = new Timestamp(System.currentTimeMillis());

        CarStoreManager man = CarStoreManager.getCONTROLLER();
        man.addCar(car);
        man.addImage(image);

        Advertisement advertisement = new Advertisement();
        advertisement.setUser(user);
        advertisement.setCar(car);
        advertisement.setImage(image);
        advertisement.setDescription(description);
        advertisement.setSold(false);
        advertisement.setPrice(price);
        advertisement.setDate(date);
        man.addAdvertisement(advertisement);

        resp.getWriter().write("success");
    }
}
