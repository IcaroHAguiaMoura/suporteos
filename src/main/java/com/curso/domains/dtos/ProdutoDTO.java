package com.curso.domains.dtos;

import com.curso.domains.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoDTO {

    private Long idProduto;

    @NotNull(message = "O campo codigo de barra nao pode ser nulo")
    @NotBlank(message = "O campo codigo de barra nao pode estar vazio")
    private String codigoBarrra;

    @NotNull(message = "O campo descrição nao pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo saldoEstoque nao pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal saldoEstoque;

    @NotNull(message = "O campo valorUnitario nao pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorUnitario;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro = LocalDate.now();

    @NotNull (message = "O campo Grupo Produto é requerido")
    private int grupoProduto;
    private String descricaoGrupoProduto;

    private int status;

    public ProdutoDTO (){ }

    public ProdutoDTO( Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.codigoBarrra = produto.getCodigoBarra();
        this.descricao = produto.getDescricao();
        this.saldoEstoque = produto.getSaldoEstoque();
        this.valorUnitario = produto.getValorUnitario();

        this.dataCadastro = produto.getDataCadastro();
        this.grupoProduto = produto.getGrupoProduto().getId();
        this.descricaoGrupoProduto = produto.getGrupoProduto().getDescricao();
        this.status = produto.getStatus().getId();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public @NotNull(message = "O campo codigo de barra nao pode ser nulo") @NotBlank(message = "O campo codigo de barra nao pode estar vazio") String getCodigoBarrra() {
        return codigoBarrra;
    }

    public void setCodigoBarrra(@NotNull(message = "O campo codigo de barra nao pode ser nulo") @NotBlank(message = "O campo codigo de barra nao pode estar vazio") String codigoBarrra) {
        this.codigoBarrra = codigoBarrra;
    }

    public @NotNull(message = "O campo descrição nao pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição nao pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo saldoEstoque nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(@NotNull(message = "O campo saldoEstoque nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    public @NotNull(message = "O campo valorUnitario nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(@NotNull(message = "O campo valorUnitario nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @NotNull(message = "O campo Grupo Produto é requerido")
    public int getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(@NotNull(message = "O campo Grupo Produto é requerido") int grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public String getDescricaoGrupoProduto() {
        return descricaoGrupoProduto;
    }

    public void setDescricaoGrupoProduto(String descricaoGrupoProduto) {
        this.descricaoGrupoProduto = descricaoGrupoProduto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
