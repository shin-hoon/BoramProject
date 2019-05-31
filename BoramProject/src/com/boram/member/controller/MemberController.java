package com.boram.member.controller;

import java.util.ArrayList;

import javax.swing.JTextField;

import com.boram.member.vo.Member;
import com.boram.member.vo.MemberDao;

public class MemberController {

	MemberDao md = new MemberDao();

//	MyCart ca=new MyCart();

	ArrayList<Member> memberList = md.fileRead();
	static Member m= new Member();
	//md.fileSave(memberList);
//	{//�ʱ��ӽõ����� �߰� : ����
//		//"name1",950417,"id1","pwd2","01029346330","seoul","email.com" 
//		memberList.add(new Member(0,"admin",950411,"admin01","pass01","001","seoul","1mail.com"));
//		memberList.add(new Member(1,"name1",950411,"id1","pwd1","01029346331","seoul","1mail.com"));
//		memberList.add(new Member(2,"name2",950412,"id2","pwd2","01029346332","seou1","2mail.com"));
//		memberList.add(new Member(3,"name3",950413,"id3","pwd3","01029346333","seou2","3mail.com"));
//		memberList.add(new Member(4,"name4",950414,"id4","pwd4","01029346334","seou3","4mail.com"));
//		memberList.add(new Member(5,"name5",950415,"id5","pwd5","01029346335","seou4","5mail.com"));
//	}
	
	public void join(int mNo, String name, int age, String id, String pwd, String phone, String address, String email) {
		
		//ȸ����ȣ �ֱ�
		  mNo = 1;
        for(Member m : memberList) {
               System.out.printf("ȸ����ȣ",mNo++, m.getName(),m.getAge(), m.getId(), m.getPwd(), m.getPhone(),m.getAddress(), m.getEmail()); // mNo�� 1�� ����
        }
        
        // ȸ���߰�
		memberList.add(new Member(name, age, id, pwd, phone, address, email));
		System.out.println(memberList.size());
		
		for(int i=0; i<memberList.size(); i++) {
			System.out.println(memberList.get(i));
		}
		
<<<<<<< HEAD
		
		// ����
=======
>>>>>>> branch 'master' of https://github.com/shin-hoon/BoramProject
		md.fileSave(memberList);
	}

	public Member logIn(String id, String pwd) {
		

		for (int i = 0; i < memberList.size(); i++) {
			// ����� ���̵�� �н����尡 �Է��� ���̴ٶ� �н������ ������
			
			if (memberList.get(i).getId().equals(id) && memberList.get(i).getPwd().equals(pwd)) {


				System.out.println("success");
				//memberList.get(i)�� �����԰����ÿ� nugu�޼ҵ带���� ���� �α����޴��� �˷���.
				m = memberList.get(i);
			
				System.out.println(m.toString());
				System.out.println("����");
				//�α��ΰ� ���ÿ� �����س��Ѵ� ��ٱ��� �ҷ�����.
				//ca.loadCart();
				return m;
			}
			
		}

		
		System.out.println("fail");
		for(Member i : memberList) {
			System.out.println(i);
		}
		return null;
	}

	public String searchId(JTextField nametext, JTextField emailtext) {

		memberList = md.fileRead();
		
		String id = null;

		for (int i = 0; i < memberList.size(); i++) {
			
			System.out.println(memberList.get(i));
			
			if (memberList.get(i).getEmail().equals(emailtext.getText())
					&& (memberList.get(i).getName().equals(nametext.getText()))) { // ����� ȸ�� ����
				
				id = memberList.get(i).getId();
			}
		}

		return id;

	}

	public String searchPwd(JTextField nametext, JTextField emailtext) {

		String pwd = null;

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getEmail().equals(emailtext.getText()) && (memberList.get(i).getName().equals(nametext.getText()))) { // ����� ȸ�� ����
				pwd = memberList.get(i).getPwd();
			}
		}

		return pwd;

	}
	
	public Member nugu() {
		return m;
	}
	
	
	
	public int idCheck(JTextField idtext) {
		
		int result = 0;
		
		for(int i=0; i<memberList.size(); i++) {
			
			if(memberList.get(i).getId().equals(idtext.getText())) {
				return 1; // ������ ���̵� ����
			}
				
		}
		return result;
		}
	

	
}
