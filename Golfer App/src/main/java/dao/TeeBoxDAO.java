package dao;


import model.TeeBox;

import java.util.List;

public interface TeeBoxDAO {
    TeeBox getTeeBoxById(int teeBoxId);
    List<TeeBox> getTeeBoxesByCourseId(int courseId);
    void addTeeBox(TeeBox teeBox);
    void updateTeeBox(TeeBox teeBox);
    void deleteTeeBox(TeeBox teeBox);
}
