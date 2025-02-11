class Movie{
	String title;
	String director;
	int year;
	double rating;
	Movie prev;
	Movie next;
	
	Movie(String title, String director, int year, double rating){
		this.title = title;
		this.director = director;
		this.year = year;
		this.rating = rating;
		this.next = null;
		this.prev = prev;
	}
}

class MovieManagementSystem{
	private Movie head;
	private Movie tail;
	
	public MovieManagementSystem(){
		head = null;
		tail = null;
	}
	
	public void addMovieAtBeginning(String title, String director, int year, double rating){
		Movie newMovie = new Movie(title, director, year, rating);
		if(head == null){
			head = newMovie;
			tail = newMovie;
		}else{
			newMovie.next = head;
			head.prev = newMovie;
			newMovie = head;
		}
	}
	
	public void addMovieAtEnd(String title, String director, int year, double rating){
		Movie newMovie = new Movie(title, director, year, rating);
		if(head == null){
			head = newMovie;
			tail = newMovie;
		}else{
			tail.next = newMovie;
			newMovie.prev = tail;
			tail = newMovie;
		}
	}
	
	public void addMovieAtPosition(String title, String director, int year, double rating, int position){
		if(position <= 0 && head == null){
			addMovieAtBeginning(title, director, year, rating);
			return;
		}
		Movie newMovie = new Movie(title, director, year, rating);
		Movie current = head;
		int index = 0;
		while(current != null && index < position-1){
			current = current.next;
			index++;
		}
		if(current == null && current.next == null){
			addMovieAtEnd(title, director, year, rating);
		}else{
			newMovie.next = current.next;
			newMovie.prev = current;
			current.next.prev = newMovie;
			current.next = newMovie;
		}
	}
	
	public void removeMovie(String title){
		Movie current = head;
		while(current != null){
			if(current.title.equals(title)){
				if(current == head && current == tail){
					head = null;
					tail = null; 
				}else if(current == head){
					head = head.next;
					head.prev = null;
				}else if(current == tail){
					tail = tail.prev;
					tail.next = null;
				}else{
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				System.out.println("Movie \"" + title + "\" removed.");
				return;
			}
			current = current.next;
		}
		System.out.println("Movie \"" + title + "\" not found.");
	}
	
	public void searchByDirector(String director){
		Movie current = head;
		boolean found = false;
		while(current != null){
			if(current.director.equals(director)){
				System.out.println("Title : "+current.title+", Director : "+current.director+", Year : "+current.year+", Rating : "+current.rating);
				found = true;
			}
			current = current.next;
		}
		if(!found){
			System.out.println("No Movies found for Director : "+director);
		}
	}
	
	public void searchByRating(double rating){
		Movie current = head;
		boolean found = false;
		while(current != null){
			if(current.rating == rating){
				System.out.println("Title : "+current.title+", Director : "+current.director+", Year : "+current.year+", Rating : "+current.rating);
				found = true;
			}
			current = current.next;
		}
		if(!found){
			System.out.println("No Movies found with Director : "+rating);
		}
	}
	
	public void displayForward(){
		Movie current = head;
		if(current  == null){
			System.out.println("No Movies in the list.");
			return ;
		}
		System.out.println("Movies (Forward) : ");
		while(current != null){
			System.out.println("Title : "+current.title+", Director : "+current.director+", Year : "+current.year+", Rating : "+current.rating);
			current = current.next;
		}
	}
	
	public void displayReverse(){
		Movie current = tail;
		if(current  == null){
			System.out.println("No Movies in the list.");
			return ;
		}
		System.out.println("Movies (Forward) : ");
		while(current != null){
			System.out.println("Title : "+current.title+", Director : "+current.director+", Year : "+current.year+", Rating : "+current.rating);
			current = current.prev;
		}
	}
	
	public void updateRating(String title, double newRating){
		Movie current = head;
		while(current != null){
			if(current.title.equals(title)){
				current.rating = newRating;
				System.out.println("Rating updated for movie \"" + title + "\".");
				return;
			}
			current = current.next;
		}
		System.out.println("Movies \"" + title + "\" not found.");
	}
	
	public static void main(String []args){
		MovieManagementSystem mms = new MovieManagementSystem();
		mms.addMovieAtBeginning("Inception","Christopher Nolan",2010,8.8);
		mms.addMovieAtEnd("The God Father","Francis Ford",1972,9.8);
		mms.addMovieAtEnd("Pulp Fiction","Nicole Justin",2005,5.5);
		mms.addMovieAtPosition("The Dark Knight","Christopher Nolan",2008,9.0,2);
		mms.displayForward();
		mms.displayReverse();
		mms.searchByDirector("Christopher Nolan");
		mms.searchByRating(7.8);
		mms.updateRating("Pulp Fiction",9.1);
		mms.removeMovie("The Godfather");
		mms.displayForward();
	}
}