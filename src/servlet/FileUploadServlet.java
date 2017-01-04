package servlet;

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
import java.util.List;

/**
 * Created by 25397 on 2016/12/24.
 */
@WebServlet(name = "FileUploadServlet",urlPatterns = "/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        ServletFileUpload fileUpload=new ServletFileUpload(diskFileItemFactory);
        fileUpload.setHeaderEncoding("utf-8");
        try {
            List<FileItem> fileItemList= fileUpload.parseRequest(request);
            for (FileItem fileItem:fileItemList){
                if(fileItem.isFormField()){
                    System.out.println(fileItem.getFieldName()+":"+fileItem.getString("utf-8"));
                }else {

                    String realPath=request.getServletContext().getRealPath("/");
                    File dir=new File(realPath,"uploadFile");
                    if (!dir.exists()){
                        dir.mkdir();
                    }

                    String name=fileItem.getName();
                    fileItem.write(new File(dir,name));
              }
          }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
