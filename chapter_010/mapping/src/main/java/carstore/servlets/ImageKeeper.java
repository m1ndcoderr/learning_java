package carstore.servlets;

import carstore.models.Image;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.09.2017
 */
public class ImageKeeper extends HttpServlet {
    /**
     * Receives image from html form.
     * Writes that image to path (below, could be changed).
     * Keeps that image in session for some time.
     * Sends redirect to add_new_adv.html.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                FileItem item = upload.parseRequest(req).get(0);
                // -------------------->>> This PATH is just for that project:
                String path = "C:\\projects\\junior\\chapter_010\\mapping\\src\\main\\webapp\\images";
                File uploaded = new File(path, item.getName());
                item.write(uploaded);

                String imageContextPath = "../images/" + item.getName();
                Image image = new Image();
                image.setUrl(imageContextPath);
                req.getSession().setAttribute("image", image);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect(String.format("%s/html/add_new_adv.html", req.getContextPath()));
    }
}
