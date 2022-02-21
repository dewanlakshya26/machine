package Model;

public class WinningParty {
    private final PartyCodes partyCodes;
    private final String percentage;

    public WinningParty(PartyCodes partyCodes, String percentage) {
        this.partyCodes = partyCodes;
        this.percentage = percentage;
    }


    public PartyCodes getPoliticalParties() {
        return partyCodes;
    }

    public String getPercentage() {
        return percentage;
    }
}
