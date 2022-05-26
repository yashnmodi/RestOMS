package com.mysquare.restoms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie_details",schema="restro")
public class MovieDetails {
	private int movieId;
	private String movieName;
	private String moviePath;
	public MovieDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieDetails(int movieId, String movieName, String moviePath) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.moviePath = moviePath;
	}

	public MovieDetails(String movieName, String moviePath) {
		super();
		this.movieName = movieName;
		this.moviePath = moviePath;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="music_id",length=4)
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	@Column(name="movie_name",length=40)
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@Column(name="movie_path",length=40)
	public String getMoviePath() {
		return moviePath;
	}
	public void setMoviePath(String moviePath) {
		this.moviePath = moviePath;
	}
	
	@Override
	public String toString() {
		return "MovieDetails [movieId=" + movieId + ", movieName=" + movieName + ", moviePath=" + moviePath + "]";
	}
}
