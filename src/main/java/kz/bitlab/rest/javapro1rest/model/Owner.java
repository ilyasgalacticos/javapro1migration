package kz.bitlab.rest.javapro1rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_owners")
@Getter
@Setter
public class Owner extends BaseModel{

    private String name;

    @Column(name = "nick_name")
    private String nickName;
}
