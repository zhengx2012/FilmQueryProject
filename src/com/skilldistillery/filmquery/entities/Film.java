package com.skilldistillery.filmquery.entities;

import java.sql.Date;
import java.util.List;

public class Film {
	private int id;
	private String title;
	private String description;
	private Date releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> cast;

	public Film() {

	}

	public Film(int id, String title, String description, Date releaseYear, int languageId, int rentalDuration,
			double rentaRate, int length, double replacementCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentaRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	public Film(String title, Date releaseYear, String rating, List<Actor> cast, String description) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.cast = cast;
		this.description = description;
	}
	public Film(String title, Date releaseYear, String rating, String description) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.description = description;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rentalDuration;
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating != other.rating)
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Film id: ");
//		builder.append(id);
//		builder.append(", title: ");
//		builder.append(title);
//		builder.append(", description: ");
//		builder.append(description);
//		builder.append(", releaseYear: ");
//		builder.append(releaseYear);
//		builder.append(", languageId: ");
//		builder.append(languageId);
//		builder.append(", rentalDuration: ");
//		builder.append(rentalDuration);
//		builder.append(", rentalRate: $");
//		builder.append(rentalRate);
//		builder.append(", length: ");
//		builder.append(length);
//		builder.append(", replacementCost: $");
//		builder.append(replacementCost);
//		builder.append(", rating: ");
//		builder.append(rating);
//		builder.append(", specialFeatures: ");
//		builder.append(specialFeatures);
//		builder.append(", cast: ");
//		builder.append(cast);
//		builder.append(".");
//		return builder.toString();
//	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nTitle: ");
		builder.append(title);
		builder.append("\nRelease Year: ");
		builder.append(releaseYear);
		builder.append("\nRating: ");
		builder.append(rating);
		builder.append("\nCast: ");
		builder.append(cast);
		builder.append("\nDescription: ");
		builder.append(description);
		return builder.toString();
	}

}
