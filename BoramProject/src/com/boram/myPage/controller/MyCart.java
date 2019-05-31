package com.boram.myPage.controller;

import java.io.*;
import java.util.*;

import com.boram.manager.vo.Order;
import com.boram.manager.vo.OrderDao;
import com.boram.manager.vo.Product;
import com.boram.member.controller.MemberController;
import com.boram.member.vo.Member;

public class MyCart extends Product implements Serializable {
	private static final long serialVersionUID = 4623389045564207219L;
	static ArrayList<Product> CList = new ArrayList<>();// ��ٱ��ϸ���Ʈ
	ArrayList<Order> OList = new ArrayList<>();// �ֹ�����Ʈ

	// �α����ϸ鼭 ���� �α����ߴ��� ȸ������ ������.
	MemberController mc = new MemberController();
	Member m = mc.nugu();

	// �ʱ� �ӽõ�����
	// {
	// // pNo, category, productName, price, size, stock, count(��ȸ��)
	// // 1,1,"hat",35000,one,1,1.
	// CList.add(new Product(1, 1, "hat", 35001, "one1", 1, 1));
	// CList.add(new Product(2, 2, "hat", 35002, "one2", 1, 1));
	// CList.add(new Product(3, 3, "hat", 35003, "one3", 1, 1));
	// CList.add(new Product(4, 1, "hat", 35004, "one4", 1, 1));
	// CList.add(new Product(5, 2, "hat", 35005, "one5", 1, 1));
	// CList.add(new Product(6, 3, "hat", 35006, "one6", 1, 1));
	// CList.add(new Product(7, 4, "hat", 35007, "one7", 1, 1));
	// }

	public MyCart() {
	}

	/**
	 * @param product
	 *            ��ٱ��� �߰��� product��ü����Ʈ.
	 */
	// �ߺ��� �������� �ؾߵǳ�?
	public void addCart(Product product) {
		CList.add(product);
	}

	/**
	 * ��ü��ȸ
	 * 
	 * @return ��ü����Ʈ ���� �� View���� ���.
	 */
	public ArrayList<Product> cartList() {
		return CList;
	}

	/**
	 * �Ⱦ����ڵ�!!!!!!!!!!!!! ����ǰ���ȣ �޾Ƽ� ����..
	 * 
	 * @param delete
	 *            ������ ǰ���ȣ
	 * @return ��������1/����0
	 */
	public int cartDelete(int delete) {
		int result = 0;
		for (Product i : CList) {
			if (i.getpNo() == delete) {
				// System.out.println(i);
				CList.remove(i);
				result = 1;
				return result;
			} else {
				result = 0;
			}
		}
		return result;
	}

	/**
	 * �Ⱦ����ڵ�!!!!!!!!!!!!! ��ٱ��� ��ü����.
	 */
	public void cartDeleteAll() {
		CList.clear();
	}

	/**
	 * @return ����0, ����1
	 */
	public int cartOrder() {
		OrderDao od = new OrderDao();// �ֹ����� Output
		ArrayList<Integer> pNo = new ArrayList<>();// �ֹ�����Ʈ�� ��ǰ��ȣ��
		ArrayList<Integer> amount = new ArrayList<>();// �ֹ�����Ʈ �� �ֹ�����
		int result = 0;
		// ��ٱ��� ��������� 0����.
		if (CList.isEmpty()) {
			result = 0;
		} else {
			// CList+Member => OList�����.
			int oNo = OList.size() + 1;// ������order��ȣ +1
			String oId = m.getId();// �ֹ��� id
			String oAdd = m.getAddress();// �ֹ��� �ּ�.
			// CList�� ��ǰ�� pNo����� ArrayList<Integer> pNo�� ����.
			for (Product i : CList) {
				pNo.add(i.getpNo());
			}
			// pNo�� ����üũ �պ���!!
			for (Product i : CList) {
				amount.add(i.getpNo());
			}
			int state = 0;
			int payment = 0;
			for (Product i : CList) {
				payment += i.getPrice();
			}

			OList.add(new Order(oNo, oId, oAdd, pNo, amount, state, payment));

			od.fileSave(OList);
			result = 1;
		}

		return result;
	}

	/**
	 * �ӽú���Ȯ��!!!!!!!!!!! ����� ȸ����ȣ +MyCart.txt���� CList����. MyCart������ ������ ����.
	 * 
	 * @param CList
	 *            MyCartView���� CList�޾Ƽ� ����.
	 * @return
	 * @return ����0, ����1
	 */
	public void saveCart(ArrayList<Product> CList) {// notSerializable exc
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(m.getmNo() + "MyCart.txt"))) {
			// oos.writeObject(null);
			for (Product i : CList) {
				oos.writeObject(i);
			}
			// for(int i=0;i<CList.size();i++) {
			// oos.writeObject(CList.get(i));
			// //return 1;
			// }
			// oos.writeObject(CList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// result=0;
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void loadCart() {// �� �۵��ϴ��� Ȯ���Ұ�.
		int result = 0;// �ӽú���Ȯ��!!
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(m.getmNo() + "MyCart.txt"))) {
			CList.clear();
			while (true) {
				// CList = (ArrayList<Product>) ois.readObject();
				CList.add((Product) ois.readObject());
				result = 1;
			}
		} catch (EOFException e) {
			// e.printStackTrace();
			System.out.println("�ҷ����� �Ϸ�.");
		} catch (FileNotFoundException e) {
			// ��ٱ��� ������ ������ ���θ�����־����.
			CList.clear();
			saveCart(CList);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
