package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class fileController {
    @RequestMapping("onefile.do")
    public String oneFileUpload(@RequestParam(name = "file") MultipartFile file, HttpServletRequest request) {
        if (file == null) {
            request.setAttribute("msg", "请选择上传的文件");
            return "result";
        }
        if (file.isEmpty()) {
            request.setAttribute("msg", "空文件");
            return "result";
        }
        try {
            String path = request.getSession().getServletContext().getRealPath("/upload");
            File root = new File(path);
            if (!root.exists()) {
                root.mkdir();
            }
            String fileName = file.getOriginalFilename();
            fileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
            //  文件拷贝
            file.transferTo(new File(root, fileName));
            request.setAttribute("msg","success");
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("msg","fail");
        }
        return "result";
    }
}
