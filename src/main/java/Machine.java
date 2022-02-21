import Model.PartyCodes;
import Model.WinningParty;
import print.Printer;
import seed.Loader;

import java.util.HashMap;
import java.util.Map;

public class Machine {

    private final Loader loader;
    private final Printer printer;

    public Machine() {
        this.loader = new Loader();
        this.printer = new Printer();
    }

    public static void main(String[] args) {
        Machine machine = new Machine();


        HashMap<String, HashMap<String, Integer>> data = machine.loader.loadDataFromFile();
        data.forEach((key, value) -> machine.printer.print(key, getWinningPartyData(value)));

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
        return new WinningParty(PartyCodes.valueOf(maxEntry.getKey()), String.format("%.1f", (maxEntry.getValue()/sum)*100));


    }

}
