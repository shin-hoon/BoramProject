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
import javax.swing.JTextField;

public class Temp extends JFrame {
	private JPanel content;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8447375608770781274L;
	private JPanel contentPane;
	private JTextField textField;

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
		
		
		
		
		
		setContentPane(content);
		
		textField = new JTextField();
		textField.setBounds(56, 64, 212, 24);
		content.add(textField);
		textField.setColumns(10);
		
	}
}