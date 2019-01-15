package evgenyhodz.servlets;

import evgenyhodz.DBController;
import evgenyhodz.models.User;
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
 * @since 10.06.2017
 */
public class ShowAllUsersServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowAllUsersServlet.class);
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
                + "<h2><center>Список всех пользователей<center></h2>\n"
                + "<table border=\"5\">\n"
                + "<tr>\n"
                + "    <th>Имя</th>\n"
                + "    <th>Логин</th>\n"
                + "    <th>Email</th>\n"
                + "    <th>Дата создания</th>\n"
                + "</tr>");
        try {
            for (User user : controller.get()) {
                pw.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                        user.getName(), user.getLogin(), user.getEmail(), user.getCreateDate()));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        pw.append("</table>\n<h2><center>Указатели<center></h2>\n"
                + "<p><a href=\"http://localhost:8080/users/create\">Создать</a> пользователя, " +
                "<a href=\"http://localhost:8080/users/edit\">cсылка</a> на редактирование, " +
                "<a href=\"http://localhost:8080/users/delete\">удалить</a> пользователя.</p>"
                + "</form></body></html>"
        );
        pw.flush();
    }
}
