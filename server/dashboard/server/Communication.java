package dashboard.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Communication {

	
	public void sendInfoToClient(Socket connectionSocket, String text) throws IOException {
		DataOutputStream outToClient = new DataOutputStream(
				connectionSocket.getOutputStream());
		outToClient.writeBytes(text +"\n");

	}

	public String receiveFromClient(Socket connectionSocket) throws IOException {
		String clientSentence;
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(
				connectionSocket.getInputStream()));

		clientSentence = inFromClient.readLine();
		System.out.println("Received: " + clientSentence);
		return clientSentence;
	}
}
