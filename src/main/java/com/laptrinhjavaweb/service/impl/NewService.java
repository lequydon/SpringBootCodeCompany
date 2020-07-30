 package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;
@Service 
public class NewService implements INewService {
@Autowired
private NewRepository newRepository;
@Autowired
private CategoryRepository categoryRepository;
@Override
public NewDTO save(NewDTO newDTO) {
	CategoryEntity categoryEntity= categoryRepository.findOneByCode(newDTO.getCategoryCode());
	// TODO Auto-generated method stub
	return null;
}
}
