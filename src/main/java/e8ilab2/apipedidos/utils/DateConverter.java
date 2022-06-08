package e8ilab2.apipedidos.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static String dateToString(LocalDateTime t) {
        return t.toString();
    }

    public static LocalDateTime stringToDate(String s) {
        String dateString = s.substring(0, 19).replaceAll("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return dateTime;
    }
}
