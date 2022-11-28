import Buildings.Building;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) {
        Building b = null;
        FactoryBuildings factory = new FactoryBuildings();
        Menu.execute();
        try {
            b = factory.createBuilding(BuildingType.GARAGE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(b);
    }
}