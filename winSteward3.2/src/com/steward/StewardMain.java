package com.steward;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import com.steward.StewardMain.MyEvent;

public class StewardMain extends JFrame  {

	// 패널(+탭 패널)
	JPanel p1, p2, p3, p4, tabMain, tab2_Music, tab3_Movie, tab2_p, tab3_p;

	// p1에 올라갈 txtkey
	JTextField txtkey;

	// p2에 올라갈 Pstart, Psetup
	JButton Pstart, Psetup;

	// p3에 올라갈 cb1,2,3,4 (카테고리별)
	JLabel cateLab1, cateLab2, cateLab3, cateLab4;
	JComboBox cb1, cb2, cb3, cb4;

	// p4에 올라갈 이것저것 버튼(+이미지)
	JButton Bcalc, Bcmd, Bnote, Bsnip, Bpaint, Bexplorer, Bmagnify, Bshutdown, Bhelp;
	ImageIcon CIcon, CmdIcon, NotepadIcon, SnippingIcon, PaintIcon, ExplorerIcon, GlassIcon, PowerIcon, QIcon;

	// 탭1
	JTabbedPane tab;

	// 탭2 button
	JButton tab2_b1, tab2_b2, tab2_b3, tab2_b4, tab2_b5, tab2_b6, tab2_b7, tab2_b8, tab2_b9, tab2_b10;

	// 탭3 button
	JButton tab3_b1, tab3_b2, tab3_b3, tab3_b4, tab3_b5, tab3_b6, tab3_b7, tab3_b8, tab3_b9, tab3_b10;

	// 종료버튼 시 팝업
	JOptionPane popupExit, popupNoinput;

	// 서브탭 이름
	static String[] music = new String[10];
	static String[] music1 = new String[10];
	static String[] movie = new String[10];
	static String[] movie1 = new String[10];

	public StewardMain() {
		// 탭 생성
		tabMain = new JPanel();
		tab = new JTabbedPane();

		// 패널 p1 생성
		p1 = new JPanel();
		txtkey = new JTextField(20);

		// 패털 p2생성
		p2 = new JPanel();
		Pstart = new JButton("실행");
		Psetup = new JButton("설정");

		// 패널 p3생성
		p3 = new JPanel();
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		cb3 = new JComboBox();
		cb4 = new JComboBox();

		cateLab1 = new JLabel("URL1");
		cateLab2 = new JLabel("URL2");
		cateLab3 = new JLabel("File");
		cateLab4 = new JLabel("Folder");

		// 패널 p4생성
		p4 = new JPanel();
		// image
		CIcon = new ImageIcon("image/calculator.png");
		CmdIcon = new ImageIcon("image/cmd.png");
		NotepadIcon = new ImageIcon("image/notepad.png");
		SnippingIcon = new ImageIcon("image/snipping.png");
		PaintIcon = new ImageIcon("image/paint.png");
		ExplorerIcon = new ImageIcon("image/expl.png");
		GlassIcon = new ImageIcon("image/glass.png");
		PowerIcon = new ImageIcon("image/power.png");
		QIcon = new ImageIcon("image/qmark.png");

		// 버튼
		Bcalc = new JButton(CIcon);
		Bcmd = new JButton(CmdIcon);
		Bnote = new JButton(NotepadIcon);
		Bsnip = new JButton(SnippingIcon);
		Bpaint = new JButton(PaintIcon);
		Bexplorer = new JButton(ExplorerIcon);
		Bmagnify = new JButton(GlassIcon);
		Bshutdown = new JButton(PowerIcon);
		Bhelp = new JButton(QIcon);

		// 탭2 설정
		tab2_Music = new JPanel();
		tab2_p = new JPanel();
		tab2_b1 = new JButton(music1[0]);
		tab2_b2 = new JButton(music1[1]);
		tab2_b3 = new JButton(music1[2]);
		tab2_b4 = new JButton(music1[3]);
		tab2_b5 = new JButton(music1[4]);
		tab2_b6 = new JButton(music1[5]);
		tab2_b7 = new JButton(music1[6]);
		tab2_b8 = new JButton(music1[7]);
		tab2_b9 = new JButton(music1[8]);
		tab2_b10 = new JButton(music1[9]);

		// 탭3 설정
		tab3_Movie = new JPanel();
		tab3_p = new JPanel();
		tab3_b1 = new JButton(movie1[0]);
		tab3_b2 = new JButton(movie1[1]);
		tab3_b3 = new JButton(movie1[2]);
		tab3_b4 = new JButton(movie1[3]);
		tab3_b5 = new JButton(movie1[4]);
		tab3_b6 = new JButton(movie1[5]);
		tab3_b7 = new JButton(movie1[6]);
		tab3_b8 = new JButton(movie1[7]);
		tab3_b9 = new JButton(movie1[8]);
		tab3_b10 = new JButton(movie1[9]);

		// 종료팝업
		popupExit = new JOptionPane();
		popupNoinput = new JOptionPane();
	}

