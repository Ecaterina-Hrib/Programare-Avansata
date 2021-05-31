# Book rental application(Booky)

My aplication has more focus on backend side:

- The main reason of the app is to make friend and read more books with friends also search for new lecture
- The application flow is like this,a user/client can borrow just one book from library, he can make friends, borrow books and comicbooks 
- I use spring boot for backend
- kotlin for the attempt on the mobile frontend
- for the kotlin side I used different layers for screens and also in one of the screens the books should be displayed(it's not integrated because I've had hardware issues and I couldn't continue with Android studio, but i tried) 
- I used the Oracle Database, with the tables USERS,COMICBOOKS,FRIENDS,BOOKS,RENTAL
- I used spring boot for the backend side and used MVC designed pattern and CRUD for objects, and REST for reqest transmission
- For comparison I use Comparable, and sort functions, used list, and arraylists for more than one object displayed
- used streams for algoritm of the most famous/least famous 
- tried an authentification with Auth0(removed it)
- I use Response Entity to handle the response code from server and tried in the first place to use the class that I build the ControlExceptionHandler, and also display the correct codes for the request