package dao;

import model.Holes;

import java.util.List;

public interface HolesDAO {
    void createHole(Holes hole);

    Holes getHoleById(int holeId);
    List<Holes> getHolesByCourseId(int courseId);

    void updateHole(Holes hole);

    void deleteHole(int holeId);
}
