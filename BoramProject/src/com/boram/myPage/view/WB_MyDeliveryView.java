package com.boram.myPage.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.boram.manager.vo.Order;
import com.boram.manager.vo.OrderDao;
import com.boram.member.controller.MemberController;
import com.boram.shopping.view.MainView;

public class WB_MyDeliveryView {
	public static final int FWID = 718;
	public static final int FHIT = 500;
	private OrderDao od = new OrderDao();
	private MemberController mc = new MemberController();
	private JPanel myDeliveryView;
	private JTable table;
//	private ArrayList<Order> order1 = od.fileRead();
	private ArrayList<Order> order1 = new ArrayList<Order>();

	public JPanel getMyDeliveryView() {
		return this.myDeliveryView;
	}

	public WB_MyDeliveryView() {
			myDeliveryView = new JPanel();
			myDeliveryView.setBackground(Color.white);
			myDeliveryView.setBounds(0, 0, FWID, 800);
			myDeliveryView.setLayout(null);

			JPanel panel1 = new JPanel();
			panel1.setBackground(Color.WHITE);
			panel1.setBounds(0, 0, FWID, 90);
			myDeliveryView.add(panel1);
			panel1.setLayout(null);

			JLabel label1 = new JLabel("My Delivery ");
			label1.setBounds(12, 10, 283, 58);
			panel1.add(label1);
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setFont(new Font("����", Font.ITALIC, 50));

			JPanel panel2 = new JPanel();
			panel2.setBackground(Color.WHITE);
			panel2.setBounds(0, 90, 718, 698);
			panel2.setLayout(null);
			myDeliveryView.add(panel2);

			// �ֹ���� �����ִ� J���̺�
			String colName[] = { "index", "pic", "OrderNo", "State", "Payment", "address" };
			DefaultTableModel dtm = new DefaultTableModel(colName, 0);
			table = new JTable(dtm);

			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(14, 0, 676, 625);
			panel2.add(sp, "Center");

			// ��������Ʈ�� �����ؼ� ���ΰ͸� �����־����
			// OList���� ���� ��ȣ�͸� �ٸ� list�� �־�����.
			// ������ ���ΰ� + state�� int���̴ϱ� String���� ��ȯ�ؼ� ���ֱ�.
			// payment�� ��������.
			
			order1 = od.fileRead();
			int who = mc.nugu().getmNo();
			
			// �ֹ�����̾�����(order1�� who���̾�����)
			try {
				order1.get(who).getOrderNo();
			}catch(NullPointerException | IndexOutOfBoundsException e) {
				System.out.println("������Ʈ���� : �ֹ���� ����.");
				JOptionPane.showMessageDialog(null, "�ֹ������ �����ϴ�.", "LogIn Error", JOptionPane.WARNING_MESSAGE);
				MainView.setMainPage(new WB_MyPage_Main().myPageMain());
			}
			
//			if (order1.size() < who) {
//				JOptionPane.showMessageDialog(null, "�ֹ������ �����ϴ�.", "LogIn Error", JOptionPane.WARNING_MESSAGE);
//				MainView.setMainPage(new WB_MyPage_Main().myPageMain());
//			}
			
			String State;
			if (order1.get(who).getState() == 0) {
				State = "����غ���";
			} else if (order1.get(who).getState() == 1) {
				State = "�����";
			} else {
				State = "��ۿϷ�";
			}
			
			for (int i = 0; i < order1.size(); i++) {
				int index = i = 1;
				Object pic = new Object();
				int oNo = order1.get(who).getOrderNo();
				int Payment = order1.get(who).getPayment();// �����ݾ�
				String address = order1.get(who).getAddress();

				Object[] data = { index, pic, oNo, State, Payment, address };
				dtm.addRow(data);
			
		}
	}
}
