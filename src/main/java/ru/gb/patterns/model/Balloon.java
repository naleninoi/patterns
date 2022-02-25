package ru.gb.patterns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "balloons")
public class Balloon extends BaseEntity {

    @Column(name = "gas_type")
    private String type;

    @Column(name = "volume")
    private int volume;

    @Column(name = "weight")
    private int weight;

    private Balloon(Builder builder) {
        this.type = builder.type;;
        this.volume = builder.volume;
        this.weight = builder.weight;
        this.setCreated(new Date());
    }

    public Balloon() {
    }

    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

     public int getWeight() {
        return weight;
    }

    public static class Builder {
        private final String type;

        private int volume;

        private int weight;

        public Builder(String title) {
            this.type = title;
        }

        public Builder volume(int volume) {
            this.volume = volume;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Balloon build() {
            return new Balloon(this);
        }

    }

}
