package Model;

public class WinningParty {
    private final PoliticalParties politicalParties;
    private final String percentage;

    public WinningParty(PoliticalParties politicalParties, String percentage) {
        this.politicalParties = politicalParties;
        this.percentage = percentage;
    }


    public PoliticalParties getPoliticalParties() {
        return politicalParties;
    }

    public String getPercentage() {
        return percentage;
    }
}
