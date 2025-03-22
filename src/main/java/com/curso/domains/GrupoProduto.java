package com.curso.domains;

import com.curso.domains.dtos.GrupoProdutoDTO;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import org.springframework.context.annotation.EnableMBeanExport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name="grupoproduto")
public class GrupoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_grupoproduto")
    private Integer id;

    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="Status")
    private Status status;

    @JsonIgnore
    @OneToMany(mappedBy = "grupoProduto")
    private List<Produto> produtos = new ArrayList<>();

    public GrupoProduto(){
        this.status = Status.ATIVO;
    }


    public GrupoProduto(Integer id, String descricao, Status status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }
    public GrupoProduto(GrupoProdutoDTO dto){
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.status = Status.toEnum(dto.getStatus());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoProduto that = (GrupoProduto) o;
        return id == that.id && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
