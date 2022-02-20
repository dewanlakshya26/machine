import Model.PoliticalParties;
import Model.WinningParty;
import print.Printer;
import seed.Loader;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Machine {

    private Loader loader;

    public Machine() {
        this.loader = new Loader();
    }

    public static void main(String[] args) {
        Machine machine = new Machine();
        Printer printer = new Printer();

        HashMap<String, HashMap<String, Integer>> data = machine.loader.loadDataFromFile();
        data.forEach((key, value) -> printer.print(key, getWinningPartyData(value)));

    }

    private static WinningParty getWinningPartyData(HashMap<String, Integer> electionData) {
        double sum = 0;
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : electionData.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
            sum += entry.getValue();

        }
        assert maxEntry != null;
        return new WinningParty(PoliticalParties.valueOf(maxEntry.getKey()), String.format("%.1f", (maxEntry.getValue()/sum)*100));


    }

}
