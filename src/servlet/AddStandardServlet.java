package servlet;

import biz.StandardBiz;
import biz.bizimpl.StandardBizImpl;
import emtity.Standard;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

/**
 * Created by 25397 on 2016/12/22.
 */
@WebServlet(name = "AddStandardServlet",urlPatterns = "/AddStandardServlet")
public class AddStandardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        ServletFileUpload fileUpload=new ServletFileUpload(diskFileItemFactory);
        fileUpload.setHeaderEncoding("utf-8");
        String realPath=request.getServletContext().getRealPath("/");
        File dir=new File(realPath,"uploadFile");
        String std_num=null,zhname=null,version=null,skeys=null,package_path=null;
        Date release_date=null,impl_date=null;
        if (!dir.exists()){
            dir.mkdir();
        }
        try {
            List<FileItem> fileItemList= fileUpload.parseRequest(request);
            for (FileItem fileItem:fileItemList){
                if(fileItem.isFormField()){
                    if("std_num".equals(fileItem.getFieldName())){
                        std_num=fileItem.getString("utf-8");
                    }else if("zhname".equals(fileItem.getFieldName())){
                        zhname=fileItem.getString("utf-8");
                    }else if("version".equals(fileItem.getFieldName())) {
                        version=fileItem.getString("utf-8");
                    }else if("skeys".equals(fileItem.getFieldName())) {
                        skeys=fileItem.getString("utf-8");
                    }else if("release_date".equals(fileItem.getFieldName())){
                        release_date=Date.valueOf(fileItem.getString("utf-8")) ;

                    }else if("impl_date".equals(fileItem.getFieldName())){
                        impl_date=Date.valueOf(fileItem.getString("utf-8"));
                    }
                }else {
                    String name=fileItem.getName();
                    File file=new File(dir,name);
                    package_path=file.getAbsolutePath();
                    fileItem.write(file);
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Standard standard=new Standard(std_num,zhname,version,skeys,release_date,impl_date,package_path);
        StandardBiz standardBiz=new StandardBizImpl();
        int count=standardBiz.addStandard(standard);
        if(count>0){
            response.sendRedirect("GetStandardByPageServlet");
        }else {
            PrintWriter printWriter=response.getWriter();
            printWriter.println(" <script type=\"text/javascript\">alert(\"添加失败\");history.back()</script>");
            printWriter.flush();
            printWriter.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
