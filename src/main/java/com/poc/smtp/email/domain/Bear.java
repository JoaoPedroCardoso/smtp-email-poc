package com.poc.smtp.email.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Bear implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id = null;

    private String name;

    private String type;

    private Double cost;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name.toUpperCase()).append(" of type ").append(this.type.toUpperCase())
        .append(" with cost: $").append(this.cost).append(".\n");
        return builder.toString();
    }

}
