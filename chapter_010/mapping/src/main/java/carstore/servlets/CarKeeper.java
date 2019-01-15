package carstore.servlets;

import carstore.controllers.CarStoreManager;
import carstore.models.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 30.08.2017
 */
public class CarKeeper extends HttpServlet {
    /**
     * Keeps car saved in session. Also gets car's price and description
     * and sets it's values if they are = null, and keeps them in session too.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarStoreManager man = CarStoreManager.getCONTROLLER();

        String brand = req.getParameter("brand"),
                model = req.getParameter("model"),
                body = req.getParameter("body"),
                engine = req.getParameter("engine"),
                trans = req.getParameter("transmission"),
                drive = req.getParameter("wheeldrive"),
                hp = req.getParameter("horsepowers"),
                prod = req.getParameter("productionYear"),
                mileage = req.getParameter("mileage"),
                color = req.getParameter("color");

        if (brand == null || model == null || body == null || engine == null
                || trans == null || drive == null || hp == null
                || prod == null || mileage == null || color == null) {
            resp.getWriter().write("fail");

        } else {

            Car car = new Car();
            car.setBrand(man.findBrandByName(brand));
            car.setModel(man.findModelByName(model));
            car.setBodyStyle(man.findBodyByName(body));
            car.setEngine(man.findEngineByNameAndCapacity(engine));
            car.setTransmission(man.findTransmissionByName(trans));
            car.setWheelDrive(man.findWheelDriveByName(drive));
            car.setHorsePowers(Integer.valueOf(hp));
            car.setProductionYear(Integer.valueOf(prod));
            car.setMileage(Integer.valueOf(mileage));
            car.setColor(color);

            String desc = req.getParameter("description");
            String price = req.getParameter("price");

            if (desc == null) {
                desc = "The seller did not write a description for this car.";
            }

            if (price == null) {
                price = "0.0";
            }

            req.getSession().setAttribute("description", desc);
            req.getSession().setAttribute("price", price);
            req.getSession().setAttribute("car", car);

            resp.getWriter().write("success");
        }
    }
}
