package com.boram.member.controller;

import java.util.ArrayList;

import com.boram.member.vo.Member;
import com.boram.member.vo.MemberDao;
import com.boram.myPage.controller.MyCart;

public class MemberController {

	MemberDao md = new MemberDao();
	MyCart ca=new MyCart();
	ArrayList<Member> memberList = md.fileRead();
	Member m= new Member();
	//md.fileSave(memberList);
	public void join(String name, int age, String id, String pwd, String phone, String address, String email) {
		
		memberList.add(new Member(name, age, id, pwd, phone, address, email));
	}

	public Member logIn(String id, String pwd) {

		for (int i = 0; i < memberList.size(); i++) {

			// ����� ���̵�� �н����尡 �Է��� ���̴ٶ� �н������ ������
			if (memberList.get(i).getId().equals(id) && memberList.get(i).getPwd().equals(pwd)) {
				//grant=memberList.get(i).getmNo();
				//memberList.get(i)�� �����԰����ÿ� nugu�޼ҵ带���� ���� �α����޴��� �˷���.
				m = memberList.get(i);
				//�α��ΰ� ���ÿ� �����س��Ѵ� ��ٱ��� �ҷ�����.
				ca.loadCart();
				return m;
			}
		}
		return null;
	}

	public String searchId(String name, String email) {

		String id = null;

		for (int i = 0; i < memberList.size(); i++) {

			if (memberList.get(i).getEmail().equals(email) && (memberList.get(i).getName().equals(name))) { // ����� ȸ�� ����
				id = memberList.get(i).getId();
			}
		}

		return id;

	}

	public String searchPwd(String name, String email) {

		String pwd = null;

		for (int i = 0; i < memberList.size(); i++) {

			if (memberList.get(i).getEmail().equals(email) && (memberList.get(i).getName().equals(name))) { // ����� ȸ�� ����
				pwd = memberList.get(i).getPwd();
			}
		}

		return pwd;

	}
	
	public Member nugu() {
		return m;
	}


}
