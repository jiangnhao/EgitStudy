package demo;

public class CalendarUtilTest {

	// 待测对象
	private static CalendarUtil cutil = new CalendarUtil();

	// 测试isLeapYear方法
	public static void isLeapYearTest(int[] testcase) {
		System.out.println("开始测试isLeapYear方法：");
		boolean result;
		for (int i = 0; i < testcase.length; i++) {
			try {
				result = cutil.isLeapYear(testcase[i]);
				System.out.println("用例" + (i + 1) + "实际运行结果: " + result);
			} catch (Exception e) {
				System.out.println("用例" + (i + 1) + "实际运行结果: " + e.getMessage());
			}
		}
		System.out.println("isLeapYear方法测试完成！");
	}

	// 测试dateCheck方法
	public static void dateCheckTest(String[] testcase) {
		System.out.println("开始测试dateCheckTest方法：");
		boolean flag = false;
		String[] key = new String[3];
		for(int a=0;a<testcase.length;a++) {
			key = testcase[a].split(",");
			try {
				flag = cutil.dateCheck(Integer.parseInt(key[0]), Integer.parseInt(key[1]), 
								Integer.parseInt(key[2])); 
				System.out.println("用例" + (a + 1) + "实际运行结果: " + flag);
			} catch (Exception e) {
				System.out.println("用例" + (a + 1) + "实际运行结果: " + e.getMessage());
			}
		}
		System.out.println("dateCheckTest方法测试完成！");
	}

	// 测试getWeekday方法
	public static void getWeekdayTest(String[] testcase) {
		System.out.println("开始测试getWeekdayTest方法：");
		String flag = "";
		String[] key = new String[3];
		for(int a=0;a<testcase.length;a++) {
			key = testcase[a].split(",");
			try {
				flag = cutil.getWeekday(Integer.parseInt(key[0]), Integer.parseInt(key[1]), Integer.parseInt(key[2])); 
				System.out.println("用例" + (a + 1) + "实际运行结果: " + flag);
			} catch (Exception e) {
				System.out.println("用例" + (a + 1) + "实际运行结果: " + e.getMessage());
			}
		}
		System.out.println("getWeekdayTest方法测试完成！");
	}

	// 测试dateInterval方法
	public static void dateIntervalTest(String[] testcase) {
		System.out.println("开始测试dateIntervalTest方法：");
		int flag = 0;
		String[] key = new String[3];
		for(int a=0;a<testcase.length;a++) {
			key = testcase[a].split(",");
			try {
				flag = cutil.dateInterval(Integer.parseInt(key[0]), Integer.parseInt(key[1]), Integer.parseInt(key[2]),
						Integer.parseInt(key[3]), Integer.parseInt(key[4]), Integer.parseInt(key[5]));
				System.out.println("用例" + (a + 1) + "实际运行结果: " + flag);
			} catch (Exception e) {
				System.out.println("用例" + (a + 1) + "实际运行结果: " + e.getMessage());
			}
		}
		System.out.println("dateIntervalTest方法测试完成！");
	}

	public static void main(String[] args) {
		String[] testcase = new String[] {"3001,12,5,3050,13,33","1020,2,31,3001,0,1","50,13,5,1000,2,29","1020,2,28,1020,2,31",
										"1020,3,1,3000,1,30","50,12,5,3000,1,30","3000,0,33,3050,15,5","1020,2,28,-3,1,5",
										"3001,12,5,3000,0,33","3000,4,30,1020,2,31","3050,13,33,1020,12,31",
										"3050,13,33,3000,12,31","2019,2,15,2019,11,31","3000,2,28,3050,3,31",
										"2019,2,15,3000,12,31"};
		dateIntervalTest(testcase);
	}
}
