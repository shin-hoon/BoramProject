package com.boram.myPage.controller;

import java.util.ArrayList;

import com.boram.member.controller.MemberController;
import com.boram.member.vo.Member;
import com.boram.member.vo.MemberDao;

public class ChangeMember {
	private ArrayList<Member> MemberList = new ArrayList<>();
	private MemberDao md = new MemberDao();
	private MemberController mc = new MemberController();
	private Member chM = mc.nugu();
	//private int mNo = m.getmNo();
	private int mNo = mc.nugu().getmNo();

	public ChangeMember() {
	}

//	{// �ʱ��ӽõ����� �߰� : ����
//		// "name1",950417,"id1","pwd2","01029346330","seoul","email.com"
//		MemberList.add(new Member("name1", 950411, "id1", "pwd1", "01029346331", "seoul", "1mail.com"));
//		MemberList.add(new Member("name2", 950412, "id2", "pwd2", "01029346332", "seou1", "2mail.com"));
//		MemberList.add(new Member("name3", 950413, "id3", "pwd3", "01029346333", "seou2", "3mail.com"));
//		MemberList.add(new Member("name4", 950414, "id4", "pwd4", "01029346334", "seou3", "4mail.com"));
//		MemberList.add(new Member("name5", 950415, "id5", "pwd5", "01029346335", "seou4", "5mail.com"));
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
			MemberList.get(mNo).setId(newId);
			result = 1;
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("�߸��� ���Դϴ�!");
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
			System.out.println("�߸��� ���Դϴ�!");
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
			System.out.println("�߸��� ���Դϴ�!");
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
			System.out.println("�߸��� ���Դϴ�!");
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
			System.out.println("�߸��� ���Դϴ�!");
			result = 0;
		}
		return result;
	}

	// age
	public int ageChange(int newAge) {
		int result = 0;
		try {
			MemberList.get(mNo).setAge(newAge);
			result = 1;
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("�߸��� ���Դϴ�!");
			result = 0;
		}
		return result;
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
		String r = MemberList.get(mNo).toString();

		return r;
	}
}
