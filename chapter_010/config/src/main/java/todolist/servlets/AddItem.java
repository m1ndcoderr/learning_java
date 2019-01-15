package todolist.servlets;

import org.apache.log4j.Logger;
import todolist.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 20.08.2017
 */
public class AddItem extends HttpServlet {
    /**
     * Log4j logger.
     */
    private static final Logger LOG = Logger.getLogger(AddItem.class);

    /**
     * Add item to DB.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String desc = req.getParameter("description");
        if (desc != null) {
            try {
                Controller.getCONTROLLER().add(desc);
            } catch (Exception e) {
                LOG.error("Servlet, AddItem error: " + e);
                e.printStackTrace();
            }
        }

    }
}
