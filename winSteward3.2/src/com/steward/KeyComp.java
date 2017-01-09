package com.steward;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class KeyComp {

	public static String startKey = null;
	public static String startUrl = null;
	public static String item = null;

	public boolean KeyComp(String Pkey) throws Exception {
		// 리턴값 저장
		boolean compReturn = false;

		// 파일 열기 위함
		FileReader fr;
		String ch = null;

		// 사용자 지정 키워드가 저장된 key.txt 열기
		fr = new FileReader("key.txt");
		BufferedReader br = new BufferedReader(fr);

		// 만일 콤마서치라면
		if (Pkey.contains(",")) {

			// key.txt의 값 읽어오기
			while ((ch = br.readLine()) != null) {

				// key.txt값을 관리클래스에 보내서 쪼개놓기
				PkeySetting keytxt = new PkeySetting(ch);

				startKey = Pkey.substring(0, Pkey.indexOf(","));
				item = Pkey.substring(Pkey.indexOf(",") + 1, Pkey.length());

				// key
				if (startKey.equals(keytxt.getKey())) {

					// 구글
					if (startKey.equals("구글")) {
						startUrl = "https://www.google.co.kr/#q=" + item;
						break;
					}

					// 네이버
					if (startKey.equals("네이버")) {
						startUrl = "https://search.naver.com/search.naver?where=nexearch&query=" + item
								+ "&sm=top_hty&fbm=1&ie=utf8";
						break;
					}

					// 다음
					if (startKey.equals("다음")) {
						startUrl = "http://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&q="
								+ item;
						break;
					}
				}
			}
		} else {
			try {
				while ((ch = br.readLine()) != null) {

					// keytxt값을 관리클래스에 보내서 쪼개놓기
					PkeySetting keytxt = new PkeySetting(ch);

					startKey = keytxt.getKey();
					startUrl = keytxt.getUrl();

					// 들어온 Pkey값과 같으면 true / 다르면 false
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
