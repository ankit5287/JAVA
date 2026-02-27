import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPserver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] receiveData = new byte[1024];
        System.out.println("Client is ready to talk.....");
        while(true)
        {
            DatagramPacket packet = new DatagramPacket(receiveData,receiveData.length);
            socket.receive(packet);

            String message = new String(packet.getData(),0, packet.getLength());
            System.out.println("Client Says:"+message);

            if(message.equalsIgnoreCase("Exit"))
            {
                break;
            }
        }
        receiveData = new byte[1024];
    }

}