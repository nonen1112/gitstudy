package com.steward;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Savetxt {

	static File fi = new File("key.txt");
	StewardMain st = new StewardMain();

	//단축키가 있을 때
	public void KeyOutput(String key, String url, String userKey, String category) throws IOException {
		FileWriter fw = new FileWriter(fi, true);
		KeyComp comp = new KeyComp();
		PkeySetting keySet = new PkeySetting(key, url, userKey, category);

		try {
			if (comp.KeyComp(key) || comp.KeyComp(userKey)) {

				StewardOption so = new StewardOption();
				so.popupNosave.showMessageDialog(null, "중복입니다.", "중복", JOptionPane.ERROR_MESSAGE);
			} else {
				fw.append(key + "/" + url + "," + userKey + "~" + category + "\n");
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fw.close();
	}

	//단축키가 없을 때
	public void KeyOutput(String key, String url, String category) throws IOException {
		FileWriter fw = new FileWriter(fi, true);
		KeyComp comp = new KeyComp();

		try {
			if (comp.KeyComp(key)) {

				StewardOption so = new StewardOption();
				so.popupNosave.showMessageDialog(null, "중복입니다.", "중복", JOptionPane.ERROR_MESSAGE);
			} else {
				fw.append(key + "/" + url + "," +"~"+category+ "\n");
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		fw.close();
	}


}
