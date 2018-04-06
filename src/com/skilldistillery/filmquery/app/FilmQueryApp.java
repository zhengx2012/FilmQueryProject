package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

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
		Scanner input = new Scanner(System.in);

		System.out.println("Would you like to:");
		System.out.println("1. Look up films by ID?");
		System.out.println("2. Look up films by keywords?");
		System.out.println("3. Exit");
		int lookUp = input.nextInt();

		if (lookUp == 1) {
			System.out.print("\nWhat is the film ID? ");
			int filmId = input.nextInt();
			db.getFilmById(filmId);

		}
		if (lookUp == 2) {
			System.out.print("\nWhat is the keyword you would like to look up? ");
			String keyword = input.next();
			db.getFilmByKeyword(keyword);

		}
		if (lookUp == 3) {
			System.out.print("\nThanks for checking us out, seeya!");
			System.exit(0);

		}
	}

	startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

	}

}
