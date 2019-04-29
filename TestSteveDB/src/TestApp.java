import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestApp {
    public static void main (String[] args) throws Exception {
        URL url = new URL("http://localhost:6701/db/state");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
