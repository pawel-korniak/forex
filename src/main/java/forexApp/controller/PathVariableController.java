package forexApp.controller;

import forexApp.comunication.ComunicationChannel;
import forexApp.forexData.ForexData;
import forexApp.messages.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
/**
 * created only because of HW3 specification, I don't like this PathVariable approach ;)
 * I prefer using ForexController
 */
public class PathVariableController {

    private ComunicationChannel comunicationChannel;

    public PathVariableController() {
        this.comunicationChannel = new ComunicationChannel(new ForexData());
    }

    @GetMapping("/EURUSD/{year}/{month}/{day}/{hour}/{minute}")
    @ResponseBody
    public String getByVariable(@PathVariable String year,@PathVariable String month, @PathVariable String day, @PathVariable String hour, @PathVariable String minute){
        comunicationChannel.load("DAT_MT_EURUSD_M1_202011.txt");
        String message = "get " + year + "." + month + "." + day + " " + hour + ":" + minute;
        return comunicationChannel.getResponse(new Message(message));
    }
    @GetMapping("/request/{request}")
    @ResponseBody
    public String getResponseByVariable(@PathVariable String request){
        comunicationChannel.load("DAT_MT_EURUSD_M1_202011.txt");
        return comunicationChannel.getResponse(new Message(request));
    }




}
