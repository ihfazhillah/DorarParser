
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Scraper {
    private String baseUrl = "https://dorar.net/dorar_api.json";
    URL url;

    public  Scraper(String key) throws MalformedURLException {
        url = new URL(baseUrl + "?skeys=" + key);
    }

    public String getResponse(){
        StringBuilder content = new StringBuilder();

        try {
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null){
                content.append(line).append("\n");
            }
            reader.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return content.toString();
    }

    public String getHTML(String resp) throws ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(resp);

        JSONObject jsonObject = (JSONObject)obj;

        JSONObject ahadith = (JSONObject)jsonObject.get("ahadith");

        return (String)ahadith.get("result");
    }

    public static String getResultArray(){
        return "";
    }

    public static void main (String[] args) throws IOException, ParseException {
        Scraper scraper = new Scraper("تسعى");
        String resp = scraper.getResponse();
        String html = scraper.getHTML(resp);
        System.out.println(html);
    }
}
