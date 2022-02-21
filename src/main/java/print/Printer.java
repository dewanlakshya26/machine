package print;

import Model.WinningParty;

public class Printer {

    public void print(String city, WinningParty winningParty) {
        System.out.println("Constituency, Winning Party, Vote Share\n" + city + ", " + winningParty.getPoliticalParties().getFullName() + ", " + winningParty.getPercentage());
    }

}
