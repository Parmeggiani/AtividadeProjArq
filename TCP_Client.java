import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPClient {
	public static void main(String args[]) throws Exception {
	  	Scanner input = new Scanner (System.in);
		String message;
		boolean flag = false;
		while (flag == false) {
			System.out.println("Digite seu lance:");
			message = input.nextLine();
			if (message.equals("sair")) {
				flag = true;
				break;
			}
			Socket clientSocket = new Socket("localhost", 6789);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			System.out.println("Para fechar o programa, digite \'sair\'");
			outToServer.writeBytes(message);
			clientSocket.close();
	    }
	    input.close();
	    System.exit(0);
	}
}
