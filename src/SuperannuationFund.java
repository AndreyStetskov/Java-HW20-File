import java.util.Objects;

public class SuperannuationFund {
    private final double COEFFICIENT = 0.02;
    private final int AVERAGE = 1500;
    private String name;
    private TypeOfFund national;
    private String dateCreated;

//    public SuperannuationFund(String name, TypeOfFund national, String dateCreated) {
//        this.name = name;
//        this.national = national;
//        this.dateCreated = dateCreated;
//    }


//    public double pensionCalculation (int timeWorked, double minWage, double maxWage) {
//        double pension = switch (national) {
//            case NATIONAL -> AverageUtil.average(minWage, maxWage);
//            case NON_NATIONAL -> AverageUtil.average(minWage, maxWage, AVERAGE);
//            default -> 0;
//        };
//        return pension * COEFFICIENT * timeWorked;
//    }

    public double getCOEFFICIENT() {
        return COEFFICIENT;
    }

    public int getAVERAGE() {
        return AVERAGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfFund getNational() {
        return national;
    }

    public void setNational(TypeOfFund national) {
        this.national = national;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperannuationFund that = (SuperannuationFund) o;
        return Double.compare(that.COEFFICIENT, COEFFICIENT) == 0 && AVERAGE == that.AVERAGE && Objects.equals(name, that.name) && national == that.national && Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(COEFFICIENT, AVERAGE, name, national, dateCreated);
    }

    @Override
    public String toString() {
        return "Foundation of " + name +
                " type is " + national +
                ", was created '" + dateCreated + '\'' +
//                "SuperannuationFund{" +
//                "COEFFICIENT=" + COEFFICIENT +
//                ", AVERAGE=" + AVERAGE +
//                ", name='" + name + '\'' +
//                ", national=" + national +
//                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
