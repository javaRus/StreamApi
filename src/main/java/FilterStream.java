import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by ruslan.
 */
public class FilterStream {
    public static void main(String[] args) {
        Book book10 = new Book(1);
        Book book11 = new Book(10);
        Book book12 = new Book(100);
        Book book13 = new Book(1000);
        Shelf shelf1 = new Shelf(Arrays.asList(book10, book11, book12, book13));

        Book book20 = new Book(2);
        Book book21 = new Book(20);
        Book book22 = new Book(200);
        Book book23 = new Book(2000);
        Shelf shelf2 = new Shelf(Arrays.asList(book20, book21, book22, book23));
        shelf1.getBooks().remove(book20);
        Room room = new Room(Arrays.asList(shelf1, shelf2));

        // filtering all book where page < 25
        int page = 25;
        lambdaFilterBook(room, page);

//        filterBook(room, page);

//        testFilter();
    }

    private static void lambdaFilterBook(Room room, int page) {
       /* List<Shelf> shelves = */room.getShelfs()
            .forEach(shelf -> shelf.getBooks().stream()
                .filter(book -> book.getPage() < page)
                .collect(Collectors.toList())
            );

//        Room room1 = new Room(shelves);
        System.out.println(room.getShelfs().get(0).getBooks().size() + " " + room.getShelfs().get(1).getBooks().size());
    }

    public static void testFilter() {
        Book book10 = new Book(1);
        Book book11 = new Book(10);
        Book book12 = new Book(100);
        Book book13 = new Book(1000);

        List<Book> books = new ArrayList<>(Arrays.asList(book10, book11, book12, book13));
        List<Book> collect = books.stream()
            .filter(book -> book.getPage() < 25)
            .collect(Collectors.toList());

        System.out.println(
            collect.size() + " " +
                books.size() + " " +
                books.removeIf(book -> book.getPage() < 25) + " " +
                books.size()
        );
    }

    private static void filterBook(Room room, int page) {
        for (Shelf shelf : room.getShelfs()) {
            shelf.getBooks().stream()
                .filter(book -> book.getPage() < 25)
                .collect(Collectors.toList());
        }
        System.out.println(room.getShelfs().get(0).getBooks().size());
    }
}

class Room {
    List<Shelf> shelfs;

    public Room(List<Shelf> shelfs) {
        this.shelfs = shelfs;
    }

    public List<Shelf> getShelfs() {
        return shelfs;
    }

    public void setShelfs(List<Shelf> shelfs) {
        this.shelfs = shelfs;
    }
}

class Shelf {
    List<Book> books;

    public Shelf(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

class Book {
    Integer page;

    public Book(Integer page) {
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
