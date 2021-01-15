package forexApp.response;

import forexApp.forexData.ForexData;
import forexApp.forexData.Record;
import forexApp.messages.Message;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseGetImpl implements Response{
    @Override
    public String getResponse(Message message) {
            String answer = "";
            double max = 0;
            double min = 10; // hardcoded starting values to see if they change
            List<Record> filteredList = ForexData.getRecordList().stream()                // Filter by date
                    .filter(x -> x.getDate().equals(message.getDate()))
                    .collect(Collectors.toList());
            if ((message.getModifier().equals("high")) || (message.getModifier().equals("low"))){ // similar operations for high and low
                for (Record record: filteredList) {
                    if (record.getTime().startsWith(message.getTime())){
                        if (record.getHigh() > max) max = record.getHigh();
                        if (record.getLow() < min) min = record.getLow();
                    }
                }
                if ((max == 0) && (min == 10)){
                    return "no data";
                } else if (message.getModifier().equals("high")){
                    return String.valueOf(max);
                } else return String.valueOf(min);

            } else if (message.getModifier().equals("open")){   // open and close are similar, later I'll join them
                for (Record record: filteredList) {
                    if (record.getDate().equals(message.getDate())){
                        if (message.getTime() != ""){
                            if ((record.getTime().equals(message.getTime())) || (record.getTime().equals(message.getTime() + ":00"))){ // dependent on format hh or hh:mm
                                answer = String.valueOf(record.getOpen());
                            }
                        } else if (record.getTime().equals("00:00")){
                            answer = String.valueOf(record.getOpen());
                        }
                    }
                }
                if (answer.equals("")){
                    answer = "no data"; // I assume that if there is no data at 00:00 answer should be 'no data'
                }
            } else if (message.getModifier().equals("close")){
                for (Record record: filteredList) {
                    if ((message.getTime() != "") && (record.getTime().equals("23:59"))) {
                        return String.valueOf(record.getClose());
                    }
                    if ((record.getTime().equals(message.getTime())) || (record.getTime().equals(message.getTime() + ":59"))){
                        return String.valueOf(record.getClose());
                    }
                }
                return "no data";
            } else {                                   // 'get' with no high/low/open/close argument
                StringBuilder sb = new StringBuilder();
                sb.append(getResponse(new Message("get open " + message.getDate() + " " + message.getTime()))+ ",");
                sb.append(getResponse(new Message("get high " + message.getDate() + " " + message.getTime()))+ ",");
                sb.append(getResponse(new Message("get low " + message.getDate() + " " + message.getTime()))+ ",");
                sb.append(getResponse(new Message("get close " + message.getDate() + " " + message.getTime())));
                return sb.toString();
            }
            return answer;
        }
}
