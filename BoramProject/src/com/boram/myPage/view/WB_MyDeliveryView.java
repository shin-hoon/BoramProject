package com.boram.myPage.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import com.boram.manager.vo.Order;
import com.boram.manager.vo.OrderDao;
import com.boram.manager.vo.Product;
import com.boram.member.controller.MemberController;
import com.boram.shopping.view.MainView;

public class WB_MyDeliveryView {
	public static final int FWID = 718;
	public static final int FHIT = 500;
	private OrderDao od = new OrderDao();
	private MemberController mc = new MemberController();
	private JPanel myDeliveryView;
	private JTable table;
	private StringBuilder pang = new StringBuilder();
	private int gsno;
	// private ArrayList<Order> order1 = od.fileRead();
	private ArrayList<Order> order1 = new ArrayList<Order>();
	// �ֹ�����̾�����(order1�� who���̾�����)
	private ArrayList<Order> order2 = new ArrayList<Order>();

	public JPanel getMyDeliveryView() {
		return this.myDeliveryView;
	}

	public WB_MyDeliveryView() {
		// �׽�Ʈ��¹�
		String who = null;
		order1 = od.fileRead();
		for (Order i : order1) {
			System.out.println(i);
		}

		try {
			// order1.get(who).getOrderNo();
			who = mc.nugu().getId();
			for (Order i : order1) {
				if (i.getOrderId() == who) {
					System.out.println("�ֹ���� ����. ������!");
				}
			}
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("������Ʈ���� : �ֹ���� ����.");
			JOptionPane.showMessageDialog(null, "�ֹ������ �����ϴ�.", "LogIn Error", JOptionPane.WARNING_MESSAGE);
			MainView.setMainPage(new WB_MyPage_Main().myPageMain());
		}

		System.out.println("o1 Size " + order1.size());
		System.out.println("o2 Size " + order2.size());

		myDeliveryView = new JPanel();
		myDeliveryView.setBackground(Color.white);
		myDeliveryView.setBounds(0, 0, FWID, 800);
		myDeliveryView.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(0, 0, FWID, 90);
		myDeliveryView.add(panel1);
		panel1.setLayout(null);

		JLabel label1 = new JLabel("My Delivery");
		label1.setBounds(20, 20, 400, 70);
		panel1.add(label1);
		//label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("����", Font.BOLD, 50));

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(0, 90, 718, 698);
		panel2.setLayout(null);
		myDeliveryView.add(panel2);

		// �ֹ���� �����ִ� J���̺�
		String colName[] = { "�ֹ���ȣ", "��ۻ���", "�ֹ����", "�����ݾ�", "����ּ�" };
		DefaultTableModel dtm = new DefaultTableModel(colName, 0);
		table = new JTable(dtm);
		table.setBackground(Color.WHITE);

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(14, 0, 676, 625);
		panel2.add(sp, "Center");

		JButton button = new JButton("����������");
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("����", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView.setMainPage(new WB_MyPage_Main().myPageMain());
			}
		});
		button.setBounds(283, 647, 180, 45);
		panel2.add(button);

		 table.getColumnModel().getColumn(0).setPreferredWidth(30);
		 table.getColumnModel().getColumn(1).setPreferredWidth(100);
		 table.getColumnModel().getColumn(2).setPreferredWidth(100);
		 table.getColumnModel().getColumn(3).setPreferredWidth(100);
		 table.getColumnModel().getColumn(4).setPreferredWidth(200);

		// ��������Ʈ�� �����ؼ� ���ΰ͸� �����־����
		// OList���� ���� ��ȣ�͸� �ٸ� list�� �־�����.
		// ������ ���ΰ� + state�� int���̴ϱ� String���� ��ȯ�ؼ� ���ֱ�.
		// payment�� ��������.

		for (int i = 0; i < order1.size(); i++) {
			if(order1.get(i).getOrderId().equals(who)) {
				order2.add(order1.get(i));
			}
		}
		System.out.println(who);
		// ���� �ѹ�, ��ۻ���, �ֹ����(btn), �ּ�, ���� �ݾ�
		for (int i = 0; i < order2.size(); i++) {

			int index = i;
			// Object pic = new Object();
			int oNo = order2.get(i).getOrderNo();
			int state1 = order2.get(i).getState();
			String state = null;
			switch (state1) {
			case 0:
				state = "����غ���";
				break;
			case 1:
				state = "�����";
				break;
			case 2:
				state = "��ۿϷ�";
				break;
			}
			int payment = order2.get(i).getPayment();
			String address = order2.get(i).getAddress();

			// System.out.println(index + " " + oNo + " " + state + " " + payment);
			Object[] data = { oNo, state,state, payment, address };
			table.getColumnModel().getColumn(2).setCellRenderer(new TableCell());
			table.getColumnModel().getColumn(2).setCellEditor(new TableCell());
			dtm.addRow(data);
		}
	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton jb;

		public TableCell() {
			jb = new JButton("�ֹ����");
			jb.addActionListener(e -> {
				pang = new StringBuilder();
				for (int i = 0; i < order2.get(gsno).getpNo().size(); i++) {
					int temp = order2.get(gsno).getpNo().get(i);
					int temp2 = order2.get(gsno).getAmount().get(i);
					pang.append(temp + "�� ��ǰ�� " + temp2 + "�� �ֹ��ϼ˽��ϴ�.\n");

				}
				System.out.println(table.getValueAt(table.getSelectedRow(), 1));
				System.out.println(table.getSelectedRow());
				gsno = table.getSelectedRow();
			});
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub

			JOptionPane.showMessageDialog(null, pang, "�ֹ����", JOptionPane.DEFAULT_OPTION);
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
				int arg5) {
			// TODO Auto-generated method stub
			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return jb;
		}

	}
}