	public void go() {
		// tab 셋팅
		tabMain.setLayout(new GridLayout(2, 2));
		tabMain.add(p1);
		tabMain.add(p2);
		tabMain.add(p3);
		tabMain.add(p4);

		// tab에 올리기
		tab.addTab("Main", tabMain);
		tab.addTab("Music Top10", tab2_Music);
		tab.addTab("Movie Top10", tab3_Movie);

		// p1 패널 셋팅 : 실행키 텍스트필드
		p1.setLayout(new GridLayout());
		p1.add(txtkey);

		// p2 패널 셋팅 : 실행, 설정 버튼
		p2.setLayout(new GridLayout(2, 1));
		p2.add(Pstart);
		p2.add(Psetup);

		// p3 패널 셋팅 : 카테고리 콤보박스 *4
		p3.setLayout(new GridLayout(8, 1));
		p3.add(cateLab1);
		p3.add(cb1);
		p3.add(cateLab2);
		p3.add(cb2);
		p3.add(cateLab3);
		p3.add(cb3);
		p3.add(cateLab4);
		p3.add(cb4);

		// p4 패널 셋팅 : 이것저것 버튼
		p4.setLayout(new GridLayout(3, 3));
		p4.add(Bcalc);
		p4.add(Bcmd);
		p4.add(Bnote);

		p4.add(Bsnip);
		p4.add(Bpaint);
		p4.add(Bexplorer);

		p4.add(Bmagnify);
		p4.add(Bshutdown);
		p4.add(Bhelp);

		// 탭2_music 생성
		tab2_Music.setLayout(new GridLayout());
		tab2_Music.add(tab2_p);
		tab2_p.setLayout(new GridLayout(10, 1));

		tab2_p.add(tab2_b1);
		tab2_p.add(tab2_b2);
		tab2_p.add(tab2_b3);
		tab2_p.add(tab2_b4);
		tab2_p.add(tab2_b5);
		tab2_p.add(tab2_b6);
		tab2_p.add(tab2_b7);
		tab2_p.add(tab2_b8);
		tab2_p.add(tab2_b9);
		tab2_p.add(tab2_b10);

		// 탭3_movie
		tab3_Movie.setLayout(new GridLayout());
		tab3_Movie.add(tab3_p);
		tab3_p.setLayout(new GridLayout(10, 1));

		tab3_p.add(tab3_b1);
		tab3_p.add(tab3_b2);
		tab3_p.add(tab3_b3);
		tab3_p.add(tab3_b4);
		tab3_p.add(tab3_b5);
		tab3_p.add(tab3_b6);
		tab3_p.add(tab3_b7);
		tab3_p.add(tab3_b8);
		tab3_p.add(tab3_b9);
		tab3_p.add(tab3_b10);

		// 프레임에 올리고
		add(tab);
		setTitle("윈집사 ver 3");

		events();

		setResizable(false);
		setSize(600, 450);
		setVisible(true);
	}

