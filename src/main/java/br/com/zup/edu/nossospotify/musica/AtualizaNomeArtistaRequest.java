package br.com.zup.edu.nossospotify.musica;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AtualizaNomeArtistaRequest {

    private String nome;

    public String getNome() {
        return nome;
    }
}
