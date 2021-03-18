package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static String getTimeStamp() {
		SimpleDateFormat dateFormater = new SimpleDateFormat("ddMMYYYYHHmmss");
		Date date = new Date();
		String timeStamp = dateFormater.format(date);
		return timeStamp;
	}
	
}
