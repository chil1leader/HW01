package models.valueobjects;

import java.io.Serializable;

public class RefreshRate implements Serializable {

    private String rate;

    public RefreshRate() {

    }

    public RefreshRate(String rate) {
        if (!rate.isEmpty())
            this.rate = rate;
        else
            throw new IllegalArgumentException("Наименование производителя не может быть пустым!");
    }

    public String getRate() { return this.rate; }

    public boolean equals(RefreshRate otherRate) { return this.rate.equals(otherRate.rate); }
}
