package com.steward;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import com.steward.StewardOption.MyEvent;

public class StewardOption extends JFrame  {

	// 생성자에서 확인(너무 많이 섞임)
	JPanel p, p1, p1_1, p1_2, p2, p3, p4, p4_1;
	JTextField addrKey, openKey, shKey;
	JLabel addr_L, open_L, sh_L, null_L;
	JButton Paddr, Psave, Pexit;
	Checkbox shCtrl, shAlt, shShift;
	ButtonGroup rbtGroup;
	JRadioButton rBt1, rBt2, rBt3, rBt4;
	JOptionPane popupNosave;

	public StewardOption() {
		// 기본
		p = new JPanel();
		null_L = new JLabel();

		// p1
		p1 = new JPanel();
		p1_1 = new JPanel();
		p1_2 = new JPanel();
		// p1에 올라갈 textfield
		addrKey = new JTextField(20);
		openKey = new JTextField(20);
		// p1에 올라갈 라벨, 버튼
		addr_L = new JLabel("주 소");
		open_L = new JLabel("실행키");
		Paddr = new JButton("주소");

		// p2
		p2 = new JPanel();
		// p2에 올라갈 버튼
		Psave = new JButton("저장");
		Pexit = new JButton("취소");

		// p3
		p3 = new JPanel();
		// p3에 올라갈 그룹화된 라디오버튼, 버튼
		rBt1 = new JRadioButton("URL1");
		rBt2 = new JRadioButton("URL2");
		rBt3 = new JRadioButton("File");
		rBt4 = new JRadioButton("Folder");
		rbtGroup = new ButtonGroup();

		// p4
		p4 = new JPanel();
		// 라벨과 텍스트필드 올릴 패널
		p4_1 = new JPanel();
		// p4에 올라갈 textfield
		shKey = new JTextField(2);
		// p4에 올라갈 라벨, 체크박스
		sh_L = new JLabel("키보드 입력");
		shCtrl = new Checkbox("Ctrl");
		shAlt = new Checkbox("Alt");
		shShift = new Checkbox("Shift");

		// 중복 팝업
		popupNosave = new JOptionPane();

	}

	public void go() {
		setLayout(new GridLayout(2, 2));

		// p1 : 주소찾기 버튼, 주소 입력, 실행키 입력
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

		// p2 : 실행버튼, 취소버튼
		p2.add(Psave);
		p2.add(Pexit);

		// p3 : 라디오버튼
		p3.setLayout(new GridLayout(2, 2));
		p3.add(rBt1);
		p3.add(rBt2);
		p3.add(rBt3);
		p3.add(rBt4);
		rbtGroup.add(rBt1);
		rbtGroup.add(rBt2);
		rbtGroup.add(rBt3);
		rbtGroup.add(rBt4);

		// p4 : 단축키
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
		//각 버튼 이벤트
		Paddr.addActionListener(new MyEvent());
		Psave.addActionListener(new MyEvent());
		Pexit.addActionListener(new MyEvent());

	}

	class MyEvent implements ActionListener {

		//주소버튼 누르면 'open 탐색기' 실행
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

			// 취소 버튼
			if (bt.equals(Pexit)) {
				dispose();
			}

			// 저장 버튼
			if (bt.equals(Psave)) {

				//카테고리 저장 위한 변수
				String j = "";
				
				//라디오버튼(카테고리) 저장부분
				if ((rBt1.isSelected() || rBt2.isSelected() || rBt3.isSelected() || rBt4.isSelected()) == false) {
					popupNosave.showMessageDialog(null, "카테고리를 선택하세요.", "저장오류", JOptionPane.YES_NO_OPTION);
				} else {
					//선택된 라디오버튼을 카테고리 저장
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
							
							// 단축키 지정할 경우 (3개로 나올 수 있는 단축키 조합 별 모두 저장)
							String s = "0-" + "0-" + "0-" + shKey.getText().toUpperCase().codePointAt(0);
							if (shCtrl.getState()) {
								if (shAlt.getState()) {
									if (shShift.getState()) {// 컨.알.쉬
										sum = InputEvent.CTRL_MASK + InputEvent.ALT_MASK + InputEvent.SHIFT_MASK;
										s = sum + "-" + sum + "-" + sum + "-"
												+ shKey.getText().toUpperCase().codePointAt(0);
									} else {// 컨.알
										sum = InputEvent.CTRL_MASK + InputEvent.ALT_MASK;
										s = sum + "-" + sum + "-" + sum + "-"
												+ shKey.getText().toUpperCase().codePointAt(0);
									}
								} else {
									if (shShift.getState()) {// 컨.쉬
										sum = InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK;
										s = sum + "-" + sum + "-" + sum + "-"
												+ shKey.getText().toUpperCase().codePointAt(0);
									} else {// 컨
										sum = InputEvent.CTRL_MASK;
										s = sum + "-" + sum + "-" + sum + "-"
												+ shKey.getText().toUpperCase().codePointAt(0);
									}
								}
							} else if (shAlt.getState()) {
								if (shShift.getState()) {// 알.쉬
									sum = InputEvent.ALT_MASK + InputEvent.SHIFT_MASK;
									s = sum + "-" + sum + "-" + sum + "-"
											+ shKey.getText().toUpperCase().codePointAt(0);
								} else {// 알
									sum = InputEvent.ALT_MASK;
									s = sum + "-" + sum + "-" + sum + "-"
											+ shKey.getText().toUpperCase().codePointAt(0);
								}
							} else {
								if (shShift.getState()) {// 쉬
									sum = InputEvent.SHIFT_MASK;
									s = sum + "-" + sum + "-" + sum + "-"
											+ shKey.getText().toUpperCase().codePointAt(0);
								}
							}
							new Savetxt().KeyOutput(openKey.getText(), addrKey.getText(), s, j);
						} else {
							// 단축키 지정안 할 경우
							new Savetxt().KeyOutput(openKey.getText(), addrKey.getText(), j);
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//저장 후 초기화 부분
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
