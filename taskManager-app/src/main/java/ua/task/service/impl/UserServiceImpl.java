package ua.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.task.domain.UserDTO;
import ua.task.entity.UserEntity;
import ua.task.repository.UserRepository;
import ua.task.service.UserService;
import ua.task.utils.ObjectMapperUtils;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void save(UserDTO dto) {
		UserEntity entity = modelMapper.map(dto, UserEntity.class);
		userRepository.save(entity);
		
	}

	@Override
	public List<UserDTO> findAllUsers() {
		List<UserEntity> entity = userRepository.findAll();
		List<UserDTO> dto = modelMapper.mapAll(entity, UserDTO.class);
		return dto;
	}

	@Override
	public UserDTO findById(Long id) {
		UserEntity entity = userRepository.findById(id).get();
		UserDTO dto = modelMapper.map(entity, UserDTO.class);
		return dto;
	}

	@Override
	public void upate(UserDTO dto) {
		userRepository.save(modelMapper.map(dto, UserEntity.class));
		
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
