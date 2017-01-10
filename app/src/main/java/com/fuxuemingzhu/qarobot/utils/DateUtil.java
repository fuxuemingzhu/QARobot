package com.fuxuemingzhu.qarobot.utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * <p>
 * Title: DateUtil
 * </p>
 * <p>
 * Description:日期帮助类
 * </p>
 *
 * @author caifugui
 * @email fuxuemingzhu@163.com
 * @date 2015年12月13日 下午9:04:39
 */
public class DateUtil {

    /**
     * 创建一个新的实例 DateUtil.
     */
    public DateUtil() {
    }

    // 获得当前应该显示的年
    public static String getYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return Integer.toString(year);
    }

    // 获得当前应该显示的月
    public static String getMonth() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        return Integer.toString(month + 1);
    }

    // 获得当前应该显示的天
    public static String getDay() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return Integer.toString(day);
    }

    // 获得当前应该显示的年月
    public static String getYearAndmonth() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return year + "年" + Integer.toString(month + 1) + "月";
    }

    // 获得当前应该显示的年月日在TextView中显示
    public static String getYearMonthDay() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year + "年" + Integer.toString(month + 1) + "月" + day;
    }

    /**
     * 日期转换成字符串 格式 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     *
     * @return str
     */
    public static String DateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    /**
     * 日期转换成字符串 格式 yyyy-MM-dd HH:mm:ss
     *
     * @return str
     */
    public static String LongToStr(long longl) {
        Date date = new Date(longl);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    /**
     * 日期转换成字符串 格式 "yyyy-MM-dd"
     *
     * @param date
     *
     * @return str
     */
    public static String DateToStr3(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        return str;
    }

    /**
     * 日期转换成字符串 格式 "yyyy-MM-dd-HH:mm"
     *
     * @param date
     *
     * @return str
     */
    public static String DateToStr2(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        String str = format.format(date);
        return str;
    }

    /**
     * <p>
     * Title: getCurrentDate
     * </p>
     * <p>
     * Description:获取当前的时间，格式 yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String str = format.format(calendar.getTime());
        return str;
    }

    /**
     * <p>
     * Title: getCurrentDate
     * </p>
     * <p>
     * Description:获取当前的时间，格式 yyyy-MM-dd
     * </p>
     *
     * @return
     */
    public static String getCurrentDate2() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String str = format.format(calendar.getTime());
        return str;
    }

    /**
     * <p>
     * Title: getCurrentDate
     * </p>
     * <p>
     * Description:获取当前的时间，格式 HH:mm:ss
     * </p>
     *
     * @return
     */
    public static String getCurrentDate3() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String str = format.format(calendar.getTime());
        return str;
    }

    /**
     * 字符串转换成日期 "yyyy-MM-dd" TODO 筛选时间 "startTime": "2014-09-15-15:30"
     * 历史数据09-15-星期1-15:10
     */
    public static boolean compareData(String Data) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String currentTime = format.format(calendar.getTime());
        String pattern = "-";
        Pattern pat = Pattern.compile(pattern);
        final String[] reData = pat.split(Data);
        final String[] cuData = pat.split(currentTime);
        Integer real = new Integer(reData[0]);
        Integer current = new Integer(cuData[0]);
        if (real - current == 0) {
            real = new Integer(reData[1]);
            current = new Integer(cuData[1]);
            if (real - current == 0) {
                currentTime = cuData[2];
                String pattern2 = " ";
                Pattern pat2 = Pattern.compile(pattern2);
                final String[] reData2 = pat2.split(currentTime);
                real = new Integer(reData[2]);
                current = new Integer(reData2[0]);
                if (real - current == 0) {
                    currentTime = reData2[1];
                    Data = reData[3];
                    pattern = ":";
                    pat = Pattern.compile(pattern);
                    String[] currentData = pat.split(currentTime);
                    String[] realData = pat.split(Data);
                    real = new Integer(realData[0]);
                    current = new Integer(currentData[0]);
                    if (real - current == 0) {
                        real = new Integer(realData[1]);
                        current = new Integer(currentData[1]);
                        if (real - current == 0) {
                            // Log.v("compareData", "true");
                            return true;
                        } else if (real - current > 0) {
                            return true;
                        } else {
                            // Log.v("compareData", "minute false");
                            return false;
                        }
                    } else if (real - current > 0) {
                        return true;
                    } else {
                        // Log.v("compareData", "hour false");
                        return false;
                    }
                } else if (real - current > 0) {
                    return true;
                } else {
                    // Log.v("compareData", "day false");
                    return false;
                }
            } else if (real - current > 0) {
                return true;
            } else {
                // Log.v("compareData", "month false");
                return false;
            }
        } else if (real - current > 0) {
            return true;
        } else {
            // Log.v("compareData", "year false");
            return false;
        }
    }

    public static boolean compareData(String Data, String Data2) {
        // Log.v("startDate", Data);
        // Log.v("endDate", Data2);
        String pattern = "-";
        Pattern pat = Pattern.compile(pattern);
        final String[] startData = pat.split(Data);
        final String[] endData = pat.split(Data2);
        Integer start = new Integer(startData[0]);
        Integer end = new Integer(endData[0]);
        if (end - start == 0) {
            start = new Integer(startData[1]);
            end = new Integer(endData[1]);
            if (end - start == 0) {
                start = new Integer(startData[2]);
                end = new Integer(endData[2]);
                if (end - start == 0) {
                    Data2 = endData[3];
                    Data = startData[3];
                    pattern = ":";
                    pat = Pattern.compile(pattern);
                    String[] currentData = pat.split(Data2);
                    String[] realData = pat.split(Data);
                    start = new Integer(realData[0]);
                    end = new Integer(currentData[0]);
                    if (end - start == 0) {
                        start = new Integer(realData[1]);
                        end = new Integer(currentData[1]);
                        if (end - start == 0) {
                            // Log.v("compareData", "true");
                            return true;
                        } else if (end - start > 0) {
                            return true;
                        } else {
                            // Log.v("compareData", "minute false");
                            return false;
                        }
                    } else if (end - start > 0) {
                        return true;
                    } else {
                        // Log.v("compareData", "hour false");
                        return false;
                    }
                } else if (end - start > 0) {
                    return true;
                } else {
                    // Log.v("compareData", "day false");
                    return false;
                }
            } else if (end - start > 0) {
                return true;
            } else {
                // Log.v("compareData", "month false");
                return false;
            }
        } else if (end - start > 0) {
            return true;
        } else {
            // Log.v("compareData", "year false");
            return false;
        }
    }

    /**
     * 字符串转换成日期"yyyy-MM-dd"
     *
     * @param str
     *
     * @return date
     */
    public static Date StrToDate(String str) {
        String formate = "yyyy-MM-dd";
        if (str.contains(".")) {
            formate = "yyyy.MM.dd";
        }
        SimpleDateFormat format = new SimpleDateFormat(formate);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 字符串转换成日期 "yyyy-MM-dd-HH:mm"
     *
     * @param str
     *
     * @return date
     */
    public static Date StrToDate2(String str) {
        String formate = "yyyy-MM-dd-HH:mm";
        if (str.contains("星期")) {
            str = "2014-" + str.substring(0, 5) + "-" + str.substring(10);
        }
        SimpleDateFormat format = new SimpleDateFormat(formate);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatePrintDate(String dateStr) {
        String result = dateStr;
        try {
            String[] weekDaysName = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
                    "星期六"};
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.get(Calendar.DAY_OF_MONTH) - 5);
            Date baseDate = calendar.getTime();
            Date currentDate = format.parse(dateStr);
            if (baseDate.before(currentDate)) {
                calendar.setTime(currentDate);
                int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                result = weekDaysName[intWeek];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * <p>
     * Title: formateStartDate
     * </p>
     * <p>
     * Description:规范约伴页的显示开始时间
     * </p>
     *
     * @param dateStr
     *
     * @return
     */
    public static String formateStartDate(String dateStr) {
        String result = dateStr;

        Date date = DateUtil.StrToDate(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        result = (month + 1) + "月" + day + "日";
        return result;
    }

    /**
     * <p>
     * Title: getWeekOfDate
     * </p>
     * <p>
     * Description:根据Date 获得这一天是星期几
     * </p>
     *
     * @param date
     *
     * @return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDaysName = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
                "星期六"};
        String[] weekDaysCode = {"0", "1", "2", "3", "4", "5", "6"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDaysCode[intWeek];
    }

    /**
     * <p>
     * Title: getWeekOfYear
     * </p>
     * <p>
     * Description:取得日期是某年的第几周
     * </p>
     *
     * @param date
     *
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
        return week_of_year;
    }

    /**
     * <p>
     * Title: getDaysOfMonth
     * </p>
     * <p>
     * Description:取得某个月有多少天
     * </p>
     *
     * @param year
     * @param month
     *
     * @return
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        int days_of_month = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days_of_month;
    }

    /**
     * 获取当日是本年的的第几天
     *
     * @return
     */
    public static int getDayOfYear() {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_YEAR);
        return day;
    }

    /**
     * <p>
     * Title: getDaysBetween
     * </p>
     * <p>
     * Description:取得两个日期之间的相差多少天
     * </p>
     *
     * @param date0
     * @param date1
     *
     * @return
     */
    public static int getDaysBetween(Date date0, Date date1) {
        GregorianCalendar cal1 = new GregorianCalendar();
        GregorianCalendar cal2 = new GregorianCalendar();
        cal1.setTime(date0);
        cal2.setTime(date1);
        double dayCount = (cal2.getTimeInMillis() - cal1.getTimeInMillis())
                / (1000 * 3600 * 24);// 从间隔毫秒变成间隔天数
        int daysBetween = (int) dayCount;
        // int daysBetween = (int) (date0.getTime() - date1.getTime() + 1000000)
        // / 86400000;// 86400000=3600*24*1000
        // 用立即数，减少乘法计算的开销
        return daysBetween;
    }

    /**
     * <p>
     * Title: getDaysBetween
     * </p>
     * <p>
     * Description:取得两个日期之间的相差多少小时
     * </p>
     *
     * @param date0
     * @param date1
     *
     * @return
     */
    public static int getHoursBetween(Date date0, Date date1) {
        GregorianCalendar cal1 = new GregorianCalendar();
        GregorianCalendar cal2 = new GregorianCalendar();
        cal1.setTime(date0);
        cal2.setTime(date1);
        double dayCount = (cal2.getTimeInMillis() - cal1.getTimeInMillis())
                / (1000 * 3600);// 从间隔毫秒变成间隔天数
        int daysBetween = (int) dayCount;
        // int daysBetween = (int) (date0.getTime() - date1.getTime() + 1000000)
        // / 86400000;// 86400000=3600*24*1000
        // 用立即数，减少乘法计算的开销
        return daysBetween;
    }

    /**
     * <p>
     * Title: getDaysBetween
     * </p>
     * <p>
     * Description:取得两个日期之间的相差多少时间
     * </p>
     *
     * @return
     */
    public static String getHoursLeft(Date startDate) {
        Date date1 = new Date();
        // 用立即数，减少乘法计算的开销
        int timesBetween = getHoursBetween(date1, startDate);// 86400000=3600*24*1000
        int daysBetween = getDaysBetween(date1, startDate);
        int hoursBetween = timesBetween % 24;
        if (daysBetween < 0) {
            return "已结束";
        }
        if (daysBetween > 0) {
            return Integer.toString(daysBetween) + "天" + Math.abs(hoursBetween)
                    + "小时后开始";
        }
        if (daysBetween == 0 && hoursBetween >= 0) {
            return Math.abs(hoursBetween) + "小时后开始";
        }
        return "已结束";
    }

    /**
     * <p>
     * Title: getDaysBetween
     * </p>
     * <p>
     * Description:取得两个日期之间的相差多少时间
     * </p>
     *
     * @return
     */
    public static String getHoursLeft(Date startDate, Date endDate) {
        Date date1 = new Date();
        // 用立即数，减少乘法计算的开销
        int timesBetween = getHoursBetween(date1, startDate);// 86400000=3600*24*1000
        int daysBetween = getDaysBetween(date1, startDate);
        int hoursBetween = timesBetween % 24;
        int endTimeBetween = getHoursBetween(date1, endDate);
        if (daysBetween < 0) {
            return "已结束";
        }
        if (daysBetween > 0) {
            return Integer.toString(daysBetween) + "天" + Math.abs(hoursBetween)
                    + "小时后开始";
        }
        if (daysBetween == 0 && hoursBetween > 0) {
            return Math.abs(hoursBetween) + "小时后开始";
        } else if (daysBetween == 0 && hoursBetween <= 0 && endTimeBetween > 0) {
            return "活动正在进行中";
        } else if (daysBetween == 0 && endTimeBetween <= 0) {
            return "已结束";
        }
        return "已结束";
    }

    /**
     * <p>
     * Title: getDaysBetween
     * </p>
     * <p>
     * Description:取得两个日期之间的相差多少周
     * </p>
     *
     * @param date0
     * @param date1
     *
     * @return
     */
    public static long getWeeksBetween(Date date0, Date date1) {
        long weeksBetween = (date0.getTime() - date1.getTime() + 1000000)
                / (86400000 * 7);// 86400000=3600*24*1000
        // 用立即数，减少乘法计算的开销
        return weeksBetween;
    }

    /**
     * Description:计算某年某月第几个星期几对应的日期格式yyyy-MM-dd
     *
     * @param year        年份
     * @param month       月份
     * @param weekOfMonth 这个月的第几周
     * @param dayOfWeek   星期几
     *
     * @return
     */
    public static String weekdate2Date(int year, int month, int weekOfMonth,
                                       int dayOfWeek) {
        Calendar c = Calendar.getInstance();
        // 计算出 x年 y月 1号 是星期几
        c.set(year, month - 1, 1);

        // 如果i_week_day =1 的话 实际上是周日
        int i_week_day = c.get(Calendar.DAY_OF_WEEK);

        int sumDay = 0;
        // dayOfWeek+1 就是星期几（星期日 为 1）
        if (i_week_day == 1) {
            sumDay = (weekOfMonth - 1) * 7 + dayOfWeek + 1;
        } else {
            sumDay = 7 - i_week_day + 1 + (weekOfMonth - 1) * 7 + dayOfWeek + 1;
        }
        // 在1号的基础上加上相应的天数
        c.set(Calendar.DATE, sumDay);
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
        return sf2.format(c.getTime());
    }

    /**
     * <p>
     * Title: getWeekDayNum
     * </p>
     * <p>
     * Description:根据传入的日期判断这个date是这个月的第几个星期几,这个函数还没写好
     * </p>
     *
     * @param date
     *
     * @return 返回值是 第几个星期/星期几 格式
     */
    public static String getWeekDayNum(Date date) {
        Calendar c = Calendar.getInstance();
        // 计算出 x年 y月 1号 是星期几
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int week = c.get(Calendar.WEEK_OF_MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // 如果i_week_day =1 的话 实际上是周日
        int i_week_day = c.get(Calendar.DAY_OF_WEEK);
        Log.i("i_week_day", Integer.toString(i_week_day));
        int sameWeekDay = 0;// 记录第一个星期和所输入Date相同的那天
        // 利用循环，判断出1号到7号那一天和所输入的星期是一样的
        for (int i = 1; i <= 7; i++) {
            c.set(Calendar.DATE, i);
            if (c.get(Calendar.DAY_OF_WEEK) == i_week_day) {
                sameWeekDay = i;
                Log.i("c seted", c.toString());
                Log.i("sameWeekDay", Integer.toString(sameWeekDay));
                break;
            }
        }
        c.set(Calendar.DAY_OF_MONTH, sameWeekDay);
        @SuppressWarnings("deprecation")
        Date firstWeekDate = new Date(year - 1900, month, sameWeekDay);
        System.out.println("firstWeekDate   " + firstWeekDate.toString());
        int weekBetween = getDaysBetween(date, firstWeekDate) / 7 + 1;
        System.out.println("weekBetween   " + weekBetween);
        System.out.println("return  " + Integer.toString(weekBetween) + "/"
                + Integer.toString(i_week_day));
        return Integer.toString(weekBetween) + "/"
                + Integer.toString(i_week_day);

    }

    /*
     * The function is to get next n days from input date
     *
     * Date oInputDate : Input date int iNoOfDay : Number of day to add
     */
    public static Date ToNextNDays(Date oInputDate, int iNoOfDay) {
        Calendar oCalendar = Calendar.getInstance();
        oCalendar.setTime(oInputDate);
        oCalendar.add(Calendar.DATE, iNoOfDay);
        return oCalendar.getTime();
    }

    /**
     * 用来处理时间转换格式的方法
     *
     * @param formate
     * @param time
     *
     * @return
     */
    private static String getConvertDateFormat(String formate, Date time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
        String date = dateFormat.format(time);
        return date;
    }

    /**
     * 得到本月的第一天
     *
     * @return
     */
    public static String getCurrentMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return getConvertDateFormat("yyyy-MM-dd", calendar.getTime());
    }

    /**
     * 得到本月的最后一天
     *
     * @return
     */
    public static String getCurrentMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getConvertDateFormat("yyyy-MM-dd", calendar.getTime());
    }

    /**
     * 获取上个月的第一天
     *
     * @return
     */
    public static String getBeforeMonthFirstDay() {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        int year = 0;
        int month = cal.get(Calendar.MONTH); // 上个月月份
        int day = cal.getActualMinimum(Calendar.DAY_OF_MONTH);// 起始天数

        if (month == 0) {
            year = cal.get(Calendar.YEAR) - 1;
            month = 12;
        } else {
            year = cal.get(Calendar.YEAR);
        }
        String endDay = year + "-" + month + "-" + day;
        return endDay;
    }

    /**
     * 获取上个月的最一天
     *
     * @return
     */
    public static String getBeforeMonthLastDay() {
        // 实例一个日历单例对象
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        int year = 0;
        int month = cal.get(Calendar.MONTH); // 上个月月份
        // int day1 = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//起始天数
        int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 结束天数

        if (month == 0) {
            // year = cal.get(Calendar.YEAR) - 1;
            month = 12;
        } else {
            year = cal.get(Calendar.YEAR);
        }
        String endDay = year + "-" + month + "-" + day;
        return endDay;
    }

    /**
     * 获取下月的第一天
     *
     * @return
     */
    public static String getNextMonthFirstDay() {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        int year = 0;
        int month = cal.get(Calendar.MONDAY) + 2; // 下个月月份
        /*
         * 如果是这样的加一的话代表本月的第一天 int month = cal.get(Calendar.MONDAY)+1; int month
		 * = cal.get(Calendar.MONTH)+1
		 */
        int day = cal.getActualMinimum(Calendar.DAY_OF_MONTH);// 起始天数

        if (month == 0) {
            year = cal.get(Calendar.YEAR) - 1;
            month = 12;
        } else {
            year = cal.get(Calendar.YEAR);
        }
        String Day = year + "-" + month + "-" + day;
        return Day;
    }

    /**
     * 获取下个月的最一天
     *
     * @return
     */
    public static String getNextMonthLastDay() {
        // 实例一个日历单例对象
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        int year = 0;
        int month = cal.get(Calendar.MONDAY) + 2; // 下个月份
        // int day1 = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//起始天数
        int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 结束天数

        if (month == 0) {
            // year = cal.get(Calendar.YEAR) - 1;
            month = 12;
        } else {
            year = cal.get(Calendar.YEAR);
        }
        String endDay = year + "-" + month + "-" + day;
        return endDay;
    }

}
