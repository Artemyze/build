public enum BuildingType {
    HOUSE("Дом"),
    GARAGE("Гараж"),
    APARTMENT("Квартира");

    private final String description;

    BuildingType(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
