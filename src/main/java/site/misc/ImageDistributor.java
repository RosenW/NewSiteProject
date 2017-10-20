package site.misc;

import site.entities.Square;
import site.enums.LandType;
import site.services.interfaces.WorldService;

import java.util.List;

public class ImageDistributor {
    private final WorldService worldService;
    private String standardSquareImage;
    private String forestSquareImage;
    private String bigForestSquareImage;
    private String crystalFieldSquareImage;
    private String bigCrystalFieldSquareImage;
    private String goldMineSquareImage;
    private String bigGoldMineSquareImage;
    private String mountainSquareImage;
    private String bigMountainSquareImage;
    private String humanCity;

    private List<Square> world;

    public ImageDistributor(WorldService worldService) {
        this.worldService = worldService;
        world = worldService.getWorld();
        standardSquareImage = "https://i.imgur.com/tR0Sofi.png";
        forestSquareImage = "https://i.imgur.com/0M7Jdxh.png";
        bigForestSquareImage = "https://i.imgur.com/DUNDZMr.png";
        crystalFieldSquareImage = "https://i.imgur.com/63SQB7U.png";
        bigCrystalFieldSquareImage = "https://i.imgur.com/eAe6Pua.png";
        mountainSquareImage = "https://i.imgur.com/1J42ZLz.png";
        bigMountainSquareImage = "https://i.imgur.com/JV1Qqlr.png";
        goldMineSquareImage = "https://i.imgur.com/ckVEnbh.png";
        bigGoldMineSquareImage = "https://i.imgur.com/FQIcUQ9.png";
        humanCity = "https://i.imgur.com/zKG2i3p.png";
    }

    public String getImage(int bx, int by, int sx, int sy) {
        LandType curTownType = null;
        for (Square square : world) {
            if (square.getBigX() == bx &&
                    square.getBigY() == by &&
                    square.getSmallX() == sx &&
                    square.getSmallY() == sy) {
                curTownType = square.getLandType();
            }
        }

        switch (curTownType) {
            case STANDARD:
                return standardSquareImage;
            case FOREST:
                return forestSquareImage;
            case BIGFOREST:
                return bigForestSquareImage;
            case CRYSTALFIELD:
                return crystalFieldSquareImage;
            case BIGCRYSTALFIELD:
                return bigCrystalFieldSquareImage;
            case BIGGOLDMINE:
                return bigGoldMineSquareImage;
            case GOLDMINE:
                return goldMineSquareImage;
            case MOUNTAIN:
                return mountainSquareImage;
            case BIGMOUNTAIN:
                return bigMountainSquareImage;
            case HUMANS:
                return humanCity;
            default:
                return null;
        }
    }
}
