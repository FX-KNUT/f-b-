package fb.blind.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NowDate {
    public static String getNowDate(){
       return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"));
    }
}
