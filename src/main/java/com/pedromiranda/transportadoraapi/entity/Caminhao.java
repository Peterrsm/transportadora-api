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
@Table(name="caminhao")
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonDeserialize
@JsonSerialize
public class Caminhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column
    private String placa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Caminhao)) return false;
        Caminhao caminhao = (Caminhao) o;
        return getId().equals(caminhao.getId()) && Objects.equals(getMarca(), caminhao.getMarca()) && Objects.equals(getModelo(), caminhao.getModelo()) && Objects.equals(getPlaca(), caminhao.getPlaca());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMarca(), getModelo(), getPlaca());
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
