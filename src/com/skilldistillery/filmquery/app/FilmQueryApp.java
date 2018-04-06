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
		app.test();
		System.out.println("*********Welcome to the film archive************");
		app.launch();
	}

	private void test() {
		Film film = db.getFilmById(1);
		Actor actor = db.getActorById(1);
		List<Actor> cast = db.getActorsByFilmId(1);
		System.out.println(film);
		System.out.println(actor);
		System.out.println(cast);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);
		int lookUp = 0;

		while (lookUp != 3) {
			System.out.println("Would you like to:");
			System.out.println("1. Look up films by ID?");
			System.out.println("2. Look up films by keywords?");
			System.out.println("3. Exit\n");
			lookUp = input.nextInt();

			if (lookUp == 1) {
				System.out.println("What is the film ID?");
				int filmID = input.nextInt();

			}
		}

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

	}

}
