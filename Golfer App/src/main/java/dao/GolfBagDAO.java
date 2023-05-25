package dao;


import model.GolfBag;

import java.util.List;

public interface GolfBagDAO {
    void deleteGolfBag(int bagId);

    GolfBag getGolfBagById(int bagId);
    GolfBag getGolfBagByUserId(int userId);
    void addGolfBag(GolfBag golfBag);
    void updateGolfBag(GolfBag golfBag);


    List<GolfBag> getGolfBagsByGolfer(int golferId);
}
