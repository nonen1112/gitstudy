package com.steward;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import com.steward.StewardMain.MyEvent;

public class StewardMain extends JFrame  {

	// �г�(+�� �г�)
	JPanel p1, p2, p3, p4, tabMain, tab2_Music, tab3_Movie, tab2_p, tab3_p;

	// p1�� �ö� txtkey
	JTextField txtkey;

	// p2�� �ö� Pstart, Psetup
	JButton Pstart, Psetup;

	// p3�� �ö� cb1,2,3,4 (ī�װ���)
	JLabel cateLab1, cateLab2, cateLab3, cateLab4;
	JComboBox cb1, cb2, cb3, cb4;

	// p4�� �ö� �̰����� ��ư(+�̹���)
	JButton Bcalc, Bcmd, Bnote, Bsnip, Bpaint, Bexplorer, Bmagnify, Bshutdown, Bhelp;
	ImageIcon CIcon, CmdIcon, NotepadIcon, SnippingIcon, PaintIcon, ExplorerIcon, GlassIcon, PowerIcon, QIcon;

	// ��1
	JTabbedPane tab;

	// ��2 button
	JButton tab2_b1, tab2_b2, tab2_b3, tab2_b4, tab2_b5, tab2_b6, tab2_b7, tab2_b8, tab2_b9, tab2_b10;

	// ��3 button
	JButton tab3_b1, tab3_b2, tab3_b3, tab3_b4, tab3_b5, tab3_b6, tab3_b7, tab3_b8, tab3_b9, tab3_b10;

	// �����ư �� �˾�
	JOptionPane popupExit, popupNoinput;

	// ������ �̸�
	static String[] music = new String[10];
	static String[] music1 = new String[10];
	static String[] movie = new String[10];
	static String[] movie1 = new String[10];

	public StewardMain() {
		// �� ����
		tabMain = new JPanel();
		tab = new JTabbedPane();

		// �г� p1 ����
		p1 = new JPanel();
		txtkey = new JTextField(20);

		// ���� p2����
		p2 = new JPanel();
		Pstart = new JButton("����");
		Psetup = new JButton("����");

		// �г� p3����
		p3 = new JPanel();
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		cb3 = new JComboBox();
		cb4 = new JComboBox();

		cateLab1 = new JLabel("URL1");
		cateLab2 = new JLabel("URL2");
		cateLab3 = new JLabel("File");
		cateLab4 = new JLabel("Folder");

		// �г� p4����
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

		// ��ư
		Bcalc = new JButton(CIcon);
		Bcmd = new JButton(CmdIcon);
		Bnote = new JButton(NotepadIcon);
		Bsnip = new JButton(SnippingIcon);
		Bpaint = new JButton(PaintIcon);
		Bexplorer = new JButton(ExplorerIcon);
		Bmagnify = new JButton(GlassIcon);
		Bshutdown = new JButton(PowerIcon);
		Bhelp = new JButton(QIcon);

		// ��2 ����
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

		// ��3 ����
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

		// �����˾�
		popupExit = new JOptionPane();
		popupNoinput = new JOptionPane();
	}

	public void go() {
		// tab ����
		tabMain.setLayout(new GridLayout(2, 2));
		tabMain.add(p1);
		tabMain.add(p2);
		tabMain.add(p3);
		tabMain.add(p4);

		// tab�� �ø���
		tab.addTab("Main", tabMain);
		tab.addTab("Music Top10", tab2_Music);
		tab.addTab("Movie Top10", tab3_Movie);

		// p1 �г� ���� : ����Ű �ؽ�Ʈ�ʵ�
		p1.setLayout(new GridLayout());
		p1.add(txtkey);

		// p2 �г� ���� : ����, ���� ��ư
		p2.setLayout(new GridLayout(2, 1));
		p2.add(Pstart);
		p2.add(Psetup);

		// p3 �г� ���� : ī�װ� �޺��ڽ� *4
		p3.setLayout(new GridLayout(8, 1));
		p3.add(cateLab1);
		p3.add(cb1);
		p3.add(cateLab2);
		p3.add(cb2);
		p3.add(cateLab3);
		p3.add(cb3);
		p3.add(cateLab4);
		p3.add(cb4);

		// p4 �г� ���� : �̰����� ��ư
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

		// ��2_music ����
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

		// ��3_movie
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

		// �����ӿ� �ø���
		add(tab);
		setTitle("������ ver 3");

		events();

		setResizable(false);
		setSize(600, 450);
		setVisible(true);
	}

