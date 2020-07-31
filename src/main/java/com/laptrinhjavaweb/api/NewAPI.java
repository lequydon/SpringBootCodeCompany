package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;
@CrossOrigin// tiêu chuẩn bảo mật web
//@Component chú thích đánh dấu giúp spring biết đó là  bean
//
//anotation là dạng chú thích hoặc 1 dạng siêu dữ liệu
@RestController//là annotation khai báo ở cấp độ class, dùng để khai báo class đó là controller
//@Override ghi đè phương thức lớp cha
public class NewAPI {
	@Autowired//
	private INewService newService;
	/*
	 * @RequestMapping là annotation khai báo ở cấp độ class và method,
	 *  dùng để đăng ký và ánh xạ các request tới một method của controller*/
	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}
	
	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);
		//cách 1
		//return newService.update(model);
		//cách 2
		return newService.save(model);
	}
	
	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
		
	}
}