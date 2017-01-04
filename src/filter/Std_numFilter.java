package filter;

import biz.StandardBiz;
import biz.bizimpl.StandardBizImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 25397 on 2016/12/24.
 */
@WebFilter(filterName = "Std_numFilter", urlPatterns = "/AddStandardServlet")
public class Std_numFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        StandardBiz standardBiz = new StandardBizImpl();
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        ServletFileUpload fileUpload=new ServletFileUpload(diskFileItemFactory);
        fileUpload.setHeaderEncoding("utf-8");
        String std_num=null;
        try {
           List<FileItem>  fileItemList= fileUpload.parseRequest((HttpServletRequest) req);
           for (FileItem fileItem:fileItemList){
               if (fileItem.isFormField()){
                   if ("std_num".equals(fileItem.getFieldName())){
                       std_num=fileItem.getString();
                       break;
                   }
               }
           }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        if (null != standardBiz.getStandardByStd_num(std_num)) {
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<script type=\"text/javascript\" >alert(\"标准号已存在\");history.back()</script> ");
            printWriter.flush();
            printWriter.close();

        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
