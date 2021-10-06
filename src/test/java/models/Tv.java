package models;

import models.valueobjects.Company;
import models.valueobjects.RefreshRate;

import java.io.Serializable;

public class Tv implements Serializable {
    private Company company;
    private RefreshRate rate;

    private int maxSize;
    private int minSize;
    private String backlight;

    public Tv() {

    }

    public Tv(Company company, RefreshRate rate) {
        this.company = company;
        this.rate = rate;
    }

    public void setCompany(Company company) { this.company = company;}
    public Company getCompany() { return this.company; }

    public void setRate(RefreshRate rate) {this.rate = rate;}
    public RefreshRate getRate() { return this.rate;}

    public void setMaxSize(int maxSize) { this.maxSize = maxSize;}
    public int getMaxSize() { return this.maxSize;}

    public void setMinSize(int minSize) { this.minSize = minSize;}
    public int getMinSize() { return this.minSize;}

    public void setBacklight(String backlight) { this.backlight = backlight;}
    public String getBacklight() {return this.backlight;}


}
