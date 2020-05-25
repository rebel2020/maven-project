package com.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.thrillio.constants.MovieGenre;
import com.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendkyEligible() {
		// Test 1- Genre is Horror- false
		Movie movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.HORROR,8.5);
		boolean isKidFriendkyEligible = movie.isKidFriendkyEligible();
		assertFalse("Genre is Horror- must return false",isKidFriendkyEligible);
		
		// Test 2- Genre is Thriller- false
		movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.THRILLER,8.5);
		isKidFriendkyEligible = movie.isKidFriendkyEligible();
		assertFalse("Genre is Thriller- must return false",isKidFriendkyEligible);
	}

}
