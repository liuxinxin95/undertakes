package com.example.undertakes.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * @Author liuxinxin
 * @Description 日期工具类
 * @Date 2018/11/14 9:08
 * @Param
 * @Return
 */
@SuppressWarnings("AliControlFlowStatementWithoutBraces")
public final class DateUtil {


    public static String defaultDateTimePattern = "yyyy-MM-dd HH:mm:ss";

    public static String defaultDatePattern = "yyyy-MM-dd";

    public static String defaultTimeZone = "GMT+8";

    public static String PRE = "pre";
    public static String NEXT = "next";

    private DateUtil() {
    }

    /**
     * 获得默认的 date pattern
     */
    public static String getDateTimePattern() {
        return defaultDateTimePattern;
    }

    /**
     * 时间格式(yyyy-MM-dd)
     */
    private final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    private final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 使用默认的时间格式转换时间为字符串
     *
     * @param date
     * @return 转换后的字符串
     */
    public static String format(LocalDate date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 转换时间为字符串
     *
     * @param date
     * @param pattern 时间格式
     * @return
     */
    public static String format(LocalDate date, String pattern) {
        return Optional.ofNullable(date).map(localDate -> localDate.format(DateTimeFormatter.ofPattern(pattern))).orElse("");
    }

    /**
     * 使用默认的时间戳格式转换时间戳
     *
     * @param dateTime
     * @return 转换后的字符串
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return formatDateTime(dateTime, DATE_TIME_PATTERN);
    }

    /**
     * 转换时间戳为字符串
     *
     * @param dateTime
     * @param timePattern 时间戳格式
     * @return
     */
    public static String formatDateTime(LocalDateTime dateTime, String timePattern) {
        String finalTimePattern = Optional.ofNullable(timePattern).orElse(DATE_TIME_PATTERN);
        return Optional.ofNullable(dateTime).map(localDateTime -> localDateTime.format(DateTimeFormatter.ofPattern(finalTimePattern))).
                orElse("");
    }

    /**
     * 使用预设格式将字符串转为Date
     */
    public static Date parse(String strDate) {
        Date date = null;
        date = strDate == null || "".equals(strDate) ? null : parse(strDate, getDateTimePattern());
        return date;
    }

    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date parse(String strDate, String pattern) {
        Date date = null;
        try {
            if (strDate != null || !"".equals(strDate)) {
                date = new SimpleDateFormat(pattern).parse(strDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 字符串转换为时间
     *
     * @param date
     * @param datePattern 时间格式
     * @return
     */
    public static LocalDate stringFormatDate(String date, String datePattern) {
        return StringUtils.isNotBlank(date) ? LocalDate.parse(date, DateTimeFormatter.ofPattern(datePattern)) :
                LocalDate.now();
    }

    /**
     * 使用默认的时间格式转换字符串为时间
     *
     * @param date
     * @return
     */
    public static LocalDate stringFormatDate(String date) {
        return stringFormatDate(date, DATE_PATTERN);
    }

    /**
     * 字符串转换为时间戳
     *
     * @param dateTiem
     * @param timePattern
     * @return
     */
    public static LocalDateTime stringFormatDateTime(String dateTiem, String timePattern) {
        return StringUtils.isNotBlank(dateTiem) ? LocalDateTime.parse(dateTiem, DateTimeFormatter.ofPattern(timePattern)) :
                LocalDateTime.now();
    }

    /**
     * 使用默认的时间格式转换字符串为时间戳
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime stringFormatDateTime(String dateTime) {
        return stringFormatDateTime(dateTime, DATE_TIME_PATTERN);
    }

    /**
     * 获取本月的第一天
     *
     * @return
     */
    public static LocalDate startDateOfMonth() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取本月的最后一天
     *
     * @return
     */
    public static LocalDate endDateOfMonth() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * @return Date
     * @author
     * @title :getNowTime
     * @Description:获取当前时间，返回14位格式的date日期
     * @date 2015年7月28日 上午11:11:47
     */
    public static Date getNowTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        String now = df.format(new Date());
        Date date = null;
        try {
            return date = df.parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @return Date
     * @author
     * @title :getNowTime
     * @Description:获取当前时间，返回14位格式的date日期
     * @date 2015年7月28日 上午11:11:47
     */
    public static Date getNowDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
        String now = df.format(new Date());
        Date date = null;
        try {
            return date = df.parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取去掉时分秒的日期
     *
     * @param dateTime
     * @param pattern
     * @return
     */
    public static Date getDateLongTime(long dateTime, String pattern) {
        if (org.apache.commons.lang.StringUtils.isBlank(pattern)) {
            pattern = defaultDateTimePattern;
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);// 设置日期格式
        String now = df.format(new Date(dateTime));
        Date date = null;
        try {
            return date = df.parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @return Date
     * @author
     * @title :getNowTime
     * @Description:获取当前时间，返回14位格式的date日期
     * @date 2015年7月28日 上午11:11:47
     */
    public static String getNowDateStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
        String now = df.format(new Date());

        return now;
    }

    /**
     * @return Date
     * @author
     * @title :getNowTime
     * @Description:获取当前时间，返回14位格式的date日期
     * @date 2015年7月28日 上午11:11:47
     */
    public static String getNowTimeStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        return df.format(new Date());
    }

    /**
     * @return String
     * @author
     * @title :getYesterday
     * @Description:获得昨天时间
     * @date 2015年8月19日 上午9:27:17
     */
    public static String getYesterday() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        String yesterday = sdf.format(date);
        return yesterday;
    }

    public static Date getYesterdayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date date = calendar.getTime();
        return date;
    }

    /**
     * @return String
     * @author
     * @title :getYesterday
     * @Description:获得昨天时间
     * @date 2015年8月19日 上午9:27:17
     */
    public static String getYesterday(String timePattern) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(timePattern); // 设置时间格式
        String yesterday = sdf.format(date);
        return yesterday;
    }

    /**
     * @return String
     * @author
     * @title :getYesterday
     * @Description:获得3天前时间
     * @date 2015年8月19日 上午9:27:17
     */
    public static String get3DaysAgo(String timePattern) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(timePattern); // 设置时间格式
        String yesterday = sdf.format(date);
        return yesterday;
    }

    /**
     * @return String
     * @author
     * @title :getYesterday
     * @Description:获得7天前时间
     * @date 2015年8月19日 上午9:27:17
     */
    public static String get7DaysAgo(String timePattern) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(timePattern); // 设置时间格式
        String yesterday = sdf.format(date);
        return yesterday;
    }

    /**
     * @return String
     * @author
     * @title :getYesterday
     * @Description:获得昨天时间
     * @date 2015年8月19日 上午9:27:17
     */
    public static String getTwoMonth() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -2);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        String yesterday = sdf.format(date);
        return yesterday;
    }


