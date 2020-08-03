 package com.laptrinhjavaweb.service.impl;

 import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;
@Service 
public class NewService implements INewService {
@Autowired
private NewRepository newRepository;
@Autowired
private CategoryRepository categoryRepository;
@Autowired
private NewConverter newConverter;
@Override// ghi đè phương thức lớp cha
public NewDTO save(NewDTO newDTO) {
	NewEntity newEntity =new NewEntity();
	if(newDTO.getId()!=null) {
		NewEntity oldNewEntity=newRepository.findOne(newDTO.getId());
		newEntity=newConverter.toEntity(newDTO,oldNewEntity);
	}else {
		newEntity=newConverter.toEntity(newDTO);
	}
	CategoryEntity categoryEntity= categoryRepository.findOneByCode(newDTO.getCategoryCode());
	// TODO Auto-generated method stub
	newEntity.setCategory(categoryEntity);
	newEntity=newRepository.save(newEntity);
	return newConverter.toDTO(newEntity);
}
@Override
public NewDTO update(NewDTO newDTO) {
	NewEntity oldNewEntity=newRepository.findOne(newDTO.getId());
	NewEntity newEntity=newConverter.toEntity(newDTO,oldNewEntity);
	CategoryEntity categoryEntity= categoryRepository.findOneByCode(newDTO.getCategoryCode());
	// TODO Auto-generated method stub
	newEntity.setCategory(categoryEntity);
	newEntity=newRepository.save(newEntity);
	return newConverter.toDTO(newEntity); 
}
@Override
public void delete(long[] ids) {
	for (long item : ids) {
		newRepository.delete(item);
	}
	// TODO Auto-generated method stub
	
}
@Override
public List<NewDTO> findAll(Pageable pageable) {
	// TODO Auto-generated method stub
	List<NewDTO> results = new ArrayList<>();
	List<NewEntity> entities = newRepository.findAll(pageable).getContent();
	for (NewEntity item: entities) {
		NewDTO newDTO = newConverter.toDTO(item);
		results.add(newDTO);
		}
	return results;
}
@Override
public int totalItem() {
	// TODO Auto-generated method stub
	return (int)newRepository.count();
}
}
