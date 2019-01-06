package Com.Dao;

import javax.swing.event.ListSelectionEvent;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Com.Bean.Student;
import Com.Util.Xmlutil;

public class StudentDao {
	//		 添加用户： （a）   删除用户：  （b） 	 查询成绩：	（c）
	
	/**
	 * 	// 4.创建节点
		Element ele = document.createElement("书的颜色");
		ele.setTextContent("蓝色");
		// 5.将新创建的节点加到第一本书上去
		Element element = (Element) document.getElementsByTagName("书").item(0);// Element是Node的子接口
		element.appendChild(ele);
		// 6.将内容更新到xml文档中去11
		WritetoXml(document);
	 */
	public static void add(Student student) {
		try {
			Document document=Xmlutil.getDocument();
			Element ele_exam = (Element) document.getElementsByTagName("exam").item(0);// Element是Node的子接口
			Element ele_student = document.createElement("student");
			Element ele_name = document.createElement("name");
			Element ele_location = document.createElement("location");
			Element ele_grade = document.createElement("grade");
			
			ele_student.setAttribute("Idnum", String.valueOf(student.getIdnum()));
			ele_student.setAttribute("examid", String.valueOf(student.getExamid()));
			
			ele_name.setTextContent(student.getName());
			ele_location.setTextContent(student.getLocation());
			ele_grade.setTextContent(student.getGrade()+"");
			
			ele_student.appendChild(ele_name);
			ele_student.appendChild(ele_location);
			ele_student.appendChild(ele_grade);
			
			ele_exam.appendChild(ele_student);
			
			Xmlutil.WritetoXml(document);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);//运行时异常
		}
	}
	
	public static void delete(int examid) throws Exception{
		Document document=Xmlutil.getDocument();
		NodeList list =  document.getElementsByTagName("student");
		
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			NamedNodeMap map=node.getAttributes();
			if(Integer.parseInt(map.item(1).getNodeValue())==examid){
				node.getParentNode().removeChild(node);
				Xmlutil.WritetoXml(document);
				System.out.println("学号为 " +examid+" 的学生删除成功！！");
				return;
			}
		}
		System.out.println("该学生不存在！");
	}
	
	public static void find(int examid) throws Exception{
		Document document=Xmlutil.getDocument();
		NodeList list =  document.getElementsByTagName("student");
		
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			NamedNodeMap map=node.getAttributes();
			if(Integer.parseInt(map.item(1).getNodeValue())==examid){
				System.out.println("学号为 " +examid+" 的学生:");
				Lists(node);
				return;
			}
		}
		System.out.println("该学生不存在！");
	}
	
	//遍历标签属性和值
	private static void Lists(Node node) {
		// TODO Auto-generated method stub
		if (node instanceof Element&&!node.getNodeName().equals("student")) {//打印标签和内容
			System.out.println(node.getNodeName()+" : "+node.getTextContent());
		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node nodes = list.item(i);
			Lists(nodes);
		}
	}
	
	
	}

