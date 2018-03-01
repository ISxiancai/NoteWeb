package servlet;

import bean.bean;
import com.google.gson.Gson;
import dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 超 on 2017/5/22.
 */
@WebServlet(name = "moreshowservlet")
public class moreshowservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 防止乱码
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String name = (String) session.getAttribute("name");

        int flag,sum;
        flag=Integer.parseInt(request.getParameter("flag"));
        sum=(int) session.getAttribute("sum");
        sum+=flag;
        session.setAttribute("sum", sum);
        DAO dao = new DAO();
        int iduser = dao.findUser(name);
        List<bean> morelist = new ArrayList<>();
        morelist = dao.findMore(iduser,sum);

        if(morelist.size()==0||morelist==null){
            request.setAttribute("morelist", "没有了……");
        }
        System.out.println("sum_"+sum);
//			System.out.println("morelist_"+morelist);


//			List<bean> list = (List<bean>)request.getAttribute("list");
//			List<bean> list = (List<bean>)request.getParameter("list");
//			List<bean> list = (List<bean>) session.getAttribute("list");


//			System.out.println("list_"+list);

//			session.removeAttribute("list");

//			list.addAll(morelist);
//			request.setAttribute("list", list);


        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String str = gson.toJson(morelist);
        out.println(str);
        out.close();




//		request.getRequestDispatcher("note.jsp").forward(request, response);


    }
}
