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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 25397 on 2016/12/22.
 */
@WebServlet(name = "SelectStandardServlet", urlPatterns = "/SelectStandardServlet")
public class SelectStandardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String select = request.getParameter("select");
        StandardBiz standardBiz = new StandardBizImpl();
        if ("" == select || null == select) {
            response.sendRedirect("GetStandardByPageServlet");
        }
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher matcher = pattern.matcher(select);
        if (matcher.find()) {
            List<Standard> standardList = standardBiz.getStandardLikeZhanName(select);
            System.out.println(standardList);
        } else {
            List<Standard> standardList = standardBiz.getStandardLikeStd_num(select);
            System.out.println(standardList);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
