package Generic_Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class Java_Utility {
	
	/**
	 * This Method is used to avoid Duplicates
	 * @return
	 * @author sheeba
	 */
	public int getRandomNum()
	{
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	//capture system date
	
	public String getsystemDateyyyyMMdd() {
		Date dateObj = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String date = simple.format(dateObj);
		return date;
		
	}	
		//get the required date
	public String getRequiredDateyyyyMMdd(int days) {
		Date dateObj=new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		simple.format(dateObj);
		Calendar cal = simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = simple.format(cal.getTime());
		return reqDate;
		
	}
	
	//get getSystemDateAndTimeForScreenshot
	public String getSystemDateAndTimeForScreenshot() {
		String dateAndtime = new Date().toString().replace(" ","_").replace(":","_");
		return dateAndtime;
	}
	
}

