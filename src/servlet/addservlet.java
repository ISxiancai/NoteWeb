package servlet;

import dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 超 on 2017/5/22.
 */
@WebServlet(name = "addservlet")
public class addservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

//		System.out.println("addservlet");

        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        DAO dao = new DAO();
        String note = request.getParameter("libdiarybody");
        int iduser = dao.findUser(name);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
        String data = format.format(date);
        boolean flag = dao.add(iduser, note, data);
        if(flag){
            request.getRequestDispatcher("findservlet").forward(request, response);

        }else{
System.out.print("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
