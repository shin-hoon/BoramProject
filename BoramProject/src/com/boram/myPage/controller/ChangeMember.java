package com.boram.myPage.controller;

import java.awt.Choice;
import java.util.ArrayList;

import com.boram.member.controller.MemberController;
import com.boram.member.vo.Member;
import com.boram.member.vo.MemberDao;

public class ChangeMember {
	private MemberDao md = new MemberDao();
	private ArrayList<Member> MemberList = md.fileRead();
	private int mNo = MemberController.m.getmNo();

	public ChangeMember() {
	}

//	{// �ʱ��ӽõ����� �߰� : ����
//		// "name1",950417,"id1","pwd2","01029346330","seoul","email.com"
//		MemberList.add(new Member(1,"name1", 950411, "id1", "pwd1", "01029346331", "seoul", "1mail.com"));
//		MemberList.add(new Member(2,"name2", 950412, "id2", "pwd2", "01029346332", "seou1", "2mail.com"));
//		MemberList.add(new Member(3,"name3", 950413, "id3", "pwd3", "01029346333", "seou2", "3mail.com"));
//		MemberList.add(new Member(4,"name4", 950414, "id4", "pwd4", "01029346334", "seou3", "4mail.com"));
//		MemberList.add(new Member(5,"name5", 950415, "id5", "pwd5", "01029346335", "seou4", "5mail.com"));
//	}

	/**
	 * ����. ���ϵ���..
	 * 
	 * @param mNo
	 *            �����ȣ -> ���ΰ͸� �����Ҽ� �ֵ��� �����ؾ���.
	 * @param new*
	 *            �ٲ��׸�
	 * @return ������1, ���н�0��ȯ.
	 */
	// id
	public int idChange(String newId) {
		int result = 0;
		try {
			for(Member i:MemberList) {
				System.out.println(i);
			}
			MemberList.get(mNo).setId(newId);
			result = 1;
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			
			System.out.println("1�߸��� ���Դϴ�!");
			result = 0;
		}

		return result;
	}

	// pwd
	public int pwChange(String newPw) {
		int result = 0;
		try {
			MemberList.get(mNo).setPwd(newPw);
			result = 1;
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("2�߸��� ���Դϴ�!");
			result = 0;
		}
		return result;
	}

	// phone
	public int phoneChange(String newPhone) {
		int result = 0;
		try {
			MemberList.get(mNo).setPhone(newPhone);
			result = 1;
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("3�߸��� ���Դϴ�!");
			result = 0;
		}
		return result;
	}

	// address
	public int addressChange(String newAddress) {
		int result = 0;
		try {
			MemberList.get(mNo).setAddress(newAddress);
			result = 1;
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("4�߸��� ���Դϴ�!");
			result = 0;
		}
		return result;
	}

	// email
	public int emailChange(String newEmail) {
		int result = 0;
		try {
			MemberList.get(mNo).setEmail(newEmail);
			result = 1;
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("5�߸��� ���Դϴ�!");
			result = 0;
		}
		return result;
	}

	// age
	public void ageChange(String newyear, String newmonth, String newday) {
		
		MemberList.get(mNo).setYear(newyear);
		MemberList.get(mNo).setMonth(newmonth);
		MemberList.get(mNo).setDay(newday);
		
//		int=0;
//		try {
//			MemberList.get(mNo).setAge(newAge);
//			result = 1;
//		} catch (NullPointerException | IndexOutOfBoundsException e) {
//			System.out.println("6�߸��� ���Դϴ�!");
//			result = 0;
//		}
//		return result;
 }
	
	public void saveChange() {
		//MemberList�� �̹� ����Ǿ�����.
		// *Change ���� nugu.get(i).*change ���� ������ �α����� �͸� �����س���.
		//�׷��⶧���� MemberList�� dao�� ���� �׳� ������ָ��.
		md.fileSave(MemberList);
	}

	/**
	 * ��ȸ�� �ӽø޴�
	 */
	public String printMem() {
		String name=MemberList.get(mNo).getName();
		String id=MemberList.get(mNo).getId();
		String year = MemberList.get(mNo).getYear();
		String month = MemberList.get(mNo).getMonth();
		String day = MemberList.get(mNo).getDay();
		String phone=MemberList.get(mNo).getPhone();
		int address=MemberList.get(mNo).getmNo();
		String email=MemberList.get(mNo).getEmail();
		
		return name+"���� �����Դϴ�.\nid : "+id+"\n������� : "+year+month+day+"\n��ȭ��ȣ : "+phone+"\n�̸��� : "+email;
	}
	public void printAllMem() {
		System.out.println("MemberList ��ü���");
		System.out.println("dao���ؼ� �ٷ� �о�°�.");
		MemberList.clear();
		ArrayList<Member> MemberList = md.fileRead();
		for(Member i:MemberList) {
			System.out.println(i.toString());
		}
	}
	
}
