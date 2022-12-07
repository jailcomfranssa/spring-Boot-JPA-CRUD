package br.com.masterClass.service;

import br.com.masterClass.entity.Cpf;

import java.util.List;
import java.util.Optional;

public interface CpfService {
    public List<Cpf> listarTodos();

    public Cpf salvar(Cpf cpf);

    public Optional<Cpf> listarPorId(Long cpfId);

    public Cpf atualizar(Long cpfId, Cpf cpf);

    String delete(Long cpfId);
}
