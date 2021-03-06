package org.generation.blogPessoal.controller;

import java.util.Optional;
import org.generation.blogPessoal.model.UserLoginModel;
import org.generation.blogPessoal.model.UsuarioModel;
import org.generation.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController 
{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<UserLoginModel> Autentication(@RequestBody Optional<UserLoginModel> user)
	{
		return this.usuarioService.Logar(user)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModel> Post(@RequestBody UsuarioModel usuario)
	{
		Optional<UsuarioModel> user = usuarioService.CadastrarUsuario(usuario);
		try 
		{
			return ResponseEntity.ok(user.get());
			
		} catch (Exception e)
		{
			return ResponseEntity.badRequest().build();
		}
		
	}
}
