package forexApp.forexData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForexData {
    public static List<Record> getRecordList() {
        return recordList;
    }

    private static List<Record> recordList;

    public static void load(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        recordList = new ArrayList<>();
        while (scanner.hasNextLine()){
            String[] line = scanner.nextLine().split(",");
            Record record = new Record(line[0],line[1]
                    ,Double.parseDouble(line[2])
                    ,Double.parseDouble(line[3])
                    ,Double.parseDouble(line[4])
                    ,Double.parseDouble(line[5]));
            recordList.add(record);
        }

    }


}
