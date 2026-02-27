import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerReverse {
    public static void main(String[] args) throws Exception { // Added throws Exception
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] code = new byte[1024];
        System.out.println("The server is ready to talk on port 5000..");

        while (true) {
            // FIX 1: Removed trailing comma
            DatagramPacket receivepacket = new DatagramPacket(code, code.length);
            socket.receive(receivepacket);

            String msg = new String(receivepacket.getData(), 0, receivepacket.getLength()).trim();
            System.out.println("Received: " + msg);

            // FIX 2: Logic to reverse the string
            StringBuilder sb = new StringBuilder(msg);
            String reversed = sb.reverse().toString();
            byte[] sendData = reversed.getBytes();

            // FIX 3: Use the client's actual port from the packet
            InetAddress ip = receivepacket.getAddress();
            int port = receivepacket.getPort();

            // FIX 4: Added semicolon and used the correct port
            DatagramPacket snedPacket = new DatagramPacket(sendData, sendData.length, ip, port);
            socket.send(snedPacket);

            // FIX 5: Removed semicolon after IF (The semicolon was breaking the logic)
            if (msg.equalsIgnoreCase("Exit")) break;

            // Clear buffer for next message
            code = new byte[1024];
        }
        socket.close();
    }
}