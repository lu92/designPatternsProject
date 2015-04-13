package DesignPatternsProject.entities.productsAndServices;

import javax.persistence.*;

/**
 * Created by lucjan on 10.03.15.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BaseProduct {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int tax;        // podatek
    private double duty;    //  clo
    private double netto;
    private double brutto;


    private Category category;

    public BaseProduct() {
    }

    public BaseProduct(String name) {
        this.name = name;
    }

    public BaseProduct(double netto, double brutto, String name) {
        this(name);
        this.netto = netto;
        this.brutto = brutto;
    }
    public BaseProduct(String name, double duty, int tax, double netto, double brutto) {
        this(netto, brutto, name);
        this.duty = duty;
        this.tax = tax;
    }


    public BaseProduct(String name, Category category, int tax, double duty, double netto, double brutto) {
        this(name, duty, tax, netto, brutto);
        this.category = category;
    }

    public BaseProduct(Long id, String name, Category category, int tax, double duty, double netto, double brutto) {
        this(name, category, tax, duty, netto, brutto);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public double getDuty() {
        return duty;
    }

    public void setDuty(double duty) {
        this.duty = duty;
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

    @Override
    public String toString() {
        return "BaseProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", tax=" + tax +
                ", duty=" + duty +
                ", netto=" + netto +
                ", brutto=" + brutto +
                '}';
    }
}
