package br.com.masterClass.service.impl;

import br.com.masterClass.entity.Cpf;
import br.com.masterClass.entity.Pessoa;
import br.com.masterClass.repository.PessoaRepository;
import br.com.masterClass.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> litar() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {

        Pessoa _pessoa = new Pessoa();
        Cpf _cpf = new Cpf();

        _pessoa.setNome(pessoa.getNome());
        _pessoa.setIdade(pessoa.getIdade());

        _cpf.setNumDocumento(pessoa.getCpf().getNumDocumento());
        _cpf.setDataEmissao(pessoa.getCpf().getDataEmissao());

        _pessoa.setCpf(_cpf);
        _cpf.setPessoa(_pessoa);

        return pessoaRepository.save(_pessoa);
    }

    @Override
    public Optional<Pessoa> listarPorId(Long pessoaId) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        if(pessoa.isEmpty()){
            throw new RuntimeException("Não encontrado...");
        }
        return pessoa;
    }

    @Override
    public Pessoa atualizar(Long pessoaId, Pessoa pessoa) {

        Optional<Pessoa> pessoaData = pessoaRepository.findById(pessoaId);
        if(pessoaData.isPresent()){
            Pessoa _pessoa = pessoaData.get();
            _pessoa.setNome(pessoa.getNome());
            _pessoa.setIdade(pessoa.getIdade());
            _pessoa.getCpf().setNumDocumento(pessoa.getCpf().getNumDocumento());
            _pessoa.getCpf().setDataEmissao(pessoa.getCpf().getDataEmissao());

            return pessoaRepository.save(_pessoa);

        }else {
            throw new RuntimeException("Não encontrado...");
        }

    }

    @Override
    public String deletar(Long pessoaId) {
        Optional<Pessoa> pessoaData = pessoaRepository.findById(pessoaId);
        if (pessoaData.isEmpty()){
            throw new RuntimeException("Não encontrado...");

        }
        pessoaRepository.deleteById(pessoaId);
        return "Pessoa deletada....";
    }


}
