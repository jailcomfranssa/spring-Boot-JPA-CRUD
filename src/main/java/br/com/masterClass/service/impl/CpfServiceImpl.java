package br.com.masterClass.service.impl;

import br.com.masterClass.entity.Cpf;
import br.com.masterClass.entity.Pessoa;
import br.com.masterClass.repository.CpfRepository;
import br.com.masterClass.service.CpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CpfServiceImpl implements CpfService {

    private CpfRepository cpfRepository;

    @Autowired
    public CpfServiceImpl(CpfRepository cpfRepository) {
        this.cpfRepository = cpfRepository;
    }


    @Override
    public List<Cpf> listarTodos() {
        return cpfRepository.findAll();
    }

    @Override
    public Cpf salvar(Cpf cpf) {
        Cpf _cpf = new Cpf();
        Pessoa pessoa = new Pessoa();

        _cpf.setDataEmissao(cpf.getDataEmissao());
        _cpf.setNumDocumento(cpf.getNumDocumento());

        pessoa.setNome(cpf.getPessoa().getNome());
        pessoa.setIdade(cpf.getPessoa().getIdade());

        _cpf.setPessoa(pessoa);
        pessoa.setCpf(_cpf);

        return cpfRepository.save(_cpf);
    }

    @Override
    public Optional<Cpf> listarPorId(Long cpfId) {

        Optional<Cpf> cpf = cpfRepository.findById(cpfId);
        if(cpf.isEmpty()){
            throw new RuntimeException("Não encontrado...");
        }

        return cpf;
    }

    @Override
    public Cpf atualizar(Long cpfId, Cpf cpf) {

        Optional<Cpf> cpfData = cpfRepository.findById(cpfId);
        if(cpfData.isPresent()){
            Cpf _cpf = cpfData.get();
            _cpf.setDataEmissao(cpf.getDataEmissao());
            _cpf.setNumDocumento(cpf.getNumDocumento());
            _cpf.getPessoa().setNome(cpf.getPessoa().getNome());
            _cpf.getPessoa().setIdade(cpf.getPessoa().getIdade());

            return cpfRepository.save(_cpf);

        }else {
            throw new RuntimeException("Não encontrado...");
        }
    }

    @Override
    public String delete(Long cpfId) {
        Optional<Cpf> cpfData = cpfRepository.findById(cpfId);
        if(cpfData.isEmpty()){
            throw new RuntimeException("Não encontrado...");
        }
        cpfRepository.deleteById(cpfId);
        return "Cpf deletado..";
    }


}
