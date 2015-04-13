package DesignPatternsProject.entities.personalData;

import javax.persistence.*;

/**
 * Created by lucjan on 10.03.15.
 */

@Entity
public class Salary {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private EmploymentContractType type;

    private double netto;
    private double brutto;
    private double insurancePrice;  // cena ubezpieczenia

    public enum EmploymentContractType {
        REGULAR_EMPLOYMENT,             //   umowa o prace
        FIXED_TERM_EMPLOYMENT           //  umowa zlecenie
    }

    public Salary() {
    }

    public Salary(EmploymentContractType type, double brutto) {
        this.type = type;
        this.brutto = brutto;
    }

    //      Constructors only for tests


    public Salary(EmploymentContractType type, double netto, double brutto, double insurancePrice) {
        this.type = type;
        this.netto = netto;
        this.brutto = brutto;
        this.insurancePrice = insurancePrice;
    }
    public Salary(Long id, EmploymentContractType type, double netto, double brutto, double insurancePrice) {
        this(type, netto, brutto, insurancePrice);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmploymentContractType getType() {
        return type;
    }

    public void setType(EmploymentContractType type) {
        this.type = type;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }
}
