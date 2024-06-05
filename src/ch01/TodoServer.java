package ch01;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class TodoServer {

	public static void main(String[] args) {
		try {
			HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

			httpServer.createContext("/todo", new TodoHandler());

			httpServer.start();
			System.out.println("todo start server");
			
			System.out.println("111111111111111111111111");
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

	static class TodoHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String method = exchange.getRequestMethod();
			System.out.println("method : " + method);
			System.out.println("뭔데 도대체");

			if ("GET".equalsIgnoreCase(method)) {
				System.out.println("get나옴?");
				handleGetRequest(exchange);
			} else if ("POST".equalsIgnoreCase(method)) {

			}

		}

		private void handleGetRequest(HttpExchange exchange) throws IOException {
			String response = "hello";

			exchange.sendResponseHeaders(200, response.length());
			OutputStreamWriter os = new OutputStreamWriter(exchange.getResponseBody());

			os.write(response);
			
			os.close();
		} // end of handleGetRequest

		private void handlePostRequest(HttpExchange exchange) {

		}

	}
}
