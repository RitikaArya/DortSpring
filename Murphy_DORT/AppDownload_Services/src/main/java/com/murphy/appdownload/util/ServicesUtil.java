package com.murphy.appdownload.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.murphy.appdownload.exception.InvalidInputFault;

/**
 * Contains utility functions to be used by Services
 * 
 * @version R1
 */
public class ServicesUtil {

	private static final Logger logger = LoggerFactory.getLogger(ServicesUtil.class);

	public static final String NOT_APPLICABLE = "N/A";
	public static final String SPECIAL_CHAR = "∅";
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

	public static boolean isEmpty(Object[] objs) {
		if (objs == null || objs.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Collection<?> o) {
		if (o == null || o.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(StringBuffer sb) {
		if (sb == null || sb.length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(StringBuilder sb) {
		if (sb == null || sb.length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Element nd) {
		if (nd == null) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(NamedNodeMap nd) {
		if (nd == null || nd.getLength() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Node nd) {
		if (nd == null ) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(NodeList nd) {
		if (nd == null || nd.getLength() == 0) {
			return true;
		}
		return false;
	}


	public static String getCSV(Object... objs) {
		if (!isEmpty(objs)) {
			if (objs[0] instanceof Collection<?>) {
				return getCSVArr(((Collection<?>) objs[0]).toArray());
			} else {
				return getCSVArr(objs);
			}

		} else {
			return "";
		}
	}

	private static String getCSVArr(Object[] objs) {
		if (!isEmpty(objs)) {
			StringBuffer sb = new StringBuffer();
			for (Object obj : objs) {
				sb.append(',');
				if (obj instanceof Field) {
					sb.append(extractFieldName((Field) obj));
				} else {
					sb.append(extractStr(obj));
				}
			}
			sb.deleteCharAt(0);
			return sb.toString();
		} else {
			return "";
		}
	}

	public static String buildNoRecordMessage(String queryName, Object... parameters) {
		StringBuffer sb = new StringBuffer("No Record found for query: ");
		sb.append(queryName);
		if (!isEmpty(parameters)) {
			sb.append(" for params:");
			sb.append(getCSV(parameters));
		}
		return sb.toString();
	}

	public static String extractStr(Object o) {
		return o == null ? "" : o.toString();
	}

	public static String extractFieldName(Field o) {
		return o == null ? "" : o.getName();
	}

	public static String appendLeadingCharsToInt(int input, char c, int finalSize) throws InvalidInputFault {
		if (finalSize > 0 && !isEmpty(input)) {
			return String.format("%"+c+finalSize+"d", input);
		}
		return String.valueOf(input);
	}

	/*public static String appendTrailingCharsToStr(String input, char c, int count) throws InvalidInputFault {

		String st = String.format("%0$-"+count+"s", input).replace(" ",MurphyConstant.CODE_SUCCESS);
		return st;
	}*/

	public static void enforceMandatory(String field, Object value) throws InvalidInputFault {
		if (ServicesUtil.isEmpty(value)) {
			String message = "Field=" + field + " can't be empty";
			throw new InvalidInputFault(message, null);
		}
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	public static Date resultAsDate(Object o) {
		//logger.error("[Murphy][WorkBoxFacade][resultAsDate][o]" + o);
		String template = "";
		if (o instanceof Object[]) {
			template = Arrays.asList((Object[]) o).toString();
		} else {
			template = String.valueOf(o);
		}
		Date date = null;
		try {
			if(!isEmpty(template)){
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				date = formatter.parse(template);
			}
			//logger.error("[Murphy][WorkBoxFacade][resultAsDate][o]" + o + "[template]" + template + "[date]" + date + "yyyy-MM-dd hh:mm:ss.SSS");
		} catch (ParseException e) {
			logger.error("resultAsString ParseException" + e.getMessage());
		}
		return date;
	}
	
	public static Date dateFormatForUserUpdated(Object o) {
		//logger.error("[Murphy][WorkBoxFacade][resultAsDate][o]" + o);
		String template = "";
		if (o instanceof Object[]) {
			template = Arrays.asList((Object[]) o).toString();
		} else {
			template = String.valueOf(o);
		}
		Date date = null;
		try {
			if(!isEmpty(template)){
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				date = formatter.parse(template);
			}
			//logger.error("[Murphy][WorkBoxFacade][resultAsDate][o]" + o + "[template]" + template + "[date]" + date + "yyyy-MM-dd hh:mm:ss.SSS");
		} catch (ParseException e) {
			logger.error("dateFormatForUserUpdated ParseException" + e.getMessage());
		}
		return date;
	}


	public static Date setInitialTime(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date setEndTime(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/*public static Date getDate(int i) throws ParseException {
		int x = -i;
		SimpleDateFormat format = new SimpleDateFormat(MurphyConstant.Murphy_DATE_FORMATE);
		Calendar cal = GregorianCalendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, x);
		Date tempdate = cal.getTime();
		String formattedDate = format.format(tempdate);
		Date date = format.parse(formattedDate);
		return date;
	}*/

	/*public static List<Date> getMonthIntervalDates() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(MurphyConstant.Murphy_DATE_FORMATE);
		List<Date> dateInterval = new ArrayList<Date>();
		int count = MurphyConstant.MONTH_RANGE;
		while (count >= 0) {
			Calendar calendar = Calendar.getInstance();
			Date date = null;
			if (count == 0) {
				calendar.add(Calendar.DAY_OF_MONTH, -(count));
				date = calendar.getTime();
			} else {
				calendar.add(Calendar.DAY_OF_MONTH, -(count - 1));
				date = sdf.parse(sdf.format(calendar.getTime()));
			}
			count = count - MurphyConstant.MONTH_INTERVAL;
			dateInterval.add(date);
		}
		return dateInterval;
	}*/


	public static String getDateDifferenceInHours(Date date) {
		long t1 = new Date().getTime();
		long t2 = date.getTime();
		long diffinHrs = (t1 - t2) / (60 * 60 * 1000) % 60;
		return String.valueOf(diffinHrs);

	}

	public static Calendar timeStampToCal(Object obj) {
		Calendar cal = Calendar.getInstance();
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			//logger.error("[Murphy][ServicesUtil][timeStampToCal][obj]" + obj + "obj.toString()" + obj.toString());
			cal.setTime(formatter.parse(obj.toString()));
			return cal;
		} catch (Exception e) {
			logger.error("[Murphy][ServicesUtil][timeStampToCal][getMessage]" + e.getMessage());
		}
		return null;
	}

	public static Date dateResultAsDate(Object o,String format) {
		String template = "";
		if (o instanceof Object[]) {
			template = Arrays.asList((Object[]) o).toString();
		} else {
			template = String.valueOf(o);
		}
		Date date = null;
		try {
			if(!isEmpty(template)){
				DateFormat formatter = new SimpleDateFormat(format);
				date = formatter.parse(template);
			}
			//logger.error("[Murphy][WorkBoxFacade][resultAsDate][o]" + o + "[template]" + template + "[date]" + date + "yyyy-MM-dd hh:mm:ss.SSS");
		} catch (ParseException e) {
			logger.error("resultAsString ParseException" + e.getMessage());
		}
		return date;
	}

	/*public static Calendar getSLADueDate(Calendar created, String slaString) {
		String[] sla = ((String) slaString).split("\\s+");
		System.err.println("sla[0]"+sla[0]+"sla[1]"+sla[1]);
		int slaCount = Integer.parseInt(sla[0]);
		if (MurphyConstant.DAYS.equalsIgnoreCase(sla[1])) {
			created.add(Calendar.DATE, slaCount);
		} else if (MurphyConstant.HOURS.equalsIgnoreCase(sla[1])) {
			created.add(Calendar.HOUR, slaCount);
		} else if (MurphyConstant.MINUTES.equalsIgnoreCase(sla[1])) {
			created.add(Calendar.MINUTE, slaCount);
		}
		return created;
	}

	public static Calendar getNotifyByDate(Calendar created, String threshold) {
		String[] sla = ((String) threshold).split("\\s+");
		int thresCount = Integer.parseInt(sla[0]);
		if (MurphyConstant.DAYS.equalsIgnoreCase(sla[1])) {
			created.add(Calendar.DATE, -thresCount);
		} else if (MurphyConstant.HOURS.equalsIgnoreCase(sla[1])) {
			created.add(Calendar.HOUR, -thresCount);
		} else if (MurphyConstant.MINUTES.equalsIgnoreCase(sla[1])) {
			created.add(Calendar.MINUTE, -thresCount);
		}
		return created;
	}*/

	public static String getSLATimeLeft(Calendar sla) {

		Calendar cal = Calendar.getInstance();
		long today = cal.getTimeInMillis();
		long slaTime = sla.getTimeInMillis();
		long timeLeft = slaTime - today;
		if (timeLeft > 0) {
			String timeLeftString = "";
			int seconds = (int) (timeLeft / 1000) % 60;
			int minutes = (int) ((timeLeft / (1000 * 60)) % 60);
			int hours = (int) ((timeLeft / (1000 * 60 * 60)) % 24);
			int days = (int) (timeLeft / (1000 * 60 * 60 * 24));
			timeLeftString = "" + days + " days :" + hours + " hrs :" + minutes + " min :" + seconds + "sec";
			return timeLeftString;
		} else {
			return "Breach";
		}

	}

	public static String getCompletedTimePassed(Calendar sla, Calendar completedAt) {

		Calendar cal = Calendar.getInstance();
		long completed = cal.getTimeInMillis();
		long slaTime = sla.getTimeInMillis();
		long timePassed = completed - slaTime;
		String timePassesString = "";
		logger.error("date_time sla: "+sla);
		logger.error("date_time completedAt: "+completedAt);
		logger.error("date_time timePassed: "+timePassed);

		int seconds = (int) (timePassed / 1000) % 60;
		int minutes = (int) ((timePassed / (1000 * 60)) % 60);
		int hours = (int) ((timePassed / (1000 * 60 * 60)) % 24);
		logger.error("date_time hours: "+hours);
		int days = (int) (timePassed / (1000 * 60 * 60 * 24));
		logger.error("date_time days: "+days);
		timePassesString = "" + days + " days :" + hours + " hrs :" + minutes + " min :" + seconds + "sec";
		return timePassesString;
	}

	public static float getPercntTimeCompleted(Calendar createdDate, Calendar slaDate) {
		Calendar cal = Calendar.getInstance();
		long today = cal.getTimeInMillis();
		long created = createdDate.getTimeInMillis();
		logger.error("[Murphy][ServicesUtil][timeStampToCal][today]" + today + "created" + created + "slaDate.getTimeInMillis()" + slaDate.getTimeInMillis());
		return (((float) (today - created) / (slaDate.getTimeInMillis() - created)) * 100);
	}

	public static Date getEarlierDate(int noOfDays) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, -noOfDays);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static String getDecryptedText(String encryptedText){
		if(!isEmpty(encryptedText)){
			byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
			return new String(decodedBytes);
		}
		return null;
	}

	public static String getBasicAuth(String userName ,String password) {
		String userpass = userName + ":" + password;
		return "Basic "
		+ javax.xml.bind.DatatypeConverter.printBase64Binary(userpass
				.getBytes());
	}


	public static String convertInputStreamToString(InputStream inputStream){
		try {

			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[10000];
			while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			buffer.flush();
			byte[] byteArray = buffer.toByteArray();
			return new String(byteArray);

		} catch (Exception e) {
			logger.error("[Murphy][ServicesUtil][convertInputStreamToString][error]"+e.getMessage());
		}
		return null;
	}
	public static Date resultTAsDate(Object o,String formatFrom,String formatTo)
	{
		Date date = null;
		if(!isEmpty(o) && o.toString() != ""){
			String template = "";
			if (o instanceof Object[]) {
				template = Arrays.asList((Object[]) o).toString();
			} else {
				template = String.valueOf(o);
			}
			try {
			//	"yyyy-MM-dd'T'hh:mm:ss.SSS""yyyy-MM-dd HH:mm:ss"
				
				DateFormat formatterT = new SimpleDateFormat(formatFrom);
				DateFormat newDf = new SimpleDateFormat(formatTo); 

				date = newDf.parse(newDf.format(formatterT.parse(template)));
//				logger.error("formatterT.parse(template)" +formatterT.parse(template)+"newDf.format(formatterT.parse(template)"+newDf.format(formatterT.parse(template))+"newDf.parse(newDf.format(formatterT.parse(template)))"+newDf.parse(newDf.format(formatterT.parse(template))));

//				logger.error("[Murphy][WorkBoxFacade][resultAsDate][o]"+o+"[template]"+template+"[date]"+date+"yyyy-MM-dd hh:mm:ss.SSS");
			} catch (Exception e) {
				logger.error("resultTAsDate " + e.getMessage());
			}
		}
		return date;
	}


	public SimpleDateFormat returnDateFormat(){
		return  new SimpleDateFormat("dd-MMM-yy hh:mm:ss a") ;
	}

	public static String resultDateAsString(Date date){
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a");
		return sf.format(date);
	}

	public static String resultObjDateAsString(Object obj){

		return	resultDateAsString(resultAsDate(obj));

	}

	public static String getStringFromList(List<String> stringList) {
		String returnString = "";
		for(String st : stringList){
			returnString = returnString + "'"+st+"',";
		}
		return returnString.substring(0,returnString.length()-1);
	}
	public static String getStringFromList(String[] stringList) {
		String returnString = "";
		for(String st : stringList){
			returnString = returnString + "'"+st+"',";
		}
		return returnString.substring(0,returnString.length()-1);
	}

	/* Setting and Unsetting SOCK Properties for Downtime */

	/*public static void unSetupSOCKS() {
		try {
			logger.error("before"+System.getProperty("socksProxyHost"));
			logger.error("before"+System.getProperty("socksProxyPort"));
			logger.error("before"+System.getProperty("java.net.socks.username"));
			System.setProperty("socksProxyHost", "");
			System.setProperty("socksProxyPort", "");
			System.setProperty("java.net.socks.username", "");
			logger.error("After"+System.getProperty("socksProxyHost"));
			logger.error("After"+System.getProperty("socksProxyPort"));
			logger.error("After"+System.getProperty("java.net.socks.username"));
		} catch (Exception e) {
			logger.error("Proxy Unsetup Exception : "+e.getMessage());
		}
	}*/


	public static String  getCurrentDateAtZoneInString(String format ,String zone){
		DateFormat df =  new SimpleDateFormat(format);
		df.setTimeZone(TimeZone.getTimeZone("CST"));
		return df.format(new Date());
	}

	public static Date  getCurrentDateAtZone(String format ,String zone){
		Date returnDate = new Date();
		try {
			DateFormat df =  new SimpleDateFormat(format);
			df.setTimeZone(TimeZone.getTimeZone("CST"));
			returnDate = df.parse(df.format(new Date()));

		} catch (Exception e) {
			System.err.println("[Murphy][ServicesUtil][getCurrentDateAtZone]"+e.getMessage());
		}
		return returnDate;
	}
	/*
	public static String  getPreviousDateAtZoneInString(String format ,String zone ,int count ,String value){
		
		DateFormat df =  new SimpleDateFormat(format);
		df.setTimeZone(TimeZone.getTimeZone("CST"));
		return df.format(new Date(getNotifyByDate(Calendar.getInstance(), count +" "+value).getTimeInMillis()));
	}*/
	
	public static Date resultAsDateDowntime(Object o) {
		// logger.error("[Murphy][WorkBoxFacade][resultAsDate][o]" + o);
		String template = "";
		if (o instanceof Object[]) {
			template = Arrays.asList((Object[]) o).toString();
		} else {
			template = String.valueOf(o);
		}
		Date date = null;
		try {
			if (!isEmpty(template)) {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				logger.error("[Murphy][WorkBoxFacade][resultAsDate][o][template]" + template + "[date]");
				date = formatter.parse(template);
			}
			logger.error("[Murphy][WorkBoxFacade][resultAsDate][o]" + o + "[template]" + template + "[date]" + date
					+ "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			logger.error("resultAsString ParseException" + e.getMessage());
		}
		return date;
	}

	public static String resultDateAsStringDowntime(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}

	public static Date getNextDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		return date = c.getTime();
	}

	public static Date getPrevDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -1);
		return date = c.getTime();
	}

	public static String formatDate(Date date) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formater.format(date);
		return dateString;
	}
	
	public static String getDurationBreakdown(Long millis) {
        if(millis < 0) {
        	throw new IllegalArgumentException("Duration must be greater than zero!");
        }

//        Long days = TimeUnit.MILLISECONDS.toDays(millis);
//        millis -= TimeUnit.DAYS.toMillis(days);
        Long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        Long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
//        Long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        return (hours + "hr " + minutes + "min");
    }
	
}

