package servlet;

import biz.StandardBiz;
import biz.bizimpl.StandardBizImpl;
import emtity.Standard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by 25397 on 2016/12/28.
 */
@WebServlet(name = "DownloadServlet", urlPatterns = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StandardBiz standardBiz = new StandardBizImpl();
        Standard standard = standardBiz.getStandardbyId(id);
        String filename = standard.getPackage_path();
        File file = new File(filename);
        response.setContentType(request.getServletContext().getMimeType(file.getName()));
        response.setHeader("Content-Disposition","attachment;filename="+file.getName());
        InputStream inputStream=new FileInputStream(file);
        OutputStream outputStream=response.getOutputStream();
        byte[] buff=new byte[1024];
        int len=0;
        while((len=inputStream.read(buff))>0){
            outputStream.write(buff,0,len);
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
