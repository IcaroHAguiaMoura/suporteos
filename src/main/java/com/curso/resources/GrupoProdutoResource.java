package com.curso.resources;

import com.curso.domains.GrupoProduto;
import com.curso.domains.dtos.GrupoProdutoDTO;
import com.curso.services.GrupoProdutoService;
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
@RequestMapping(value = "/grupoproduto")
<<<<<<< HEAD
=======
@Tag(name = "Grupo de produtos",description = "API para gerenciamento de grupo de produtos")
>>>>>>> 97f7a06 (adição do swagger)
public class GrupoProdutoResource {

    @Autowired
    private GrupoProdutoService grupoProdutoService;

    @GetMapping
<<<<<<< HEAD
=======
    @Operation(summary = "Listar todos os grupos produtos"
            ,description = "Retorna uma lista com todos os grupos produtos cadastrados")
>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<List<GrupoProdutoDTO>> findAll(){
        return ResponseEntity.ok().body(grupoProdutoService.findAll());
    }

    @GetMapping(value = "/{id}")
<<<<<<< HEAD
=======
    @Operation(summary = "Busca um grupo de produto por id"
            ,description = "Retorna Realiza a busca de um grupo produto cadastrado por id")

>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<GrupoProdutoDTO> findById(@PathVariable Integer id){
        GrupoProduto obj = this.grupoProdutoService.findById(id);
        return ResponseEntity.ok().body(new GrupoProdutoDTO(obj));
    }

    @PostMapping
<<<<<<< HEAD
=======
    @Operation(summary = "Criar um novo grupo de produto"
            ,description = "Cria um novo grupo de produto com base nos dados fornecidos")
>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<GrupoProdutoDTO> create(@Valid @RequestBody GrupoProdutoDTO dto){
        GrupoProduto grupoProduto = grupoProdutoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(grupoProduto.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
<<<<<<< HEAD
=======
    @Operation(summary = "Deletar um grupo de produto"
            ,description = "Remove um grupo de produto a partir do seu Id")
>>>>>>> 97f7a06 (adição do swagger)
    public ResponseEntity<GrupoProdutoDTO> update(@PathVariable Integer id, @Valid @RequestBody GrupoProdutoDTO objDto){
        GrupoProduto Obj = grupoProdutoService.update(id,objDto);
        return ResponseEntity.ok().body(new GrupoProdutoDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<GrupoProdutoDTO> delete(@PathVariable Integer id){
        grupoProdutoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


