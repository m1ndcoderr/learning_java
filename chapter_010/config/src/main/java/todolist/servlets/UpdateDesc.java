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
public class UpdateDesc extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(UpdateDesc.class);

    /**
     * Updates item.
     * @param req .
     * @param resp .
     * @throws ServletException .
     * @throws IOException .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String desc = req.getParameter("description");
        if (id != null && StringUtils.isNumeric(id) && desc != null) {
            try {
                Controller.getCONTROLLER().updateDesc(Integer.parseInt(id), desc);
            } catch (Exception e) {
                LOG.error("Update desc post error: " + e);
                e.printStackTrace();
            }
        }
    }
}
