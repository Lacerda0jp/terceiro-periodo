package br.com.terceiroperiodo.services;

import br.com.terceiroperiodo.model.Cidade;
import br.com.terceiroperiodo.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CidadeService {
    @Autowired
    CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade) {
        return cidadeRepository.save(cidade);

    }

    public List<Cidade> buscarTodos() {
        List<Cidade> response = cidadeRepository.findAll();
        return response;
    }
}
