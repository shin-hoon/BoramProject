package com.boram.myPage.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.boram.myPage.controller.*;
import com.boram.shopping.view.MainView;

public class WB_MyPageView {
	ChangeMember cm = new ChangeMember();
	public static final int FWID = 718;
	public static final int FHIT = 500;
	private JPanel myPageView;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static JTextArea ta;
//	private ta = new JTextArea();
	//private int gran = /* mem.getGrant() */0;
//	{// �ʱ��ӽõ����� �߰� : ����
//	// "name1",950417,"id1","pwd2","01029346330","seoul","email.com"
//	memberList.add(new Member(1, "1", 1, "1", "1", "1", "1", "1"));
//	memberList.add(new Member(2, "name1", 950411, "id1", "pwd1", "01029346331", "seoul", "1mail.com"));
//	memberList.add(new Member(3, "name2", 950412, "id2", "pwd2", "01029346332", "seou1", "2mail.com"));
//	memberList.add(new Member(4, "name3", 950413, "id3", "pwd3", "01029346333", "seou2", "3mail.com"));
//	memberList.add(new Member(5, "name4", 950414, "id4", "pwd4", "01029346334", "seou3", "4mail.com"));
//	memberList.add(new Member(6, "name5", 950415, "id5", "pwd5", "01029346335", "seou4", "5mail.com"));
//}

	// ���� ������ ȣ���� ���� JPanel ��ȯ
	public JPanel getmyPageView() {
		return this.myPageView;
	}

	public WB_MyPageView() {
		myPageView = new JPanel();
		myPageView.setBackground(Color.WHITE);
		myPageView.setBounds(0, 0, FWID, 1000);
		myPageView.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, FWID, 90);
		myPageView.add(panel);
		panel.setLayout(null);

		JLabel lblMyPage = new JLabel("My Page ");
		lblMyPage.setBounds(0, 32, 218, 58);
		lblMyPage.setBackground(Color.BLACK);
		lblMyPage.setForeground(Color.BLACK);
		lblMyPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyPage.setFont(new Font("����", Font.ITALIC, 50));
		panel.add(lblMyPage);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 90, 718, 955);

		myPageView.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("���̵� ���� :");
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setBounds(50, 51, 121, 27);
		panel_2.add(label);

		JLabel label_0 = new JLabel("��й�ȣ ���� :");
		label_0.setBounds(71, 137, 80, 15);
		panel_2.add(label_0);

		JLabel label_1 = new JLabel("���� ���� :");
		label_1.setBounds(71, 209, 80, 15);
		panel_2.add(label_1);

		JLabel label_2 = new JLabel("�ּ� ���� :");
		label_2.setBounds(71, 282, 80, 15);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("�̸��� ���� :");
		label_3.setBounds(71, 337, 80, 15);
		panel_2.add(label_3);

		JLabel label_4 = new JLabel("��ȭ��ȣ ���� :");
		label_4.setBounds(71, 405, 80, 15);
		panel_2.add(label_4);

		// id
		textField = new JTextField("");
		textField.setBackground(Color.WHITE);
		textField.setBounds(180, 46, 220, 40);
		panel_2.add(textField);
		textField.setColumns(10);

		// pw
		textField_1 = new JTextField("");
		textField_1.setColumns(10);
		textField_1.setBounds(180, 112, 220, 40);
		panel_2.add(textField_1);

		// age
		textField_2 = new JTextField("");
		textField_2.setColumns(10);
		textField_2.setBounds(180, 184, 220, 40);
		panel_2.add(textField_2);

		// address
		textField_3 = new JTextField("");
		textField_3.setColumns(10);
		textField_3.setBounds(180, 257, 220, 40);
		panel_2.add(textField_3);

		// email
		textField_4 = new JTextField("");
		textField_4.setColumns(10);
		textField_4.setBounds(180, 324, 220, 40);
		panel_2.add(textField_4);

		// phone
		textField_5 = new JTextField("");
		textField_5.setColumns(10);
		textField_5.setBounds(180, 392, 220, 40);
		panel_2.add(textField_5);

		JButton btnChange = new JButton("����");

		btnChange.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnChange1();
			}
		});
		btnChange.setBounds(81, 636, 97, 23);
		panel_2.add(btnChange);

		JLabel lblResult = new JLabel("��� : ");
		lblResult.setBounds(12, 470, 57, 15);
		panel_2.add(lblResult);

		// ����ڰ� �����Ұ����ϰ� �����Ұ�.
