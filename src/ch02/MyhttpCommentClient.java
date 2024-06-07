package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyhttpCommentClient {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/comments/1");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-typ", "application/json");
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			// 200 출력됨 연결 확인
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
			in.close();
			System.out.println(buffer.toString());
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Comment commentDTO = gson.fromJson(buffer.toString(), Comment.class);
			System.out.println("------------------");
			System.out.println(commentDTO.getId());
			System.out.println(commentDTO.getPostid());
			System.out.println(commentDTO.getEmail());
			System.out.println(commentDTO.getBody());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
