package com.cms.controller;

import com.cms.mapper.TeamMapper;
import com.cms.pojo.Team;
import com.cms.util.MybatiesUtil;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import com.cms.controller.Login;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class UploadServlet extends HttpServlet {
    private Team t = new Team();

    private static final long serialVersionUID = 1L;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = getUploadUrl(req,resp);
        System.out.println(url);
        insetAttach(url,req,resp);

    }
    private String getUploadUrl(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = getServletContext().getRealPath("/")  + UPLOAD_DIRECTORY;



        // 如果目录不存在则创建
        String fileUrl="";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(req);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        fileUrl=filePath;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "0";
        }
        return fileUrl;
    }

    private void insetAttach(String url,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String CONTENT_TYPE = "text/html; charset=GBK";
        resp.setContentType(CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        File file = null;
        try {
            file = new File(url);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        if(!file.exists()){
            //先得到文件的上级目录，并创建上级目录，在创建文件
            file.getParentFile().mkdir();
            System.out.println(file.exists());
            try {
                //创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InputStream is = null;
        try {
            is=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            out.print("<script>alert('读取文件出错');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
            System.out.println(e);
        }
        byte[] att = new byte[0];
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc=0;
            while ((rc=is.read(buff,0,100))>0){
                swapStream.write(buff, 0, rc);
            }
            att = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        t.setAttachment(att);


        SqlSession sqlSession = MybatiesUtil.getSession();
        TeamMapper mapper = sqlSession.getMapper(TeamMapper.class);

        try {
            mapper.insertAttachment(t);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        out.print("<script>alert('附件上传成功');window.location.href = 'http://localhost:8080/cms/mainPage.jsp'</script>");
        sqlSession.commit();

        sqlSession.close();
    }

}
