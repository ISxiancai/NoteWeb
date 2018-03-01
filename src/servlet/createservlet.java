package servlet;

import bean.bean;
import dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 超 on 2017/5/22.
 */
@WebServlet(name = "createservlet")
public class createservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("libusername");
        String pwd = request.getParameter("libpassword");
        String email = request.getParameter("libemail");

        DAO dao  = new DAO();
        boolean flag = dao.checkUser(name);
//		System.out.println(flag);
        if(flag){
            request.setAttribute("nameerror", "这个名字被人用了……");
            request.getRequestDispatcher("create.jsp").forward(request, response);

        }else{
            bean user = new bean();
            user.setName(name);
            user.setPwd(pwd);
            user.setEmail(email);
            if(dao.saveUser(user)){
                request.setAttribute("error", "注册成功了！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{
                request.setAttribute("error", "注册出错了！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
