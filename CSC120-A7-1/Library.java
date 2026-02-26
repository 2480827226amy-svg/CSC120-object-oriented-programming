import java.util.Hashtable;
/* This is a stub for the Library class */
/**
 * This class represents a library.
 */
public class Library extends Building implements LibraryRequirements {

    /** 
     * A hashtable that represents the collection.
     */
    private Hashtable<String, Boolean> collection;

    /**
     * Constructs a library with name, address and number of floors.
     * @param name the name of the library
     * @param address the address of the library
     * @param nFloors the number of floors in the library
     */
    public Library(String name,String address,int nFloors) {
      super(name,address,nFloors);
      this.collection=new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
  
    /**
     * Add a new book to the library, and set the status as availble.
     * @param title the title of the book we want to add
     */
    public void addTitle(String title) {
        this.collection.put(title, true);
    }

    /**
     * Remove a book from the library.
     * @param title the title of the book that we want to remove
     * @return the removed book
     * @throws RuntimeException if the book is not in the collection
     */
    public String removeTitle(String title) {
         if (this.collection.containsKey(title)) {
            this.collection.remove(title);
            return title;
        }else{
            throw new RuntimeException("This book is not in the collection.");
        }
    }

    /**
     * Check out a book from the library.
     * @param title the title of the book we want to check out
     * @throws RuntimeException if the book is not in the collection
     */
    public void checkOut(String title) {
        if (this.collection.containsKey(title)) {
            if (this.collection.get(title)) {
                this.collection.replace(title, false);
            }else{
                throw new RuntimeException("This book is already checked out.");
            }
        }else{
            throw new RuntimeException("This book is not in the collection.");
        }
    }

    /**
     * Return a book to the library.
     * @param title the title of the book we want to return
     * @throws RuntimeException if the book is not in the collection
     */
    public void returnBook(String title) {
        if (this.collection.containsKey(title)) {
            if (this.collection.get(title)) {
                throw new RuntimeException("This book is already returned.");
            }else{
                this.collection.replace(title, true);
            }
        }else{
            throw new RuntimeException("This book is not in the collection.");
        }

    }

    /**
     * Check whether the library contains a title.
     * @param title the title of the book we need to search for
     * @return true if the book is in the collection, false otherwise
     */
    public boolean containsTitle(String title) {
        if (this.collection.containsKey(title)){
            return true;
        }else{
            return false;
        }
    }

    /**
    * Determine whether a book in the library is available now.
    * @param title the title of the book we need to check
    * @return true if the book is currently available, false if the book is checked out
    * @throws RuntimeException if the book is not in the collection
    */
    public boolean isAvailable(String title) {
        if (this.collection.containsKey(title)) {
            if (this.collection.get(title)) {
                return true;
            }else{
                return false;
            }
        }else{
            throw new RuntimeException("This book is not in the collection.");
        }
    }

    /**
     * Print all the books in the library and their status.
     */
    public void printCollection() {
        for (String title : this.collection.keySet()) {
            String status;
            if (this.collection.get(title)) {
                status="Now available";
            }else{
                status="Checked out";
            } 
            System.out.println(title + " [" + status + "]");
        }
    }

    // public static void main(String[] args) {
    //   new Library();
    // }
    
  }