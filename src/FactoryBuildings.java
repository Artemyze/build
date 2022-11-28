import Buildings.Building;
import Buildings.Flat;
import Buildings.Garage;
import Buildings.House;

import java.io.IOException;

public final class FactoryBuildings {
    public Building createBuilding(BuildingType type) throws IOException {
        Building building = null;
        switch (type) {
            case HOUSE -> building = new House();
            case APARTMENT -> building = new Flat();
            case GARAGE -> building = new Garage();
        }
        return building;
    }
}
