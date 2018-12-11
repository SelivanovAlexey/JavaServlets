package servlets.validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ValidationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkValidation(req,resp);
    }

    public void checkValidation(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String correctPasword = "newyeariscoming";
        String reqLogin = req.getParameter("login");
        String reqPassword = req.getParameter("password");
        PrintWriter out = resp.getWriter();

        if (reqPassword.equals(correctPasword)){
            out.print("<html><body>");
            out.print("<h1>Hello, " + reqLogin + " </h1></br>");
            out.print("<h2>Your password is correct</h2>");
            out.print("</body></html>");
        }
        else resp.sendError(404,"Password is not correct");
    }
}


