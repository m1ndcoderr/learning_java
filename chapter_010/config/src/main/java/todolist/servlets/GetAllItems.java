package todolist.servlets;

import todolist.Controller;
import todolist.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.08.2017
 */
public class GetAllItems extends HttpServlet {
    /**
     * Returns list of all items.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlResponse = "<table class=\"pure-table\"><thead><tr>"
                + "            <th>Item ID</th>\n"
                + "            <th>Created</th>\n"
                + "            <th>Description</th>\n"
                + "            <th>Done</th>"
                + "        </tr></thead>";
        ArrayList<Item> list = Controller.getCONTROLLER().getAllItems();
        for (Item item : list) {
            htmlResponse = htmlResponse + "<tbody><tr><th>" + item.getId() + "</th><th>" + item.getCreated()
                    + "</th><th>" + item.getDesc() + "</th><th>" + item.isDone() + "</th></tr></tbody>";
        }
        htmlResponse = htmlResponse + "</table>";
        resp.getWriter().write(htmlResponse);
    }
}
