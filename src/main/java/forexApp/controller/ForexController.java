package forexApp.controller;

import forexApp.comunication.ComunicationChannel;
import forexApp.forexData.ForexData;
import forexApp.messages.Message;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ForexController {

    List<Element> elements = new ArrayList<>();
    ComunicationChannel comunicationChannel;
    private final Marker importantMarker;
    private boolean show;

    public ForexController(Marker importantMarker) {
        this.importantMarker = importantMarker;
        comunicationChannel = new ComunicationChannel(new ForexData());
    }

    @GetMapping("index")
    String get(Model model){
        model.addAttribute("show",show);
        model.addAttribute("elements", elements);
        model.addAttribute("newElement",new Element());
        return "index";
    }

    @PostMapping("add-element")
    String addUser(@ModelAttribute Element element){
        comunicationChannel.load(LoadFileController.myPath);
        element.setResponse(comunicationChannel.getResponse(new Message(element.getRequest())));
        elements.add(element);
        if (element.getResponse().equals("exit") || element.getResponse().equals("quit")) show = false;
        log.info(importantMarker,element.getRequest() + " -> " + element.getResponse() );
        return "redirect:index";
    }
}
