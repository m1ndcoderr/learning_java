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
 * @since 25.08.2017
 */
public class UpdateDone extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(UpdateDone.class);

    /**
     * Changes boolean value of item.
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
                Controller.getCONTROLLER().updateDone(Integer.valueOf(id));
            } catch (Exception e) {
                LOG.error("Update done post error: " + e);
                e.printStackTrace();
            }
        }
    }
}
