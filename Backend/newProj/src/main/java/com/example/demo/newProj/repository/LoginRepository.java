package com.example.demo.newProj.repository;
import com.example.demo.newProj.model.Login;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
public interface LoginRepository  extends MongoRepository<Login,String>{
	@Query("{email: ?0, roles: ?1}")
	List<Login>  findByEmailAndRoles( String email,String roles);
	
}
