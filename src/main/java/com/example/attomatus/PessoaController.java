package com.example.attomatus;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa editarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        return pessoaService.editarPessoa(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa consultarPessoa(@PathVariable Long id) {
        return pessoaService.consultarPessoa(id);
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @PostMapping("/{idPessoa}/enderecos")
    public void adicionarEndereco(@PathVariable Long idPessoa, @RequestBody Endereco endereco) {
        pessoaService.adicionarEndereco(idPessoa, endereco);
    }

    @GetMapping("/{idPessoa}/enderecos")
    public List<Endereco> listarEnderecosPessoa(@PathVariable Long idPessoa) {
        return pessoaService.listarEnderecosPessoa(idPessoa);
    }

    @PutMapping("/{idPessoa}/enderecos/{idEndereco}/principal")
    public void setEnderecoPrincipal(@PathVariable Long idPessoa, @PathVariable Long idEndereco) {
        pessoaService.setEnderecoPrincipal(idPessoa, idEndereco);
    }

}
