package com.mysquare.restoms.repository;

import java.util.List;
import com.mysquare.restoms.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepo extends CrudRepository<Menu, Long> {
	@Query("select m from Menu m where specification='roti'")
	public List<Menu> getRotiImages();

	@Query("select m from Menu m where specification='sabji'")
	public List<Menu> getSabjiImages();

	@Query("select m from Menu m where specification='rice'")
	public List<Menu> getRiceImages();

	@Query("select m from Menu m where specification='soup'")
	public List<Menu> getSoupImages();

	@Query("select m from Menu m where category='starter' and specification not in('soup')")
	public List<Menu> starterImagesDao();
	
	@Query("select m from Menu m where category='dessert'")
	public List<Menu> dessertImagesDao();
	
	@Query("select m from Menu m where specification='paratha'")
	public List<Menu> parathaImagesDao();

	@Query("select m from Menu m where category='breakfast'")
	public List<Menu> breakfastImagesDao();

	@Query("select m from Menu m where category='starter'")
	public List<Menu> getStarterImages();

	@Query("select m from Menu m where m.menuId= ?1")
	public List<Menu> fetchMenuData(int mid);

	@Query("select m from MusicDetails m")
	public List<MusicDetails> getMusics();

	@Query("select m from MovieDetails m")
	public List<MovieDetails> getMovieDao();
}
