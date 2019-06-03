package com.boram.myPage.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

import com.boram.manager.vo.Product;
import com.boram.myPage.controller.*;
import com.boram.shopping.view.MainView;
import com.boram.manager.vo.*;

public class WB_MyCartView {
	public static final int FWID = 718;
	public static final int FHIT = 500;
	
	private JPanel myCartView;
	private JTable table;
	private MyCart ca = new MyCart();
	private ArrayList<Product> CList = ca.cartList();
	
	

	/**
	 * Launch the application.
	 */

	public JPanel getMyCartView() {
		return this.myCartView;
	}

	/**
	 * Create the frame.
	 */
	public WB_MyCartView() {
		myCartView = new JPanel();
		myCartView.setBackground(Color.white);
		myCartView.setBounds(0, 0, FWID, 800);
		myCartView.setLayout(null);
		// getContentPane().add(myCartView);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(0, 0, FWID, 90);
		//panel1.setLayout(null);
		myCartView.add(panel1);
		panel1.setLayout(null);

		JLabel lblMyCart = new JLabel("My Cart ");
		lblMyCart.setBounds(0, 22, 197, 58);
		panel1.add(lblMyCart);
		lblMyCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyCart.setFont(new Font("����", Font.ITALIC, 50));
		// lblMyCart.setBounds(0,0,55,100);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(0, 90, 718, 698);
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

		String colName[] = { "index"/*, "Pic"*/, "Cat", "pName", "Size", "Amount", "Price" };
		DefaultTableModel dtm = new DefaultTableModel(colName, 0);
		// �� �־����.
		table = new JTable(dtm);
		table.setBackground(Color.WHITE);
		// sp.setViewportView(table);
		// table.setBackground(Color.DARK_GRAY);

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(14, 0, 676, 625);
		panel2.add(sp, "Center");
		// sp.add(table);

		// DefaultTableCellRenderer dcr = new DefaultTableCellRenderer() {
		// public Component getTableCellRendererComponent(JTable table, Object value,
		// boolean isselected, boolean hasfocus,
		// int row, int column) {
		// JCheckBox chk = new JCheckBox();
		// chk.setSelected(((Boolean) value).booleanValue());
		// chk.setHorizontalAlignment(JLabel.CENTER);
		// return chk;
		// }
		// };
		//
		// JCheckBox[] chk = new JCheckBox[CList.size()];
		// table.getColumn("chk").setCellRenderer(dcr);
		// table.getColumn("chk").setCellEditor(new DefaultCellEditor(chk));

		for (int i = 0; i < CList.size(); i++) {

			// üũ�ڽ� �̷��� �������?
			// chk[i]= new JCheckBox();
			// �����ֱ� �ٽ�.
			// ���� ������ ���� 325*430
			//Object image = new Object();
			int index = i+1;
			int cat = CList.get(i).getCategory();
			String pName = CList.get(i).getProductName();
			String size = CList.get(i).getSize();
			// �޺��ڽ���..?
			int amount = 1;
			int price = CList.get(i).getPrice();

			Object[] data = { /* chk */index/*, image*/, cat, pName, size, amount, price };
			dtm.addRow(data);
			// dtm.add(data);
		}
		System.out.println("==========================");
		for(Product i:CList) {
			System.out.println(i);
		}
		System.out.println("==========================");
		// �޺��ڽ�
		TableColumn comm = table.getColumnModel().getColumn(4);
		JComboBox<Integer> cb1 = new JComboBox<>();
		cb1.addItem(1);
		cb1.addItem(2);
		cb1.addItem(3);
		cb1.addItem(4);
		cb1.addItem(5);
		comm.setCellEditor(new DefaultCellEditor(cb1));

		
		// ��ư : ����, �ֹ��ϱ�, �����޴�

		// ������ư�� ������ JTable�� row����.
		//�����Ѱ��� CList�� �ٽ� �־��־����.
		JButton btnNewButton = new JButton("���� �� ����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row =0;
				//����Ʈ �� row ��ü�� �ѹ��� �����ϴ� while
				while (row>=0) {
					row = table.getSelectedRow();

					if (row >= 0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.removeRow(row);
						CList.remove(row);
					}
				}
				ca.saveCart(CList);
			}
		});
		btnNewButton.setBounds(122, 637, 105, 27);
		panel2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("�ֹ�");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i =ca.cartOrder();
				System.out.println(i);
				JOptionPane.showMessageDialog(null, "�ֹ��Ǿ����ϴ�.","Order Complete!",JOptionPane.DEFAULT_OPTION);
				MainView.setMainPage(new WB_MyDeliveryView().getMyDeliveryView());
			}
		});
		btnNewButton_1.setBounds(303, 637, 105, 27);
		panel2.add(btnNewButton_1);

		JButton button = new JButton("�����޴�");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView.setMainPage(new WB_MyPage_Main().myPageMain());
			}
		});
		button.setBounds(489, 637, 105, 27);
		panel2.add(button);

	}
}
