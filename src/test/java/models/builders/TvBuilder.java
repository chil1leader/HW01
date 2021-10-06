package models.builders;

import models.testobjetcs.Tv;
import models.valueobjects.Company;
import models.valueobjects.RefreshRate;

public class TvBuilder {
    private Company company;
    private RefreshRate rate;

    private int maxSize = 80;
    private int minSize = 60;
    private String backlight = "Direct LED";

    public TvBuilder(Company company, RefreshRate rate) {
        this.company = company;
        this.rate = rate;
    }

    public TvBuilder setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    public TvBuilder setMinSize(int minSize) {
        this.minSize = minSize;
        return this;
    }

    public TvBuilder setBacklight(String backlight) {
        this.backlight = backlight;
        return this;
    }

    public Tv build() {
        Tv tv = new Tv();
        tv.setCompany(this.company);
        tv.setRate(this.rate);
        tv.setMinSize(this.minSize);
        tv.setMaxSize(this.maxSize);
        tv.setBacklight(this.backlight);
        return tv;
    }
}
