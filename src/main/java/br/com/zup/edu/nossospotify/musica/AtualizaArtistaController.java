package br.com.zup.edu.nossospotify.musica;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/artistas")
public class AtualizaArtistaController {

    private final ArtistaRepository artistaRepository;

    public AtualizaArtistaController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    @PatchMapping("/{idArtista}")
    public ResponseEntity<Void> atualizaArtista(@PathVariable Long idArtista, @RequestBody @Valid AtualizaNomeArtistaRequest request){

        Artista artista = artistaRepository.findById(idArtista).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "artista não localizado"));

        artista.setNome(request.getNome());
        artistaRepository.save(artista);


        return ResponseEntity.noContent().build();



    }
}
