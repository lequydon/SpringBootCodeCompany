package com.laptrinhjavaweb.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import com.laptrinhjavaweb.dto.NewDTO;

public interface INewService {
NewDTO save(NewDTO newDTO);
NewDTO update(NewDTO newDTO);
void delete(long[] ids);
List<NewDTO> findAll( Pageable pageable);
int totalItem();
}
