package mashcom.co.zw.sis.enums;

public enum PersonType {
    STUDENT("STUDENT"),
    PARENT("PARENT"),
    TEACHER("TEACHER");

    private String personType;

    private PersonType(String personType) {
        this.personType = personType;
    }

    public String getPersonType() {
        return personType;
    }

}
