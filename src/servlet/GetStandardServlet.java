package servlet;

import biz.StandardBiz;
import biz.bizimpl.StandardBizImpl;
import emtity.Standard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 25397 on 2016/12/22.
 */
@WebServlet(name = "GetStandardServlet", urlPatterns = "/GetStandardServlet")
public class GetStandardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        StandardBiz standardBiz=new StandardBizImpl();
        Standard standard=standardBiz.getStandardbyId(id);
        request.setAttribute("standard",standard);
        request.getRequestDispatcher("updateStandard.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
