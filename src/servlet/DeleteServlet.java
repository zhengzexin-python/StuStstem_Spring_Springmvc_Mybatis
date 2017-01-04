package servlet;

import biz.StandardBiz;
import biz.bizimpl.StandardBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 25397 on 2016/12/23.
 */
@WebServlet(name = "DeleteServlet",urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] str_id=request.getParameterValues("id");
        int[] id=new int[str_id.length];
        for (int i = 0; i <str_id.length ; i++) {
            id[i]=Integer.parseInt(str_id[i]);
        }
        StandardBiz standardBiz=new StandardBizImpl();
        if(standardBiz.deleteStandard(id)>0){
            response.sendRedirect("GetStandardByPageServlet");
        }else {
            PrintWriter printWriter =response.getWriter();
            printWriter.println("  <script type=\"text/javascript\">alert(\"删除失败\");history.back()</script>");
            printWriter.flush();
            printWriter.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
