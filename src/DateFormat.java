import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化工具
 **/
public class DateFormat {

    /** 日期格式：yyyyMMdd **/
    public static final String YYYYMMDD = "yyyyMMdd";
    /** 日期格式：yyyyMMddHHMMSSHHmmss **/
    public static final String YYYYMMDDHHMMSSHHMMSS = "yyyyMMddHHMMSSHHmmss";
    /** 日期格式：yyyyMMddHHMMSSHHmmssSSS **/
    public static final String YYYYMMDDHHMMSSHHMMSSSSS = "yyyyMMddHHMMSSHHmmssSSS";
    /** 日期格式：yyyy-MM-dd **/
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    /** 日期格式：yyyy-MM-dd HH:mm:ss **/
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyyMMdd HH:mm:ss";
    /** 日期格式：yyyy-MM-dd HH:mm:ss SSS **/
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMdd HH:mm:ss SSS";

    /**
     * 将日期格式转换成指定格式的字符串
     * @param date 要转换的日期
     * @param format 要转换的日期
     * @return 格式化后的日期字符串
     */
    public static String dateFormatToString(Date date, String format) {
        if (null == date || null == format || format.length() == 0) {
            return null;
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            String dateString = formatter.format(date);
            return dateString;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析日期格式为Date对象
     * @param dateString 日期字符串
     * @param pattern 日期格式
     * @return 解析出来的Date对象，解析失败时返回 null
     */
    public static Date parseString(String dateString, String pattern) {
        if (null == dateString || dateString.length() == 0 || null == pattern || pattern.length() == 0) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.parse(dateString);
        } catch (IllegalArgumentException e) {
            System.out.println("传入参数格式参数非法：" + pattern);
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将日期格式转换成yyyy-MM-dd的字符串格式
     * @param time 要转换的日期
     * @param format 要转换的日期
     * @return 格式化后的日期对象
     */
    public static Date dateFormatToDate(Date time, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String stringTime = formatter.format(time);
        Date date = null;
        try {
            date = formatter.parse(stringTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

//    public static void main(String[] args) {
//        System.out.println("---|" + dateFormatToString(null, null) + "|---");
//        System.out.println("---|" + dateFormatToString(null, YYYYMMDD) + "|---");
//        System.out.println("---|" + dateFormatToString(new Date(), null) + "|---");
//        System.out.println("---|" + dateFormatToString(new Date(), "123") + "|---");
//        System.out.println("---|" + dateFormatToString(new Date(), YYYYMMDDHHMMSSHHMMSS) + "|---");

//        System.out.println("---|" + parseString(null, null) + "|---");
//        System.out.println("---|" + parseString(null, YYYYMMDDHHMMSSHHMMSSSSS) + "|---");
//        System.out.println("---|" + parseString("2018", null) + "|---");
//        System.out.println("---|" + parseString("hello", null) + "|---");
//        System.out.println("---|" + parseString("2018-01-01", "yyyyhello") + "|---");
//    }
}