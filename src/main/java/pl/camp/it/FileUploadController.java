package pl.camp.it;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class FileUploadController {

    //@GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getForm() {
        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveFile(@RequestParam("file") MultipartFile file) {
        File fileOnDisk = new File("src/main/resources/" + file.getOriginalFilename());

        file.getOriginalFilename().contains(".txt");

        try {
            OutputStream os = new FileOutputStream(fileOnDisk);
            os.write(file.getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}
