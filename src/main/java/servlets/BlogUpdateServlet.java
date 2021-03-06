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

@WebServlet( name = "blogUpdateServlet", value = "/blog-update")
public class BlogUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid = Integer.parseInt( req.getParameter("bid"));
        req.getSession().setAttribute("updateBid", bid);
        DBUtil util = new DBUtil();
        Blog blo = util.singleBlog(bid);

        req.setAttribute("blo", blo);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/blog_update.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Boolean bidStatus = req.getSession().getAttribute("updateBid") !=null;
        if( bidStatus ){
            String author = req.getParameter("author");
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String detail = req.getParameter("detail");
            int bid = (int) req.getSession().getAttribute("updateBid");

            DBUtil util = new DBUtil();
            int status = util.updateBlog(author, title, content, detail, bid);
        }


        resp.sendRedirect(Util.base_url+"dashboard.jsp");




    }
}
