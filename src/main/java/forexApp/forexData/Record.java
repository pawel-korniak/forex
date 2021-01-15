package forexApp.forexData;

public class Record {
    private String date;
    private String time;
    private double open;
    private double high;
    private double low;
    private double close;

    public Record(String date, String time, double open, double high, double low, double close) {
        this.date = date;
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                '}';
    }
}
