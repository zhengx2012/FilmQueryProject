package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  public Film getFilmById(int filmId);
  public List<Film> getFullFilmById(int filmId);
  public Actor getActorById(int actorId);
  public List<Actor> getActorsByFilmId(int filmId);
  public List<Film> getFilmByKeyword(String keyword);
  public Language getLanguageByFilmId(int filmId);
}
