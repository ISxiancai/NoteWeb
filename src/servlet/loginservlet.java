package servlet;

import dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by 超 on 2017/5/22.
 */
@WebServlet( name ="loginservlet")
public class loginservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");



        // 自动登录  cookie

        String remmber = request.getParameter("libloglong");
        // 选中 —— yes  未选中 —— null
//		System.out.println(remmber);

        if(remmber!=null){
            // String str = URLEncoder.encode(request.getParameter("name"),"utf-8");
            System.out.println("cookie");
            String name = URLEncoder.encode(request.getParameter("libusername"),"utf-8");
            String pwd = URLEncoder.encode(request.getParameter("libpassword"),"utf-8");



            System.out.println(name);
            System.out.println(pwd);
            System.out.println(remmber);

            //创建两个Cookie对象
            Cookie nameCookie = new Cookie("username", name);
            //设置Cookie的有效期为3天
            nameCookie.setMaxAge(60 * 60 );
            Cookie pwdCookie = new Cookie("password", pwd);
            pwdCookie.setMaxAge(60 * 60 );
            response.addCookie(nameCookie);
            response.addCookie(pwdCookie);



        }





        // 登录 设置




        String name = request.getParameter("libusername");
        String pwd = request.getParameter("libpassword");
        HttpSession session = request.getSession();

        session.setAttribute("name", name);

//		int sum =0;
//		session.setAttribute("sum", sum);
//		System.out.println("sumOK");

        System.out.println("session  OK");


        DAO dao = new DAO();
//		System.out.println("OK");
        boolean flag = dao.checkUserName(name,pwd);

        if(flag){

            request.setAttribute("name", name);

//				System.out.println(((bean) list).getIdnote());
            response.sendRedirect("findservlet");
//					request.getRequestDispatcher("findservlet").forward(request,response);
        }else{
            System.out.println("error");
            request.setAttribute("error", "账号或者密码错误！");
//            response.sendRedirect("login.jsp");
				request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