	public void events() {
		// p1 패널 : 텍스트필드 엔터 이벤트
		txtkey.addKeyListener(new MyEvent());

		// p2 패널 : 실행, 설정 버튼 이벤트
		Psetup.addActionListener(new MyEvent());
		Pstart.addActionListener(new MyEvent());

		// p4 패널 : 이것저것 버튼 이벤트
		Bcalc.addActionListener(new MyEvent());
		Bcmd.addActionListener(new MyEvent());
		Bnote.addActionListener(new MyEvent());
		Bsnip.addActionListener(new MyEvent());
		Bpaint.addActionListener(new MyEvent());
		Bexplorer.addActionListener(new MyEvent());
		Bmagnify.addActionListener(new MyEvent());
		Bshutdown.addActionListener(new MyEvent());
		Bhelp.addActionListener(new MyEvent());

		// 서브탭 이벤트
		tab2_b1.addActionListener(new MyEvent());
		tab2_b2.addActionListener(new MyEvent());
		tab2_b3.addActionListener(new MyEvent());
		tab2_b4.addActionListener(new MyEvent());
		tab2_b5.addActionListener(new MyEvent());
		tab2_b6.addActionListener(new MyEvent());
		tab2_b7.addActionListener(new MyEvent());
		tab2_b8.addActionListener(new MyEvent());
		tab2_b9.addActionListener(new MyEvent());
		tab2_b10.addActionListener(new MyEvent());

		tab3_b1.addActionListener(new MyEvent());
		tab3_b2.addActionListener(new MyEvent());
		tab3_b3.addActionListener(new MyEvent());
		tab3_b4.addActionListener(new MyEvent());
		tab3_b5.addActionListener(new MyEvent());
		tab3_b6.addActionListener(new MyEvent());
		tab3_b7.addActionListener(new MyEvent());
		tab3_b8.addActionListener(new MyEvent());
		tab3_b9.addActionListener(new MyEvent());
		tab3_b10.addActionListener(new MyEvent());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 콤보박스에 올리기
		FileReader fr;
		String ch;

		try {
			fr = new FileReader("key.txt");

			BufferedReader br = new BufferedReader(fr);
			try {

				while ((ch = br.readLine()) != null) {
					PkeySetting pk = new PkeySetting(ch);

					//각 카테고리 별 저장
					if (pk.getCategory().equals(cateLab1.getText())) {
						cb1.addItem(pk.getKey());
					} else if (pk.getCategory().equals(cateLab2.getText())) {
						cb2.addItem(pk.getKey());
					} else if (pk.getCategory().equals(cateLab3.getText())) {
						cb3.addItem(pk.getKey());
					} else if (pk.getCategory().equals(cateLab4.getText())) {
						cb4.addItem(pk.getKey());
					}

				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}

		// 콤보박스 이벤트
		cb1.addActionListener(new MyEvent());
		cb2.addActionListener(new MyEvent());
		cb3.addActionListener(new MyEvent());
		cb4.addActionListener(new MyEvent());
	}

	class MyEvent extends KeyAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// 콤보박스에서 선택된 아이템 실행
			FileReader fr;
			String ch;
			if ((e.getSource() == cb1) || (e.getSource() == cb2) || (e.getSource() == cb3) || (e.getSource() == cb4)) {
				JComboBox cb = (JComboBox) e.getSource();

				try {
					fr = new FileReader("key.txt");

					BufferedReader br = new BufferedReader(fr);

					while ((ch = br.readLine()) != null) {
						PkeySetting pk = new PkeySetting(ch);
						if (cb == cb1) {
							String str = (String) cb1.getSelectedItem();
							if (str.equals(pk.getKey())) {
								new Run();
								Run.exe(pk.getUrl());
							}
						} else if (cb == cb2) {
							String str = (String) cb2.getSelectedItem();
							if (str.equals(pk.getKey())) {
								new Run();
								Run.exe(pk.getUrl());
							}
						} else if (cb == cb3) {
							String str = (String) cb3.getSelectedItem();
							if (str.equals(pk.getKey())) {
								new Run();
								Run.exe(pk.getUrl());
							}
						} else {
							String str = (String) cb4.getSelectedItem();
							if (str.equals(pk.getKey())) {
								new Run();
								Run.exe(pk.getUrl());
							}
						}

					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else {

				JButton bt = (JButton) e.getSource();

				//music 탭 버튼 실행
				String url1 = "https://www.youtube.com/results?search_query=";
				if (bt.equals(tab2_b1)) {
					new Run();
					Run.exe(url1 + music[0]);
				}
				if (bt.equals(tab2_b2)) {
					new Run();
					Run.exe(url1 + music[1]);
				}
				if (bt.equals(tab2_b3)) {
					new Run();
					Run.exe(url1 + music[2]);
				}
				if (bt.equals(tab2_b4)) {
					new Run();
					Run.exe(url1 + music[3]);
				}
				if (bt.equals(tab2_b5)) {
					new Run();
					Run.exe(url1 + music[4]);
				}
				if (bt.equals(tab2_b6)) {
					new Run();
					Run.exe(url1 + music[5]);
				}
				if (bt.equals(tab2_b7)) {
					new Run();
					Run.exe(url1 + music[6]);
				}
				if (bt.equals(tab2_b8)) {
					new Run();
					Run.exe(url1 + music[7]);
				}
				if (bt.equals(tab2_b9)) {
					new Run();
					Run.exe(url1 + music[8]);
				}
				if (bt.equals(tab2_b10)) {
					new Run();
					Run.exe(url1 + music[9]);
				}

				//movie 탭 버튼 실행
				String url2 = "https://search.naver.com/search.naver?where=nexearch&query=";
				if (bt.equals(tab3_b1)) {
					new Run();
					Run.exe(url2 + movie[0]);
				}
				if (bt.equals(tab3_b2)) {
					new Run();
					Run.exe(url2 + movie[1]);
				}
				if (bt.equals(tab3_b3)) {
					new Run();
					Run.exe(url2 + movie[2]);
				}
				if (bt.equals(tab3_b4)) {
					new Run();
					Run.exe(url2 + movie[3]);
				}
				if (bt.equals(tab3_b5)) {
					new Run();
					Run.exe(url2 + movie[4]);
				}
				if (bt.equals(tab3_b6)) {
					new Run();
					Run.exe(url2 + movie[5]);
				}
				if (bt.equals(tab3_b7)) {
					new Run();
					Run.exe(url2 + movie[6]);
				}
				if (bt.equals(tab3_b8)) {
					new Run();
					Run.exe(url2 + movie[7]);
				}
				if (bt.equals(tab3_b9)) {
					new Run();
					Run.exe(url2 + movie[8]);
				}
				if (bt.equals(tab3_b10)) {
					new Run();
					Run.exe(url2 + movie[9]);
				}

				// 설정버튼 누르면 StewardOption 여는 부분
				if (bt.equals(Psetup)) {
					new StewardOption().go();
				}

				KeyComp comp = new KeyComp();

				///////////// 1. 계산기
				if (bt.equals(Bcalc)) {
					new Run();
					Run.exe("calc");
				}

				//////////// 2.cmd
				if (bt.equals(Bcmd)) {
					new Run();
					Run.exe("cmd");
				}

				//////////// 3.메모장
				if (bt.equals(Bnote)) {
					new Run();
					Run.exe("notepad");
				}

				//////////// 4.SnippingTool
				if (bt.equals(Bsnip)) {
					new Run();
					Run.exe("SnippingTool");
				}

				//////////// 5.mspaint
				if (bt.equals(Bpaint)) {
					new Run();
					Run.exe("mspaint");
				}

				//////////// 6.탐색기
				if (bt.equals(Bexplorer)) {
					new Run();
					Run.exe("explorer.exe");
				}

				//////////// 7.돋보기
				if (bt.equals(Bmagnify)) {
					new Run();
					Run.exe("Magnify");
				}

				//////////// 8.pc종료
				if (bt.equals(Bshutdown)) {
					Runtime runtime = Runtime.getRuntime();

					int result = JOptionPane.showConfirmDialog(null, "종료합니다.", "종료확인", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);

					if (result == 0) {

						try {
							Process process = runtime.exec("C:\\WINDOWS\\system32\\cmd.exe");
							OutputStream os = process.getOutputStream();
							os.write("shutdown -s -f -t 0 \n\r".getBytes());
							os.close();
							process.waitFor();
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}

				}

				//////////// 9.도움
				if (bt.equals(Bhelp)) {
					// 현재 클래스의 절대 경로를 가져온다.
					String path = StewardMain.class.getResource("").getPath();
					File fPath = new File(path + "[HELP].txt");
					new Run();
					Run.exe(fPath.toString());
				}

				if (bt.equals(Pstart)) {
					if (txtkey.getText().equals("")) {
						popupNoinput.showMessageDialog(null, "실행키가  없습니다.", "NullPointException",JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							comp.KeyComp(txtkey.getText());
							new Run();
							Run.exe(comp.startUrl);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}

			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			KeyComp comp = new KeyComp();

			// 엔터 치면 Run.exe()를 호출합니다.
			if (e.getKeyChar() == KeyEvent.VK_ENTER && txtkey.getText() != null) {
				try {
					comp.KeyComp(txtkey.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				new Run();
				Run.exe(comp.startUrl);
			}

			// 단축키 눌렸을 때 Run.exe()를 실행합니다.
			FileReader fr;
			String ch;

			try {
				fr = new FileReader("key.txt");

				BufferedReader br = new BufferedReader(fr);
				try {

					while ((ch = br.readLine()) != null) {
						
						PkeySetting pk = new PkeySetting(ch);

						String compare = (e.getModifiers() + "-" + e.getModifiers() + "-" + e.getModifiers() + "-"
								+ e.getKeyCode());

						if (compare.equals(pk.getShkey())) {
							new Run();
							Run.exe(pk.getUrl());
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		new StewardMain().go();
	}
}
