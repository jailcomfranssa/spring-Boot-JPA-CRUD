package br.com.masterClass.service;

import br.com.masterClass.entity.Ordem;

import java.util.List;
import java.util.Optional;

public interface OrdemService {
    public Ordem salvar(Ordem ordem);

    public List<Ordem> listarTodos();

    public Optional<Ordem> buscarPorId(Long id);

    public Ordem atualizar(Long id, Ordem ordem);

    public void deletar(Long id);
}