    /**
     * 获取几个月前的时间
     *
     * @param num
     * @return
     */
    public static String getBeforMonth(int num, String pattern) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, num);
        Date date = calendar.getTime();
        if (StringUtils.isBlank(pattern)) {
            pattern = DateUtil.defaultDateTimePattern;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern); // 设置时间格式
        String yesterday = sdf.format(date);
        return yesterday;
    }

    /**
     * 时间加一秒
     *
     * @param date
     * @return
     */
    public static Date addOneSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, 1);
        return calendar.getTime();
    }

    /**
     * @return String
     * @author
     * @title :getTomorrow
     * @Description:获得明天时间
     * @date 2015年8月19日 上午9:28:17
     */
    public static String getTomorrow() {
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    /**
     * @return int
     * @author
     * @title :getAgeFromBirthday
     * @Description:根据生日获得年龄
     * @date 2015年7月28日 下午1:41:53
     */
    public static int getAgeFromBirthday(Date birthday) {
        int age = 0;
        if (birthday == null) {
            return age;
        } else {
            Calendar cal = Calendar.getInstance();
            if (cal.before(birthday)) {
                throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
            }
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH) + 1;
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(birthday);
            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH) + 1;
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
            age = yearNow - yearBirth;
            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth) {
                        age--;
                    }
                } else {
                    age--;
                }
            }
            return age;
        }

    }

    /**
     * @return String
     * @author
     * @title :formatDate
     * @Description:TODO
     * @date 2015年7月29日 下午5:08:55
     */
    public static String formatDate(Date date, String partem) {
        return DateUtil.formatDate(date, partem, null);
    }

    /**
     * @return String
     * @author
     * @title :formatDate
     * @Description:TODO
     * @date 2015年7月29日 下午5:08:55
     */
    public static String formatDate(Date date, String partem, String timeZoneStr) {
        if (date == null) {
            return "";
        }
        TimeZone timeZone = null;
        if (org.apache.commons.lang.StringUtils.isBlank(timeZoneStr)) {
            Calendar cal = Calendar.getInstance();
            timeZone = cal.getTimeZone();
        } else {
            timeZone = TimeZone.getTimeZone(timeZoneStr);
        }

        SimpleDateFormat df = new SimpleDateFormat(partem);
        df.setTimeZone(timeZone);
        try {
            return df.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 根据日期的字符串进行格式化
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatStringDate(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date temp = format.parse(date);
            return format.format(temp);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * @return int
     * @author
     * @title :getDayByTwoDate
     * @Description:TODO
     * @date 2015年8月5日 下午4:47:44
     */
    public static int getDayByTwoDate(Date date2, Date date1) {
        int day = 0;
        try {
            if (date2 == null || date1 == null) {
                return day;
            } else {
                day = (int) ((date2.getTime() - date1.getTime()) / 86400000);
            }
            return day;
        } catch (Exception e) {

        }
        return day;
    }

    /**
     * @return String
     * @author
     * @title :prettyTime
     * @Description:TODO
     * @date 2015年8月5日 下午4:29:27
     */
    public static String prettyTime(Date date) {

        Calendar calendar = Calendar.getInstance();

        int nowYear = calendar.get(Calendar.YEAR);
        int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
        int nowMonth = calendar.get(Calendar.MONTH);

        calendar.setTime(date);

        int preYear = calendar.get(Calendar.YEAR);
        int preDay = calendar.get(Calendar.DAY_OF_MONTH);
        int preMonth = calendar.get(Calendar.MONTH);

        int subYear = nowYear - preYear;
        int subDay = nowDay - preDay;
        int subMonth = nowMonth - preMonth;

        SimpleDateFormat dateFormat = null;
        String displayTime = "";
        if (subYear == 0) {
            if (subDay == 0) {
                dateFormat = new SimpleDateFormat("HH:mm");
            } else if (subDay == 1) {
                dateFormat = new SimpleDateFormat("HH:mm");
                displayTime = "昨天" + dateFormat;
            } else {
                dateFormat = new SimpleDateFormat("M月d日");
            }
        } else {
            dateFormat = new SimpleDateFormat("yyyy年M月d日");
        }
        displayTime = (dateFormat == null ? displayTime : dateFormat.format(date));

        return displayTime;
    }

    /***
     * 日期减一天、加一天
     *
     * @param option
     *            传入类型 pro：日期减一天，next：日期加一天
     * @param _date
     *
     * @return
     */
    public static String dateAddOrSubtractDay(String option, String date) {
        if (DateUtil.PRE.equals(option)) {
            // 时间减一天
            return DateUtil.dateAddOrSubtractDay(date, -1);

        } else if (DateUtil.NEXT.equals(option)) {
            // 时间加一天
            return DateUtil.dateAddOrSubtractDay(date, 1);
        } else {
            return date;
        }
    }


    /***
     * 日期减一天、加一天
     *
     * @param option
     *            传入类型 pro：日期减一天，next：日期加一天
     * @param _date
     *
     * @return
     */
    public static String dateAddOrSubtractDay(String date, int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cl = Calendar.getInstance();
        Date newDate = null;

        try {
            newDate = (Date) sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cl.setTime(newDate);
        cl.add(Calendar.DAY_OF_MONTH, days);
        newDate = cl.getTime();
        return sdf.format(newDate);
    }

    /***
     * 日期减一天、加一天
     *
     * @param option
     *            传入类型 pro：日期减一天，next：日期加一天
     * @param _date
     *
     * @return
     */
    public static Date dateAddOrSubtractDay(Date date, int days) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.DAY_OF_MONTH, days);
        return cl.getTime();
    }

    public static Date dateAddOrSubtractDay(String option, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        if (DateUtil.PRE.equals(option)) {
            // 时间减一天
            return DateUtil.dateAddOrSubtractDay(date, -1);

        } else if (DateUtil.NEXT.equals(option)) {
            // 时间加一天
            return DateUtil.dateAddOrSubtractDay(date, 1);
        }
        return cl.getTime();
    }

    public static String prettyTime2(Date date) {

        Calendar calendar = Calendar.getInstance();

        int nowYear = calendar.get(Calendar.YEAR);
        int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
        int nowMonth = calendar.get(Calendar.MONTH);

        calendar.setTime(date);

        int preYear = calendar.get(Calendar.YEAR);
        int preDay = calendar.get(Calendar.DAY_OF_MONTH);

        int subYear = nowYear - preYear;
        int subDay = nowDay - preDay;

        SimpleDateFormat dateFormat = null;
        String displayTime = "";
        if (subYear == 0) {
            if (subDay == 0) {
                displayTime = "今天";
            } else if (subDay == 1) {
                displayTime = "昨天";
            } else {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }
        } else {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
        displayTime = (dateFormat == null ? displayTime : dateFormat.format(date));
        return displayTime;
    }

    /**
     * date minutes 后的时间
     *
     * @param
     * @return
     */
    public static Date minutesAfterDate(Date date, Integer minutes) {
        Long millisecond = date.getTime() + minutes * 60 * 1000;
        return new Date(millisecond);
    }

    public static Date formatStrToDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return DateUtil.parse(dateString, "yyyy-MM-dd");
    }

    /**
     * @return Date
     * @author
     * @title :getNextNMinTime
     * @Description:得到后续的N分钟后的时间
     * @date 2015年8月25日 上午10:10:40
     */
    public static String getNextNMinuteTime(Integer minute) {
        Date date = new Date(System.currentTimeMillis() + minute * 60 * 1000);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        String now = df.format(date);
        return now;
    }

    /**
     * Timestamp 转 String
     *
     * @param time
     * @return
     */
    public static String timeToStr(Timestamp time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(time);
    }

    public static String dateTimeToStr(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    public static String dateToStr(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    /**
     * Timestamp 转 String
     *
     * @param time
     * @return
     */
    public static String timeToStrDate(Timestamp time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(time);
    }

    /**
     * 连个日期之间的所有日期
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> dateIntervalAll(String startDate, String endDate) {
        List<String> list = new ArrayList<String>();
        list.add(startDate);
        while (true) {
            String date = dateAddOrSubtractDay("pre", startDate);
            if (endDate.equals(date)) {
                break;
            } else {
                list.add(date);
            }
        }
        list.add(endDate);
        return list;
    }

    /**
     * 判断是否是周末
     *
     * @param date
     * @return
     */
    public static boolean isWeekend(String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date bdate;
        boolean isWeekend = true;
        try {
            bdate = df.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(bdate);
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                isWeekend = true;
            } else {
                isWeekend = false;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isWeekend;
    }

    /**
     * 判断是否是周末
     *
     * @param date
     * @return
     */
    public static boolean isWeekend(Date date, String timeZone) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone(timeZone));
        cal.setTime(date);
        boolean isWeekend = true;
        try {
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                isWeekend = true;
            } else {
                isWeekend = false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isWeekend;
    }

    public static String secToTime(long time) {
        // 小于一秒不计算
        if (time < 1000) {
            return "0";
        }
        time = time / 1000;
        String timeStr = null;
        long hour = 0;
        long minute = 0;
        // long second = 0;
        if (time <= 0) {
            return "00:00";
        } else {
            minute = time / 60;
            if (minute < 60) {
                // second = time % 60;
                timeStr = unitFormat(minute) + "分";// + unitFormat(second) + "秒"
            } else {
                hour = minute / 60;
                minute = minute % 60;
                // second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + "小时" + unitFormat(minute) + "分";// +
                // unitFormat(second)
                // +
                // "秒"
            }
        }
        return timeStr;
    }

    public static String unitFormat(long i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr = Long.toString(i);
        } else {
            retStr = "" + i;
        }
        return retStr;
    }


    public static String getMondayDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        c.add(Calendar.DATE, -dayOfWeek + 1);
        return sdf.format(c.getTime());
    }

    public static Long getMondayDateLong() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        c.add(Calendar.DATE, -dayOfWeek + 1);

        return DateUtil.parse(sdf.format(c.getTime()), "yyyy-MM-dd").getTime();
    }

    /**
     * 获得传入日期是星期几
     *
     * @param date
     * @return
     */
    public static String getWeekOfYear(String date) {
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(parseDate(date, "yyyy-MM-dd HH:mm"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
        return weeks[weekOfYear];
    }

    public static Date parseDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (Exception e) {
            return new Date();
        }
    }

    public String yesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    public static Long calculateTwoTimeSecond(Date beginDate, Date endDate) {
        long miSecond = beginDate.getTime() - endDate.getTime();
        return miSecond / 1000;
    }

    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        Long datecon = DateUtil.parse(DateUtil.formatDate(date, "yyyy-MM-dd"), "yyyy-MM-dd").getTime();

        Long today = DateUtil.parse(DateUtil.formatDate(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd").getTime();

        if (datecon.longValue() == today.longValue()) {
            return true;
        }
        return false;
    }

    public static boolean isToday(Long date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        if (date == null) {
            return false;
        }
        calendar.setTimeInMillis(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        Long starttime = calendar.getTimeInMillis();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
        Long endtime = calendar.getTimeInMillis();

        System.out.println(starttime);
        System.out.println(endtime);
        Long today = System.currentTimeMillis();
        System.out.println(today);
        if (today > starttime && today < endtime) {
            return true;
        }
        return false;
    }


    public static Long timeDifference(String startTime, String endTime) {
        Long diffValue = 0L;
        if (startTime.contains(":") && endTime.contains(":")) {
            String[] startArray = startTime.split(":");
            String[] endArray = endTime.split(":");
            Long diffValueH = (Long.valueOf(endArray[0]).longValue() - Long.valueOf(startArray[0]).longValue());
            Long diffValueM = (Long.valueOf(endArray[1]).longValue() - Long.valueOf(startArray[1]).longValue());
            diffValue += (diffValueH * 60 * 60 * 1000) + (diffValueM * 60 * 1000);
        }
        return diffValue;
    }

    public static String getTimeZone(Object timeZone) {
        String timeZoneRet = DateUtil.defaultTimeZone;
        if (timeZone != null) {
            timeZoneRet = (String) timeZone;
        }
        if (timeZone == null || org.apache.commons.lang.StringUtils.isBlank((String) timeZone)) {
            timeZoneRet = DateUtil.defaultTimeZone;
        }
        return timeZoneRet;
    }

    // 获得某天最小时间 2017-10-15 00:00:00
    public static String getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MIN);
        Date date1 = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date1);
    }

    // 获得某天最大时间 2017-10-15 23:59:59
    public static String getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        ;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        Date date1 = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date1);
    }
}
