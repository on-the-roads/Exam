package Com.UI;

import java.util.Scanner;

import Com.Bean.Student;
import Com.Dao.StudentDao;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(" 添加学生：（a）   删除学生：（b）  查询成绩：（c）");
		System.out.print("请输入操作类型:");
		  String do_type = scan.nextLine();

		  //添加学生
		  if (do_type.equals("a")) {
			  Student student=new Student();
			System.out.print("请输入学生姓名：");
			student.setName(scan.nextLine());
			System.out.print("请输入学生准考证号：");
			student.setExamid(scan.nextInt());
			System.out.print("请输入学生身份证号：");
			student.setIdnum(scan.nextInt());
			scan.nextLine();//将nextInt的Enter换行过滤掉
			System.out.print("请输入学生所在地：");
			student.setLocation(scan.nextLine());
			System.out.print("请输入学生成绩：");
			student.setGrade(scan.nextInt());
			
			try {
				StudentDao.add(student);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("-------学生信息添加成功！-------");
		}
		  
		  //删除学生
		  else if(do_type.equals("b")){
			  System.out.println("请输入要删除学生的准考证号：");
			  int examid=scan.nextInt();
			  try {
				StudentDao.delete(examid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  
		  //查找学生
		  else  if(do_type.equals("c")){
			  System.out.println("请输入要查找学生的准考证号：");
			  int examid=scan.nextInt();
			  try {
				StudentDao.find(examid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  else{
			  System.out.println("不支持此操作");
		  }
	}
}
