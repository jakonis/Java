package controllers;

import java.util.Collection;
import java.util.Map;

import models.Book;
import models.Rating;
import models.User;
import asg.cliche.Command;
import asg.cliche.Param;


public class Admin {
	private String name;
	private RepeatAPI likeBooks;
	
	public Admin(RepeatAPI likeBook,String name)
	{
		this.likeBooks=likeBook;
		this.setName(name);
		
	}

	private void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}
	private String getName(){
		return name;
	}
	
	@Command(description="Delete ALL Users")
	public void clearUsers()
	{
		likeBooks.removeUsers();
	}

	@Command(description="Create new User")
	public void addUser(@Param(name="First Name") String fname,@Param(name="Last Name") String lname,@Param(name="Age") String age,@Param(name="Gender") String gender,
			@Param(name="occupation")String occupation,@Param(name="password") String password,@Param(name="zipCode") String zipCode)
	{
		likeBooks.addUser(fname,lname,age,gender,occupation,password,zipCode);
	}
	
	@Command(description="Delete a User")
	public void deleteUser(@Param(name="User ID")long id)
	{
		likeBooks.deleteUser(id);
	}
	
	
	
	@Command(description="Clear all Books")
	public void clearBooks()
	{
		likeBooks.clearBooks();
	}
	
	@Command(description="Add new Book")
	public void addBook(@Param(name="Title")String title,@Param(name="Release Date")String releaseDate,@Param(name="Link")String link)
	{
		likeBooks.addBook(title, releaseDate, link);
	}
	
	
	
	@Command(description="Delete Book")
	public void deleteBook(@Param(name="Book Id")long id)
	{
		likeBooks.deleteBook(id);
	}
	
	
	
	@Command(description="Delete all Ratings")
	public void clearRating()
	{
		likeBooks.deleteRatings();
	}
	
	
	@Command(description ="Get all User Details")
	public void getUsers()
	{
		Collection<User> users = likeBooks.getUsers();
		System.out.println(users);
	}
	
	@Command(description="Search for a User")
	public User getUser(@Param(name="User Id")long id)
	{
		return likeBooks.getUser(id);
	}
	
	@Command(description="all Books")
	public void getBooks()
	{
		Collection<Book> books = likeBooks.getBooks();
		System.out.println(books);
	}
	
	
	
	@Command(description="Get Book")
	public Book getBook(@Param(name="Book Id")long id)
	{
		return likeBooks.getBook(id);
	}
	
	@Command(description="All Ratings")
	public void getRatings()
	{
		Collection<Rating> ratings = likeBooks.getRatings();
		System.out.println(ratings);
	}
	
	
	
	
	@Command(description="Adding new Rating")
	public void addRating(@Param(name="User id")long UserId,@Param(name="Books Id")long bookId,@Param(name="Rating Value")float rating)
	{
		likeBooks.addRating(UserId, bookId, rating);
	}
	
	@Command(description="Users Ratings")
	public Map<Long,Rating> getUserRating(@Param(name="User ID")long id)
	{
		return likeBooks.getUserRating(id);
	}
	
	@Command(description="Book Ratings")
	public Map<Long,Rating> getBookRating(@Param(name="Book Id")long id)
	{
		return likeBooks.getBookRating(id);
	}
	
	
	
	
	
	@Command(description="Return Rating")
	public Rating getRating(@Param(name="Rating Id")long id)
	{
		return likeBooks.getRating(id);
	}
	
	@Command(description="Delete a Rating")
	public void deleteRating(@Param(name="Rating Id")long id)
	{
		likeBooks.deleteRating(id);
	}
	
	
	
	
	
	@Command(description="Get TOP 10 Books")
	public void Top10()
	{
		likeBooks.Top10Books();
	}
	
	@Command(description="User Recommended Books")
	public void Recommender()
	{
		likeBooks.recommenderGen(likeBooks.curntUser.get().id);
	}
	
	@Command(description="Get Book with title")
	public void searchBook(String word)
	{
		for(Book book : likeBooks.titleSearchBook(word))
		{
			System.out.println(book);
		}
	}
	
}

	