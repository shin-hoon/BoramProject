package com.boram.myPage.controller;

import java.io.*;
import java.util.*;

import com.boram.manager.vo.Order;
import com.boram.manager.vo.OrderDao;
import com.boram.manager.vo.Product;
import com.boram.member.controller.MemberController;

public class MyCart {
	static ArrayList<Product> CList = new ArrayList<>();// ��ٱ��ϸ���Ʈ
	ArrayList<Order> OList = new ArrayList<>();// �ֹ�����Ʈ

	// �α����ϸ鼭 ���� �α����ߴ��� ȸ������ ������.
	MemberController mc = new MemberController();
//	{
//		CList.add(new Product(1,1,"name",32001,"free","discripe","img",1,1));
//		CList.add(new Product(2,1,"name",32002,"free","discripe","img",2,1));
//		CList.add(new Product(3,1,"name",32003,"free","discripe","img",3,1));
//		CList.add(new Product(4,1,"name",32004,"free","discripe","img",4,1));
//		CList.add(new Product(5,1,"name",32005,"free","discripe","img",5,1));
//		CList.add(new Product(6,1,"name",32006,"free","discripe","img",6,1));
//		CList.add(new Product(7,1,"name",32007,"free","discripe","img",7,1));
//	}
	

	public MyCart() {
	}

	/**
	 * @param product ��ٱ��� �߰��� product��ü����Ʈ.
	 */
	// �ߺ��� �������� �ؾߵǳ�?
	public void addCart(Product product) {
		CList.add(product);
	}

	/**
	 * ��ü��ȸ
	 * @return ��ü����Ʈ ���� �� View���� ���.
	 */
	public ArrayList<Product> cartList() {
		return CList;
	}

	/**
	 * �Ⱦ����ڵ�!!!!!!!!!!!!! ����ǰ���ȣ �޾Ƽ� ����..
	 * @param delete ������ ǰ���ȣ
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
		ArrayList<Order> OList = od.fileRead();
		int result = 0;
		// ��ٱ��� ��������� 0����.
		if (CList.isEmpty()) {
			System.out.println("��ٱ��� �������!");
			result = 0;
		} else {
			// CList+Member => OList�����.
			int oNo =0; // ������order��ȣ +1
			if (OList.size() != 0) {
				oNo = OList.size();
			}
			String oId = MemberController.m.getId();// �ֹ��� id
			String oAdd = MemberController.m.getAddress();// �ֹ��� �ּ�.
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
			CList.clear();
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
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MemberController.m.getmNo() + "MyCart.txt"))) {
			oos.reset();
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

	public void loadCart() {// �� �۵��ϴ��� Ȯ���Ұ�.
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(MemberController.m.getmNo() + "MyCart.txt"))) {
			CList.clear();
			while (true) {
				// CList = (ArrayList<Product>) ois.readObject();
				CList.add((Product) ois.readObject());
			}
		}
		catch (EOFException e) {
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
