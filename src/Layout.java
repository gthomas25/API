import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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

public class Layout implements ActionListener {

    org.json.simple.JSONArray jsonArray ;
    private JFrame mainFrame;
    private JTextArea pokemon, allies;
    private int WIDTH = 800;
    private int HEIGHT = 700;

    public void pull() throws ParseException {
        String output = "abc";
        String totlaJson = "";
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
                totlaJson += output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        //System.out.println(str);
        jsonArray = (org.json.simple.JSONArray) parser.parse(totlaJson);
        System.out.println(jsonArray);

        try {
            System.out.println(jsonArray.get(0));
            JSONObject secretTunnelGuy = (JSONObject) jsonArray.get(0);
            System.out.println(secretTunnelGuy.get("name"));
            org.json.simple.JSONArray secretTunnelGuyAllies = (JSONArray) secretTunnelGuy.get("allies");
            System.out.println(secretTunnelGuyAllies.get(0));


            //put this in a for loop
            //  for ()
            System.out.println(jsonArray.get(1));
            JSONObject guy2 = (JSONObject) jsonArray.get(1);
            System.out.println(guy2.get("name"));
            org.json.simple.JSONArray guy2Alliess = (JSONArray) secretTunnelGuy.get("allies");
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
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public Layout() throws ParseException {
        prepareGUI();
        pull();
    }

    public static void main(String[] args) throws ParseException {
        Layout layout = new Layout();
        layout.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Layout");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(4, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton nextButton = new JButton("Next");
        JButton previousButton = new JButton("Previous");


        nextButton.setActionCommand("Next");
        previousButton.setActionCommand("Previous");

        nextButton.addActionListener(new ButtonClickListener());
        previousButton.addActionListener(new ButtonClickListener());


        pokemon = new JTextArea("Pokemon");
        allies = new JTextArea("Allies");

        mainFrame.add(pokemon);
        mainFrame.add(allies);
        mainFrame.add(nextButton);
        mainFrame.add(previousButton);


        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class ButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Next")) {
                System.out.println(jsonArray.get(0));
                JSONObject secretTunnelGuy = (JSONObject) jsonArray.get(0);
                System.out.println(secretTunnelGuy.get("name"));
                org.json.simple.JSONArray secretTunnelGuyAllies = (JSONArray) secretTunnelGuy.get("allies");
                System.out.println(secretTunnelGuyAllies.get(0));

                pokemon.setText("next");
                allies.setText("next");

            } else if (command.equals("Previous")) {
                //  statusLabel.setText("GO.");
                pokemon.setText("previous");
                allies.setText("previous");
            } else if (command.equals("Cancel")) {
                //   statusLabel.setText("Cancel Button clicked.");
            } else if (command.equals("startbutton")) {
                // statusLabel.setText("Start Button clicked.");

            } else {
                //  statusLabel.setText("No Button CLicked");
            }

        }
    }
}





