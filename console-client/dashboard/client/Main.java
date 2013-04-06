package dashboard.client;

import java.io.*;
import java.net.*;


public class Main {
	public static void main(String argv[]) throws Exception {
		System.out.println("Starting client");
		//String sentence;
		String modifiedSentence;
		//BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
		//		System.in));
		Socket clientSocket = new Socket("localhost", 6789);
		//DataOutputStream outToServer = new DataOutputStream(
		//		clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		//sentence = inFromUser.readLine();
		//outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("\nFROM SERVER: " + modifiedSentence);
		clientSocket.close();
		
	}
	

}