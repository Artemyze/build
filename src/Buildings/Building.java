package Buildings;

import java.util.Objects;
import Exceptions.IncorrectValue;
public abstract class Building
{
    private String address;
    private int buildingWearFactor;
    public Building(String address,int buildingWearFactor) throws IncorrectValue {
        setBuildingWearFactor(buildingWearFactor);
        setAddress(address);
    }
    public Building() throws IncorrectValue {
        this(Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE);
    }

    static protected String checkStrValue(String valueToCheck, String valueCompared) throws IncorrectValue
    {
        if (Objects.equals(valueToCheck, valueCompared))
        {
            throw new IncorrectValue();
        }
        else return valueToCheck;
    }
    public void setAddress(String address) throws IncorrectValue
    {
        try {
            this.address = checkStrValue(address, Constants.NULL_STR_VALUE);
        }
        catch (IncorrectValue e) {
            this.address = Constants.DEFAULT_STR_VALUE;
            throw new IncorrectValue();
        }
    }

    public String getAddress()
    {
        return address;
    }

    static protected int checkIntValue(Integer valueToCheck, Integer minValue, Integer maxValue) throws IncorrectValue
    {
        if (valueToCheck < minValue ||
            valueToCheck > maxValue)
        {
            throw new IncorrectValue();
        }
        else return valueToCheck;
    }

    public void setBuildingWearFactor(int buildingWearFactor) {
        try {
            this.buildingWearFactor = checkIntValue(buildingWearFactor,
                    Constants.DEFAULT_ZERO_INT_VALUE, Constants.MAX_PERCENTAGE_FOR_BUILDING_WEAR);
        }
        catch (IncorrectValue e) {
            this.buildingWearFactor = Constants.DEFAULT_ZERO_INT_VALUE;
            System.out.printf("Коэффициент износа здания сброшен на %d/%%n", this.buildingWearFactor);
        }
    }

    public int getBuildingWearFactor() {
        return buildingWearFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building building)) return false;
        return buildingWearFactor == building.buildingWearFactor && Objects.equals(address, building.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, buildingWearFactor);
    }

    @Override
    public String toString() {
        return "Buildings.Building{" +
                "address='" + address + '\'' +
                ", buildingWearFactor=" + buildingWearFactor +
                '}';
    }
}
