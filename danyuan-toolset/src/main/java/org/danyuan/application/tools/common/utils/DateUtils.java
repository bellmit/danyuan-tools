package org.danyuan.application.tools.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期相关的共通方法的提供类。
 */
public final class DateUtils {

	/**
	 * 日期格式：yyyy-MM-dd
	 */
	public static String YYYYMMDD = "yyyy-MM-dd";
	/**
	 * 日期格式：yyyy-MM-dd HH:mm
	 */
	public static String YYYYMMDDHHmm = "yyyy-MM-dd HH:mm";
	/**
	 * 日期格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String YYYYMMDDHHmmSS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 构造函数。
	 */
	private DateUtils() {
	}

	/**
	 * 取得AP系统时间。
	 *
	 * 返 回 : AP系统时间
	 */
	public static Date getSystemDate() {
		return new Date();
	}

	/**
	 * 取得AP系统时间，不包括时分秒。
	 *
	 * 返 回 : AP系统时间
	 */
	public static Date getDate() {
		Calendar calendar = getSystemCalendar();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
		return DateUtils.convertString2Date(DateUtils.convertDate2String(calendar.getTime(), "yyyyMMdd"), "yyyyMMdd");
	}

	/**
	 * 取得AP系统时间，不包括时分秒。
	 *
	 * 返 回 : AP系统时间
	 */
	public static String getStringDate() {
		Calendar calendar = getSystemCalendar();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

		return DateUtils.convertDate2String(calendar.getTime(), "yyyyMMdd");
	}

	/**
	 * 取得AP系统时间。
	 *
	 * 返 回 : AP系统时间
	 */
	public static Date getDateTime() {
		return getSystemDate();
	}

