package com.boram.myPage.controller;

import java.io.*;
import java.util.*;

import com.boram.manager.vo.Order;
import com.boram.manager.vo.OrderDao;
import com.boram.manager.vo.Product;
import com.boram.manager.vo.ProductDao;
import com.boram.member.controller.MemberController;

public class MyCart {
	static ArrayList<Product> CList = new ArrayList<>();// ��ٱ��ϸ���Ʈ
	ArrayList<Order> OList = new ArrayList<>();// �ֹ�����Ʈ
	ProductDao pDao = new ProductDao();
List<Product> pArr = pDao.fileRead();
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
	public void cartOrder(int cb1) {
		OrderDao od = new OrderDao();// �ֹ����� Output
		ArrayList<Integer> pNo = new ArrayList<>();// �ֹ�����Ʈ�� ��ǰ��ȣ��
		ArrayList<Integer> amount = new ArrayList<>();// �ֹ�����Ʈ �� �ֹ�����
		ArrayList<Order> OList = od.fileRead();
		// ��ٱ��� ��������� 0����.
		if (CList.isEmpty()) {
			System.out.println("��ٱ��� �������!");
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
			
			// pNo�� ����üũ �պ���!! -> �պ�.
			for (Product i : CList) {
				amount.add(cb1);
			}
			int state = 0;
			int payment = 0;
			for (Product i : CList) {
				payment += i.getPrice();
			}
			OList.add(new Order(oNo, oId, oAdd, pNo, amount, state, payment));
			od.fileSave(OList);
			CList.clear();
			saveCart(CList);
		}
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
	public int reduceStock(int oNo, int amount) {
		int result=0;
		for (int i = 0; i < pArr.size(); i++) {
			if(oNo==pArr.get(i).getpNo()) {
				
				int stock =pArr.get(i).getStock();
				pArr.get(i).setStock(stock-amount);
				if(pArr.get(i).getStock()<0) {
					pArr.get(i).setStock(stock);
					result= -1;
				}else {
					pDao.fileSave(pArr);
					result=  0;
				}
			}
		}
		return result;
	}

}
