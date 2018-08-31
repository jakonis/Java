package controllers;

import java.util.Collection;
import java.util.Map;

import models.Book;
import models.Rating;
import models.User;
import asg.cliche.Command;
import asg.cliche.Param;

public class DMenu {

	private User user;
	private String name;
	private RepeatAPI likeBooks;
	
	
	public DMenu (RepeatAPI likeBooks, User user){
		this.likeBooks=likeBooks;
		this.setName(user.firstName);
		this.user=user;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
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
	
	@Command(description="Get all Books")
	public void getBooks()
	{
		Collection<Book> books = likeBooks.getBooks();
		System.out.println(books);
	}
	
	@Command(description="Get a Book")
	public Book getBook(@Param(name="Book Id")long id)
	{
		return likeBooks.getBook(id);
	}
	
	@Command(description="Get All Ratings")
	public void getRatings()
	{
		Collection<Rating> ratings = likeBooks.getRatings();
		System.out.println(ratings);
	}
	
	@Command(description="Adding a new Rating")
	public void addRating(@Param(name="User id")long UserId,@Param(name="Books Id")long bookId,@Param(name="Rating")float rating)
	{
		likeBooks.addRating(UserId, bookId, rating);
	}
	
	@Command(description="Get User Ratings")
	public Map<Long,Rating> getUserRating(@Param(name="User ID")long id)
	{
		return likeBooks.getUserRating(id);
	}
	
	@Command(description="Get Book Ratings")
	public Map<Long,Rating> getBookRating(@Param(name="Book Id")long id)
	{
		return likeBooks.getBookRating(id);
	}
	
	@Command(description="Return a Rating")
	public Rating getRating(@Param(name="Rating Id")long id)
	{
		return likeBooks.getRating(id);
	}
	
	@Command(description="Delete a Rating")
	public void deleteRating(@Param(name="Rating Id")long id)
	{
		likeBooks.deleteRating(id);
	}
	
	@Command(description="TOP 10 Books")
	public void Top10()
	{
		likeBooks.Top10Books();
	}
	
	@Command(description="User Recommended Books")
	public void Recommender()
	{
		likeBooks.recommenderGen(likeBooks.curntUser.get().id);
	}

	@Command(description="Search Book by title")
	public void searchBook(String books)
	{
		for(Book book : likeBooks.titleSearchBook(books))
		{
			System.out.println(book);
		}
	}
}
