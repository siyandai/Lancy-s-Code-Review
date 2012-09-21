/*
 * @author: Xiaodan Lan
 * Last Modified: September 21, 2012
 * 
 * This model searches required pictures from Olympic.org and return relevant data to the servlet (controller)
 */
package Distributed.System.Project1.Task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * This class searches pictures from Olympic.org with the required sports type
 * and athlete
 *
 * @author Lancy
 */
public class OlympicPictureSearchModel {

    private String pictureTag;
    private String pictureURL;
    private boolean isConnected;
    //The sports name and sports code mapping are used to show sports name in the repsonse page
    private Map<String, String> sportsNames = new HashMap<String, String>();

    public OlympicPictureSearchModel() {
        isConnected = true;
        //Construct the sports name and sports code map
        sportsNames.put("1313719", "Alpine Skiing");
        sportsNames.put("1313713", "Archery");
        sportsNames.put("1313887", "Artistic Gymnastics");
        sportsNames.put("1313725", "Athletics");
        sportsNames.put("1313737", "Badminton");
        sportsNames.put("1313743", "Basketball");
        sportsNames.put("1313965", "Basque Pelota");
        sportsNames.put("1313761", "Beach volleyball");
        sportsNames.put("1313767", "Boxing");
        sportsNames.put("1313785", "Canoe / Kayak Flatwater");
        sportsNames.put("1313803", "Croquet");
        sportsNames.put("1313773", "Cycling BMX");
        sportsNames.put("1313809", "Cycling Road");
        sportsNames.put("1313821", "Cycling Track");
        sportsNames.put("1313833", "Diving");
        sportsNames.put("10370494", "Equestrian");
        sportsNames.put("1313845", "Equestrian / Dressage");
        sportsNames.put("1313839", "Equestrian / Eventing");
        sportsNames.put("1313851", "Equestrian / Jumping");
        sportsNames.put("1313857", "Equestrian / Vaulting");
        sportsNames.put("1313869", "Fencing");
        sportsNames.put("1313881", "Figure skating");
        sportsNames.put("1313863", "Football");
        sportsNames.put("1313875", "Freestyle Skiing");
        sportsNames.put("1313893", "Golf");
        sportsNames.put("1313911", "Handball");
        sportsNames.put("1313917", "Hockey");
        sportsNames.put("1313923", "Ice Hockey");
        sportsNames.put("1313929", "Jeu de Paume");
        sportsNames.put("1313935", "Judo");
        sportsNames.put("1313941", "Lacrosse");
        sportsNames.put("1313947", "Luge");
        sportsNames.put("1313953", "Modern Pentathlon");
        sportsNames.put("1313797", "Mountain Bike");
        sportsNames.put("1313959", "Nordic Combined");
        sportsNames.put("1313971", "Polo");
        sportsNames.put("1313983", "Rackets");
        sportsNames.put("1313899", "Rhythmic Gymnastics");
        sportsNames.put("1313977", "Rink-Hockey");
        sportsNames.put("1313995", "Roque");
        sportsNames.put("1313989", "Rowing");
        sportsNames.put("1314001", "Rugby");
        sportsNames.put("1314007", "Sailing");
        sportsNames.put("1314019", "Shooting");
        sportsNames.put("1314049", "Short Track Speed Skating");
        sportsNames.put("1314031", "Skeleton");
        sportsNames.put("1314025", "Ski Jumping");
        sportsNames.put("1314013", "Snowboard");
        sportsNames.put("1314037", "Softball");
        sportsNames.put("1314043", "Speed skating");
        sportsNames.put("1314055", "Speed skiing");
        sportsNames.put("1314061", "Swimming");
        sportsNames.put("1314067", "Synchronized Swimming");
        sportsNames.put("1314097", "Table Tennis");
        sportsNames.put("1314085", "Taekwondo");
        sportsNames.put("1314073", "Tennis");
        sportsNames.put("1313905", "Trampoline");
        sportsNames.put("1314091", "Triathlon");
        sportsNames.put("1314079", "Tug of War");
        sportsNames.put("1314103", "Volleyball");
        sportsNames.put("1314127", "Water Motorsports");
        sportsNames.put("1314133", "Water polo");
        sportsNames.put("1314139", "Water Skiing");
        sportsNames.put("1314121", "Weightlifting");
        sportsNames.put("10370509", "Wrestling");
        sportsNames.put("1314109", "Wrestling Freestyle");


    }

    /**
     * This method do the actuall search on Olypmic.org for the picture
     *
     * @param getAthlete required searching athlete
     * @param getSports required searching sports type
     */
    public void doOlympicPictureSearch(String getAthlete, String getSports) throws MalformedURLException {
        //Record the code of the sports, in order to display the name of the sports later on the return page
        pictureTag = getSports;
        String response = "";

        try {
            //Get the url of the picture search page on Olympic.org with the sports code and athlete's name as asigned
            URL url = new URL("http://www.olympic.org/photos/search-results?men=true&women=true&mixed=true&sport=" + getSports + "&game=&country=&search=" + getAthlete);
            //Connect to Olympic.org and get the html data from the website
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            while ((str = in.readLine()) != null) {
                // str is one line of text; readLine() strips the newline character(s)
                response += str;
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
            //Catch exception if the connection to Olympic.org is failed
            isConnected = false;
        }

        //Get location of the picture's url inside the html code 
        int startSportsAnthletePicture = response.indexOf("href=\"/Assets/MediaPlayer/Photos/2012/London/");

        //Determine if there isn't any pictures return, if yes return message saying no pictures; if not, get the picture url 
        if (startSportsAnthletePicture == -1) {
            pictureURL = "no pictures";
        } else {
            // only start looking after the quote before http 
            int endSportsAnthletePicture = response.indexOf("\"", startSportsAnthletePicture + 6);
            // +1 to include the quote
            pictureURL = response.substring(startSportsAnthletePicture + 6, endSportsAnthletePicture + 1);
            
            pictureURL = "src=\"http://www.olympic.org" + pictureURL;
        }
    }

    /**
     * Get the picture's url
     *
     * @return string of url
     */
    public String getPictureURL() {
        return (pictureURL);
    }

    /**
     * Get the sports code
     *
     * @return string of the sports code
     */
    public String getPictureTag() {
        return (pictureTag);
    }

    /**
     * Get the status if Olympic.org is successfully connected
     *
     * @return true or false
     */
    public Boolean getIsConnected() {
        return (isConnected);
    }

    /**
     * Get the sports name
     *
     * @param sportsValue sports code
     * @return string of sports name
     */
    public String getSportsName(String sportsValue) {
        return (sportsNames.get(sportsValue));
    }
}
