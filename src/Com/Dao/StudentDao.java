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
	//		 ����û��� ��a��   ɾ���û���  ��b�� 	 ��ѯ�ɼ���	��c��
	
	/**
	 * 	// 4.�����ڵ�
		Element ele = document.createElement("�����ɫ");
		ele.setTextContent("��ɫ");
		// 5.���´����Ľڵ�ӵ���һ������ȥ
		Element element = (Element) document.getElementsByTagName("��").item(0);// Element��Node���ӽӿ�
		element.appendChild(ele);
		// 6.�����ݸ��µ�xml�ĵ���ȥ11
		WritetoXml(document);
	 */
	public static void add(Student student) {
		try {
			Document document=Xmlutil.getDocument();
			Element ele_exam = (Element) document.getElementsByTagName("exam").item(0);// Element��Node���ӽӿ�
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
			throw new RuntimeException(e);//����ʱ�쳣
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
				System.out.println("ѧ��Ϊ " +examid+" ��ѧ��ɾ���ɹ�����");
				return;
			}
		}
		System.out.println("��ѧ�������ڣ�");
	}
	
	public static void find(int examid) throws Exception{
		Document document=Xmlutil.getDocument();
		NodeList list =  document.getElementsByTagName("student");
		
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			NamedNodeMap map=node.getAttributes();
			if(Integer.parseInt(map.item(1).getNodeValue())==examid){
				System.out.println("ѧ��Ϊ " +examid+" ��ѧ��:");
				Lists(node);
				return;
			}
		}
		System.out.println("��ѧ�������ڣ�");
	}
	
	//������ǩ���Ժ�ֵ
	private static void Lists(Node node) {
		// TODO Auto-generated method stub
		if (node instanceof Element&&!node.getNodeName().equals("student")) {//��ӡ��ǩ������
			System.out.println(node.getNodeName()+" : "+node.getTextContent());
		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node nodes = list.item(i);
			Lists(nodes);
		}
	}
	
	
	}

