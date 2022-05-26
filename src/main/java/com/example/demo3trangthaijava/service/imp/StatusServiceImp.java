package com.example.demo3trangthaijava.service.imp;

import com.example.demo3trangthaijava.model.dto.StatusDto;
import com.example.demo3trangthaijava.model.entity.Status;
import com.example.demo3trangthaijava.model.entity.User;
import com.example.demo3trangthaijava.model.in.StatusIn;
import com.example.demo3trangthaijava.repository.StatusRepository;
import com.example.demo3trangthaijava.repository.UserRepository;
import com.example.demo3trangthaijava.service.StatusService;
import com.example.demo3trangthaijava.service.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusServiceImp implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private UserRepository userRepository;

    private StatusMapper statusMapper;
    @Override
    public List<StatusDto> getAll() {
        List<Status> list = statusRepository.findAll();
        List<StatusDto>dtoList = list.stream().map(it->statusMapper.map(it)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public Status create(StatusIn statusIn) {
       Status status = statusMapper.map(statusIn);
       return statusRepository.save(status);
    }

    @Override
    public Status update(Integer id, StatusIn statusIn) {
        Status status = statusRepository.findAllById(id);
        statusIn.setId(id);
        if(statusIn.getUsers()==null){
            List<User> users = status.getUsers();
            statusIn.setUsers(users);
        }else {
            List<User> users =  statusIn.getUsers();

            for (int i = 0; i < users.size();i++){
                if (users.get(i) == null){
                    User user = userRepository.findById(users.get(i).getId_status()).orElse(null);
                    users.set(i,user);
                }
            }
            statusIn.setUsers(users);
        }
        status = StatusMapper.map(statusIn);
        return statusRepository.save(status);
        }


    @Override
    public void delete(Integer id, StatusIn statusIn) {
        if (statusIn.getCheckDelete() == false){
            List<User> userList = userRepository.findById_statusOrderById_statusAsc();
            for (int i =0; i < userList.size();i++){
                userList.get(i).setStatus(null);
                userRepository.save(userList.get(i));
            }
        }
        statusRepository.deleteById(id);
    }
}
