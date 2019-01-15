package carstore.servlets;

import carstore.controllers.CarStoreManager;
import carstore.models.Transmission;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 30.08.2017
 */
public class ListOfTransmissionsResponder extends HttpServlet {
    /**
     * Receives a list of transmissions from database and writes html for transmissions dropdown form.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlResponse = null;
        ArrayList<Transmission> list = CarStoreManager.getCONTROLLER().getTransmissions();
        for (Transmission transmission : list) {
            htmlResponse = htmlResponse + "<option>" + transmission.getType() + "</option>\n";
        }
        if (htmlResponse == null) {
            htmlResponse = "<option>There is no values in database for that</option";
        }
        resp.getWriter().write(htmlResponse);
    }
}
