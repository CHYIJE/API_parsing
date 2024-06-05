package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExplorer {
	public static void main(String[] args) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("https://jsonplaceholder.typicode.com/todos/1");

		URL url = new URL(urlBuilder.toString());

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "json");
		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Todo todo = gson.fromJson(sb.toString(), Todo.class);
		System.out.println(todo.getTitle());
//		


		Todo todo1 = new Todo(1,2,"아몰라",true);
		
		Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
		
		String todoStr = gson.toJson(todo1);
//		System.out.println(todoStr);
		
		System.out.println("--------------");
		
		Todo todoObject = gson1.fromJson(todoStr, Todo.class);
		System.out.println(todoObject.getId());
		System.out.println(todoObject.getTitle());
		System.out.println(todoObject.getUserId());
		System.out.println(todoObject.isCompleted());
		
		
//		Gson todoGson = new GsonBuilder().setPrettyPrinting().create();
//		Todo todo1 = todoGson.fromJson(todo1, Todo.class);
//		System.out.println(todo1 + "이건가");
//		

	}
	
}
