package com.curso.services;

import com.curso.domains.Technician;
import com.curso.domains.dtos.TechnicianDTO;
import com.curso.repositories.TechnicianRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    public List<TechnicianDTO> findAll(){
        return technicianRepository.findAll().stream()
                .map(obj -> new TechnicianDTO(obj)).collect(Collectors.toList());
    }

    public Technician findById(Long id){
        Optional<Technician> obj = technicianRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:"+id));
    }

    public Technician findByCpf(String cpf){
        Optional<Technician> obj = technicianRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF: "+cpf));
    }

    public Technician findByEmail(String email){
        Optional<Technician> obj = technicianRepository.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF: "+email));

    }

    public Technician create (TechnicianDTO objDto){
        objDto.setId(null);
        ValidaPorCPFeEmail(objDto);
        Technician newObj = new Technician(objDto);
        return technicianRepository.save(newObj);
    }
    public Technician update(Long id, TechnicianDTO objDto){
        objDto.setId(id);
        Technician oldObj = findById(id);
        ValidaPorCPFeEmail(objDto);
        oldObj = new Technician(objDto);
        return technicianRepository.save(oldObj);
    }

    public void delete (Long id){
        Technician obj = findById(id);
        if (obj.getServiceOrders().size()>0){
            throw new DataIntegrityViolationException("Técnico  nao pode ser deletado pois possuiu ordens de serviço!");
        }
        technicianRepository.deleteById(id);
    }

    private void ValidaPorCPFeEmail(TechnicianDTO objDto){
        Optional<Technician> obj = technicianRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent()&& obj.get().getId()!= objDto.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }
        Optional<Technician> obj2 = technicianRepository.findByEmail(objDto.getEmail());
        if(obj2.isPresent() && obj2.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
