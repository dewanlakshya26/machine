package seed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Loader {

    public HashMap<String, HashMap<String, Integer>> loadDataFromFile() {

        String fileName = "input.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);


        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return getData(inputStream);
        }

    }


    private HashMap<String, HashMap<String, Integer>> getData(InputStream is) {


        HashMap<String, HashMap<String, Integer>> data = new HashMap<>();
        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String contents;
            while ((contents = reader.readLine()) != null) {
                HashMap<String, Integer> cityVoteList = new HashMap<>();
                String[] city = contents.split("-");
                String[] politicalParties = city[1].split(",");
                for (String politicalParty : politicalParties) {
                    String[] politicalPartyList = politicalParty.split("=");
                    cityVoteList.put( politicalPartyList[0], Integer.parseInt(politicalPartyList[1]));
                }
                data.put(city[0], cityVoteList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

    }

}