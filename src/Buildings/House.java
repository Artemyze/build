package Buildings;

import java.util.Objects;
import Exceptions.IncorrectValue;

public class House extends Building
{
    private String nameOfManagingCompany;
    private int amountFlats;
    public House(String address, int buildingWearFactor,
                 String nameOfManagingCompany, int amountFlats) throws IncorrectValue {
        super(address, buildingWearFactor);
        setAmountFlats(amountFlats);
        setNameOfManagingCompany(nameOfManagingCompany);
    }

    public House() throws IncorrectValue {
        this(Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE,
                Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE);
    }

    public String getNameOfManagingCompany() {
        return nameOfManagingCompany;
    }

    public void setNameOfManagingCompany(String nameOfManagingCompany) {
        try {
            this.nameOfManagingCompany = checkStrValue(nameOfManagingCompany, Constants.NULL_STR_VALUE);
        } catch (IncorrectValue e) {
            this.nameOfManagingCompany = Constants.DEFAULT_STR_VALUE;
        }
    }

    public int getAmountFlats() {
        return amountFlats;
    }

    public void setAmountFlats(int amountFlats) {
        try {
            this.amountFlats = checkIntValue(amountFlats,
                    Constants.DEFAULT_ZERO_INT_VALUE,
                    Constants.MAX_FLATS_IN_HOUSE);
        }
        catch (IncorrectValue e) {
            this.amountFlats = Constants.DEFAULT_ZERO_INT_VALUE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;
        if (!super.equals(o)) return false;
        return amountFlats == house.amountFlats && Objects.equals(nameOfManagingCompany, house.nameOfManagingCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameOfManagingCompany, amountFlats);
    }

    @Override
    public String toString() {
        return String.format("%s Buildings.House{nameOfManagingCompany='%s', amountFlats=%d}",
                super.toString(),
                this.nameOfManagingCompany,
                this.amountFlats );
    }
}
