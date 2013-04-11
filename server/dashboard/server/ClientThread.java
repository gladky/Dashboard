package dashboard.server;

import java.io.IOException;
import java.net.Socket;

import dashboard.databaseUtil.DatabaseUtil;

public class ClientThread implements Runnable {

	Communication communicationUtil;
	private String request;
	Socket connectionSocket;
	DatabaseUtil databaseUtil;

	@Override
	public void run() {
		String currentAnswer;
		boolean read = true;
		System.out.println("New Client!!");
		while (connectionSocket.isConnected() && read) {	
			try {
				System.out.println("Getting request!");
				request = communicationUtil.receiveFromClient(connectionSocket);

				if (request != null) {
					currentAnswer = databaseUtil.getAnswer(request);
					communicationUtil.sendInfoToClient(connectionSocket,
							currentAnswer);
				}
				else{
					read = false;
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ClientThread(Socket connectionSocket, DatabaseUtil databaseUtil,
			Communication communicationUtil) {
		this.connectionSocket = connectionSocket;
		this.databaseUtil = databaseUtil;
		this.communicationUtil = communicationUtil;
	}

}
