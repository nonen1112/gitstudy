package com.steward;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import com.steward.StewardOption.MyEvent;

public class StewardOption extends JFrame  {

	// �����ڿ��� Ȯ��(�ʹ� ���� ����)
	JPanel p, p1, p1_1, p1_2, p2, p3, p4, p4_1;
	JTextField addrKey, openKey, shKey;
	JLabel addr_L, open_L, sh_L, null_L;
	JButton Paddr, Psave, Pexit;
	Checkbox shCtrl, shAlt, shShift;
	ButtonGroup rbtGroup;
	JRadioButton rBt1, rBt2, rBt3, rBt4;
	JOptionPane popupNosave;

	public StewardOption() {
		// �⺻
		p = new JPanel();
		null_L = new JLabel();

		// p1
		p1 = new JPanel();
		p1_1 = new JPanel();
		p1_2 = new JPanel();
		// p1�� �ö� textfield
		addrKey = new JTextField(20);
		openKey = new JTextField(20);
		// p1�� �ö� ��, ��ư
		addr_L = new JLabel("�� ��");
		open_L = new JLabel("����Ű");
		Paddr = new JButton("�ּ�");

		// p2
		p2 = new JPanel();
		// p2�� �ö� ��ư
		Psave = new JButton("����");
		Pexit = new JButton("���");

		// p3
		p3 = new JPanel();
		// p3�� �ö� �׷�ȭ�� ������ư, ��ư
		rBt1 = new JRadioButton("URL1");
		rBt2 = new JRadioButton("URL2");
		rBt3 = new JRadioButton("File");
		rBt4 = new JRadioButton("Folder");
		rbtGroup = new ButtonGroup();

		// p4
		p4 = new JPanel();
		// �󺧰� �ؽ�Ʈ�ʵ� �ø� �г�
		p4_1 = new JPanel();
		// p4�� �ö� textfield
		shKey = new JTextField(2);
		// p4�� �ö� ��, üũ�ڽ�
		sh_L = new JLabel("Ű���� �Է�");
		shCtrl = new Checkbox("Ctrl");
		shAlt = new Checkbox("Alt");
		shShift = new Checkbox("Shift");

		// �ߺ� �˾�
		popupNosave = new JOptionPane();

	}

	public void go() {
		setLayout(new GridLayout(2, 2));

		// p1 : �ּ�ã�� ��ư, �ּ� �Է�, ����Ű �Է�
		p1.setLayout(new GridLayout(2, 1));
		p1.add(p1_1);
		p1.add(p1_2);

		p1_1.add(null_L);
		p1_1.add(Paddr);

		p1_2.setLayout(new FlowLayout());
		p1_2.add(addr_L);
		p1_2.add(addrKey);
		p1_2.add(open_L);
		p1_2.add(openKey);

		// p2 : �����ư, ��ҹ�ư
		p2.add(Psave);
		p2.add(Pexit);

		// p3 : ������ư
		p3.setLayout(new GridLayout(2, 2));
		p3.add(rBt1);
		p3.add(rBt2);
		p3.add(rBt3);
		p3.add(rBt4);
		rbtGroup.add(rBt1);
		rbtGroup.add(rBt2);
		rbtGroup.add(rBt3);
		rbtGroup.add(rBt4);

		// p4 : ����Ű
		p4.setLayout(new GridLayout(2, 2));

		p4.add(shAlt);
		p4.add(shCtrl);
		p4.add(shShift);
		p4.add(p4_1);

		p4_1.setLayout(new FlowLayout());
		p4_1.add(sh_L);
		p4_1.add(shKey);

		add(p1);
		add(p2);
		add(p3);
		add(p4);

		events();

		setSize(600, 300);
		setVisible(true);
	}

	public void events() {
		//�� ��ư �̺�Ʈ
		Paddr.addActionListener(new MyEvent());
		Psave.addActionListener(new MyEvent());
		Pexit.addActionListener(new MyEvent());

	}

	class MyEvent implements ActionListener {

