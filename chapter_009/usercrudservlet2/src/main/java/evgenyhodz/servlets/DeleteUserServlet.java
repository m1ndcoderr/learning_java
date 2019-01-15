package evgenyhodz.servlets;

import evgenyhodz.DBController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 04.06.2017
 */
public class DeleteUserServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteUserServlet.class);
    /**
     * DataBase Controller.
     */
    private final DBController controller = new DBController();

    @Override
    public void init() throws ServletException {
        controller.loadProperties();
        controller.connect();
    }

    @Override
    public void destroy() {
        controller.disconnect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append("<html>\n"
                + "<head>\n"
                + "    <title>Пользовательская база данных</title>\n"
                + "<style type=\"text/css\">\n"
                + "body {\n" +
                "background-color: #d2b48c;\n" +
                "margin-left: 20%;\n" +
                "margin-right: 20%;\n" +
                "border: 2px dotted black;\n" +
                "padding: 10px 10px 10px 10px;\n" +
                "font-family: sans-serif;\n" +
                "} "
                + "</style>"
                + "</head>\n"
                + "<body>\n"
                + "<h1><center>Пользовательская база данных</center></h1>\n"
                + "<h2><center>Удаление пользователя<center></h2>\n"
                + "<p>Введите имя пользователя, которого хотите удалить, в поле ниже:</p> ");
        pw.append(String.format("<form action='%s/delete' method=post>", req.getContextPath()));
        pw.append("<input type='text' name='name'><br/>");
        pw.append("<input type='submit' value='Удалить пользователя'/><br/>");
        pw.append("\n<h2><center>Указатели<center></h2>\n"
                + "<p><a href=\"http://localhost:8080/users/create\">Создание</a> пользователя, " +
                "<a href=\"http://localhost:8080/users/edit\">cсылка</a> на редактирование, " +
                "<a href=\"http://localhost:8080/users/showall\">показать</a> всех пользователей.</p>\n");
        pw.append("</form></body></html>");
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            controller.delete(req.getParameter("name"));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        resp.sendRedirect(String.format("%s/delete", req.getContextPath()));
    }
}
