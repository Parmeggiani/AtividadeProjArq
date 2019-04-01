import java.io.*;
import java.net.*;
import java.time.*;

class TCPServer {
	public static void main(String args[]) throws Exception {
		String clientSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		int bestBet = 0;
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient =
			new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			clientSentence = inFromClient.readLine();
			System.out.println("Lance Recebido: " + clientSentence);
			if(Integer.parseInt(clientSentence) > bestBet){
				bestBet = Integer.parseInt(clientSentence);
				System.out.println("Maior lance ate agora!");
			}
		}
	}
}
