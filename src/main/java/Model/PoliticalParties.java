package Model;

public enum PoliticalParties {

    BJP("Bhartiya Janta Party"),
    INC("Indian National Congress"),
    BSP("Bahujan Samaj Party"),
    CPI("Communist Party of India"),
    NCP("Nationalist Congress Party"),
    IND("Independent");

    private String fullName;

    public String getFullName() {
        return fullName;
    }

    PoliticalParties(String fullName) {
        this.fullName = fullName;
    }
}
