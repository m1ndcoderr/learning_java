package evgenyhodz.servlets;

import evgenyhodz.DBController;
import evgenyhodz.models.Role;
import evgenyhodz.models.User;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 11.07.2017
 */
public class ServletsTest {
    /**
     * CreateUserServlet test.
     *
     * @throws ServletException .
     * @throws IOException      .
     */
    @Test
    public void whenAddNewUserThenDBGetNewUserTest() throws ServletException, IOException {

        CreateUserServlet servlet = new CreateUserServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        servlet.init();

        when(request.getParameter("name")).thenReturn("testName");
        when(request.getParameter("login")).thenReturn("testLogin");
        when(request.getParameter("email")).thenReturn("test@email.com");
        when(request.getParameter("role_id")).thenReturn("3");

        servlet.doPost(request, response);

        User user = servlet.getController().getUser("testLogin");

        assertNotNull(user);
        assertThat(user.getName(), is("testName"));
        assertThat(user.getLogin(), is("testLogin"));
        assertThat(user.getEmail(), is("test@email.com"));
        assertThat(user.getRole().getName(), is("just_user"));

        servlet.destroy();
    }

    /**
     * CreateRoleServlet test.
     *
     * @throws ServletException .
     * @throws IOException      .
     */
    @Test
    public void whenAddNewRoleThenDBGetNewRoleTest() throws ServletException, IOException {

        CreateRoleServlet servlet = new CreateRoleServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        servlet.init();

        when(request.getParameter("role")).thenReturn("testRole");

        servlet.doPost(request, response);

        Role role = servlet.getController().findRoleByName("testRole");

        assertNotNull(role);
        assertThat(role.getId(), is(5));
        assertThat(role.getName(), is("testRole"));

        servlet.destroy();
    }

    /**
     * EditUserServlet test.
     *
     * @throws ServletException .
     * @throws IOException      .
     */
    @Test
    public void whenEditUserThenDBGetUpdatedUserTest() throws ServletException, IOException {

        EditUserServlet servlet = new EditUserServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        servlet.init();
        servlet.getController().add(new User(null, null, null, LocalDate.now(), new Role(3, "just_user")));

        when(request.getParameter("txtusername")).thenReturn("testName");
        when(request.getParameter("txtlogin")).thenReturn("testLogin");
        when(request.getParameter("txtemail")).thenReturn("test@email.com");
        when(request.getParameter("role_id")).thenReturn("3");

        servlet.doPost(request, response);

        User user = servlet.getController().getUser("testLogin");

        assertNotNull(user);
        assertThat(user.getName(), is("testName"));
        assertThat(user.getLogin(), is("testLogin"));
        assertThat(user.getEmail(), is("test@email.com"));
        assertThat(user.getRole().getName(), is("just_user"));

        servlet.destroy();
    }

    /**
     * EditRoleServlet test.
     *
     * @throws ServletException .
     * @throws IOException      .
     */
    @Test
    public void whenEditRoleThenDBGetUpdatedRoleTest() throws ServletException, IOException {

        EditRoleServlet servlet = new EditRoleServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        servlet.init();
        DBController controller = servlet.getController();
        controller.addRole("oldName");

        when(request.getParameter("role_id")).thenReturn("20");
        when(request.getParameter("role")).thenReturn("newname");

        servlet.doPost(request, response);

        Role role = servlet.getController().findRoleById(20);
        assertNotNull(role);
        assertThat(role.getName(), is("newname"));

        servlet.destroy();
    }

    /**
     * DeleteUserServlet test.
     *
     * @throws ServletException .
     * @throws IOException      .
     */
    @Test
    public void whenDeleteUserThenDBGetNullTest() throws ServletException, IOException {

        DeleteUserServlet servlet = new DeleteUserServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        servlet.init();
        servlet.getController().add(new User("test", "test", "test@email.com", LocalDate.now(), new Role(3, "just_user")));

        when(request.getParameter("txtlogin")).thenReturn("test");

        servlet.doPost(request, response);

        User user = servlet.getController().getUser("test");

        assertNull(user);

        servlet.destroy();
    }
}