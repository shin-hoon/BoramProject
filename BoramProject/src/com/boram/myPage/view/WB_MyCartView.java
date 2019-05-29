package com.boram.myPage.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.boram.manager.vo.Product;
import com.boram.member.controller.MemberController;
import com.boram.member.vo.Member;
import com.boram.myPage.controller.*;

public class WB_MyCartView {
	private JPanel myCartView;
	public static final int FWID = 718;
	public static final int FHIT = 500;
	private JTable table;
	private MyCart ca = new MyCart();

	private MemberController mc = new MemberController();
	Member m = mc.nugu();

	/**
	 * Launch the application.
	 */

	public JPanel getMyCartView() {
		return this.myCartView;
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("null")
	public WB_MyCartView() {
		myCartView = new JPanel();
		myCartView.setBackground(Color.white);
		myCartView.setBounds(0, 0, FWID, 800);
		myCartView.setLayout(null);
		// getContentPane().add(myCartView);

		JPanel panel1 = new JPanel();

		panel1.setBackground(Color.WHITE);
		panel1.setForeground(Color.WHITE);
		panel1.setBounds(0, 0, FWID, 90);
		myCartView.add(panel1);

		JLabel lblMyCart = new JLabel("My Cart ");
		panel1.add(lblMyCart);
		lblMyCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyCart.setFont(new Font("����", Font.ITALIC, 50));
		// lblMyCart.setBounds(0,0,55,100);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setForeground(Color.WHITE);
		panel2.setBounds(0, 90, FWID, 710);
		myCartView.add(panel2);

		JScrollPane sp = new JScrollPane();
		// �� �־����.
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		panel2.add(sp);
		sp.add(table);

		/**
		 * ��ٱ��� �����ִ� ���̺�.
		 * 
		 * @return ���̺� ���� ���̺�������. [��ٱ��ϻ�����][�޺��ڽ�,�̹���,��ȣ,ī�װ�,ǰ���̸�,������,���� ,����](6)
		 * 
		 */
		// pNo, category, productName, price, size, stock, count(��ȸ��)
		// 1,1,"hat",35000,one,1,1.
		// ���� ���̺� �׽�Ʈ�Ұ�.
		// ���� ���̺� CList�������.
		// CList���� ���ͼ� ���α����ؾ���.

		// �̰� CList
		// String col[] = { "pNo", "Cat", "pName", "Price", "Size", "Stock", "Count" };
		// �������
		String colName[] = { "chk", "Pic", "index", "Cat", "pName", "Size", "Amount", "Price" };
		ArrayList<Product> CList = ca.cartList();
		DefaultTableModel dtm = new DefaultTableModel(colName, 0);
		
		
		JCheckBox[] chk = new JCheckBox[CList.size()-1];
		for (int i = 0; i < CList.size(); i++) {
			
			// üũ�ڽ� �̷��� �������?
			chk[i]= new JCheckBox();
			// �����ֱ� �ٽ�.
			Object image = new Object();
			int index = i;
			int cat = CList.get(i).getCategory();
			String pName = CList.get(i).getProductName();
			String size = CList.get(i).getSize();
			// �޺��ڽ���..?
			int amount = 1;
			int price = CList.get(i).getPrice();
			
			Object[] data = { chk, image, index, cat, pName, size, amount, price };
			dtm.addRow(data);
			// dtm.add(data);
		}

		// ��ư : ����, �ֹ��ϱ�, ��������, �����޴�

	}

	

}
