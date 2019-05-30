package com.boram.shopping.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.boram.member.controller.MemberController;
import com.boram.member.view.MemberView1;
import com.boram.myPage.view.WB_MyPage_Main;
import com.boram.shopping.view.MainView;
import com.boram.shopping.view.MainPanel;

public class MainMouseEvent extends MouseAdapter{
	private MemberController mc = new MemberController();
	JPanel subMenu;
	JScrollPane subMenuScroll;
	String what;

	public MainMouseEvent(JPanel subMenu, JScrollPane subMenuScroll,String what) {
		this.subMenu= subMenu;
		this.subMenuScroll = subMenuScroll;
		this.what = what;
	}
	
	public MainMouseEvent(String what) {
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
			MainView.setMainPage(new MemberView1().getLoginView());
		}
		else if(what.equals("����������")) {
			if(mc.nugu().getName()==null) {
				JOptionPane.showMessageDialog(null, "�α��� ���� ���ּ���", "LogIn Error", JOptionPane.WARNING_MESSAGE);	
			}else {
				MainView.setMainPage(new WB_MyPage_Main().myPageMain());
			}
		}
		
	}
}
