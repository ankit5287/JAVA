import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class url {
    public static void main(String[] args) {
        try {
            // URL
            URL url = new URL("https://www.w3schools.com/");
            System.out.println(url.getProtocol());
            System.out.println(url.getPort());
            System.out.println(url.getHost());
            System.out.println(url.getFile());

            // URL Connection Class

            URLConnection conn = url.openConnection();
            System.out.println(conn.getContentType());
            System.out.println(conn.getContentLength());
            System.out.println(conn.getLastModified());
            System.out.println(conn.getInputStream());
            System.out.println(conn.getOutputStream());
            InputStream is = conn.getInputStream();
            int i;
            while ((i = is.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}