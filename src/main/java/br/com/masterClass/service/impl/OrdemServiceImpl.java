package br.com.masterClass.service.impl;

import br.com.masterClass.entity.Ordem;
import br.com.masterClass.repository.OrdemRepository;
import br.com.masterClass.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemServiceImpl implements OrdemService {

   private final OrdemRepository ordemRepository;

   @Autowired
    public OrdemServiceImpl(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }


    @Override
    public Ordem salvar(Ordem ordem) {
       // ordem.setPrecoTotal(new BigDecimal(String.valueOf(ordem.getPrecoTotal())));
        return ordemRepository.save(ordem);
    }

    @Override
    public List<Ordem> listarTodos() {
        return ordemRepository.findAll();
    }

    @Override
    public Optional<Ordem> buscarPorId(Long id) {

        Optional<Ordem> ordem = ordemRepository.findById(id);
        if(ordem.isEmpty()){
            throw new RuntimeException("Não encontrado...");
        }

        return ordem;
    }

    @Override
    public Ordem atualizar(Long id, Ordem ordem) {
       Optional<Ordem> ordemData = ordemRepository.findById(id);

       if (ordemData.isPresent()){
           Ordem _ordem = ordemData.get();
           _ordem.setNumRastreamentoPedido(ordem.getNumRastreamentoPedido());
           _ordem.setQuantidadeTotal(ordem.getQuantidadeTotal());
           _ordem.setStatus(ordem.getStatus());
           _ordem.setPrecoTotal(ordem.getPrecoTotal());
           _ordem.getEnderecoCobranca().setRua(ordem.getEnderecoCobranca().getRua());
           _ordem.getEnderecoCobranca().setCidade(ordem.getEnderecoCobranca().getCidade());
           _ordem.getEnderecoCobranca().setEstado(ordem.getEnderecoCobranca().getEstado());
           _ordem.getEnderecoCobranca().setPais(ordem.getEnderecoCobranca().getPais());
           _ordem.getEnderecoCobranca().setCodigoPostal(ordem.getEnderecoCobranca().getCodigoPostal());

           return  ordemRepository.save(_ordem);

       } else {
           throw new RuntimeException("Não encontrado...");
       }
    }

    @Override
    public void deletar(Long id) {
        Optional<Ordem> ordem = ordemRepository.findById(id);
        if(ordem.isEmpty()){
            throw new RuntimeException("Não encontrado...");
        }else {
            ordemRepository.deleteById(id);
        }

    }
}
