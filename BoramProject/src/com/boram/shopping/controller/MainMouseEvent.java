package com.boram.shopping.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.boram.manager.view.ManageViewFinal;
import com.boram.manager.vo.Product;
import com.boram.member.controller.MemberController;
import com.boram.member.view.MemberView1;
import com.boram.myPage.controller.MyCart;
import com.boram.myPage.view.WB_MyPage_Main;
import com.boram.shopping.view.ContentPanel;
import com.boram.shopping.view.FixedMainMenu;
import com.boram.shopping.view.MainPanel;
import com.boram.shopping.view.MainView;

public class MainMouseEvent extends MouseAdapter{
	private MemberController mc = new MemberController();
	private String what;
	private Product product;
	private int category;
	
	public MainMouseEvent(String what) {
		this.what = what;
	}
	
	public MainMouseEvent(Product product, String what) {
		this.product = product;
		this.what = what;
	}
	
	public MainMouseEvent(int category, String what) {
		this.category = category;
		this.what = what;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(what.equals("서브메뉴닫기")) {
			new MainThreadEvent(-376,0,"서브메뉴닫기").start();
		}
		else if(what.equals("서브메뉴열기")) {
			new MainThreadEvent(-376,0,"서브메뉴열기").start();
		}
		else if(what.equals("메인")) {
			MainView.setMainPage(new MainPanel(1).getMainPanel());
		}
		else if(what.equals("로그인")) {
			
			if(mc.nugu()!=null) {
				// 로그인 되어있을 때 다시 로그인 버튼 누르면 로그아웃되고!
				mc.logOut();
				System.out.println("logout");
				//로그아웃 팝업창
				JOptionPane.showMessageDialog(null, "정상적으로 로그아웃 되었습니다.");
				MainView.setMainPage(new MainPanel(1).getMainPanel());
				// 로그인 아이콘 바꾸기
				MainView.setMainMenu(new FixedMainMenu().getMainMenu());
			}else {
				MainView.setMainPage(new MemberView1().getLoginView());
			}
			
		}
		else if(what.equals("마이페이지")) {
			if(mc.nugu()==null) {
				JOptionPane.showMessageDialog(null, "로그인 해주세요", "LogIn Error", JOptionPane.WARNING_MESSAGE);	
			}else {
				MainView.setMainPage(new WB_MyPage_Main().myPageMain());
			}
		}
		else if(what.equals("관리자페이지")) {
			//System.out.println(mc.nugu().getmNo());
			/*if(mc.nugu().getName()==null ) {
				JOptionPane.showMessageDialog(null, "로그인 먼저 해주세요", "LogIn Error", JOptionPane.WARNING_MESSAGE);
			}else if(mc.nugu().getmNo() != 0) {
				JOptionPane.showMessageDialog(null, "권한이 없는 사용자 입니다.", "LogIn Error", JOptionPane.WARNING_MESSAGE);
			}else {*/
				MainView.setMainPage(new ManageViewFinal().manageMain());
			/* } */
		}
		else if(what.equals("상세페이지")) {
			MainView.setMainPage(new ContentPanel(product).getContent());
		}
		else if(what.equals("장바구니")) {
			if(mc.nugu()!=null) {
				JOptionPane.showMessageDialog(null, "장바구니에 추가 되었습니다. 마이페이지에서 확인 가능합니다.", "LogIn Error", JOptionPane.WARNING_MESSAGE);
				new MyCart().addCart(product);
			}
			else {
				JOptionPane.showMessageDialog(null, "로그인 후 이용 가능합니다.", "LogIn Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(what.equals("검색")) {
			if(FixedMainMenu.searchChk)	FixedMainMenu.searchChk = false;
			else 						FixedMainMenu.searchChk = true;
			MainView.setMainMenu(new FixedMainMenu().getMainMenu());
			
		}
		else if(what.equals("뒤로가기")) {
			MainView.setMainPage(new MainPanel(category).getMainPanel());
		}
		else if(what.equals("11")) {
			MainView.setMainPage(new MainPanel(11).getMainPanel());
		}
		else if(what.equals("12")) {
			MainView.setMainPage(new MainPanel(12).getMainPanel());
		}
		else if(what.equals("13")) {
			MainView.setMainPage(new MainPanel(13).getMainPanel());
		}
		else if(what.equals("14")) {
			MainView.setMainPage(new MainPanel(14).getMainPanel());
		}
		else if(what.equals("21")) {
			MainView.setMainPage(new MainPanel(21).getMainPanel());
		}
		else if(what.equals("22")) {
			MainView.setMainPage(new MainPanel(22).getMainPanel());
		}
		else if(what.equals("23")) {
			MainView.setMainPage(new MainPanel(23).getMainPanel());
		}
		else if(what.equals("24")) {
			MainView.setMainPage(new MainPanel(24).getMainPanel());
		}
		else if(what.equals("25")) {
			MainView.setMainPage(new MainPanel(25).getMainPanel());
		}
		else if(what.equals("31")) {
			MainView.setMainPage(new MainPanel(31).getMainPanel());
		}
		else if(what.equals("32")) {
			MainView.setMainPage(new MainPanel(32).getMainPanel());
		}
		else if(what.equals("33")) {
			MainView.setMainPage(new MainPanel(33).getMainPanel());
		}
		else if(what.equals("41")) {
			MainView.setMainPage(new MainPanel(41).getMainPanel());
		}
		else if(what.equals("42")) {
			MainView.setMainPage(new MainPanel(42).getMainPanel());
		}
		else if(what.equals("43")) {
			MainView.setMainPage(new MainPanel(43).getMainPanel());
		}
		else if(what.equals("44")) {
			MainView.setMainPage(new MainPanel(44).getMainPanel());
		}
		else if(what.equals("45")) {
			MainView.setMainPage(new MainPanel(45).getMainPanel());
		}
		else if(what.equals("46")) {
			MainView.setMainPage(new MainPanel(46).getMainPanel());
		}
		else if(what.equals("51")) {
			MainView.setMainPage(new MainPanel(51).getMainPanel());
		}
		else if(what.equals("52")) {
			MainView.setMainPage(new MainPanel(52).getMainPanel());
		}
		else if(what.equals("53")) {
			MainView.setMainPage(new MainPanel(53).getMainPanel());
		}
	}
}
