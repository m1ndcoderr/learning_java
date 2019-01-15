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
import java.time.LocalDate;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 03.06.2017
 */
public class CreateUserServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserServlet.class);
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
                + "<h2><center>Создание нового пользователя<center></h2>\n"
                + "<p>Введите имя, логин и пароль, а затем нажмите \"Создать!\"</p>");
        pw.append(String.format("<form action='%s/create' method=post>", req.getContextPath()));
        pw.append(" Имя: <input type='text' name='name'><br/>"
                + " Логин: <input type='text' name='login'><br/>"
                + " Email: <input type='text' name='email'><br/>"
                + "<input type='submit' value=' Создать! '/><br/>"
                + "<h2><center>Указатели<center></h2>\n"
                + "<p><a href=\"http://localhost:8080/users/delete\">Ссылка</a> на удаление, " +
                "<a href=\"http://localhost:8080/users/edit\">cсылка</a> на редактирование, " +
                "<a href=\"http://localhost:8080/users/showall\">показать</a> всех пользователей.</p>"
                + "</form></body></html>"
        );
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            controller.add(new User(
                    req.getParameter("name"),
                    req.getParameter("login"),
                    req.getParameter("email"),
                    LocalDate.now()));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        resp.sendRedirect(String.format("%s/create", req.getContextPath()));
        int size = controller.get().size();
        System.out.println(size);
    }
}
