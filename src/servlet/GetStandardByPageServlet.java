package servlet;

import biz.StandardBiz;
import biz.bizimpl.StandardBizImpl;
import emtity.Standard;
import util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 25397 on 2016/12/22.
 */
@WebServlet(name = "GetStandardByPageServlet", urlPatterns = "/GetStandardByPageServlet")
public class GetStandardByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StandardBiz standardBiz = new StandardBizImpl();
        String select = request.getParameter("select");
        Map<String, Object> map = new HashMap<>();
        if ("".equals(select) || null == select) {

        } else {

            Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]");
            Matcher matcher = pattern.matcher(select);
            if (matcher.find()) {
                    map.put("zhname", select);
            } else {
                map.put("std_num", select);
            }
        }

        String pageIndex = request.getParameter("pageIndex");
        if (null == pageIndex) {
            pageIndex = "1";
        }
        int currentPage = Integer.parseInt(pageIndex);
        Page page = new Page();
        page.setCurrentPage(currentPage);
        page.setTotal(standardBiz.getCount(map));

        map.put("start", (page.getCurrentPage() - 1) * page.getPageSize());
        map.put("pageSize", page.getPageSize());
        List<Standard> standardList = standardBiz.getStandardByPage(map);
        request.setAttribute("standardList", standardList);
        request.setAttribute("page", page);
        request.setAttribute("select",select);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