//		JTextArea ta = new JTextArea("");
		
		ta = new JTextArea();
		ta.setBackground(Color.WHITE);
		//ta.setBounds(14, 472, 690, 170);
		
		JScrollPane sp = new JScrollPane(ta);
		sp.setBounds(12, 495, 679, 106);
		panel_2.add(sp);

		
		JButton btnPre = new JButton("����ȭ��");
		btnPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			MainView.setMainPage(new WB_MyPage_Main().myPageMain());
			
			
			}
		});
		btnPre.setBounds(252, 634, 105, 27);
		panel_2.add(btnPre);

		// ȸ������ ��� temp
		JButton btnTemp_1 = new JButton("������ȸ");
		btnTemp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.append(cm.printMem()+"\n");
				cm.printAllMem();
			}
		});
		btnTemp_1.setBounds(416, 634, 105, 27);
		panel_2.add(btnTemp_1);

	}

	/**
	 * �Է��� �׸� ��������. ������ ���� textArea�� ��� ������ �����̾�����textArea�� �������׾������. �ؿ� ����޼ҵ忡��
	 * textArea�� ������ ����Ǿ����� ���.
	 */
	public void btnChange1() {
		String nId = textField.getText();
		String nPw = textField_1.getText();
		// int nAge = Integer.parseInt( textField_2.getText());
		String nAge = textField_2.getText();
		String nAdd = textField_3.getText();
		String nEmail = textField_4.getText();
		String nPh = textField_5.getText();
		int count = 0;

		if (!(nId.equals(""))) {
			idChange(nId);
			count++;
		}
		if (!(nPw.equals(""))) {
			pwChange(nPw);
			count++;
		}
		if (!(nAge.equals(""))) {
			int nAgeI = 0;
			try {
				nAgeI = Integer.parseInt(nAge);
				ageChange(nAgeI);
			} catch (NullPointerException | IndexOutOfBoundsException e) {
				// �������Է�.���
			}
			// ageChange(nAge);
			count++;
		}
		if (!(nAdd.equals(""))) {
			addressChange(nAdd);
			count++;
		}
		if (!(nEmail.equals(""))) {
			emailChange(nEmail);
			count++;
		}
		if (!(nPh.equals(""))) {
			phoneChange(nPh);
			count++;
		}
		// .append(count+"���� ���������� �Ϸ�Ǿ����ϴ�.");
		// ���
		if (count == 0) {
			// �ؽ�Ʈ ���� "������ ������ �����ϴ�." ���
			ta.append("������ ������ �����ϴ�!\n");
		}else {
			totResult();
		}
		
		/*
		 * else { // �ؽ�Ʈ���� // count +" ���� ���������� �Ϸ�Ǿ����ϴ�." ta.append(count +
		 * " ���� ���������� �Ϸ�Ǿ����ϴ�."); }
		 */
	}

	
	/**
	 * @param newId �ٲܾ��̵�
	 * ����/���� ta(TextArea)�� ���
	 */
	public void idChange(String newId) {
		int result = cm.idChange(newId);
		if (result == 0) {
			ta.append("���̵� ���濡 �����Ͽ����ϴ�.\n");
		} else {
			ta.append("���̵� ���濡 �����Ͽ����ϴ�.\n");
		}
	}

	
	/**
	 * @param newId �ٲܺ�й�ȣ
	 * ����/���� ta(TextArea)�� ���
	 */
	public void pwChange(String newPw) {
		int result = cm.pwChange(newPw);
		if (result == 0) {
			ta.append("��й�ȣ ���濡 �����Ͽ����ϴ�.\n");
		} else {
			ta.append("��й�ȣ ���濡 �����Ͽ����ϴ�.\n");
		}
	}

	/**
	 * @param newId �ٲ� ��ȭ��ȣ
	 * ����/���� ta(TextArea)�� ���
	 */
	public void phoneChange(String newPh) {
		int result = cm.phoneChange(newPh);
		if (result == 0) {
			ta.append("��ȭ��ȣ ���濡 �����Ͽ����ϴ�.\n");
		} else {
			ta.append("��ȭ��ȣ ���濡 �����Ͽ����ϴ�.\n");
		}
	}

	/**
	 * @param newId �ٲ��ּ�
	 * ����/���� ta(TextArea)�� ���
	 */
	public void addressChange(String newAdd) {
		int result = cm.addressChange(newAdd);
		if (result == 0) {
			ta.append("�ּ� ���濡 �����Ͽ����ϴ�.\n");
		} else {
			ta.append("�ּ� ���濡 �����Ͽ����ϴ�.\n");
		}
	}

	/**
	 * @param newId �ٲ��̸���
	 * ����/���� ta(TextArea)�� ���
	 */
	public void emailChange(String newEmail) {
		int result = cm.emailChange(newEmail);
		if (result == 0) {
			ta.append("�̸��� ���濡 �����Ͽ����ϴ�.\n");
		} else {
			ta.append("�̸��� ���濡 �����Ͽ����ϴ�.\n");
		}
	}

	
	
	/**
	 * @param newId �ٲܳ���
	 * ����/���� ta(TextArea)�� ���
	 */
	public void ageChange(int newAge) {
		int result = cm.ageChange(newAge);
		if (result == 0) {
			ta.append("���� ���濡 �����Ͽ����ϴ�.\n");
		} else {
			ta.append("���� ���濡 �����Ͽ����ϴ�.\n");
		}
	}
	public void totResult() {
		cm.saveChange();
		ta.append("���������� �����Ͽ����ϴ�.\n");
	}
}
