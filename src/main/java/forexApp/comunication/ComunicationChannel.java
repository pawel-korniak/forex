package forexApp.comunication;

import forexApp.forexData.ForexData;
import forexApp.messages.Message;
import forexApp.response.Response;
import java.io.File;
import java.io.FileNotFoundException;

/**Class with main logic of the application
 */

public class ComunicationChannel {
    /**
     * forexData keeps data loaded from selected file
     */
    ForexData forexData;
    private boolean show;                                   //after typing exit or quit app just stop showing content
    public ComunicationChannel(ForexData forexData) {
        this.forexData = forexData;
        show = true;
    }

    /**
     * responding method
     * @param message string from input parsed in Message's constructor
     * @return response data as string
     */
    public String getResponse(Message message) {
        Response response = message.getResponse();
        if (message.getArgument().equals("help")) return "help";
        return response.getResponse(message);
    }

    private String answerForHelp() {
        return """
                 Available commands : "
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

    /**
     * loads file to forexData field
     * @param path
     */
    public void load(String path){
        try {
            forexData.load(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}

