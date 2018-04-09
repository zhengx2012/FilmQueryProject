## Film Query Homework Project

#### Description
This program has Object classes of the tables from the MySQL database. It will use jdbc to call specific data and use it to print out a list of film(s). The user can then choose from the menu options to view certain films.

#### How it works
* Users are prompted to choose from three menu options, search by film, film keyword, or to exit the program.
* When they select a search the program will call select methods to look up the film in the database.
* If a film is not found, they will be prompted to choose again.
* Once a film is found, it will then be printed for the user to see.
* The user will be prompted again, but with a sub menu to decide if they would like to see the full film detail, or to go back to the main menu.

#### Lessons learned
* Using an ArrayList to store the films by keyword, then use a foreach loop to iterate through the array and then print all the films.
* Using an int to store the release_year, rather than a Date will give you the first integers, like only the year, when in ISO format.
