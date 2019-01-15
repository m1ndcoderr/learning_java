package evgenyhodz.servlets;

import evgenyhodz.DBController;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 20.07.2017
 */
public class JsonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(DBController.getController().getUsersInJSON().toString());
        writer.flush();
    }
}
