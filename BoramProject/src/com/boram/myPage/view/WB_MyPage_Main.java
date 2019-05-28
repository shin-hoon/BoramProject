package com.boram.myPage.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import com.boram.member.vo.Member;

public class WB_MyPage_Main extends JFrame {
	public static final int FWID = 718;
	public static final int FHIT = 500;
	private ArrayList<Member> mList = new ArrayList<>();
	private JPanel contentPane;
	
	public WB_MyPage_Main() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,FWID,FHIT);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		
		
		JButton btnNewButton = new JButton("<HTML><Center> ȸ������<br>����</HTML>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				new WB_MyPageView();
				
			}
		});
		btnNewButton.setBounds(78, 371, 103, 94);
		contentPane.add(btnNewButton);
		
		
		JButton button = new JButton("��ٱ���");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				new WB_MyCartView();
			}
		});
		button.setBounds(215, 371, 103, 94);
		contentPane.add(button);
		
		JButton button_1 = new JButton("���Ȯ��");
		button_1.setBounds(346, 371, 103, 94);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("<HTML><Center>���ų���<br>Ȯ��</HTML>");
		button_2.setBounds(482, 371, 103, 94);
		contentPane.add(button_2);
		
		
		JLabel lblMyCart = new JLabel("My Page");
		lblMyCart.setBounds(0,0, 700,112);
		lblMyCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyCart.setFont(new Font("����", Font.ITALIC, 50));
		contentPane.add(lblMyCart);
		
		JLabel lblNewLabel = new JLabel("���� ������");
		lblNewLabel.setBounds(78, 149, 507, 40);
		contentPane.add(lblNewLabel);
	}
}