	/**
	 * 取得AP系统时间。
	 *
	 * 返 回 : AP系统时间
	 */
	public static Calendar getSystemCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * 系统日期的年月日时分秒毫秒的文字列，取得方法。
	 *
	 * 返 回 : 年月日时分秒毫秒的文字列
	 */
	public static String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(getSystemDate());
	}

	/**
	 * 参数的字符串使用指定的格式转换日期型的方法。
	 *
	 * 参 数 : str
	 *            转换的对象
	 * 参 数 : pattern
	 *            日期时间格式的模式
	 * 返 回 : 参数null的时候返回null，字符串时按照指定的日期时间格式实行Date型转换
	 */
	public static Date convertString2Date(String str, String pattern) {
		if (str == null || "".equals(str)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(str.trim()));
		} catch (ParseException ex) {
			throw new RuntimeException(ex);
		}
		return calendar.getTime();
	}

	/**
	 * 参数的日期型使用指定的格式转换字符串的方法。
	 *
	 * 参 数 : date
	 *            转换的对象
	 * 参 数 : pattern
	 *            日期时间格式的模式
	 * 返 回 : 参数null的时候返回null，字符串时按照指定的日期时间格式实行String型转换
	 */
	public static String convertDate2String(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 取得参数日期的年
	 *
	 * 参 数 : date
	 *            日期
	 * 返 回 : 指定的年
	 */
	public static int getYear(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 取得参数日期的月
	 *
	 * 参 数 : date
	 *            日期
	 * 返 回 : 指定的月
	 */
	public static int getMonth(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 取得参数日期的日
	 *
	 * 参 数 : date
	 *            日期
	 * 返 回 : 指定的日
	 */
	public static int getDay(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);

	}

	/**
	 * 取得参数日期的时
	 *
	 * 参 数 : date
	 *            日期
	 * 返 回 : 指定的时
	 */
	public static int getHour(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 取得参数日期的分
	 *
	 * 参 数 : date
	 *            日期
	 * 返 回 : 指定的分
	 */
	public static int getMinute(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 取得参数日期的秒
	 *
	 * 参 数 : date
	 *            日期
	 * 返 回 : 指定的秒
	 */
	public static int getSecond(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 参数的日期被指定的年加算的方法。
	 *
	 * 参 数 : date
	 *            日期
	 * 参 数 : year
	 *            加算的年
	 * 返 回 : 加算后的日期
	 */
	public static Date addYear(Date date, int year) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);
		return calendar.getTime();
	}

	/**
	 * 参数的日期被指定的月加算的方法。
	 *
	 * 参 数 : date
	 *            日期
	 * 参 数 : month
	 *            加算的月
	 * 返 回 : 加算后的日期
	 */
	public static Date addMonth(Date date, int month) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	/**
	 * 参数的日期被指定的日加算的方法。
	 *
	 * 参 数 : date
	 *            日期
	 * 参 数 : day
	 *            加算的日
	 * 返 回 : 加算后的日期
	 */
	public static Date addDay(Date date, int day) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

	/**
	 * 参数的日期被指定的时加算的方法。
	 *
	 * 参 数 : date
	 *            日期
	 * 参 数 : hour
	 *            加算的时
	 * 返 回 : 加算后的日期
	 */
	public static Date addHour(Date date, int hour) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}

	/**
	 * 参数的日期被指定的分加算的方法。
	 *
	 * 参 数 : date
	 *            日期
	 * 参 数 : min
	 *            加算的分
	 * 返 回 : 加算后的日期
	 */
	public static Date addMinute(Date date, int min) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, min);
		return calendar.getTime();
	}

	/**
	 * 参数的日期被指定的秒加算的方法。
	 *
	 * 参 数 : date
	 *            日期
	 * 参 数 : second
	 *            加算的秒
	 * 返 回 : 加算后的日期
	 */
	public static Date addSecond(Date date, int second) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, second);
		return calendar.getTime();
	}

	/**
	 * 参数的日期取得当月的首日
	 *
	 * 参 数 : date
	 *            日付
	 * 返 回 : 当月的首日
	 */
	public static Date getFirstDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 参数的日期取得当月的末日
	 *
	 * 参 数 : date
	 *            日付
	 * 返 回 : 当月的末日
	 */
	public static Date getLastDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);

		return calendar.getTime();
	}

	/**
	 * 字符串是否是正确日期格式的判定
	 *
	 * 参 数 : date
	 *            日期字符串
	 * 参 数 : pattern
	 *            日期时间格式的模式
	 * 返 回 : 字符是正确的日期格式 true
	 */
	public static boolean isValidDate(String date, String pattern) {
		if (date == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			sdf.setLenient(false);
			sdf.parse(String.valueOf(date));
		} catch (ParseException ex) {
			return false;
		}
		return true;
	}

	/**
	 * 获取前后时间的日差的方法。
	 *
	 * 参 数 : stateDate
	 *            开始时间
	 * 参 数 : endDate
	 *            结束时间
	 * 返 回 : 前后时间的日差
	 */
	public static int dateDiff(Date stateDate, Date endDate) {
		return (int) ((endDate.getTime() - stateDate.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * 判断是否是闰年的方法。
	 *
	 * 参 数 : year
	 *            年份
	 * 返 回 : 闰年返回true,否则false
	 */
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 从日期FROM到日期TO的天数
	 *
	 * 参 数 : dateStrFrom
	 *            日期FROM("yyyy-MM-dd")
	 * 参 数 : dateStrTo
	 *            日期TO("yyyy-MM-dd")
	 * 作 者: 2015/06/11 Jinhui
	 * 返 回 : int 天数
	 */
	public static int getDaysIn2Day(String dateStrFrom, String dateStrTo) {

		if (StringUtils.isEmpty(dateStrFrom) || StringUtils.isEmpty(dateStrTo)) {
			return 0;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar fromCalendar = Calendar.getInstance();
		Calendar toCalendar = Calendar.getInstance();
		try {
			fromCalendar.setTime(sdf.parse(dateStrFrom.trim()));
			toCalendar.setTime(sdf.parse(dateStrTo.trim()));
		} catch (ParseException ex) {
			throw new RuntimeException(ex);
		}
		long day = (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (24 * 60 * 60 * 1000);

		return ConvUtils.convToInt(day);
	}

	/**
	 * 比较两个日期大小
	 *
	 * 参 数 : d1
	 * 参 数 : d2
	 * 返 回 : 1:d1&lt;d2;2:d1$gt;d2;3:d1=d2
	 */
	public static int compareDate(Date d1, Date d2) {
		if (d1.getTime() > d2.getTime()) {
			return 1;
		} else if (d1.getTime() < d2.getTime()) {
			return -1;
		} else {// 相等
			return 0;
		}
	}

	public static Date formatStr2Date(String dateStr, String pattern) {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHmmSS);
		if (!StringUtils.isEmpty(pattern)) {
			sdf = new SimpleDateFormat(pattern);
		}
		Date retDate;
		try {
			retDate = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return retDate;
	}
}
