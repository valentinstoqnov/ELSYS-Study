package bg.elsys.ip.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	public static final String LOGOUT = "logout";

	/**
	 * 
	 */
	private static final long serialVersionUID = 5151507837875513420L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (request.getParameter(LOGOUT) != null) {
			Cookie[] cookies = request.getCookies();

			if (cookies != null) {
				String name = request.getParameter(LOGOUT);

				for (Cookie cookie : cookies) {
					out.println(cookie);
					if (cookie.getName().equals(name)) {
						Singleton singleton = Singleton.getInstance();
						if (singleton.users.containsKey(cookie)) {
							singleton.users.remove(cookie);
						}
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}

				getServletContext().getRequestDispatcher("index.html").forward(request, response);
			}
		} else {
			out.print("Welcome, " + request.getParameter("name"));
		}
		out.close();
	}

}
