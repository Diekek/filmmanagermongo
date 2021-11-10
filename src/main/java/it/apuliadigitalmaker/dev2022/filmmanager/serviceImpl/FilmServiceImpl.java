package it.apuliadigitalmaker.dev2022.filmmanager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigitalmaker.dev2022.filmmanager.repository.FilmRepository;
import it.apuliadigitalmaker.dev2022.filmmanager.requestDto.FilmRequestDto;
import it.apuliadigitalmaker.dev2022.filmmanager.responseDto.FilmResponseDto;
import it.apuliadigitalmaker.dev2022.filmmanager.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	FilmRepository filmRepository;

	@Override
	public List<FilmResponseDto> getFilms() {
		
		filmRepository.findAll();
		
		return null;
	}

	@Override
	public FilmResponseDto getFilm(String filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilmResponseDto createFilm(FilmRequestDto film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilmResponseDto updateFilm(String filmId, FilmRequestDto film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteFilm(String filmId) {
		// TODO Auto-generated method stub
		return false;
	}

}
