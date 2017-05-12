package org.elsys.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

	private Socket client;
	private EchoServer server;

	public ClientHandler(Socket socket, EchoServer server) {
		this.client = socket;
		this.server = server;
	}

	@Override
	public void run() {
		
		try(
			//in try(her) because it will automatically call .close()
			//Stream not string, thats why => Scanner&PrintWriter
			Scanner inScanner = new Scanner(client.getInputStream());
				//true = auto flush
			PrintWriter outWriter = new PrintWriter(client.getOutputStream(), true);
		) {
			System.out.println("New client accepted: " + client);
			String input;
			while((input = inScanner.nextLine()) != null) {
				if(input.equals("SHUTDOWN")) {
					server.shutDown();
					break;
				}
				System.out.println("ECHO: " + input);
				outWriter.println("ECHO: " + input);
				//outWriter.flush();
			}
		} catch (IOException e) {
			System.err.println("Not able to accept requests");
			System.exit(-1);
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
