package com.boram.shopping.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.boram.member.controller.MemberController;
import com.boram.shopping.controller.MainMouseEvent;

public class FixedMainMenu {
	private JPanel mainMenu;
	// ���� ������ JPanel�� ���� JLabel(�� ���� => ���� ����, �˻�, �α���, ���� ������, ������ ������)
	private JLabel kategorie, logo, search, login, myPage, adminPage;	
	
	public JPanel getMainMenu() {
		return this.mainMenu;
	}
	
	/**
	 *   ���� ������ JPanel(�� ����, ����޴�, ���� ����, �˻�, �α���, ���� ������, ������ ������)
	 *   ���� ������ JPanel�� ���� JLabel(�� ���� => ���� ����, �˻�, �α���, ���� ������, ������ ������)
	 */
	public FixedMainMenu() {
		mainMenu = new JPanel();
		mainMenu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mainMenu.setBackground(new Color(255, 255, 255));
		mainMenu.setBounds(-16, 0, 729, 79);
		mainMenu.setVisible(true);
		mainMenu.setLayout(null);
		
		
		kategorie = new JLabel(new ImageIcon(MainView.PATH + "image\\MainImage\\kategorie.jpg"));
		kategorie.setBackground(new Color(255, 204, 51));
		kategorie.setBounds(30, 12, 55, 57);
		mainMenu.add(kategorie);
		
		logo = new JLabel("Boram");
		logo.setFont(new Font("Broadway", Font.BOLD, 50));
		logo.setBounds(118, -2, 201, 79);
		mainMenu.add(logo);
		
		adminPage = new JLabel(new ImageIcon(MainView.PATH + "image\\MainImage\\adminPage.jpg"));
		adminPage.setBounds(540, 26, 30, 32);
		adminPage.setVisible(false);
		mainMenu.add(adminPage);
		
		if(MemberController.m != null) {
			if(MemberController.m.getId().equals("admin") ) {
				adminPage.setVisible(true);
			}
			else {
				adminPage.setVisible(false);
			}
		}
		
		search = new JLabel(new ImageIcon(MainView.PATH + "image\\MainImage\\search.jpg"));
		search.setBounds(583, 26, 30, 32);
		mainMenu.add(search);
		
		if(MemberController.m != null)
			login = new JLabel(new ImageIcon(MainView.PATH + "image\\MainImage\\logout.jpg"));
		else
			login = new JLabel(new ImageIcon(MainView.PATH + "image\\MainImage\\login.jpg"));
		login.setBounds(627, 26, 30, 32);
		mainMenu.add(login);
		
		
		myPage = new JLabel(new ImageIcon(MainView.PATH + "image\\MainImage\\myPage.jpg"));
		myPage.setBounds(667, 26, 30, 32);
		mainMenu.add(myPage);
		
		JPanel boderPanel = new JPanel();
		boderPanel.setBackground(new Color(255, 255, 255));
		boderPanel.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(0, 0, 0)));
		boderPanel.setBounds(0, 2, 102, 75);
		mainMenu.add(boderPanel);
		
		kategorie.addMouseListener(new MainMouseEvent("����޴�����") );	
		logo.addMouseListener(new MainMouseEvent("����") );
		login.addMouseListener(new MainMouseEvent("�α���") );
		myPage.addMouseListener(new MainMouseEvent("����������") );
		adminPage.addMouseListener(new MainMouseEvent("������������"));
	}
}
