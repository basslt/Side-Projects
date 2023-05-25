package mlb;

public class Teams {
    private int teamId;
    private String teamName;
    private String locationName;
    private String shortName;
    private String abbreviation;
    private String leagueName;
    private String divisionName;
    private int lastChampionshipYear;
    private int lastDivisionTitleYear;
    private int lastPennantYear;




    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getLastChampionshipYear() {
        return lastChampionshipYear;
    }

    public void setLastChampionshipYear(int lastChampionshipYear) {
        this.lastChampionshipYear = lastChampionshipYear;
    }

    public int getLastDivisionTitleYear() {
        return lastDivisionTitleYear;
    }

    public void setLastDivisionTitleYear(int lastDivisionTitleYear) {
        this.lastDivisionTitleYear = lastDivisionTitleYear;
    }

    public int getLastPennantYear() {
        return lastPennantYear;
    }

    public void setLastPennantYear(int lastPennantYear) {
        this.lastPennantYear = lastPennantYear;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", locationName='" + locationName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", leagueName='" + leagueName + '\'' +
                ", divisionName='" + divisionName + '\'' +
                ", lastChampionshipYear=" + lastChampionshipYear +
                ", lastDivisionTitleYear=" + lastDivisionTitleYear +
                ", lastPennantYear=" + lastPennantYear +
                '}';
    }

    public Teams(int teamId, String teamName, String locationName, String shortName, String abbreviation, String leagueName, String divisionName, int lastChampionshipYear, int lastDivisionTitleYear, int lastPennantYear) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.locationName = locationName;
        this.shortName = shortName;
        this.abbreviation = abbreviation;
        this.leagueName = leagueName;
        this.divisionName = divisionName;
        this.lastChampionshipYear = lastChampionshipYear;
        this.lastDivisionTitleYear = lastDivisionTitleYear;
        this.lastPennantYear = lastPennantYear;




    }
}




