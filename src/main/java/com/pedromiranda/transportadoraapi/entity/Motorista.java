package com.pedromiranda.transportadoraapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="motorista")
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonDeserialize
@JsonSerialize
public class Motorista {
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

    @Column
    private Long caminhao_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motorista)) return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(getId(), motorista.getId()) && Objects.equals(getPrimeiro(), motorista.getPrimeiro()) && Objects.equals(getSobrenome(), motorista.getSobrenome()) && Objects.equals(getEndereco(), motorista.getEndereco()) && Objects.equals(getCaminhao_id(), motorista.getCaminhao_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrimeiro(), getSobrenome(), getEndereco(), getCaminhao_id());
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "id=" + id +
                ", primeiro='" + primeiro + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", caminhao_id=" + caminhao_id +
                '}';
    }
}
