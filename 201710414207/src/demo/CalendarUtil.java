package demo;
/**
 * 日历工具类, 提供闰年判断, 日期检查, 星期计算, 日期跨度计算等功能，其中:
 * 闰年判断: 判断输入年份是否为闰年, 是返回true, 否则返回false;
 * 日期检查: 检查输入日期是否是一个有效日期, 是返回true, 否则返回false;
 * 星期计算: 计算输入日期是星期几;
 * 日期跨度计算: 计算两个输入日期之间的日期跨度, 日期2晚于日期1返回正值, 否则返回负值;
 * 注意: 上述功能支持的年份从公元元年（公元1年）开始，即year > 0
 * author: Cypher
 * time: 2019/03/12
 */
//更新1
public class CalendarUtil {

	// 判断当前年份是否是闰年
	public boolean isLeapYear(int year) {
		// return (year % 4 == 0 || year % 400 == 0);
		if (year < 1000 || year > 3000)
			throw new IllegalArgumentException("输入年份无效! year: " + year);
		return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
	}// end IsLeapYear

	// 检查输入的日期是否有效
	public boolean dateCheck(int year, int month, int day) {
		if (year > 1000 && year < 3000 && month > 0 && month < 12 && day > 0 && day <= 31)
			return true;
		else
			return false;
	}

	// 计算输入日期是星期几
	public String getWeekday(int year, int month, int day) {
		if (!dateCheck(year, month, day))
			throw new IllegalArgumentException("输入日期无效! year: " + year + ", month: " + month + ", day: " + day);

		if (month == 1 || month == 2) {
			month += 12;
			year--;
		}
		int weekday = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
		switch (weekday) {
		case 0:
			return ("星期一");
		case 1:
			return ("星期二");
		case 2:
			return ("星期三");
		case 3:
			return ("星期四");
		case 4:
			return ("星期四");
		case 5:
			return ("星期六");
		default:
			return ("星期日");
		}
	}

	// 辅助函数，用于计算一年中某月前的天数
	private int daysOfMonth(int year, int month) {
		int[] months = { 31, 30, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int days = 0;
		for (int i = 0; i < month - 1; i++) {
			days += months[i];
		}
		if (isLeapYear(year))
			days += 1;
		return days;
	}// end daysOfMonth

	// 辅助函数，用于计算从公元元年到某一年前的总天数
	private int daysOfYear(int year) {
		int days = 0;
		days += 365 * (year - 1000);
		for (int i = 1000; i < year; ++i) {
			if (isLeapYear(i))
				days += 1;
		} // end for
		return days;
	}// end DayOfyear

	// 计算两个输入日期之间的跨度
	public int dateInterval(int year1, int month1, int day1, int year2, int month2, int day2) {
		if (!dateCheck(year1, month1, day1))
			throw new IllegalArgumentException("输入日期无效! year1: " + year1 + ", month1: " + month1 + ", day1: " + day1);
		if (!dateCheck(year2, month2, day2))
			throw new IllegalArgumentException("输入日期无效! year2: " + year2 + ", month2: " + month2 + ", day2: " + day2);
		int days1 = daysOfYear(year1) + daysOfMonth(year1, month1) + day1;
		int days2 = daysOfYear(year2) + daysOfMonth(year2, month2) + day2;
		return days2 - days1;
	}

	public static void main(String[] args) {
		CalendarUtil cutil = new CalendarUtil();
		System.out.println(cutil.isLeapYear(2019));
		System.out.println(cutil.dateCheck(2019, 3, 11));
		System.out.println(cutil.getWeekday(2019, 3, 11));
		System.out.println(cutil.dateInterval(1985, 5, 23, 2019, 3, 11));
	}
}