import java.io.*;
import java.net.*;
import java.time.*;

class TCPServer {
	public static void main(String args[]) throws Exception {
		String clientSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		int bestBet = 0;
		int num_bets = 10;
		while (true) {
			if(num_bets == 0){
				System.out.println("\nLeilao terminou!");
				System.out.println("Lance Vencedor: "+ bestBet);
				break;
			}
			else{
				System.out.println("\nLances Restantes: "+ num_bets);
				num_bets = num_bets - 1;	
			}
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient =
			new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			clientSentence = inFromClient.readLine();
			System.out.println("Lance Recebido: " + clientSentence);
			if(Integer.parseInt(clientSentence) > bestBet){
				bestBet = Integer.parseInt(clientSentence);
				System.out.println("\nMaior lance ate agora!");
			}
		}
	}
}
