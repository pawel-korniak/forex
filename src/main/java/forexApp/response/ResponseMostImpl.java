package forexApp.response;

import forexApp.forexData.ForexData;
import forexApp.forexData.Record;
import forexApp.messages.Message;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * response for 'most'
 */
public class ResponseMostImpl implements Response {
    @Override
    public String getResponse(Message message) {

        Set<String> setOfDates = new HashSet<>();
        for (Record record : ForexData.getRecordList()) {
            String date = record.getDate();
            if (message.getModifier().equals("day")) {
                date = record.getDate();
            } else if (message.getModifier().equals("hour")) {
                date = record.getDate() + " " + record.getTime().split(":")[0];
            }
            setOfDates.add(date);     // get every date or hour in recordList deduplicated
        }
        List<Double> volatilityList = new ArrayList<>();
        Response response = new ResponseVolatilityImpl();
        for (String dayOrHour : setOfDates) {
            volatilityList.add(Double.valueOf(response.getResponse(new Message("volatility " + dayOrHour))));
        }
        return String.valueOf(volatilityList.stream()
                .max(Comparator.naturalOrder())
                .get());
    }
}
