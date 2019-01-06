package Com.UI;

import java.util.Scanner;

import Com.Bean.Student;
import Com.Dao.StudentDao;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(" ���ѧ������a��   ɾ��ѧ������b��  ��ѯ�ɼ�����c��");
		System.out.print("�������������:");
		  String do_type = scan.nextLine();

		  //���ѧ��
		  if (do_type.equals("a")) {
			  Student student=new Student();
			System.out.print("������ѧ��������");
			student.setName(scan.nextLine());
			System.out.print("������ѧ��׼��֤�ţ�");
			student.setExamid(scan.nextInt());
			System.out.print("������ѧ�����֤�ţ�");
			student.setIdnum(scan.nextInt());
			scan.nextLine();//��nextInt��Enter���й��˵�
			System.out.print("������ѧ�����ڵأ�");
			student.setLocation(scan.nextLine());
			System.out.print("������ѧ���ɼ���");
			student.setGrade(scan.nextInt());
			
			try {
				StudentDao.add(student);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("-------ѧ����Ϣ��ӳɹ���-------");
		}
		  
		  //ɾ��ѧ��
		  else if(do_type.equals("b")){
			  System.out.println("������Ҫɾ��ѧ����׼��֤�ţ�");
			  int examid=scan.nextInt();
			  try {
				StudentDao.delete(examid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  
		  //����ѧ��
		  else  if(do_type.equals("c")){
			  System.out.println("������Ҫ����ѧ����׼��֤�ţ�");
			  int examid=scan.nextInt();
			  try {
				StudentDao.find(examid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  else{
			  System.out.println("��֧�ִ˲���");
		  }
	}
}
