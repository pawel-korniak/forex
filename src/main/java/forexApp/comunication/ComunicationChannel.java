package forexApp.comunication;

import forexApp.forexData.ForexData;
import forexApp.messages.Message;
import forexApp.response.Response;
import java.io.File;
import java.io.FileNotFoundException;

public class ComunicationChannel {
    ForexData forexData;
    public ComunicationChannel(ForexData forexData) {
        this.forexData = forexData;
    }

    public String getResponse(Message message) {
        Response response = message.getResponse();
        if (message.getArgument().equals("help")) return answerForHelp();
        return response.getResponse(message);
    }

    private String answerForHelp() {
        return """
                 Available commands :
                 - get high/low/open/close yyyy.mm.dd hh:mm
                 - get high/low/open/close yyyy.mm.dd hh
                 - get high/low/open/close yyyy.mm.dd
                 - get yyyy.mm.dd hh:mm 
                 - get yyyy.mm.dd hh
                 - get yyyy.mm.dd
                 - volatility yyyy.mm.dd-hh:mm
                 - volatility yyyy.mm.dd-hh
                 - volatility yyyy.mm.dd
                 - most_volatile_day
                 - most_volatile_hour
                 - average_minutely_volatility
                 - average_hourly_volatility
                 - average_daily_volatility
                """;
    }

    public void load(String path){
        try {
            forexData.load(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

