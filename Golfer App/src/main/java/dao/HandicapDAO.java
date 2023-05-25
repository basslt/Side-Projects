package dao;

import model.Handicap;

public interface HandicapDAO {
    Handicap getHandicapById(int handicapId);
    Handicap getHandicapByUserId(int userId);
    void addHandicap(Handicap handicap);
    void updateHandicap(Handicap handicap);
    void deleteHandicap(Handicap handicap);
}
