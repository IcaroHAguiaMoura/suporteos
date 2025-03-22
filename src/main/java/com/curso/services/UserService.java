package com.curso.services;

import com.curso.domains.User;

import com.curso.domains.dtos.UserDTO;
import com.curso.repositories.UsersRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    
    @Autowired
    private UsersRepository usersRepository;

    public List<UserDTO> findAll(){
        return usersRepository.findAll().stream()
                .map(obj -> new UserDTO(obj)).collect(Collectors.toList());
    }

    public User findById(Long id){
        Optional<User> obj = usersRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:"+id));
    }

    public User findByCpf(String cpf){
        Optional<User> obj = usersRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF: "+cpf));
    }

    public User findByEmail(String email){
        Optional<User> obj = usersRepository.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF: "+email));

    }

    public User create (UserDTO objDto){
        objDto.setId(null);
        ValidaPorCPFeEmail(objDto);
        User newObj = new User(objDto);
        return usersRepository.save(newObj);
    }
    public User update(Long id, UserDTO objDto){
        objDto.setId(id);
        User oldObj = findById(id);
        ValidaPorCPFeEmail(objDto);
        oldObj = new User(objDto);
        return usersRepository.save(oldObj);
    }

    public void delete (Long id){
        User obj = findById(id);
        if (obj.getServiceOrders().size()>0){
            throw new DataIntegrityViolationException("Usuario  nao pode ser deletado pois possuiu ordens de serviço!");
        }
        usersRepository.deleteById(id);
    }

    private void ValidaPorCPFeEmail(UserDTO objDto){
        Optional<User> obj = usersRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent()&& obj.get().getId()!= objDto.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }
        Optional<User> obj2 = usersRepository.findByEmail(objDto.getEmail());
        if(obj2.isPresent() && obj2.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}

