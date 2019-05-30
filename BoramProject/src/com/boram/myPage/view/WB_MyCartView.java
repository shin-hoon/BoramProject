package com.boram.myPage.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.boram.manager.vo.Product;
import com.boram.member.controller.MemberController;
import com.boram.member.vo.Member;
import com.boram.myPage.controller.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WB_MyCartView {
	private JPanel myCartView;
	public static final int FWID = 718;
	public static final int FHIT = 500;
	private JTable table;
	private MyCart ca = new MyCart();
	private ArrayList<Product> CList = ca.cartList();
	private MemberController mc = new MemberController();
	Member m = mc.nugu();
	private JTable table_1;

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
		panel2.setLayout(null);
		myCartView.add(panel2);
	
		
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
		DefaultTableModel dtm = new DefaultTableModel(colName, 0);
		// �� �־����.
		table = new JTable(dtm);
//		sp.setViewportView(table);
//		table.setBackground(Color.DARK_GRAY);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(74, 39, 579, 423);
		panel2.add(sp);
//		sp.add(table);
		
		
		
		JCheckBox[] chk = new JCheckBox[CList.size()];
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
		
		//�޺��ڽ�
		TableColumn comm =table.getColumnModel().getColumn(6);
		JComboBox<Integer> cb1 = new JComboBox<>();
		cb1.addItem(1);
		cb1.addItem(2);
		cb1.addItem(3);
		cb1.addItem(4);
		cb1.addItem(5);
		comm.setCellEditor(new DefaultCellEditor(cb1));
		
		
		
		
		
		
		
		
		// ��ư : ����, �ֹ��ϱ�, �����޴�
		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(85, 637, 105, 27);
		panel2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�ֹ�");
		btnNewButton_1.setBounds(216, 637, 105, 27);
		panel2.add(btnNewButton_1);
		
		JButton button = new JButton("�����޴�");
		button.setBounds(362, 636, 105, 27);
		panel2.add(button);
				
		

		

	}
}
