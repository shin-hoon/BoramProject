package com.boram.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.boram.manager.vo.Order;
import com.boram.manager.vo.OrderDao;
import com.boram.manager.vo.Product;
import com.boram.manager.vo.ProductDao;
import com.boram.member.vo.Member;
import com.boram.member.vo.MemberDao;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

public class ManagerController2 {

	private OrderDao od = new OrderDao();
	private ProductDao pd = new ProductDao();
	private MemberDao md = new MemberDao();

	private ArrayList<Order> oArr = od.fileRead();
	private List<Product> pArr = (ArrayList<Product>)pd.fileRead();
	private ArrayList<Member> mArr = md.fileRead();

	public ArrayList<Member> searchMember() {
		oArr.clear();
		oArr = od.fileRead();
		pArr.clear();
		pArr = pd.fileRead();
		mArr.clear();
		mArr = md.fileRead();
		return mArr;
	}

	public List<Product> searchProduct() {
		oArr.clear();
		oArr = od.fileRead();
		pArr.clear();
		pArr = pd.fileRead();
		mArr.clear();
		mArr = md.fileRead();
		return pArr;
	}
	public ArrayList<Order> searchOrder(){
		oArr.clear();
		oArr = od.fileRead();
		pArr.clear();
		pArr = pd.fileRead();
		mArr.clear();
		mArr = md.fileRead();
		return oArr;
	}
	
	/**
	 * ��� �޼ҵ� manageProduct, analyzeSale
	 * �뵵 ���δ�Ʈ ��ȣ���� �Է¹ް� �� �ε����� ���� ��ȯ�Ѵ�.
	 */
	public int indexProduct(int pNo) {
		oArr.clear();
		oArr = od.fileRead();
		pArr.clear();
		pArr = pd.fileRead();
		mArr.clear();
		mArr = md.fileRead();
		int b=-1;
		for (int i = 0; i < pArr.size(); i++) {
			if (pArr.get(i).getpNo() == pNo) {
				b = i;
				break;
			}
		}
		return b;
	}
	
	public int indexMember(int mNo) {
		oArr.clear();
		oArr = od.fileRead();
		pArr.clear();
		pArr = pd.fileRead();
		mArr.clear();
		mArr = md.fileRead();
		int temp = -1;
		for (int i = 0; i < mArr.size(); i++) {
			if (mArr.get(i).getmNo() == (int) mNo) {
				temp = i;
				break;
			}
		}
		return temp;
	}
	
//	oArr.clear();
//	oArr = od.fileRead();
//	pArr.clear();
//	pArr = pd.fileRead();
//	mArr.clear();
//	mArr = md.fileRead();
	
	public String orderInfo(Order o) {
		String message = "";
		message += ("�ֹ���ȣ : " + o.getOrderNo()) + "\n �ֹ���ǰ \n";// messaage�� �ֹ���ȣ���
		for (int j = 0; j < o.getpNo().size(); j++) {

			for (int l = 0; l < pArr.size(); l++) {
				if (pArr.get(l).getpNo() == o.getpNo().get(j)) {
					message += pArr.get(l).getProductName() + " : "
							+ o.getAmount().get(j) + "��\n";//message�� ��ǰ�� + ��ǰ���� ���
				}
			}
		}
		message += "�ֹ����� : " + o.getPayment() + "\n"; //message�� �ֹ����ݴ��
		if (o.getState() == 0) { // �޼����� ��ۻ��´��
			message += "��ۻ��� : ����Ϸ�";
		} else if (o.getState() == 1) {
			message += "��ۻ��� : ��� ��";
		} else {
			message += "��ۻ��� : �������";
		}
		return message;
	}
	
	
//	public void insertProduct(int category, String productName, int price, String size, String explain, int stock) {
//
//		int pNo = 1;
//		try {
//			if (pArr != null) {
//				pNo = pArr.get(pArr.size() - 1).getpNo() + 1;
//			}
//		} catch (ArrayIndexOutOfBoundsException e) {
//			pNo = 1;
//		}
//
//		pArr.add(new Product(pNo, category, productName, price, size, stock, 0));
//	}


//	public void updateProduct(int index, int menu, String update) {
//
//		int result = Integer.parseInt(update);
//
//		switch (menu) {
//		case 1:
//
//			pArr.get(index).setCategory(result);
//			break;
//		case 2:
//			pArr.get(index).setProductName(update);
//			break;
//		case 3:
//			pArr.get(index).setPrice(result);
//			break;
//		case 4:
//			pArr.get(index).setSize(update);
//			break;
//		case 5:
//			pArr.get(index).setExplain(update);
//			break;
//
//		default:
//			break;
//		}
//
//	}

