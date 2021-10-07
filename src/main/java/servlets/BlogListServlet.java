package servlets;

import props.Blog;
import utils.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "blogListServlet", value = "/blog-list")
public class BlogListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid = Integer.parseInt(req.getParameter("bid"));
        DBUtil util = new DBUtil();
        if(util.isBlogValid(bid)){
            Blog blog = util.singleBlog(bid);
            String title = blog.getTitle();
            String blog1 = blog.getContent();
            req.setAttribute("blog", blog);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/detay.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
