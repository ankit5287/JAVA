import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        InetAddress ip = InetAddress.getByName("localhost");
        while(true){
            System.out.println("Enter message...");
            String msg = sc.nextLine();
            byte[] code = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(code,code.length,ip,5000);
            socket.send(packet);

            if(msg.equalsIgnoreCase("Exit")) break;
        }
        socket.close();
    }
}
