import org.json.simple.parser.ParseException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Dorar {
    ArrayList<Hadith> hadithList;

    public Dorar(String skey) throws MalformedURLException, ParseException, URISyntaxException {
        hadithList = new Scraper(skey).getResults();
    }

    public ArrayList<String> getRawResults(){
        ArrayList<String> results = new ArrayList<>();

        for (Hadith hadith: hadithList) {
            results.add(hadith.getText() + "\n" + hadith.getInfo());
        }
        return results;
    }
}
