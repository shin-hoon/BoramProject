package com.boram.manager.vo;

public class Category {
	/*
	 * 11 ��Ʈ
	 * 12 ����
	 * 13 ������
	 * 14 �����
	 * 21����
	 * 22 ����/����
	 * 23 ������/ �ĵ�Ƽ
	 * 24��Ʈ
	 * 25������
	 * 31 �⺻����
	 * 32 ���ϼ���
	 * 33���ȼ���
	 * 41 ������
	 * 42 ������
	 * 43û����
	 * 44 �ݹ���
	 * 45Ʈ���̴�
	 * 46 UP ��������
	 * 51 ����Ŀ��
	 * 52 ����/��Ŀ
	 * 53 ������/����
	 */
	
	
	private int num;
	private String kind;
	
	
	
	public Category(int num, String kind) {
		super();
		this.num = num;
		this.kind = kind;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	@Override
	public String toString() {
		return "Category [num=" + num + ", kind=" + kind + "]";
	}
	
	
}
