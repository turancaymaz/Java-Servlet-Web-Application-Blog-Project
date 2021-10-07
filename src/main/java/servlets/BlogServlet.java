package servlets;

import props.Blog;
import utils.DBUtil;
import utils.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "blogServlet", value = "/blog-add")
public class BlogServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        String author = req.getParameter("author");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String detail = req.getParameter("detail");

        Blog blo = new Blog();
        blo.setAuthor(author);
        blo.setTitle(title);
        blo.setContent(content);
        blo.setDetail(detail);

        DBUtil util = new DBUtil();
        int status = util.blogAdd(blo);
        if( status > 0 ) {
            resp.sendRedirect(Util.base_url+"dashboard.jsp");
        }else{
            req.setAttribute("addError", "Ekleme sırasında hata oluştu");
            RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("/dashboard.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        String ipAdress = req.getHeader("X-FORWARD-FOR");
        if (ipAdress == null ){
            ipAdress = req.getRemoteAddr();
        }
        try {
            int xbid = Integer.parseInt(bid);
            DBUtil util = new DBUtil();
            int status = util.blogDelete(xbid);
            if( status > 0) {}
        } catch (NumberFormatException e) {
            System.err.println("Delete item Error :"+ ipAdress +"Error" + e);
        }
        resp.sendRedirect(Util.base_url+"dashboard.jsp");


    }
}
