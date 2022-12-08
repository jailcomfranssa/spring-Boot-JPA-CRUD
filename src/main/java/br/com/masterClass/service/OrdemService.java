package br.com.masterClass.service;

import br.com.masterClass.entity.Ordem;
import br.com.masterClass.entity.OrdemItem;

import java.util.List;
import java.util.Optional;

public interface OrdemService {
    public Ordem salvar(Ordem ordem);

    public List<Ordem> listarTodos();

    public Optional<Ordem> buscarPorId(Long id);

    public Ordem atualizar(Long id, Ordem ordem);

    public void deletar(Long id);

    Ordem salvarOrdemList(Ordem ordem, OrdemItem ordemItem);

    List<Ordem> listOrdemItem();
}
