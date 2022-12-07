package br.com.masterClass.service;

import br.com.masterClass.entity.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    public List<Pessoa> litar();

    public Pessoa salvar(Pessoa pessoa);

    public Optional<Pessoa> listarPorId(Long pessoaId);

    public Pessoa atualizar(Long pessoaId, Pessoa pessoa);

    String deletar(Long pessoaId);
}
