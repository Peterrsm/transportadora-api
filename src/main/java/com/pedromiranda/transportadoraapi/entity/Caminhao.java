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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "caminhao")
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonDeserialize
@JsonSerialize
@Getter
@Setter
public class Caminhao implements Serializable {
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

    @OneToMany(targetEntity = Motorista.class)
    private Set<Motorista> motoristas = new HashSet<>();

    public void vinculaMotorista(Motorista moto){
        this.motoristas.add(moto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Caminhao)) return false;
        Caminhao caminhao = (Caminhao) o;
        return Objects.equals(marca, caminhao.marca) && Objects.equals(modelo, caminhao.modelo) && Objects.equals(placa, caminhao.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, placa);
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", motoristas='" + motoristas + '\'' +
                '}';
    }
}
