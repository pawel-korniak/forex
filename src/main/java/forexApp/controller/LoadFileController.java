package forexApp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
/**
 * controller to load file
 * offer a select file from '/data' directory
 */
public class LoadFileController {
    Path path = new Path();
    static String myPath;

    @GetMapping("")
    String start(Model model){
        model.addAttribute("paths",path.getPaths());
        model.addAttribute("path1",new Path());
        return "start";
    }

    @PostMapping("add-path")
    String getPath(@ModelAttribute Path pathArg){
        myPath = ("data/" + pathArg.getPath());
        log.info("loaded file = " + myPath);
        return "redirect:index";
    }
}
