package controllers;


import java.io.File;
import java.io.IOException;
import models.User;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import utils.Serializer;
import utils.XMLSerializer;



public class Main implements ShellDependent
{
	
	private static final String ADMIN="admin";
	RepeatAPI likeBooks=new RepeatAPI();
	private Shell theshell;
	
	public Main()throws Exception
	{
		File data = new File("./lib/datatest.xml");
		Serializer serializer = new XMLSerializer(data);
		
		likeBooks = new RepeatAPI(serializer);
		
		if(data.isFile())
		{
			likeBooks.load();
		}
		
	}
	
	@Override
	public void cliSetShell(Shell shell) {
		// TODO Auto-generated method stub
		this.theshell=shell;
	}	


		
		@Command(description="Log in")
		public void login(@Param(name = "User Id")long userId,@Param(name = "password")String password) throws IOException
		{
			if(likeBooks.logIn(userId, password)&& likeBooks.curntUser.isPresent()) {
				User user = likeBooks.curntUser.get();
				System.out.println("You Logged as " + user.id+""+user.firstName);
			if(user.role != null && user.role.equals(ADMIN)) {
				Admin adminMenu = new Admin(likeBooks, user.firstName);
				ShellFactory.createSubshell(user.firstName, theshell, "Admin", adminMenu).commandLoop();
			}
			else {
				DMenu defaultMenu = new DMenu(likeBooks, user);
				ShellFactory.createSubshell(user.firstName, theshell, "Default", defaultMenu).commandLoop();
			}
			}else
				System.out.println("Wrong Username/password");
		}

		
		@Command(description= "Initial CSV Load")
		public void initialLoad() throws IOException 
		{
			likeBooks.initialLoad();
		}
		
		public static void main(String[] args) throws Exception
		{
			// TODO Auto-generated method stub
			Main main = new Main();
			Shell shell= ShellFactory.createConsoleShell("---", "Welcome to the Repeat Assignment. Type ?help for help  ", main);
			shell.commandLoop();
		
			main.likeBooks.store();
	}

		
}




