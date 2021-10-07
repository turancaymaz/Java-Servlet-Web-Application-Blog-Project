package servlets;

import props.Admin;
import utils.DBUtil;
import utils.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "passwordChangeServlet", value = "/passwordchange")
public class PasswordChangeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String old_password = req.getParameter("old_password");
        String new_password = req.getParameter("new_password");
        int aid = (int) req.getSession().getAttribute("aid");
        System.out.println("aid:" +aid);

        DBUtil util = new DBUtil();

        String errorMessage = "";
        boolean status = util.isPasswordValid(aid,old_password);
        if(status) {
            int status1 =  util.changePassword(aid,new_password);
            resp.sendRedirect(Util.base_url + "blog.jsp");
        }else{
            errorMessage = "Eski Şifrenizi Hatalı Girdiniz!";
            req.setAttribute("passwordError", errorMessage);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/passwordchange.jsp");
            dispatcher.forward(req,resp);
        }



    }
}
