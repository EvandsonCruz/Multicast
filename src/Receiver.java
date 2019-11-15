import java.net.*;
import java.io.*;
import java.util.*;

public class Receiver {

	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack", "true");
		
		try {
			InetAddress grupo = InetAddress.getByName("225.6.7.8");
			MulticastSocket mSocket = new MulticastSocket(3456);
			mSocket.joinGroup(grupo);
			
			int i = 0;
			while (i<10){
				byte[] buffer = new byte[18];
				DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
				mSocket.receive(pacote);
				System.out.println(new String(buffer));
				i++;
			}
			mSocket.close();
			} catch (Exception e){e.printStackTrace();}

	}

}
