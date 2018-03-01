package servlet;

import bean.bean;
import dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by 超 on 2017/5/22.
 */
@WebServlet(name = "findservlet")
public class findservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String name = (String) session.getAttribute("name");


//		int sum =0;
//		session.setAttribute("sum", sum);
//		System.out.println("sumOK");


        DAO dao = new DAO();
        int iduser = dao.findUser(name);
        List<bean> list = dao.findNote(iduser);
        request.setAttribute("list", list);
//        response.sendRedirect("note.jsp");
		request.getRequestDispatcher("note.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String name = (String) session.getAttribute("name");

        int sum =0;
        session.setAttribute("sum", sum);
        System.out.println("sumOK");

        DAO dao = new DAO();
        int iduser = dao.findUser(name);
        List<bean> list = dao.findNote(iduser);
        request.setAttribute("list", list);
//		session.setAttribute("list", list);
//		response.sendRedirect("note.jsp");
        request.getRequestDispatcher("note.jsp").forward(request, response);
    }
}
