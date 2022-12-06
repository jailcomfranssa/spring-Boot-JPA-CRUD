package br.com.masterClass.service.impl;

import br.com.masterClass.repository.EnderecoRepository;
import br.com.masterClass.repository.OrdemRepository;
import br.com.masterClass.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

   private final EnderecoRepository enderecoRepository;

   @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }
}
