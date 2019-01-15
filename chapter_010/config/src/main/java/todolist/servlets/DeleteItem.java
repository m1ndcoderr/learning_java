package todolist.servlets;


import org.apache.commons.lang3.StringUtils;
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
public class DeleteItem extends HttpServlet {
    /**
     * Log4j logger.
     */
    private static final Logger LOG = Logger.getLogger(DeleteItem.class);

    /**
     * Removes item from DB.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && StringUtils.isNumeric(id)) {
            try {
                Controller.getCONTROLLER().delete(Integer.parseInt(id));
            } catch (Exception e) {
                LOG.error("Delete item post error: " + e);
                e.printStackTrace();
            }
        }
    }
}
