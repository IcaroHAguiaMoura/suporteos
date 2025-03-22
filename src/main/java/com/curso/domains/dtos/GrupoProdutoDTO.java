package com.curso.domains.dtos;

import com.curso.domains.GrupoProduto;
import com.curso.domains.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;


public class GrupoProdutoDTO {

    private Integer id;


    private String descricao;
    private Integer status;

    public GrupoProdutoDTO(){}

    public  GrupoProdutoDTO (GrupoProduto grupoProduto){
    this.id = grupoProduto.getId();
    this.descricao = grupoProduto.getDescricao();
    this.status = grupoProduto.getStatus().getId();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
