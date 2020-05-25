package com.thrillio.entities;
import static org.junit.Assert.*;

import org.junit.Test;

import com.thrillio.entities.Weblink;
import com.thrillio.managers.BookmarkManager;

class WeblinkTest {

	@Test
	void testIsKidFriendkyEligible() {
		//Test 1- porn in url-- false
		Weblink weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com","unknown");
		boolean isKidFriendkyEligible = weblink.isKidFriendkyEligible();
		
		assertFalse("Porn in url- must return false",isKidFriendkyEligible);

		
		//Test 2- porn in title-- false
		weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming porn, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com","unknown");
		isKidFriendkyEligible = weblink.isKidFriendkyEligible();
		
		assertFalse("Porn in title- must return false",isKidFriendkyEligible);
		
		//Test 3- adult in host-- false
		weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.adult.com","unknown");
		isKidFriendkyEligible = weblink.isKidFriendkyEligible();
		
		assertFalse("adult in host- must return false",isKidFriendkyEligible);
		
		//Test 4- adult in url but not in host-- true
		weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html","http://www.javaworld.com","unknown");
		isKidFriendkyEligible = weblink.isKidFriendkyEligible();
		
		assertTrue("adult in url- must return true",isKidFriendkyEligible);
		
		//Test 5- adult in title only-- true
		 weblink = BookmarkManager.getInstance().createWeblink(2000,"Taming adult, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com","unknown");
		isKidFriendkyEligible = weblink.isKidFriendkyEligible();
		
		assertTrue("adult in title- must return true",isKidFriendkyEligible);
		
	}

}
