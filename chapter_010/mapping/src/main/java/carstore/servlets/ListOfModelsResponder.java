package carstore.servlets;

import carstore.controllers.CarStoreManager;
import carstore.models.Model;

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
public class ListOfModelsResponder extends HttpServlet{
    /**
     * Receives a list of models from database and writes html for models dropdown form.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlResponse = null;
        ArrayList<Model> list = CarStoreManager.getCONTROLLER().getModels();
        for (Model model : list) {
            htmlResponse = htmlResponse + "<option>" + model.getModel() + "</option>\n";
        }
        if (htmlResponse == null) {
            htmlResponse = "<option>There is no values in database for that</option";
        }
        resp.getWriter().write(htmlResponse);
    }
}
