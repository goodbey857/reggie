package top.kingdon.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.kingdon.reggie.entity.Category;
import top.kingdon.reggie.entity.R;
import top.kingdon.reggie.service.CategoryService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController()
@RequestMapping("/common")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;

    @Autowired
    CategoryService categoryService;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf('.'));
        String uuidFilename = UUID.randomUUID().toString()+suffix;

        File dir = new File(basePath);

        if(!dir.exists()){
            boolean mkdir = dir.mkdir();
        }

        try{
            file.transferTo(new File(basePath + uuidFilename));
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(uuidFilename);
        return R.success(uuidFilename);

    }


    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        try (FileInputStream fileInputStream = new FileInputStream(new File(basePath + name))) {
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024*128];
            while(fileInputStream.read(bytes)!=-1){
                outputStream.write(bytes);
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
