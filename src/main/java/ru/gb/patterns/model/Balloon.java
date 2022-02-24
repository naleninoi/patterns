package ru.gb.patterns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "balloons")
public class Balloon extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "volume")
    private int volume;

    @Column(name = "weight")
    private int weight;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
