package Buildings;

import java.util.Objects;
import Exceptions.IncorrectValue;

public class Garage extends Building{
    private int numberOfStoreys;
    private String equipmentOfTheGarage;

    public Garage(String address, int buildingWearFactor,
                  String equipmentOfTheGarage, int numberOfStoreys) throws IncorrectValue {
        super(address, buildingWearFactor);
        this.numberOfStoreys = numberOfStoreys;
        this.equipmentOfTheGarage = equipmentOfTheGarage;
    }

    public Garage() throws IncorrectValue {
        this(Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE,
                Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE);
    }

    public String getEquipmentOfTheGarage() {
        return equipmentOfTheGarage;
    }

    public void setEquipmentOfTheGarage(String equipmentOfTheGarage) {
        try {
            this.equipmentOfTheGarage = checkStrValue(equipmentOfTheGarage, Constants.NULL_STR_VALUE);
        } catch (IncorrectValue e) {
            this.equipmentOfTheGarage = Constants.DEFAULT_STR_VALUE;
        }
    }

    public int getNumberOfStoreys() {
        return numberOfStoreys;
    }

    public void setNumberOfStoreys(int numberOfStoreys) {
        try {
            this.numberOfStoreys = checkIntValue(numberOfStoreys,
                    Constants.DEFAULT_ZERO_INT_VALUE,
                    Constants.MAX_FLATS_IN_HOUSE);
        }
        catch (IncorrectValue e) {
            this.numberOfStoreys = Constants.DEFAULT_ZERO_INT_VALUE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garage garage)) return false;
        if (!super.equals(o)) return false;
        return numberOfStoreys == garage.numberOfStoreys && Objects.equals(equipmentOfTheGarage, garage.equipmentOfTheGarage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfStoreys, equipmentOfTheGarage);
    }

    @Override
    public String toString() {
        return String.format("%s Buildings.Garage{equipmentOfTheGarage='%s', numberOfStoreys=%d}",
                super.toString(),
                this.equipmentOfTheGarage,
                this.numberOfStoreys );
    }
}
