package com.steward;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {
	
	//���� ��ư ���� �� ȣ��Ǵ� �޼���
	public static void exe(String url){
	
		Process process = null;
		String[] cmd = new String[] { "rundll32", "url.dll", "FileProtocolHandler", url };
		String str = null;

		try {
			// ���μ��� ������ ���Ͽ� �ܺ� ���α׷� ����
			process = new ProcessBuilder(cmd).start();

			// �ܺ� ���α׷��� ǥ����� ���� ���ۿ� ����
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			// ǥ����� ���¸� ���
			while ((str = stdOut.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
