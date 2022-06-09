package e8ilab2.apipedidos.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static String dateToString(LocalDateTime timeFormat) {
        return timeFormat.toString();
    }

    public static LocalDateTime stringToDate(String stringFormat) {
        int cutPosition = stringFormat.length() > 16 ? 19 : 16;
        String dateString = stringFormat.substring(0, cutPosition).replace("T", " ");

        if (dateString.length() == 16) {
            dateString += ":00";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);
    }
}
