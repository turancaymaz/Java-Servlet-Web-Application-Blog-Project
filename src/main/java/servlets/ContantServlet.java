package servlets;

import props.Blog;
import props.Contact;
import utils.DBUtil;
import utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "contactServlet", value = "/contact-servlet")
public class ContantServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String message = req.getParameter("message");

        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setMessage(message);


        DBUtil util = new DBUtil();


        int status = util.contactInsert(contact);
        if(status>0) {

            resp.sendRedirect(Util.base_url +"index.jsp");
        }else {
            String errorMessage = "";
            if (status == 0) {

                errorMessage = "Ekleme sırasında bir hata oluştu";
                System.out.println("errror"+ errorMessage);

            }
        }
        resp.sendRedirect(Util.base_url +"index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        String ipAddress = req.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = req.getRemoteAddr();
        }
        try {
            int cbid = Integer.parseInt(bid);
            int aid = (int) req.getSession().getAttribute("aid");
            DBUtil util = new DBUtil();
            if ( util.isBlogValid(cbid) ) {
                int status = util.blogDelete(cbid);
                if ( status > 0 ) { }
            }
        } catch (NumberFormatException e) {
            System.err.println("Delete item Error : " + ipAddress + " Error " + e);
        }
        resp.sendRedirect(Util.base_url+"index.jsp");
    }
}
