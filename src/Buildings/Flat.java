package Buildings;

import java.util.Objects;
import Exceptions.IncorrectValue;

public class Flat extends House
{
    private int apartmentNumber;
    private String ownerName;

    public Flat(String address, int buildingWearFactor,
                String nameOfManagingCompany, int amountFlats,
                String ownerName, int apartmentNumber) throws IncorrectValue {
        super(address, buildingWearFactor, nameOfManagingCompany, amountFlats);
        setApartmentNumber(apartmentNumber);
        setOwnerName(ownerName);
    }

    public Flat() throws IncorrectValue {
        this(Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE,
                Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE,
                Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE);
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        try {
            this.apartmentNumber = checkIntValue(apartmentNumber,
                    Constants.DEFAULT_ZERO_INT_VALUE,
                    Constants.MAX_FLATS_IN_HOUSE);
        }
        catch (IncorrectValue e) {
            this.apartmentNumber = Constants.DEFAULT_ZERO_INT_VALUE;
        }
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        try {
            this.ownerName = checkStrValue(ownerName, Constants.NULL_STR_VALUE);
        } catch (IncorrectValue e) {
            this.ownerName = Constants.DEFAULT_STR_VALUE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat flat)) return false;
        if (!super.equals(o)) return false;
        return apartmentNumber == flat.apartmentNumber && Objects.equals(ownerName, flat.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), apartmentNumber, ownerName);
    }

    @Override
    public String toString() {
        return String.format("%s Buildings.House{ownerName='%s', apartmentNumber=%d}",
                super.toString(),
                this.ownerName,
                this.apartmentNumber );
    }
}
