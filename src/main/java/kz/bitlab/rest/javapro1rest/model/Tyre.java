package kz.bitlab.rest.javapro1rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "t_tyres")
public class Tyre extends BaseModel {

    private String name;
    private String profile;
    private int price;

    @Column(name = "country")
    private String manufacturer;
    @ManyToOne
    private Owner owner;
}