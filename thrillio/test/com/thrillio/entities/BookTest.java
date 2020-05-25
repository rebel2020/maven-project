package com.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.thrillio.constants.BookGenre;
import com.thrillio.managers.BookmarkManager;

import static org.junit.Assert.*;
class BookTest {

	@Test
	void testIsKidFriendkyEligible() {
		//Test 1- Genre is Philosophy- false
		Book book = BookmarkManager.getInstance().createBook(4000,"Walden","",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
		boolean isKidFriendkyEligible = book.isKidFriendkyEligible();
		assertFalse("Genre is Philosophy- must return false",isKidFriendkyEligible);
		
		//Test 2- Genre is Self help- false
		book = BookmarkManager.getInstance().createBook(4000,"Walden","",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.SELF_HELP,4.3);
		isKidFriendkyEligible = book.isKidFriendkyEligible();
		assertFalse("Genre is Self help- must return false",isKidFriendkyEligible);
	}

}
