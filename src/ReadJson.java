import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


// video to load jar
//https://www.youtube.com/watch?v=QAJ09o3Xl_0

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;

// Program for print data in JSON format.
public class ReadJson {
    public static void main(String args[]) throws ParseException {
        // In java JSONObject is used to create JSON Array
        // which is a subclass of java.util.HashMap.

        JSONObject file = new JSONObject();
        file.put("Full Name", "Ritu Sharma");
        file.put("Roll No.", 1704310046);
        file.put("Tution Fees", 65400);


        // To print in JSON format.
        System.out.print(file.get("Tution Fees"));
        pull();

    }

    public static void pull() throws ParseException {
        String output = "abc";
        String totlaJson="";
        try {

            URL url = new URL("https://last-airbender-api.fly.dev/api/v1/characters");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                totlaJson+=output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) parser.parse(totlaJson);
        System.out.println(jsonArray);

        try {
            System.out.println(jsonArray.get(0));
            JSONObject secretTunnelGuy = (JSONObject) jsonArray.get(0);
            System.out.println(secretTunnelGuy.get("name"));
            org.json.simple.JSONArray secretTunnelGuyAllies = (JSONArray)  secretTunnelGuy.get("allies");
            System.out.println(secretTunnelGuyAllies.get(0));



            //put this in a for loop
            for ()
            System.out.println(jsonArray.get(1));
            JSONObject guy2 = (JSONObject) jsonArray.get(1);
            System.out.println(guy2.get("name"));
            org.json.simple.JSONArray guy2Alliess = (JSONArray)  secretTunnelGuy.get("allies");
            System.out.println(guy2Alliess.get(0));



         //   String name = (String)jsonArray.get("name")

     //       org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonArray.get("abilities");
            //int n =   msg.size(); //(msg).length();
            //for (int i = 0; i < n; ++i) {
               // String test =(String) msg.get(i);
              //  System.out.println(test);
                // System.out.println(person.getInt("key"));
           // }
            //String name= (String)jsonObject.get("height");
           // System.out.println(name);
        }

        catch (Exception e) {
            e.printStackTrace();
        }




    }
    public class Avatarcharacter extends JFrame{
        private JLabel nameLabel, alliesLabel, enemiesLabel;
        private JButton previousButton, nextButton;

        public Avatarcharacter() {
            setTitle("Avatar: The Last Airbender Characters");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);

    }

}


