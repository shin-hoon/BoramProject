package com.boram.member.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.boram.manager.controller.ManagerController2;
import com.boram.member.vo.Member;
import com.boram.member.vo.MemberDao;
import com.boram.shopping.view.MainView;

public class MemberView1{

	private JPanel frmLogin;
	private JTextField id;
	private JTextField pwd;

	
	// ���� ������ ȣ���� ���� JPanel ��ȯ
	public JPanel getLoginView() {
		return this.frmLogin;
	}

	/**
	 * Create the application.
	 */
	public MemberView1() {
		MemberDao md = new MemberDao();
		ArrayList<Member> mArr = md.fileRead();
		frmLogin = new JPanel();
		frmLogin.setBackground(new Color(255, 255, 255));
		frmLogin.setBounds(550, 0, 647, 596);
		frmLogin.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(73, 40, 515, 528);
		panel.setLayout(null);
		frmLogin.add(panel);
		
		JLabel BORAMLABEL = new JLabel("BORAM");
		BORAMLABEL.setBounds(40, 75, 234, 83);
		BORAMLABEL.setFont(new Font("����", Font.BOLD, 54));
		panel.add(BORAMLABEL);
		
		JLabel MEMLABEL = new JLabel("MEMBERSHIP LOGIN");
		MEMLABEL.setFont(new Font("����", Font.BOLD, 23));
		MEMLABEL.setBounds(42, 147, 340, 27);
		panel.add(MEMLABEL);
		
		JLabel IDLABEL = new JLabel("ID*");
		IDLABEL.setFont(new Font("����", Font.PLAIN, 26));
		IDLABEL.setBounds(46, 227, 109, 44);
		panel.add(IDLABEL);
		
		id = new JTextField();
		id.setBounds(208, 227, 303, 39);
		panel.add(id);
		id.setColumns(10);
		
		JLabel PWDLABEL = new JLabel("Password*");
		PWDLABEL.setFont(new Font("����", Font.PLAIN, 26));
		PWDLABEL.setBounds(48, 302, 207, 39);
		panel.add(PWDLABEL);
		
		pwd = new JPasswordField();
		pwd.setBounds(208, 302, 303, 39);
		panel.add(pwd);
		pwd.setColumns(10);
		
		JButton logIn = new JButton("\uB85C\uADF8\uC778"); // �α��� ��ư
		logIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �α��� ��ư Ŭ���ϸ�
				String userId = id.getText();
				String userPwd= pwd.getText();
				
				ManagerController2 mc = new ManagerController2();
				
				int result = mc.checkLogin(userId, userPwd);
				
				if(result == 1) {
					//�α��� ����
					MainView mv = new MainView(); // ����â�߱�
					frmLogin.setVisible(false); // �α��� â ����
					
				}else if(result == 0) {
					//�α��� ����
					
				}else {
					//������ �α���
				}
			}
		});
		
		
		logIn.setBounds(66, 370, 189, 44);
		panel.add(logIn);
		
		JButton join = new JButton("\uD68C\uC6D0\uAC00\uC785"); // ȸ������ ��ư
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ȸ������ ��ư Ŭ���ϸ�
				frmLogin.setVisible(false); // �α��� â ����
			
				JPanel joinPanel = new JPanel();
				
				joinPanel.add(new JLabel("�̸� : "));
				JTextField name = new JTextField(10);
				joinPanel.add(name);
				
				joinPanel.add(new JLabel("�������(ex: 950417) : "));
				JTextField birth = new JTextField(10);
				joinPanel.add(birth);
				
				joinPanel.add(new JLabel("���̵� : "));
				JTextField id = new JTextField(10);
				joinPanel.add(id);
				
				//���̵� �ߺ�Ȯ�� ��� ��
				JLabel idCheck = new JLabel();
				joinPanel.add(idCheck);
				
				
				
				
				joinPanel.add(new JLabel("��й�ȣ : "));
				JTextField pwd = new JTextField(10);
				joinPanel.add(pwd);
				
				joinPanel.add(new JLabel("�������ȣ : "));
				JTextField phone = new JTextField(10);
				joinPanel.add(phone);
				
				joinPanel.add(new JLabel("�ּ� : "));
				JTextField address = new JTextField(10);
				joinPanel.add(address);
				
				
				
			}
		});
		
		
		join.setBounds(301, 370, 199, 44);
		panel.add(join);
		
		JButton searchId = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30"); // ���̵� ã�� ��ư
		searchId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���̵�ã�� ��ư Ŭ���ϸ�
				panel.setVisible(false); // �α��� â ����
				
				
				
				
				
				
			}
		});
		searchId.setBounds(144, 496, 130, 27);
		panel.add(searchId);
		
		JButton searchPwd = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30"); // ��й�ȣ ã�� ��ư
		searchPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��й�ȣã�� ��ư Ŭ���ϸ�
				panel.setVisible(false); // �α��� â ����
			}
		});
		searchPwd.setBounds(287, 496, 130, 27);
		panel.add(searchPwd);
		
		
	}
}

