package com.boram.member.view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
import com.boram.myPage.controller.MyCart;
import com.boram.shopping.view.FixedMainMenu;
import com.boram.shopping.view.MainPanel;
import com.boram.shopping.view.MainView;

public class MemberView1 {

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

		/*
		 * �α��� ��ư
		 */
		JButton logIn = new JButton("\uB85C\uADF8\uC778");
		logIn.setFont(new Font("����", Font.PLAIN, 18));
		logIn.setForeground(Color.WHITE);
		logIn.setBackground(Color.BLACK);
		logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �α��� ��ư Ŭ���ϸ�
				String userId = id.getText();
				String userPwd = "";
				char[] pwd1 = pwd.getPassword();
				for (int i = 0; i < pwd1.length; i++) {
					userPwd += pwd1[i];
				}

				// ���̵� ��й�ȣ �Է� ��������
				if (userId.length() == 0 || userPwd.length() == 0) {
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է� �ϼž� �˴ϴ�.", "�Է��� Ȯ���ϼ���!",
							JOptionPane.DEFAULT_OPTION); // �Է�Ȯ�� �˾�â
					return;
				}

				MemberController mc = new MemberController();
				Member result = mc.logIn(userId, userPwd); // �����Ʈ�ѷ����� ����Ǿ��ִ� ���̵� �н��������� Ȯ��

				// �α��� �����ϸ� Ȯ�� �˾�â �߰� �ٽ� �α����ϴ� â ���ư���
				if (result == null) {
					JOptionPane.showMessageDialog(null, "�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
					Login.setVisible(true);
					MainView.setMainPage(Login);
					Login.add(panel);
				}
				// �α��� ������
				else {
					MyCart mct = new MyCart();
					mct.loadCart(); // �α����ϸ� ���� ��ٱ��Ͽ� �����ߴ� ���� �ҷ�����
					Login.setVisible(false); // �α��� â ����
					// ����â ����
					MainView.setMainPage(new MainPanel(1).getMainPanel());
					// ������ �ٲٱ�
					MainView.setMainMenu(new FixedMainMenu().getMainMenu());
				}

			}
		});

		logIn.setBounds(66, 370, 189, 44);
		panel.add(logIn);

		/*
		 * ȸ������ ��ư
		 */
		JButton join = new JButton("\uD68C\uC6D0\uAC00\uC785");
		join.setFont(new Font("����", Font.PLAIN, 18));
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

				JLabel idLb = new JLabel("* \uC544\uC774\uB514");
				idLb.setFont(new Font("����", Font.BOLD, 18));
				idLb.setBounds(41, 164, 102, 28);
				joinPanel.add(idLb);

				JLabel pwdLb = new JLabel("* \uBE44\uBC00\uBC88\uD638");
				pwdLb.setFont(new Font("����", Font.BOLD, 18));
				pwdLb.setBounds(40, 217, 103, 36);
				joinPanel.add(pwdLb);

				JLabel nameLb = new JLabel("* \uC774\uB984");
				nameLb.setFont(new Font("����", Font.BOLD, 18));
				nameLb.setBounds(41, 287, 62, 18);
				joinPanel.add(nameLb);

				JLabel birthLb = new JLabel("\uC0DD\uB144\uC6D4\uC77C ");
				birthLb.setFont(new Font("����", Font.PLAIN, 18));
				birthLb.setBounds(41, 342, 191, 28);
				joinPanel.add(birthLb);

				JLabel addressLb = new JLabel("* \uC8FC\uC18C");
				addressLb.setFont(new Font("����", Font.BOLD, 18));
				addressLb.setBounds(41, 409, 62, 18);
				joinPanel.add(addressLb);

				JLabel phoneLb = new JLabel("* \uD578\uB4DC\uD3F0 \uBC88\uD638");
				phoneLb.setFont(new Font("����", Font.BOLD, 18));
				phoneLb.setBounds(41, 463, 150, 28);
				joinPanel.add(phoneLb);

				JLabel emailLb = new JLabel("\uC774\uBA54\uC77C ");
				emailLb.setFont(new Font("����", Font.PLAIN, 18));
				emailLb.setBounds(41, 526, 80, 28);
				joinPanel.add(emailLb);

				JLabel starLb = new JLabel("'*'�� ��� �Է��� �ּ���.");
				starLb.setFont(new Font("����", Font.BOLD, 15));
				starLb.setBounds(160, 560, 200, 80);
				joinPanel.add(starLb);

				JTextField idText = new JTextField(); // ���̵��Է�
				idText.setBounds(301, 162, 176, 36);
				joinPanel.add(idText);
				idText.setColumns(10);

				JTextField pwdText = new JTextField(); // ��й�ȣ�Է�
				pwdText.setColumns(10);
				pwdText.setBounds(301, 225, 176, 36);
				joinPanel.add(pwdText);

				JTextField nameText = new JTextField(); // �̸��Է�
				nameText.setColumns(10);
				nameText.setBounds(301, 286, 176, 36);
				joinPanel.add(nameText);

				Choice year = new Choice(); // �¾ ����
				year.setBounds(300, 345, 80, 36);
				int y = 0;
				for (y = 1900; y < 2011; y++) {
					year.add(String.valueOf(y));
				}
				joinPanel.add(year);

				Choice month = new Choice(); // �¾ ��
				month.setBounds(400, 345, 45, 36);
				int m = 0;
				for (m = 0; m < 13; m++) {
					month.add(String.valueOf(m));
				}
				joinPanel.add(month);

				Choice day = new Choice(); // �¾ ��
				day.setBounds(460, 345, 45, 36);
				int d = 0;
				for (d = 0; d < 32; d++) {
					day.add(String.valueOf(d));
				}
				joinPanel.add(day);

				JTextField phoneText = new JTextField(); // ����ȣ �Է�
				phoneText.setColumns(10);
				phoneText.setBounds(301, 463, 176, 36);
				joinPanel.add(phoneText);

				JTextField emailText = new JTextField(); // �̸��� �Է�
				emailText.setColumns(10);
				emailText.setBounds(301, 518, 176, 36);
				joinPanel.add(emailText);

				JTextField addressText = new JTextField(); // �ּ��Է�
				addressText.setBounds(301, 399, 377, 43);
				joinPanel.add(addressText);
				addressText.setColumns(10);

				/*
				 * ȸ������ Ȯ�� ��ư
				 */
				JButton joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
				joinBtn.setForeground(Color.WHITE);
				joinBtn.setBackground(Color.BLACK);
				joinBtn.setFont(new Font("����", Font.PLAIN, 22));
				joinBtn.setEnabled(false);
				joinBtn.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						// �����Է��� ȸ������ ��ư ������
						String name = nameText.getText();
						String id = idText.getText();
						String pwd = pwdText.getText();
						String phone = phoneText.getText();
						String address = addressText.getText();
						String email = emailText.getText();

						if (name.equals("") || id.equals("") || pwd.equals("") || phone.equals("") || address.equals("")) {
							JOptionPane.showMessageDialog(null, "������ ��� �Է��ϼ���.");// �ϳ��� �Է¾��ϰ� ���Դ����� �ߴ� �˾�â

						} else {

							MemberController mc = new MemberController();
							mc.join(name, year.getSelectedItem(), month.getSelectedItem(), day.getSelectedItem(), id,
									pwd, phone, address, email); // �Է��Ѱ� �����Ʈ�ѷ� ȸ������Ʈ�� �߰�

							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame, "ȸ�������� �Ϸ� �Ǿ����ϴ�."); // �Ϸ�Ǹ� �Ϸ� �˾�â
							Login.setVisible(true);

							// ȸ������â ����
							joinPanel.setVisible(false);

							// �α���â �߱�
							MainView.setMainPage(Login);
							Login.add(panel);
						}
					}
				});
				joinBtn.setBounds(252, 650, 160, 52);
				joinPanel.add(joinBtn);

				/*
				 * ���̵� üũ ��ư
				 */
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

						// ���� ���̵� �����ϸ�
						if (result == 1) {
							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame, "���� ���̵� �����մϴ�. �ٸ�ID�� ����ϼ���."); // �ٸ����̵� ����϶�� �˾�â
							joinBtn.setEnabled(false); // ȸ�����Թ�ư �ȴ������ϱ�
						}

						// ����� ���̵�� �ٸ��� ��밡��
						else if (result == 0) {
							JFrame frame2 = new JFrame();
							JOptionPane.showMessageDialog(frame2, "��밡���� ID�Դϴ�."); // ����Ҽ� �ִٴ� �˾�â
							joinBtn.setEnabled(true); // ȸ�����Թ�ư ����
						}

					}
				});

				idcheckBtn.setBounds(500, 164, 150, 25);
				joinPanel.add(idcheckBtn);

				MainView.setMainPage(joinPanel);
			}
		});

		join.setBounds(301, 370, 199, 44);
		panel.add(join);

		/*
		 * ���̵� ã�� ��ư
		 */
		JButton searchId = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		searchId.setFont(new Font("Gulim", Font.PLAIN, 15));
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

				JLabel phoneLb = new JLabel("�ڵ��� ��ȣ('-'���� �Է�) : ");
				phoneLb.setFont(new Font("����", Font.PLAIN, 19));
				phoneLb.setBounds(100, 275, 250, 30);
				idSearchPanel.add(phoneLb);

				JTextField nametext = new JTextField(); // �̸��Է�
				nametext.setBounds(350, 218, 248, 38);
				idSearchPanel.add(nametext);
				nametext.setColumns(10);

				JTextField phonetext = new JTextField(); // ����ȣ�Է�
				phonetext.setColumns(10);
				phonetext.setBounds(350, 273, 248, 38);
				idSearchPanel.add(phonetext);

				/*
				 * ���̵� ã�� ���� �Է��� Ȯ�� ��ư
				 */
				JButton confirmBtn = new JButton("\uD655  \uC778");
				confirmBtn.setFont(new Font("����", Font.PLAIN, 18));
				confirmBtn.setForeground(Color.WHITE);
				confirmBtn.setBackground(Color.BLACK);
				confirmBtn.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						// ���̵� ã�� Ȯ�� ��ư ������
						MemberController mc = new MemberController();

						// ã�� �̸��� ��ȣ�� ������
						if (mc.searchId(nametext, phonetext) == null) {
							JOptionPane.showMessageDialog(null, "��ġ�ϴ� ������ �����ϴ�"); // ����ġ �˾�â

						// �̸��� ��ȣ�� �´� ����� ���̵� ã����
						} else {
							String id = mc.searchId(nametext, phonetext);
							// ã�� id �˾�â�߱�
							String i = (nametext.getText() + "���� ���̵� : " + id);
							JOptionPane.showMessageDialog(null, i);

							// ���̵�ã��â ����
							idSearchPanel.setVisible(false);
							panel.setVisible(true);

							// �α���â �߱�
							MainView.setMainPage(Login);
							Login.add(panel);

						}

					}
				});
				confirmBtn.setBounds(280, 342, 119, 54);
				idSearchPanel.add(confirmBtn);

				MainView.setMainPage(idSearchPanel);

			}

		});
		searchId.setBounds(130, 496, 130, 27);
		panel.add(searchId);

		/*
		 * ��й�ȣ ã�� ��ư
		 */
		JButton searchPwd = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		searchPwd.setFont(new Font("Gulim", Font.PLAIN, 15));
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

				JLabel searchLb = new JLabel("��й�ȣ ã��");
				searchLb.setFont(new Font("����", Font.BOLD, 17));
				searchLb.setBounds(64, 155, 150, 31);
				pwdSearchPanel.add(searchLb);

				JLabel nameLb = new JLabel("\uC774\uB984 : ");
				nameLb.setFont(new Font("����", Font.PLAIN, 19));
				nameLb.setBounds(100, 214, 62, 49);
				pwdSearchPanel.add(nameLb);

				JLabel phoneLb = new JLabel("�ڵ��� ��ȣ('-'���� �Է�) : ");
				phoneLb.setFont(new Font("����", Font.PLAIN, 19));
				phoneLb.setBounds(100, 275, 250, 30);
				pwdSearchPanel.add(phoneLb);

				JTextField nametext = new JTextField(); // �̸��Է�
				nametext.setBounds(350, 218, 248, 38);
				pwdSearchPanel.add(nametext);
				nametext.setColumns(10);

				JTextField phonetext = new JTextField(); // ����ȣ�Է�
				phonetext.setColumns(10);
				phonetext.setBounds(350, 273, 248, 38);
				pwdSearchPanel.add(phonetext);

				/*
				 * ��й�ȣã�� �̸��� ����ȣ �Է��� Ȯ�ι�ư
				 */
				JButton confirmBtn = new JButton("\uD655  \uC778");
				confirmBtn.setFont(new Font("����", Font.PLAIN, 18));
				confirmBtn.setForeground(Color.WHITE);
				confirmBtn.setBackground(Color.BLACK);
				confirmBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// ��й�ȣ ã�� Ȯ�ι�ư ������
						MemberController mc = new MemberController();

						// �̸��� ��ȣ�� ã���� ������
						if (mc.searchId(nametext, phonetext) == null) {
							JOptionPane.showMessageDialog(null, "��ġ�ϴ� ������ �����ϴ�"); // ����ġ �˾�â

							// �̸��� ��ȣ�� ��ġ�ϴ� ��й�ȣã����
						} else {
							String pwd = mc.searchId(nametext, phonetext);
							// ã�� pwd �˾�â�߱�
							String i = (nametext.getText() + "���� ��й�ȣ : " + pwd);
							JOptionPane.showMessageDialog(null, i);

							// ��й�ȣã��â ����
							pwdSearchPanel.setVisible(false);
							panel.setVisible(true);

							// �α���â �߱�
							MainView.setMainPage(Login);
							Login.add(panel);
						}
					}
				});
				confirmBtn.setBounds(290, 342, 119, 54);
				pwdSearchPanel.add(confirmBtn);

				MainView.setMainPage(pwdSearchPanel);
			}
		});
		searchPwd.setBounds(300, 496, 130, 27);
		panel.add(searchPwd);

	}
}
