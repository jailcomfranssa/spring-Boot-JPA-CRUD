package br.com.masterClass.repository;

import br.com.masterClass.entity.Cpf;
import br.com.masterClass.entity.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CpfRepository cpfRepository;

    @Test
    public void addPessoaCpf(){

        Pessoa pessoa = new Pessoa();
        Cpf cpf = new Cpf();

        pessoa.setNome("Maria");
        pessoa.setIdade("43");

        cpf.setDataEmissao("2021");
        cpf.setNumDocumento("1111111111");

        pessoa.setCpf(cpf);
        cpf.setPessoa(pessoa);

        pessoaRepository.save(pessoa);
    }

    @Test
    public void listCpfId(){

        Cpf cpf = cpfRepository.findById(2L).get();
        System.out.println("CPF: "+ cpf);
    }

    @Test
    public void listPessoaId(){

        Pessoa pessoa = pessoaRepository.findById(1L).get();
        System.out.println("Pessoa: "+ pessoa);
    }







}