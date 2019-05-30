package com.boram.member.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.boram.member.controller.MemberController;
import com.boram.member.vo.Member;
import com.boram.member.vo.MemberDao;
import com.boram.shopping.view.MainView;

public class MemberView1{

	private JPanel Login;
	private JTextField id;
	private JPasswordField pwd;

	// ���� ������ ȣ���� ���� JPanel ��ȯ
	public JPanel getLoginView() {
		return this.Login;
	}

	/**
	 * Create the application.
	 */
	public MemberView1() {
		MemberDao md = new MemberDao();
		ArrayList<Member> mArr = md.fileRead();
		
		Login = new JPanel();
		Login.setBackground(new Color(255, 255, 255));
		Login.setBounds(550, 0, 647, 596);
		Login.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(73, 40, 515, 528);
		panel.setLayout(null);
		Login.add(panel);

		JLabel BORAMLABEL = new JLabel("BORAM");
		BORAMLABEL.setBounds(40, 75, 234, 83);
		BORAMLABEL.setFont(new Font("����", Font.BOLD, 54));
		panel.add(BORAMLABEL);

		JLabel MEMLABEL = new JLabel("MEMBERSHIP LOGIN");
		MEMLABEL.setFont(new Font("����", Font.BOLD, 23));
		MEMLABEL.setBounds(42, 147, 340, 27);
		panel.add(MEMLABEL);

		JLabel IDLABEL = new JLabel("ID*");
		IDLABEL.setFont(new Font("����", Font.PLAIN, 26));
		IDLABEL.setBounds(46, 227, 109, 44);
		panel.add(IDLABEL);

		id = new JTextField();
		id.setBounds(208, 227, 303, 39);
		panel.add(id);
		id.setColumns(10);

		JLabel PWDLABEL = new JLabel("Password*");
		PWDLABEL.setFont(new Font("����", Font.PLAIN, 26));
		PWDLABEL.setBounds(48, 302, 207, 39);
		panel.add(PWDLABEL);

		pwd = new JPasswordField();
		pwd.setBounds(208, 302, 303, 39);
		panel.add(pwd);
		pwd.setColumns(10);

		
		
		/* �α��� ��ư */
		JButton logIn = new JButton("\uB85C\uADF8\uC778"); 
		logIn.setForeground(Color.WHITE);
		logIn.setBackground(Color.BLACK);
		logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �α��� ��ư Ŭ���ϸ�
				String userId = id.getText();
				String userPwd = "";
				char[] pwd1 = pwd.getPassword();
				for(int i=0; i<pwd1.length; i++) {
					userPwd += pwd1[i];
				}
				
				MemberController mc = new MemberController(); 
				Member result = mc.logIn(userId , userPwd);
				
					Login.setVisible(false); // �α��� â ����
					
					// �α��� �����ϸ� Ȯ�� �˾�â
					if(result == null) {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
					Login.setVisible(true);
					}
			}
		});

		logIn.setBounds(66, 370, 189, 44);
		panel.add(logIn);

		
		
		/* ȸ������ ��ư */
		JButton join = new JButton("\uD68C\uC6D0\uAC00\uC785"); 
		join.setForeground(Color.WHITE);
		join.setBackground(Color.BLACK);
		join.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// ȸ������ ��ư Ŭ���ϸ�
				Login.setVisible(false); // �α��� â ����

				JPanel joinPanel = new JPanel();
				
				joinPanel.setBackground(Color.WHITE);
				joinPanel.setLayout(null);
				
				JLabel memberjoinLb = new JLabel("MEMBER JOIN");
				memberjoinLb.setFont(new Font("����", Font.BOLD, 28));
				memberjoinLb.setHorizontalAlignment(SwingConstants.CENTER);
				memberjoinLb.setBounds(155, 39, 222, 72);
				joinPanel.add(memberjoinLb);
				
				JLabel idLb = new JLabel("\uC544\uC774\uB514 * ");
				idLb.setFont(new Font("����", Font.PLAIN, 18));
				idLb.setBounds(41, 164, 102, 28);
				joinPanel.add(idLb);
				
				JLabel pwdLb = new JLabel("\uBE44\uBC00\uBC88\uD638 * ");
				pwdLb.setFont(new Font("����", Font.PLAIN, 18));
				pwdLb.setBounds(40, 217, 103, 36);
				joinPanel.add(pwdLb);
				
				JLabel nameLb = new JLabel("\uC774\uB984 *");
				nameLb.setFont(new Font("����", Font.PLAIN, 18));
				nameLb.setBounds(41, 287, 62, 18);
				joinPanel.add(nameLb);
				
				JLabel birthLb = new JLabel("\uC0DD\uB144\uC6D4\uC77C(ex:950417) *");
				birthLb.setFont(new Font("����", Font.PLAIN, 18));
				birthLb.setBounds(41, 342, 191, 28);
				joinPanel.add(birthLb);
				
				JLabel addressLb = new JLabel("\uC8FC\uC18C *");
				addressLb.setFont(new Font("����", Font.PLAIN, 18));
				addressLb.setBounds(41, 409, 62, 18);
				joinPanel.add(addressLb);
				
				JLabel phoneLb = new JLabel("\uD578\uB4DC\uD3F0 \uBC88\uD638 *");
				phoneLb.setFont(new Font("����", Font.PLAIN, 18));
				phoneLb.setBounds(41, 463, 118, 28);
				joinPanel.add(phoneLb);
				
				JLabel emailLb = new JLabel("\uC774\uBA54\uC77C *");
				emailLb.setFont(new Font("����", Font.PLAIN, 18));
				emailLb.setBounds(41, 526, 80, 28);
				joinPanel.add(emailLb);
				
				JTextField idText = new JTextField();
				idText.setBounds(301, 162, 176, 36);
				joinPanel.add(idText);
				idText.setColumns(10);
				
				JButton idcheckBtn = new JButton("ID CHECK");
				idcheckBtn.setForeground(Color.WHITE);
				idcheckBtn.setBackground(Color.BLACK);
				idcheckBtn.setFont(new Font("����", Font.PLAIN, 20));
				
				idcheckBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
							// ���̵� �Է��� ��밡���� ���̵����� Ȯ���ϴ� ��ư
							// ���̵� �Է��� ���̵�üũ��ư ������ ����� ��� ���̵� �˻�
							MemberController mc = new MemberController();
							int result = mc.idCheck(idText);
					
							//���� ���̵� �����ϸ�
							if(result == 1) {
							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame, "���� ���̵� �����մϴ�. �ٸ�ID�� ����ϼ���.");
							joinPanel.setVisible(true);
							}
				
							// ����� ���̵�� �ٸ��� ��밡��
							else if(result == 0) {
							JFrame frame2 = new JFrame();
							JOptionPane.showMessageDialog(frame2, "��밡���� ID�Դϴ�.");
							joinPanel.setVisible(true);
							}
						
					}
				});
			
				
				idcheckBtn.setBounds(500, 164, 150, 25);
				joinPanel.add(idcheckBtn);
				
				JTextField pwdText = new JTextField();
				pwdText.setColumns(10);
				pwdText.setBounds(301, 225, 176, 36);
				joinPanel.add(pwdText);
				
				JTextField nameText = new JTextField();
				nameText.setColumns(10);
				nameText.setBounds(301, 286, 176, 36);
				joinPanel.add(nameText);
				
				JTextField birthText = new JTextField();
				birthText.setColumns(10);
				birthText.setBounds(301, 342, 176, 36);
				joinPanel.add(birthText);
				
				JTextField phoneText = new JTextField();
				phoneText.setColumns(10);
				phoneText.setBounds(301, 463, 176, 36);
				joinPanel.add(phoneText);
				
				JTextField emailText = new JTextField();
				emailText.setColumns(10);
				emailText.setBounds(301, 518, 176, 36);
				joinPanel.add(emailText);
				
				JTextField addressText = new JTextField();
				addressText.setBounds(100, 399, 377, 43);
				joinPanel.add(addressText);
				addressText.setColumns(10);
				
				JButton joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
				joinBtn.setForeground(Color.WHITE);
				joinBtn.setBackground(Color.BLACK);
				joinBtn.setFont(new Font("����", Font.PLAIN, 22));
				joinBtn.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						// �����Է��� ȸ������ ��ư ������
						String name = nameText.getText();
						int age = birthText.getColumns();
						String id = idText.getText();
						String pwd = pwdText.getText();
						String phone = phoneText.getText();
						String address = addressText.getText();
						String email = emailText.getText();
						
						MemberController mc = new MemberController();
						mc.join(name, age, id, pwd, phone, address, email); // �����Ʋ�ѷ� ȸ������Ʈ�� �߰�
						System.out.println("ddd");
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "ȸ�������� �Ϸ� �Ǿ����ϴ�.");
						Login.setVisible(true); // ȸ������ �Ϸ� Ȯ��â �߰�
						
						// ȸ������â ����
						joinPanel.setVisible(false);
						
						// �α���â �߱�
						MainView.setMainPage(Login);
						Login.add(panel);
						
					}
				});
				joinBtn.setBounds(202, 609, 160, 52);
				joinPanel.add(joinBtn);
				
				MainView.setMainPage(joinPanel);
			}
		});

		join.setBounds(301, 370, 199, 44);
		panel.add(join);

	
		
		
		/* ���̵� ã�� ��ư */
		JButton searchId = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30"); 
		searchId.setForeground(Color.WHITE);
		searchId.setBackground(Color.BLACK);
		searchId.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// ���̵�ã�� ��ư Ŭ���ϸ�
				panel.setVisible(false); // �α��� â ����

				JPanel idSearchPanel = new JPanel();
				
				idSearchPanel.setBackground(Color.WHITE);
				idSearchPanel.setLayout(null);

				JLabel lblIdpwFind = new JLabel("ID/PW FIND");
				lblIdpwFind.setFont(new Font("����", Font.BOLD, 38));
				lblIdpwFind.setHorizontalAlignment(SwingConstants.CENTER);
				lblIdpwFind.setBounds(133, 55, 288, 54);
				idSearchPanel.add(lblIdpwFind);

				JLabel searchLb = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
				searchLb.setFont(new Font("����", Font.BOLD, 17));
				searchLb.setBounds(64, 155, 98, 31);
				idSearchPanel.add(searchLb);

				JLabel nameLb = new JLabel("\uC774\uB984 : ");
				nameLb.setFont(new Font("����", Font.PLAIN, 19));
				nameLb.setBounds(100, 214, 62, 49);
				idSearchPanel.add(nameLb);

				JLabel emailLb = new JLabel("\uC774\uBA54\uC77C : ");
				emailLb.setFont(new Font("����", Font.PLAIN, 19));
				emailLb.setBounds(100, 275, 78, 31);
				idSearchPanel.add(emailLb);

				JTextField nametext = new JTextField();
				nametext.setBounds(173, 218, 248, 38);
				idSearchPanel.add(nametext);
				nametext.setColumns(10);

				JTextField emailtext = new JTextField();
				emailtext.setColumns(10);
				emailtext.setBounds(174, 273, 248, 38);
				idSearchPanel.add(emailtext);

				JButton confirmBtn = new JButton("\uD655  \uC778");
				confirmBtn.setForeground(Color.WHITE);
				confirmBtn.setBackground(Color.BLACK);
				confirmBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// ���̵� ã�� Ȯ�� ��ư ������
	
						MemberController mc = new MemberController();
						mc.searchId(nametext, emailtext);
						
					
						
						
					}
				});
				confirmBtn.setBounds(217, 342, 119, 54);
				idSearchPanel.add(confirmBtn);
				
				MainView.setMainPage(idSearchPanel);

			}
		});
		searchId.setBounds(144, 496, 130, 27);
		panel.add(searchId);
		
		
		
		/*��й�ȣ ã�� ��ư*/
		JButton searchPwd = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		searchPwd.setBackground(Color.BLACK);
		searchPwd.setForeground(Color.WHITE);
		searchPwd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// ��й�ȣã�� ��ư Ŭ���ϸ�
				panel.setVisible(false); // �α��� â ����
				
				JPanel pwdSearchPanel = new JPanel();
				
				pwdSearchPanel.setBackground(Color.WHITE);
				pwdSearchPanel.setLayout(null);

				JLabel lblIdpwFind = new JLabel("ID/PW FIND");
				lblIdpwFind.setFont(new Font("����", Font.BOLD, 38));
				lblIdpwFind.setHorizontalAlignment(SwingConstants.CENTER);
				lblIdpwFind.setBounds(133, 55, 288, 54);
				pwdSearchPanel.add(lblIdpwFind);

				JLabel searchLb = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
				searchLb.setFont(new Font("����", Font.BOLD, 17));
				searchLb.setBounds(64, 155, 98, 31);
				pwdSearchPanel.add(searchLb);

				JLabel nameLb = new JLabel("\uC774\uB984 : ");
				nameLb.setFont(new Font("����", Font.PLAIN, 19));
				nameLb.setBounds(100, 214, 62, 49);
				pwdSearchPanel.add(nameLb);

				JLabel emailLb = new JLabel("\uC774\uBA54\uC77C : ");
				emailLb.setFont(new Font("����", Font.PLAIN, 19));
				emailLb.setBounds(100, 275, 78, 31);
				pwdSearchPanel.add(emailLb);

				JTextField nametext = new JTextField();
				nametext.setBounds(173, 218, 248, 38);
				pwdSearchPanel.add(nametext);
				nametext.setColumns(10);

				JTextField emailtext = new JTextField();
				emailtext.setColumns(10);
				emailtext.setBounds(174, 273, 248, 38);
				pwdSearchPanel.add(emailtext);

				JButton confirmBtn = new JButton("\uD655  \uC778");
				confirmBtn.setForeground(Color.WHITE);
				confirmBtn.setBackground(Color.BLACK);
				confirmBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// ��й�ȣ ã�� Ȯ�ι�ư ������
						
						MemberController mc = new MemberController();
						mc.searchPwd(nametext, emailtext);
						
						
						
						
					}
				});
				confirmBtn.setBounds(217, 342, 119, 54);
				pwdSearchPanel.add(confirmBtn);

				MainView.setMainPage(pwdSearchPanel);
			}
		});
		searchPwd.setBounds(287, 496, 130, 27);
		panel.add(searchPwd);

	}
}
