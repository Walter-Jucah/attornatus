package com.example.attornatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PessoaTest {

    @Test
    public void testGetId() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        assertEquals(1L, pessoa.getId());
    }

    @Test
    public void testGetNome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("John Doe");
        assertEquals("John Doe", pessoa.getNome());
    }

    @Test
    public void testGetEmail() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("johndoe@example.com");
        assertEquals("johndoe@example.com", pessoa.getEmail());
    }

    @Test
    public void testGetIdade() {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdade(30);
        assertEquals(30, pessoa.getIdade());
    }

    @Test
    public void testGetEnderecoPrincipal() {
        Endereco endereco = new Endereco("Rua A", "Cidade B", "Estado C", "12345-678");
        Pessoa pessoa = new Pessoa();
        pessoa.setEnderecoPrincipal(endereco);
        assertEquals(endereco, pessoa.getEnderecoPrincipal());
    }

    @Test
    public void testGetEnderecos() {
        Endereco endereco1 = new Endereco("Rua A", "Cidade B", "Estado C", "12345-678");
        Endereco endereco2 = new Endereco("Rua D", "Cidade E", "Estado F", "23456-789");
        List<Endereco> enderecos = Arrays.asList(endereco1, endereco2);
        Pessoa pessoa = new Pessoa();
        pessoa.setEnderecos(enderecos);
        assertEquals(enderecos, pessoa.getEnderecos());
    }
}