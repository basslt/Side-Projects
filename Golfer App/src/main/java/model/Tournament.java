package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Tournament {
    private int tournamentId;
    private String tournamentName;
    private Date date;
    private String location;
    private String registrationInfo;
    private String rules;
    private BigDecimal fee;
    private int organizerUserId;

    public Tournament(int tournamentId, String tournamentName, Date date, String location, String registrationInfo, String rules, BigDecimal fee, int organizerUserId) {
            this.tournamentId = tournamentId;
            this.tournamentName = tournamentName;
            this.date = date;
            this.location = location;
            this.registrationInfo = registrationInfo;
            this.rules = rules;
            this.fee = fee;
            this.organizerUserId = organizerUserId;
        }

    public Tournament() {

    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegistrationInfo() {
        return registrationInfo;
    }

    public void setRegistrationInfo(String registrationInfo) {
        this.registrationInfo = registrationInfo;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public int getOrganizerUserId() {
        return organizerUserId;
    }

    public void setOrganizerUserId(int organizerUserId) {
        this.organizerUserId = organizerUserId;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournamentId=" + tournamentId +
                ", tournamentName='" + tournamentName + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", registrationInfo='" + registrationInfo + '\'' +
                ", rules='" + rules + '\'' +
                ", fee=" + fee +
                ", organizerUserId=" + organizerUserId +
                '}';
    }
}


