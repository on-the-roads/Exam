package Com.test;

import java.util.Scanner;

import org.junit.Test;

public class test {
	@Test
	public void test1() throws Exception {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(" 添加用户： （a）   删除用户：  （b） 	 查询成绩：	（c）");
		System.out.print("请输入操作类型:");
//		  String do_type = scan.nextLine();
		  int num=scan.nextInt();
//		  System.out.println(do_type);
		  System.out.println(num);

	}
}
