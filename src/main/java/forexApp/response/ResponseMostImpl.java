package forexApp.response;

import forexApp.forexData.ForexData;
import forexApp.forexData.Record;
import forexApp.messages.Message;

import java.util.*;

public class ResponseMostImpl implements Response{
    @Override
    public String getResponse(Message message) {

            Set<String> setOfDates = new HashSet<>();
            for (Record record : ForexData.getRecordList()) {
                String date = record.getDate();
                if (message.getModifier().equals("day")){
                    date = record.getDate();
                } else if (message.getModifier().equals("hour")){
                    date = record.getDate() + " " + record.getTime().split(":")[0];
                }
                setOfDates.add(date);     // get every date or hour in recordList
            }
            List<Double> volatilityList = new ArrayList<>();
            Response response = new ResponseVolatilityImpl();
            for (String hour : setOfDates){
                volatilityList.add(Double.valueOf(response.getResponse(new Message("volatility " + hour))));
            }
            return String.valueOf(volatilityList.stream()
                    .max(Comparator.naturalOrder())
                    .get());

        }
    }
