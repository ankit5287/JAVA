import java.net.InetAddress;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());

            // Get local machine details
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("My Computer Name: " + local.getHostName());
            System.out.println("My IP Address: " + local.getHostAddress());
        } catch (Exception e) {
            System.out.println("Could not find the host: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
