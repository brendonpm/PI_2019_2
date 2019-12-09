package com.example.soft.repository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.soft.resource.UserRepository;
import com.example.soft.model.User;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public List<User> list(){
		return userRepo.findAll();	
	}
	
	@GetMapping("/nome/{nome}")
	public List<User> senha(@PathVariable String nome){	
		return userRepo.findByName(nome);
	}
	
	
	@GetMapping("/{cod}")
	public Optional<User> findById(@PathVariable Long cod) {
		return userRepo.findById(cod);
		
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user,HttpServletResponse response){
		
		User save = userRepo.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{cod}")
				.buildAndExpand(save.getCod()).toUri();
		
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{cod}")
	@ResponseStatus
	public void delete(@PathVariable Long cod) {
		userRepo.deleteById(cod);		
	}
	
	@PutMapping("/{cod}")
	public ResponseEntity<User> update(@PathVariable Long cod,@RequestBody User user){
		Optional<User> userBanco = userRepo.findById(cod);
		BeanUtils.copyProperties(user, userBanco.get(),"cod");
		userRepo.save(userBanco.get());
		return ResponseEntity.ok(user);
	}
	
	
}
