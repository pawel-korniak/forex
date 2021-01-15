package forexApp.response;

import forexApp.forexData.ForexData;
import forexApp.forexData.Record;
import forexApp.messages.Message;

import java.util.Formatter;
import java.util.HashSet;
import java.util.Set;

public class ResponseAverageImpl implements Response{
    @Override
    public String getResponse(Message message) {
            double sum = 0;
            long count = 0;
            Set<String> set = new HashSet<>(); // Set deduplicates each hour and day
            for (Record record : ForexData.getRecordList()){
                switch (message.getModifier()){
                    case "minutely" : {
                        set.add(record.getDate() + " " + record.getTime());
                        break;
                    }
                    case "hourly" : {
                        set.add(record.getDate() + " " + record.getTime().split(":")[0]);
                        break;
                    }
                    case "daily" : {
                        set.add(record.getDate());
                        break;
                    }
                }
            }
            Response response = new ResponseVolatilityImpl();
            for (String date : set) {
                sum += Double.valueOf(response.getResponse(new Message("volatility " + date)));
                count++;
            }
            Formatter formatter = new Formatter();
            formatter.format("%.5f", (sum/count));
            return formatter.toString();
    }
}
