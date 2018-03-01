package servlet;

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
@WebServlet(name = "deleteservlet")
public class deleteservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idnote = request.getParameter("idnote");
        DAO dao = new DAO();
//		System.out.println("dao");
        System.out.println(idnote);
        dao.delete(Integer.parseInt(idnote));
        System.out.println("delete");
        request.getRequestDispatcher("findservlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idnote = request.getParameter("idnote");
        DAO dao = new DAO();
//		System.out.println("dao");
        System.out.println(idnote);
        dao.delete(Integer.parseInt(idnote));
        System.out.println("delete");
        request.getRequestDispatcher("findservlet").forward(request, response);
    }
}
