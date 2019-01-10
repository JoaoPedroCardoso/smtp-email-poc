package com.poc.smtp.email.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id = null;

    private String name;

    @Column(unique=true)
    private String email;

    @OneToMany
    private List<Bear> bearConsume;

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Hello, ").append(this.getName()).append("!\n\n");
        builder.append("Until now you have consumed the following beers: \n\n");
        builder.append(bearConsume.toString());
        return builder.toString();
    }

}
