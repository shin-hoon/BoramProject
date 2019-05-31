package com.boram.shopping.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.boram.manager.view.ManageViewFinal;
import com.boram.member.controller.MemberController;
import com.boram.member.view.MemberView1;
import com.boram.member.vo.Member;
import com.boram.myPage.view.WB_MyPage_Main;
import com.boram.shopping.view.MainPanel;
import com.boram.shopping.view.MainView;

public class MainMouseEvent extends MouseAdapter{
	private MemberController mc = new MemberController();
	JPanel subMenu;
	JScrollPane subMenuScroll;
	String what;
	JLabel mainImage;

	public MainMouseEvent(JPanel subMenu, JScrollPane subMenuScroll,String what) {
		this.subMenu= subMenu;
		this.subMenuScroll = subMenuScroll;
		this.what = what;
	}
	
	public MainMouseEvent(String what) {
		this.what = what;
	}
	
	public MainMouseEvent(JLabel mainImage, String what) {
		this.mainImage = mainImage;
		this.what = what;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(what.equals("����޴��ݱ�")) {
			new MainThreadEvent(subMenu,subMenuScroll,-376,0,"����޴��ݱ�").start();
		}
		else if(what.equals("����޴�����")) {
			new MainThreadEvent(subMenu,subMenuScroll,-376,0,"����޴�����").start();
		}
		else if(what.equals("����")) {
			MainView.setMainPage(new MainPanel().getMainPanel());
		}
		else if(what.equals("�α���")) {
			
			if(mc.nugu()!=null) {
				// �α��� �Ǿ����� �� �ٽ� �α��� ��ư ������ �α׾ƿ��ǰ�!
				mc.logOut();
				System.out.println("logout");
				MainView.setMainPage(new MainPanel().getMainPanel());
				//�α׾ƿ� �˾�â
				JOptionPane.showMessageDialog(null, "���������� �α׾ƿ� �Ǿ����ϴ�.");
			}else {
				MainView.setMainPage(new MemberView1().getLoginView());
			}
			
		}
		else if(what.equals("����������")) {
			if(mc.nugu()==null) {
				JOptionPane.showMessageDialog(null, "�α��� ���� ���ּ���", "LogIn Error", JOptionPane.WARNING_MESSAGE);	
			}else {
				MainView.setMainPage(new WB_MyPage_Main().myPageMain());
			}
		}
		else if(what.equals("������������")) {
			System.out.println(mc.nugu().getmNo());
			/*if(mc.nugu().getName()==null ) {
				JOptionPane.showMessageDialog(null, "�α��� ���� ���ּ���", "LogIn Error", JOptionPane.WARNING_MESSAGE);
			}else if(mc.nugu().getmNo() != 0) {
				JOptionPane.showMessageDialog(null, "������ ���� ����� �Դϴ�.", "LogIn Error", JOptionPane.WARNING_MESSAGE);
			}else {*/
				MainView.setMainPage(new ManageViewFinal().manageMain());
			/* } */
		}
		else if(what.equals("��������")) {
			System.out.println(mainImage.getName());
		}
		
	}
}
