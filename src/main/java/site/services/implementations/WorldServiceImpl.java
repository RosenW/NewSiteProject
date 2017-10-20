package site.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.entities.Square;
import site.enums.LandType;
import site.repositories.WorldRepository;
import site.services.interfaces.WorldService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WorldServiceImpl implements WorldService {

    private final WorldRepository worldRepository;

    @Autowired
    public WorldServiceImpl(WorldRepository worldRepository) {
        this.worldRepository = worldRepository;
    }

    @Override
    public void save(Square square) {
        worldRepository.save(square);
    }

    @Override
    public List<Square> getWorld() {
        return worldRepository.findAll();
    }

    @Override
    public LandType getLandType(int bx, int by, int sx, int sy) {
        List<Square> world = this.getWorld();
        LandType landType = null;
        for (Square square : world) {
            if (square.getBigX() == bx &&
                    square.getBigY() == by &&
                    square.getSmallX() == sx &&
                    square.getSmallY() == sy) {
                landType = square.getLandType();
                break;
            }
        }
        return landType;
    }

    @Override
    public Square getSquareByCoordinates(int bx, int by, int sx, int sy) {
        List<Square> world = this.getWorld();
        for (Square square : world) {
            if (square.getBigX() == bx &&
                    square.getBigY() == by &&
                    square.getSmallX() == sx &&
                    square.getSmallY() == sy) {
                return square;
            }
        }
        return null;
    }
}