	public void events() {
		// p1 �г� : �ؽ�Ʈ�ʵ� ���� �̺�Ʈ
		txtkey.addKeyListener(new MyEvent());

		// p2 �г� : ����, ���� ��ư �̺�Ʈ
		Psetup.addActionListener(new MyEvent());
		Pstart.addActionListener(new MyEvent());

		// p4 �г� : �̰����� ��ư �̺�Ʈ
		Bcalc.addActionListener(new MyEvent());
		Bcmd.addActionListener(new MyEvent());
		Bnote.addActionListener(new MyEvent());
		Bsnip.addActionListener(new MyEvent());
		Bpaint.addActionListener(new MyEvent());
		Bexplorer.addActionListener(new MyEvent());
		Bmagnify.addActionListener(new MyEvent());
		Bshutdown.addActionListener(new MyEvent());
		Bhelp.addActionListener(new MyEvent());

		// ������ �̺�Ʈ
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

		// �޺��ڽ��� �ø���
		FileReader fr;
		String ch;

		try {
			fr = new FileReader("key.txt");

			BufferedReader br = new BufferedReader(fr);
			try {

				while ((ch = br.readLine()) != null) {
					PkeySetting pk = new PkeySetting(ch);

					//�� ī�װ� �� ����
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

		// �޺��ڽ� �̺�Ʈ
		cb1.addActionListener(new MyEvent());
		cb2.addActionListener(new MyEvent());
		cb3.addActionListener(new MyEvent());
		cb4.addActionListener(new MyEvent());
	}

	class MyEvent extends KeyAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// �޺��ڽ����� ���õ� ������ ����
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

				//music �� ��ư ����
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

				//movie �� ��ư ����
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

				// ������ư ������ StewardOption ���� �κ�
				if (bt.equals(Psetup)) {
					new StewardOption().go();
				}

				KeyComp comp = new KeyComp();

				///////////// 1. ����
				if (bt.equals(Bcalc)) {
					new Run();
					Run.exe("calc");
				}

				//////////// 2.cmd
				if (bt.equals(Bcmd)) {
					new Run();
					Run.exe("cmd");
				}

				//////////// 3.�޸���
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

				//////////// 6.Ž����
				if (bt.equals(Bexplorer)) {
					new Run();
					Run.exe("explorer.exe");
				}

				//////////// 7.������
				if (bt.equals(Bmagnify)) {
					new Run();
					Run.exe("Magnify");
				}

				//////////// 8.pc����
				if (bt.equals(Bshutdown)) {
					Runtime runtime = Runtime.getRuntime();

					int result = JOptionPane.showConfirmDialog(null, "�����մϴ�.", "����Ȯ��", JOptionPane.YES_NO_OPTION,
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

				//////////// 9.����
				if (bt.equals(Bhelp)) {
					// ���� Ŭ������ ���� ��θ� �����´�.
					String path = StewardMain.class.getResource("").getPath();
					File fPath = new File(path + "[HELP].txt");
					new Run();
					Run.exe(fPath.toString());
				}

				if (bt.equals(Pstart)) {
					if (txtkey.getText().equals("")) {
						popupNoinput.showMessageDialog(null, "����Ű��  �����ϴ�.", "NullPointException",JOptionPane.ERROR_MESSAGE);
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

			// ���� ġ�� Run.exe()�� ȣ���մϴ�.
			if (e.getKeyChar() == KeyEvent.VK_ENTER && txtkey.getText() != null) {
				try {
					comp.KeyComp(txtkey.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				new Run();
				Run.exe(comp.startUrl);
			}

			// ����Ű ������ �� Run.exe()�� �����մϴ�.
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
