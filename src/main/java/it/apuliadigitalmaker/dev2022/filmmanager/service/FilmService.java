package it.apuliadigitalmaker.dev2022.filmmanager.service;

import java.util.List;

import it.apuliadigitalmaker.dev2022.filmmanager.requestDto.FilmRequestDto;
import it.apuliadigitalmaker.dev2022.filmmanager.responseDto.FilmResponseDto;

public interface FilmService {

	public List<FilmResponseDto> getFilms();
	
	public FilmResponseDto getFilm(String filmId);
	
	public FilmResponseDto createFilm(FilmRequestDto film);
	
	public FilmResponseDto updateFilm(String filmId, FilmRequestDto film);
	
	public boolean deleteFilm(String filmId);
	
}