	public void deleteProduct(int result) {
		oArr.clear();
		oArr = od.fileRead();
		pArr.clear();
		pArr = pd.fileRead();
		mArr.clear();
		mArr = md.fileRead();
		
		pArr.remove(result);
		pd.fileSave(pArr);
	}

//	public void deleteMember(int result) {
//		mArr.remove(result);
//	}

//	public void updateProduct(int result, int stock) {
//		pArr.get(result).setStock(stock);
//	}

	
	/**
	 * �ֹ�������κ��� Ű���� ��ǰ��ȣ, value���� �Ǹ����� �־��� HashMap
	 */
	public HashMap<Integer, Double> analysis() {
		oArr.clear();
		oArr = od.fileRead();
		pArr.clear();
		pArr = pd.fileRead();
		mArr.clear();
		mArr = md.fileRead();
		
		HashMap<Integer, Double> anl = new HashMap<Integer, Double>(); //��ȯ���� ��
		//anl.clear();
		ArrayList<Integer> pNo = new ArrayList<Integer>(); //��ǰ��ȣ�� �޾��� ��ǰ��ȣ
		ArrayList<Integer> count = new ArrayList<Integer>();//��ǰ���� ���Ű����� ������ int�� �迭
		for (int i = 0; i < oArr.size(); i++) {
			for (int j = 0; j < oArr.get(i).getpNo().size(); j++) {
				pNo.add(oArr.get(i).getpNo().get(j));//pNo�� ��� orderList�� ��ǰ��ȣ����
				count.add(oArr.get(i).getAmount().get(j));//count�� ������ ��ǰ��ȣ�� ���
				int index = 0;
				for (int j2 = 0; j2 < pNo.size()-1; j2++) {// �������� �Է��Ѱ� ������ �ݺ�
					if(oArr.get(i).getpNo().get(j)== pNo.get(j2)) {//���������� ������ �������� ��
						pNo.remove(pNo.size()-1);//��ġ�� �� ������ �������� �Է��� ������
						int temp = count.get(j2);
						count.set(j2, temp+oArr.get(i).getAmount().get(j));
						count.remove(pNo.size()-1);
						break;
					}
				}
			}
		}
			ArrayList<Integer> same = new ArrayList<Integer>();//Orderlist�� ��ǰ��ȣ�� ���� Product�� ã�� �� �ε��������� �����ϴ� �迭
			for (int k = 0; k < pNo.size(); k++) { // pNo�� ��簪 �ݺ�
				for (int j = 0; j < pArr.size(); j++) {//�׻�ǰ��ȣ�� ��ȸ���� ã������ ��ǰ����Ʈ�� ��� �˻�
					if (pNo.get(k) == pArr.get(j).getpNo()) {
							same.add(j);//�� �ε����� ����
							break;
					}
				}
				try {
					anl.put(pNo.get(k), (count.get(k) / (double)(pArr.get(same.get(k)).getCount())));//�ؽ��ʿ� ����
				} catch (ArithmeticException e) {//��ȸ���� 0�̸� 0����ȯ
					anl.put(pNo.get(k), 0.0);
				}
			}
		return anl;
	}

//	oArr.clear();
//	oArr = od.fileRead();
//	pArr.clear();
//	pArr = pd.fileRead();
//	mArr.clear();
//	mArr = md.fileRead();
	
	public ArrayList<Integer> salesState(int month, int term) {
		oArr.clear();
		oArr = od.fileRead();
		pArr.clear();
		pArr = pd.fileRead();
		mArr.clear();
		mArr = md.fileRead();
		
		ArrayList<Integer> sumArr = new ArrayList<Integer>();//�����ջ���� ������ arraylist
		int count;
		int a = (month / 100) % 100;//��������� ��Ÿ���� ����
		// month�� ���� 'yyyyMMdd'
		for (int i = 0; i < term; i++) {//�м��� ��������ŭ �ݺ�
			count = 0;
			if (a == 0) {
				for (int j = 0; j < oArr.size(); j++) {
					if ((month / 100 - i - 100+12) == (oArr.get(j).getOrderDate() / 100)) {
						//�۳����� ���ư��� ��� ���������� 1�� ������ ���� 12���� �ǰ� �������� ex)201900-> 201812;
						count += oArr.get(j).getPayment();//�����Ϳ��� ���� ��� ���� ������
						a=12;
					}
				}
				sumArr.add(count);
			} else {
				for (int j = 0; j < oArr.size(); j++) {
					if ((month / 100 - i) == (oArr.get(j).getOrderDate() / 100)) {//100���� ���� 1�� ���ְ� ������ ��������
						count += oArr.get(j).getPayment();//�����Ϳ��� ���� ��� ���� ������
					}
				}
				a--;//�Ѵ޾� �ٿ����� sumArr�� �����ϱ� ���Ѱ�
				sumArr.add(count);
			}
		}
		return sumArr;
	}

}
