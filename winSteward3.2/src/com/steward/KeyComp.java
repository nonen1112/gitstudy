package com.steward;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class KeyComp {

	public static String startKey = null;
	public static String startUrl = null;
	public static String item = null;

	public boolean KeyComp(String Pkey) throws Exception {
		// ���ϰ� ����
		boolean compReturn = false;

		// ���� ���� ����
		FileReader fr;
		String ch = null;

		// ����� ���� Ű���尡 ����� key.txt ����
		fr = new FileReader("key.txt");
		BufferedReader br = new BufferedReader(fr);

		// ���� �޸���ġ���
		if (Pkey.contains(",")) {

			// key.txt�� �� �о����
			while ((ch = br.readLine()) != null) {

				// key.txt���� ����Ŭ������ ������ �ɰ�����
				PkeySetting keytxt = new PkeySetting(ch);

				startKey = Pkey.substring(0, Pkey.indexOf(","));
				item = Pkey.substring(Pkey.indexOf(",") + 1, Pkey.length());

				// key
				if (startKey.equals(keytxt.getKey())) {

					// ����
					if (startKey.equals("����")) {
						startUrl = "https://www.google.co.kr/#q=" + item;
						break;
					}

					// ���̹�
					if (startKey.equals("���̹�")) {
						startUrl = "https://search.naver.com/search.naver?where=nexearch&query=" + item
								+ "&sm=top_hty&fbm=1&ie=utf8";
						break;
					}

					// ����
					if (startKey.equals("����")) {
						startUrl = "http://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&q="
								+ item;
						break;
					}
				}
			}
		} else {
			try {
				while ((ch = br.readLine()) != null) {

					// keytxt���� ����Ŭ������ ������ �ɰ�����
					PkeySetting keytxt = new PkeySetting(ch);

					startKey = keytxt.getKey();
					startUrl = keytxt.getUrl();

					// ���� Pkey���� ������ true / �ٸ��� false
					if (Pkey.equals(keytxt.getKey()) || Pkey.equals(keytxt.getShkey())) {
						compReturn = true;
						// System.out.println(startUrl);
						break;
					} else {
						compReturn = false;
					}

				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return compReturn;
	}


}
