package e8ilab2.apipedidos.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static String dateToString(LocalDateTime t) {
        return t.toString();
    }

    public static LocalDateTime stringToDate(String s) {
        Integer cut = s.length() > 16 ? 19 : 16;
        String dateString = s.substring(0, cut).replaceAll("T", " ");

        if (dateString.length() == 16) {
            dateString += ":00";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return dateTime;
    }
}
