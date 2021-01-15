package forexApp.response;

import forexApp.messages.Message;

import java.util.Formatter;

public class ResponseVolatilityImpl implements Response{


    @Override
    public String getResponse(Message message) {
        Response response = new ResponseGetImpl();
        Double high = Double.parseDouble(response.getResponse(new Message("get high " + message.getDate() + " " + message.getTime())));
        Double low = Double.parseDouble(response.getResponse(new Message("get low " + message.getDate() + " " + message.getTime())));
        Double volatility = high - low;
        Formatter formatter = new Formatter();
        formatter.format("%.5f", volatility);
        return formatter.toString();
    }
}
