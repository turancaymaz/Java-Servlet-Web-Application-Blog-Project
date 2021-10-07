package utils;

import props.Blog;
import props.Contact;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBUtil {
    public boolean login( String email, String password,String remember, HttpServletRequest req, HttpServletResponse resp){
        boolean status = false;
        DB db = new DB();


        try {
            String sql = "select * from admin where email = ? and password = ?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1,email);
            pre.setString(2, Util.MD5(password));
            ResultSet rs = pre.executeQuery();
            status = rs.next();

            if(  status ){
                int aid = rs.getInt("aid");
                String name = rs.getString("name");

                req.getSession().setAttribute("aid", aid);
                req.getSession().setAttribute("name", name);

                if( remember != null && remember.equals("on")){
                    name= name.replaceAll(" ","_");
                    String val = aid+"_"+name;
                    Cookie cookie = new Cookie("user", val);
                    cookie.setMaxAge(60*60*24);
                    resp.addCookie(cookie);
                }


            }

        } catch (Exception e) {
            System.err.println("login Error "+ e);
        } finally {
            db.close();
        }
        return  status;
    }

    //blog-add

        public int blogAdd(Blog blo){
        int status = 0;
        DB db = new DB();
            System.out.println(blo.getDetail() + " " + blo.getAuthor() +" "+ blo.getContent()+ " "+ blo.getTitle());

            try {
                String sql ="insert into blogger values( null, ?, ?, ?,?, now() )";
                PreparedStatement pre = db.conn.prepareStatement(sql);
                pre.setString(1, blo.getAuthor() );
                pre.setString(2, blo.getTitle());
                pre.setString(3,blo.getContent());
                pre.setString(4, blo.getDetail());
                status = pre.executeUpdate();
            } catch (Exception e) {
                System.err.println("blogAdd Error: "+ e);
            } finally {
                db.close();
            }
            return status;
        }

    public int contactInsert(Contact contact) {
        int status = 0;
        DB db = new DB();

        try {
            String sql ="insert into contant values (null,?,?,?,?)";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1,contact.getName());
            pre.setString(2,contact.getEmail());
            pre.setString(3,contact.getPhone());
            pre.setString(4,contact.getMessage());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return status;
    }
    public boolean isPasswordValid(int aid, String password){
        boolean status = false;
        DB db = new DB();
        try {
            String sql = "select password from author where aid=? and password=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1,aid);
            pre.setString(2,Util.MD5(password));
            ResultSet rs = pre.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            System.err.println("Password Valid Error: " + e);
        } finally {
            db.close();
        }
        return status;
    }

    //PASSWORD CHANGE
    public int changePassword(int aid,String password) {
        int status = 0;
        DB db = new DB();
        try {
            String sql ="update blogger set password=? where aid=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1,Util.MD5(password));
            pre.setInt(2, aid);
            status = pre.executeUpdate();
        } catch (Exception e) {
            System.err.println("userPasswordUpdate Error : " + e);
        } finally {
            db.close();
        }
        return status;
    }

    public List<Blog> allBlog(){
        List<Blog> ls = new ArrayList<>();
        DB db = new DB();
            try {
                String sql = "select * from blogger";
                PreparedStatement pre = db.conn.prepareStatement(sql);
                ResultSet rs = pre.executeQuery();;
                while ( rs.next()){
                    int bid = rs.getInt("bid");
                    String author = rs.getString("author");
                    String title = rs.getString("title");
                    String content = rs.getString("content");
                    String detail = rs.getString("detail");
                    Date date = rs.getDate("date");
                    Blog bl = new Blog(bid,author,title,content,detail,date);
                    ls.add(bl);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                db.close();
            }
            return ls;
        }

        public int blogDelete (  int bid) {
        int status = 0;
        DB db = new DB();


            try {
                String sql = "delete from blogger where bid = ?";
                PreparedStatement pre = db.conn.prepareStatement(sql);
                pre.setInt(1, bid);
                status = pre.executeUpdate();

            } catch (Exception e) {
                System.err.println("blogDelete Error : "+ e);
            } finally {
                db.close();
            }
            return  status;
        }

    public boolean isBlogValid( int bid) {
        boolean status = false;
        DB db = new DB();
        try {
            String sql = "select * from blogger where bid = ? ";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, bid);
            ResultSet rs = pre.executeQuery();
            status = rs.next();
        }catch (Exception ex) {
            System.err.println("isBlogValid Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }



        public Blog singleBlog( int bid ) {
        Blog blo = new Blog();
        DB db = new DB();

            try {
                String sql = "select * from blogger where bid = ?";
                PreparedStatement preparedStatement = db.conn.prepareStatement(sql);
                preparedStatement.setInt(1, bid);
                ResultSet rs = preparedStatement.executeQuery();
                if( rs.next()){
                    int bidx = rs.getInt("bid");
                    String author = rs.getString("author");
                    String title = rs.getString("title");
                    String content = rs.getString("content");
                    String detail = rs.getString("detail");
                    Date date = rs.getDate("date");

                    blo = new Blog(bidx,author,title,content,detail,date);
                    return blo;

                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                db.close();
            }
            return blo;
        }
    public int updateBlog(String author, String title, String content, String detail, int bid){

        int status = 0;
        DB db = new DB();
        try {
            String sql = "update blogger set author = ?, title = ?, content= ?, detail = ?  where bid = ? ";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1,author);
            pre.setString(2,title);
            pre.setString(3,content);
            pre.setString(4,detail);
            pre.setInt(5,bid);
            status = pre.executeUpdate();

        }catch (Exception e){
            System.err.println("updateBlog Error : " + e);
        }finally {
            db.close();
        }

        return status;
    }



}
