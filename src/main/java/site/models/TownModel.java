package site.models;

import site.entities.TownCoordinate;
import site.enums.Element;

public class TownModel {
    private Element element;
    private TownCoordinate coordinate;

    public TownModel(Element element, TownCoordinate coordinate) {
        this.element = element;
        this.coordinate = coordinate;
    }

    public TownModel() {

    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public TownCoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(TownCoordinate coordinate) {
        this.coordinate = coordinate;
    }
}
