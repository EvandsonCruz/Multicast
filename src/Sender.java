import java.net.*;
import java.io.*;
import java.util.*;

public class Sender {

	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack", "true");
		
		try {
			InetAddress grupo = InetAddress.getByName("225.6.7.8");
			MulticastSocket socket = new MulticastSocket();
			String mensagem = "teste de multicast";
			
			DatagramPacket pacote = new DatagramPacket(mensagem.getBytes(),mensagem.length(),grupo,3456);
			socket.send(pacote);
			socket.close();
		} catch (Exception e){e.printStackTrace();}
	}
	
}
