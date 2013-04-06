package dashboard.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import dashboard.databaseUtil.DatabaseUtil;

public class DashboardService implements Runnable {

	private int port;
	private String greetings = "Welcome to Dashboard server";

	
	private DatabaseUtil databaseUtil;
	private Communication communicationUtil;
	
	@Override
	public void run() {

		ServerSocket welcomeSocket;
		try {
			welcomeSocket = new ServerSocket(port);


			while (true) {
				Socket connectionSocket = welcomeSocket.accept();
				System.out.println("New client");
				communicationUtil.sendInfoToClient(connectionSocket, greetings);
				
				
				ClientThread ct = new ClientThread(connectionSocket, databaseUtil, communicationUtil);
				ct.run();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public DashboardService(int port) {
		this.port = port;
		databaseUtil = new DatabaseUtil();
		communicationUtil = new Communication();
	}



}
