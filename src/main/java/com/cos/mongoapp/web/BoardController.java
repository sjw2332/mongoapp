package com.cos.mongoapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.mongoapp.domain.Board;
import com.cos.mongoapp.domain.BoardRepository;
import com.cos.mongoapp.dto.BoardSaveDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {

	private final BoardRepository boardRepository;
	
	@GetMapping("/board")
	public List<Board> findAll() { 	//return을 JavaObject로 하면 스프링 내무적으로 JSON으로 자동 변환
		return boardRepository.findAll();		
	}
	
	@PostMapping("/board")
	public Board save(@RequestBody BoardSaveDto dto) { //{title:"제목3" , content:"내용3"}
		
		//dto는 xxx 마임, 우리는 json으로 넣어야됨
		//@RequestBody 는 JSON 타입으로 받음.
		
		return boardRepository.save(dto.toEntity());
	}
	
	
	
}
