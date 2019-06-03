package com.boram.shopping.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boram.manager.vo.Product;
import com.boram.manager.vo.ProductDao;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Temp extends JFrame {
	private JPanel content;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8447375608770781274L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temp frame = new Temp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*	
	private int pNo;				// �Խù���ȣ
	private int category;			// ī�װ�
	private String productName;		// ��ǰ�̸�
	private int price;				// ��ǰ����
	private String size;			// ��ǰ������
	private String explain;			// ��ǰ����
	private String imgFilePath;		// �̹������
	private int stock;				// ��ǰ���
	private int count; 				// ��ȸ��
	
*/	

	/**
	 * Create the frame.
	 */
	public Temp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 0, 718, 1890);
		content = new JPanel();
		content.setBackground(new Color(255, 255, 255));
		content.setBounds(0, 259, 718, 1890);
		content.setLayout(null);
		content.setVisible(true);
		
		
		List<Product> productList = new ProductDao().fileRead();
		
		Image image = null;
		try {
			File file = new File(MainView.PATH + productList.get(2).getImgFilePath());
			image = ImageIO.read(file).getScaledInstance(718 , 630, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("�̹��� �ҷ����� ���� : " + e.getMessage());
		}
		
		JLabel contentImage = new JLabel(new ImageIcon(image));
		contentImage.setBounds(0, 0, 700, 630);
		content.add(contentImage);
		
		JLabel productName = new JLabel("[MUTNAM] ��������Ƽ ���̴� ����");
		productName.setFont(new Font("����", Font.BOLD, 25));
		productName.setBounds(14, 637, 631, 44);
		content.add(productName);
			
		
		JLabel priceTitle = new JLabel("�ǸŰ�");
		priceTitle.setForeground(Color.GRAY);
		priceTitle.setFont(new Font("����", Font.BOLD, 20));
		priceTitle.setBounds(14, 696, 133, 44);
		content.add(priceTitle);
		
		JLabel price = new JLabel("55,300��");
		price.setForeground(Color.BLACK);
		price.setFont(new Font("���� ���", Font.BOLD, 20));
		price.setBounds(141, 696, 133, 44);
		content.add(price);
		JLabel savings = new JLabel("������");
		savings.setForeground(Color.GRAY);
		savings.setFont(new Font("����", Font.BOLD, 20));
		savings.setBounds(14, 738, 133, 44);
		content.add(savings);
		
		JLabel savingsPay = new JLabel("420��");
		savingsPay.setForeground(Color.GRAY);
		savingsPay.setFont(new Font("����", Font.BOLD, 20));
		savingsPay.setBounds(141, 738, 133, 44);
		content.add(savingsPay);
		
		JLabel shippingFee = new JLabel("��ۺ�");
		shippingFee.setForeground(Color.GRAY);
		shippingFee.setFont(new Font("���� ���", Font.PLAIN, 20));
		shippingFee.setBounds(14, 780, 133, 44);
		content.add(shippingFee);
		
		JLabel shippingFeePay = new JLabel("2,000�� (50,000 �̻� ���� �� ����)");
		shippingFeePay.setForeground(Color.GRAY);
		shippingFeePay.setFont(new Font("���� ���", Font.PLAIN, 20));
		shippingFeePay.setBounds(141, 780, 356, 44);
		content.add(shippingFeePay);
		
		JLabel size = new JLabel("������");
		size.setForeground(Color.GRAY);
		size.setFont(new Font("����", Font.BOLD, 20));
		size.setBounds(14, 822, 133, 44);
		content.add(size);
		
		JLabel free = new JLabel("Free");
		free.setForeground(Color.BLACK);
		free.setFont(new Font("���� ���", Font.BOLD, 20));
		free.setBounds(141, 822, 133, 44);
		content.add(free);
		
		JButton buyNow = new JButton("BUY NOW");
		buyNow.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 26));
		buyNow.setForeground(Color.WHITE);
		buyNow.setBackground(Color.BLACK);
		buyNow.setEnabled(false);
		buyNow.setBounds(0, 887, 700, 61);
		content.add(buyNow);
		
		JButton cart = new JButton("CART");
		cart.setForeground(Color.BLACK);
		cart.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 26));
		cart.setEnabled(false);
		cart.setBackground(Color.WHITE);
		cart.setBounds(0, 960, 700, 61);
		content.add(cart);
		
		
		setContentPane(content);
		/*
		JTextArea sdfdsf = new JTextArea();
		sdfdsf.setFont(new Font("����", Font.BOLD, 20));
		sdfdsf.setEditable(false);
		sdfdsf.setLineWrap(true);
		sdfdsf.setText(productList.get(2).getExplain());
		sdfdsf.setBounds(0, 0, 700, 625);
		content.add(sdfdsf);
		*/
//		String aa = productList.get(2).getExplain();
	/*	JLabel sdfdsf = new JLabel();
		sdfdsf.setForeground(Color.BLACK);
		sdfdsf.setFont(new Font("���� ���", Font.BOLD, 20));
		sdfdsf.setText(productList.get(2).getExplain());
		sdfdsf.setBounds(25, 12, 640, 622);
		content.add(sdfdsf);*/
		
//		System.out.println(productList.get(2).getExplain());
		
	}
}