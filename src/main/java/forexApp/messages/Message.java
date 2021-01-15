package forexApp.messages;

import forexApp.response.*;

public class Message {
    private String argument = "";
    private String modifier = "";
    private String date = "";
    private String time = "";
    private Response response;

    public Message(String message) {
        parseMessage(message);
    }

    public Response getResponse() {
        return response;
    }

    private void parseMessage(String message) {
        String[] subMessage = message.split(" ");
        if (subMessage[0].equals("get")){
            parseGet(subMessage);
            response = new ResponseGetImpl();
        } else if (subMessage[0].equals("volatility")){
            argument = "volatility";
            date = subMessage[1];
            if (subMessage.length > 2) time = subMessage[2];
            response = new ResponseVolatilityImpl();
        } else if (subMessage[0].startsWith("most")){
            argument = "most";
            modifier = subMessage[0].split("_")[2];
            response = new ResponseMostImpl();
        } else if (subMessage[0].startsWith("average")){
            argument = "average";
            modifier = subMessage[0].split("_")[1];
            response = new ResponseAverageImpl();
        } else  if ((subMessage[0].equals("quit")) || (subMessage[0].equals("exit")) || (subMessage[0].equals("help"))){
            argument = subMessage[0];
            response = new Response() {
                @Override
                public String getResponse(Message message) {
                    return message.getArgument();
                }
            };
        } else response = new Response() {
            @Override
            public String getResponse(Message message) {
                return "No such command. type 'help' for commands list";
            }
        };
    }

    private void parseGet(String[] subMessage) {
        argument = "get";
        if (subMessage[1].equals("high"))modifier ="high";
        else if (subMessage[1].equals("low"))modifier ="low";
        else if (subMessage[1].equals("open"))modifier ="open";
        else if (subMessage[1].equals("close"))modifier ="close";
        else {
            date = subMessage[1];
            if (subMessage.length > 2) time = subMessage[2];
        }
        if (modifier!=""){
            date = subMessage[2];
            if (subMessage.length > 3) time = subMessage[3];
        }
    }

    public String getArgument() {
        return argument;
    }

    public String getModifier() {
        return modifier;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