		//�ּҹ�ư ������ 'open Ž����' ����
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();

			if (bt.equals(Paddr)) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					addrKey.setText(f.getPath());
				}
			}

			// ��� ��ư
			if (bt.equals(Pexit)) {
				dispose();
			}

			// ���� ��ư
			if (bt.equals(Psave)) {

				//ī�װ� ���� ���� ����
				String j = "";
				
				//������ư(ī�װ�) ����κ�
				if ((rBt1.isSelected() || rBt2.isSelected() || rBt3.isSelected() || rBt4.isSelected()) == false) {
					popupNosave.showMessageDialog(null, "ī�װ��� �����ϼ���.", "�������", JOptionPane.YES_NO_OPTION);
				} else {
					//���õ� ������ư�� ī�װ� ����
					if (rBt1.isSelected()) {
						j = "URL1";
					} else if (rBt2.isSelected()) {
						j = "URL2";
					} else if (rBt3.isSelected()) {
						j = "File";
					} else if (rBt4.isSelected()) {
						j = "Folder";
					}

					try {
						int sum = 0;

						if (shCtrl.getState() || shAlt.getState() || shShift.getState()
								|| (shKey.getText().isEmpty() == false)) {
							
							// ����Ű ������ ��� (3���� ���� �� �ִ� ����Ű ���� �� ��� ����)
							String s = "0-" + "0-" + "0-" + shKey.getText().toUpperCase().codePointAt(0);
							if (shCtrl.getState()) {
								if (shAlt.getState()) {
									if (shShift.getState()) {// ��.��.��
										sum = InputEvent.CTRL_MASK + InputEvent.ALT_MASK + InputEvent.SHIFT_MASK;
										s = sum + "-" + sum + "-" + sum + "-"
												+ shKey.getText().toUpperCase().codePointAt(0);
									} else {// ��.��
										sum = InputEvent.CTRL_MASK + InputEvent.ALT_MASK;
										s = sum + "-" + sum + "-" + sum + "-"
												+ shKey.getText().toUpperCase().codePointAt(0);
									}
								} else {
									if (shShift.getState()) {// ��.��
										sum = InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK;
										s = sum + "-" + sum + "-" + sum + "-"
												+ shKey.getText().toUpperCase().codePointAt(0);
									} else {// ��
										sum = InputEvent.CTRL_MASK;
										s = sum + "-" + sum + "-" + sum + "-"
												+ shKey.getText().toUpperCase().codePointAt(0);
									}
								}
							} else if (shAlt.getState()) {
								if (shShift.getState()) {// ��.��
									sum = InputEvent.ALT_MASK + InputEvent.SHIFT_MASK;
									s = sum + "-" + sum + "-" + sum + "-"
											+ shKey.getText().toUpperCase().codePointAt(0);
								} else {// ��
									sum = InputEvent.ALT_MASK;
									s = sum + "-" + sum + "-" + sum + "-"
											+ shKey.getText().toUpperCase().codePointAt(0);
								}
							} else {
								if (shShift.getState()) {// ��
									sum = InputEvent.SHIFT_MASK;
									s = sum + "-" + sum + "-" + sum + "-"
											+ shKey.getText().toUpperCase().codePointAt(0);
								}
							}
							new Savetxt().KeyOutput(openKey.getText(), addrKey.getText(), s, j);
						} else {
							// ����Ű ������ �� ���
							new Savetxt().KeyOutput(openKey.getText(), addrKey.getText(), j);
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//���� �� �ʱ�ȭ �κ�
					addrKey.setText(null);
					openKey.setText(null);
					shKey.setText(null);
					if(shCtrl.getState() || shAlt.getState() || shShift.getState() ||  rBt1.isSelected() ||rBt2.isSelected() ||  rBt3.isSelected() || rBt4.isSelected()){
						shCtrl.setState(false);
						shAlt.setState(false);
						shShift.setState(false);

					}
				}
			}
		}
	}

	public static void main(String[] args) {
	}

}
