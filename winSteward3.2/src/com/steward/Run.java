package com.steward;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {
	
	//실행 버튼 누를 때 호출되는 메서드
	public static void exe(String url){
	
		Process process = null;
		String[] cmd = new String[] { "rundll32", "url.dll", "FileProtocolHandler", url };
		String str = null;

		try {
			// 프로세스 빌더를 통하여 외부 프로그램 실행
			process = new ProcessBuilder(cmd).start();

			// 외부 프로그램의 표준출력 상태 버퍼에 저장
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			// 표준출력 상태를 출력
			while ((str = stdOut.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
