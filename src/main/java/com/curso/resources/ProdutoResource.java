package com.curso.resources;

import com.curso.domains.Produto;
import com.curso.domains.dtos.GrupoProdutoDTO;
import com.curso.domains.dtos.ProdutoDTO;
import com.curso.services.ProdutoService;
<<<<<<< HEAD
=======
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
>>>>>>> 97f7a06 (adição do swagger)
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
<<<<<<< HEAD
=======
@Tag(name = "Produtos",description = "API para gerenciamento de produtos")
>>>>>>> 97f7a06 (adição do swagger)
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
<<<<<<< HEAD
=======
    @Operation(summary = "Listar todos os produtos"
            ,description = "Retorna a lista de produtos cadastrados")
>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @GetMapping(value = "/{id}")
<<<<<<< HEAD
=======
    @Operation(summary = "Busca um produto por id"
            ,description = "Retorna Realiza a busca de um grupo produto cadastrado por id")
>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        Produto obj = this.produtoService.findById(id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @GetMapping(value = "/codigobarra/{codigoBarra}")
<<<<<<< HEAD
=======
    @Operation(summary = "Busca um produto por codigo de barras"
            ,description = "Retorna o produto com o codigo de barra fornecido")
>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<ProdutoDTO> findByCodigoBarra(@PathVariable String codigoBarra) {
        Produto obj = this.produtoService.findByCodigoBarra(codigoBarra);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @PostMapping
<<<<<<< HEAD
=======
    @Operation(summary = "Cria um novo produto"
            ,description = "Cria um produto com base nos dados fornecidos")
>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<ProdutoDTO> create( @RequestBody ProdutoDTO dto) {
        Produto produto = produtoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getIdProduto()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
<<<<<<< HEAD
=======
    @Operation(summary = "Atualiza dados de produto"
            ,description = "Retorna o produto atualziado")
>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @Valid @RequestBody ProdutoDTO objDto){
        Produto Obj = produtoService.update(id,objDto);
        return ResponseEntity.ok().body(new ProdutoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
<<<<<<< HEAD
=======
    @Operation(summary = "Deleta produto"
            ,description = "Remove o produto")
>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<ProdutoDTO> delete (@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
