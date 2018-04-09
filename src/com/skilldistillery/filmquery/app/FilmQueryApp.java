package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	static Scanner input = new Scanner(System.in);

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		System.out.println("*********Welcome to the film archive************");
		app.launch();
	}

	// private void test() {
	// Film film = db.getFilmById(1);
	// Actor actor = db.getActorById(1);
	// List<Actor> cast = db.getActorsByFilmId(1);
	// System.out.println(film);
	// System.out.println(actor);
	// System.out.println(cast);
	// }

	private void launch() {
		int lookUp = -1;

		do {

			System.out.println("\n**************************************************");
			System.out.println("Would you like to:");
			System.out.println("\t1. Look up films by ID?");
			System.out.println("\t2. Look up films by keywords?");
			System.out.println("\t3. Exit");
			System.out.println("**************************************************");
			lookUp = input.nextInt();
			startUserInterface(lookUp);

		} while (lookUp != 0);

		input.close();
	}

	private void startUserInterface(int lookUp) {
		int filmId = 0;
		if ((lookUp < 1) || (lookUp > 3)) {
			System.out.println("\n********Please enter a number from 1-3********");
			launch();
		}

		else if (lookUp == 1) {
			System.out.print("\nWhat is the film ID? ");
			filmId = input.nextInt();
			Film film = db.getFilmById(filmId);

			printFilm(film);
			subMenu(filmId);

		}

		else if (lookUp == 2) {
			System.out.print("\nWhat is the keyword you would like to look up? ");
			String keyword = input.next();
			List<Film> filmList = db.getFilmByKeyword(keyword);
			if (filmList == null) {
				startUserInterface(lookUp);
			}
			for (Film film : filmList) {
				printFilm(film);
				
			}
			subMenu(filmId);
		}

		else if (lookUp == 3) {
			System.out.print("\n*********Thanks for checking us out, seeya!*********");
			System.exit(0);
		}

	}
	
	private void subMenu(int filmId) {
		System.out.println("**************************************************");
		System.out.println("Would you like to: ");
		System.out.println("\t1. Look at full film details.");
		System.out.println("\t2. Return to the main menu.");
		System.out.println("**************************************************");
		int subOption = input.nextInt();
		
		if ((subOption < 1) || (subOption > 2)) {
			System.out.println("\n********Please enter a number from 1-3********");
			launch();
		}
		else if (subOption == 1) {
			List<Film> filmList = db.getFullFilmById(filmId);
			for (Film film : filmList) {
				fullFilmDetails(film);
			}
			
		}
		else if (subOption == 2) {
			launch();
		}
		
	}
	
	private void fullFilmDetails(Film film) {
		System.out.println(film.toString1());
	}

	private void printFilm(Film film) {
		System.out.println(film);
	}

}
