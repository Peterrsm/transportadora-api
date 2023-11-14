package com.pedromiranda.transportadoraapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "motorista")
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonDeserialize
@JsonSerialize
@Getter
@Setter
public class Motorista implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String primeiro;

    @Column
    private String sobrenome;

    @Column
    private String endereco;

//    @Column
//    private Caminhao caminhao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motorista)) return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(getPrimeiro(), motorista.getPrimeiro()) && Objects.equals(getSobrenome(), motorista.getSobrenome()) && Objects.equals(getEndereco(), motorista.getEndereco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrimeiro(), getSobrenome(), getEndereco());
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "id=" + id +
                ", primeiro='" + primeiro + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
//                ", caminhao=" + caminhao +
                '}';
    }
}
