package site.services.interfaces;

import site.entities.Square;
import site.enums.LandType;

import java.util.List;

public interface WorldService {
    void save(Square square);

    List<Square> getWorld();

    LandType getLandType(int bx, int by, int sx, int sy);

    Square getSquareByCoordinates(int bx, int by, int sx, int sy);
}
