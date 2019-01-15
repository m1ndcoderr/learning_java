package usersdatabase.servlets;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 07.07.2017
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        boolean loggedUser = session != null && session.getAttribute("role").equals("just_user"),
                loggedAdmin = session != null && session.getAttribute("role").equals("admin");
        if (isValidRequest(request)) {
            chain.doFilter(request, response);
        }
        if (request.getRequestURI().contains("/adminpage") && loggedAdmin) {
            chain.doFilter(request, response);
        }
        if (request.getRequestURI().contains("/userpage") && loggedUser) {
            chain.doFilter(request, response);
        }
        if (loggedUser && request.getRequestURI().contains("/adminpage")) {
            response.sendRedirect(request.getContextPath() + "/html/userpage.html");
        } else if (loggedAdmin && request.getRequestURI().contains("/userpage")) {
            response.sendRedirect(request.getContextPath() + "/html/adminpage.html");
        } else if (request.getRequestURI().contains("/adminpage") || request.getRequestURI().contains("/userpage")
                && session == null) {
            response.sendRedirect(request.getContextPath() + "/html/signin.html");
        }
        // TODO delete this thing below then proj will be ready
        System.out.println(request.getRequestURI());
    }

    @Override
    public void destroy() {
    }

    /**
     * Determines if request need to be passed.
     *
     * @param request .
     * @return boolean.
     */
    private boolean isValidRequest(HttpServletRequest request) {
        boolean result = false;
        String[] requests = {".css", ".js", ".jpg", ".json", ".ico",
                "/signin", "/signup", "/showallusers",
                "/showallroles", "/createuser", "/createrole",
                "/edituser", "/editrole", "/deleteuser",
                "/deleterole", "/typeusername", "/logout",
                "/typepersonaldata", "/errormanager", "/error"};
        for (int i = 0; i != requests.length; i++) {
            if (request.getRequestURI().contains(requests[i])) {
                result = true;
            }
        }
        return result;
    }
}
