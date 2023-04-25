package br.com.terceiroperiodo.services;

import br.com.terceiroperiodo.model.Estado;
import br.com.terceiroperiodo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

      @Autowired// injeção de dependência no spring bot
      EstadoRepository estadoRepository;

      public Estado salvar(Estado estado){
          estado.setAtivo(true);
          return  estadoRepository.save(estado);

      }
        public List<Estado> buscarTodos() {
          List<Estado> response = estadoRepository.findAll();

          for(Estado estado: response){
              if(!estado.getAtivo()){
                  response.remove(estado);
              }

          }

            return response;


        }
            public Optional<Estado> buscarPorID(Long id){
                return estadoRepository.findById(id);
            }
            public List<Estado> buscarPorNome(String nome){
          return estadoRepository.findByNomeAndAtivo(nome, true);
            }

            public void deleteByid(Long id){
          estadoRepository.deleteById(id);
            }
}
