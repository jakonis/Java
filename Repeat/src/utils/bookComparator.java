package utils;
import java.util.Comparator;
import models.Book;

public class bookComparator implements Comparator<Book> {

	public int compare(Book s1,Book s2){
		return(int)(s1.ratingsMod-s2.ratingsMod);
	}


}
