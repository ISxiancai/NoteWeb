package servlet;

import dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 超 on 2017/5/22.
 */
@WebServlet(name = "pwdchangeservlet")
public class pwdchangeservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String name =  (String) session.getAttribute("name");
        String pwd = request.getParameter("libnickname");

        DAO dao = new DAO();
        if(dao.pwdChange(name, pwd)){
            request.setAttribute("pwdok", "你的密码修改成功了！");
            request.getRequestDispatcher("setting.jsp").forward(request, response);

        }else{request.setAttribute("pwdok", "你的密码修改失败了！");
            request.getRequestDispatcher("setting.jsp").forward(request, response);

        }



    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
