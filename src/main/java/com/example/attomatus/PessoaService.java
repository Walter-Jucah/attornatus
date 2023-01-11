package com.example.attomatus;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa editarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa consultarPessoa(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public void adicionarEndereco(Long idPessoa, Endereco endereco) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElse(null);
        if (pessoa != null) {
            pessoa.getEnderecos().add(endereco);
            pessoaRepository.save(pessoa);
        }
    }

    public List<Endereco> listarEnderecosPessoa(Long idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElse(null);
        if (pessoa != null) {
            return pessoa.getEnderecos();
        } else {
            return Collections.emptyList();
        }
    }

    public void setEnderecoPrincipal(Long idPessoa, Long idEndereco) {
    }
}
