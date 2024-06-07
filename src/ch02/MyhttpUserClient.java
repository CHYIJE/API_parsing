package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyhttpUserClient {

	public static void main(String[] args) {

		// 순수 자바코드 http 통신
		// 1. 서버 주소 경로
		// 2. URL 클래스
		// 3. url.openConnection() <--- 스트림 I/O

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			// 겟 방식으로 던질거다
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-typ", "application/json");

			// 응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);

			// HTTP 응답 메세지에서 데이터를 추출 [] --- Stream --- []
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
			in.close();
			System.out.println(buffer.toString());
			//Gson lib 활용
			// Gson gson = new Gson();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			User userDTO = gson.fromJson(buffer.toString(), User.class);
			
			System.out.println(userDTO);
			System.out.println("------------");
			System.out.println(userDTO.getId());	
			System.out.println(userDTO.getAddress());	
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
