package com.alexk.spring_book_library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testGetAllBooks() {
        Book book = new Book(1L, "Test Book", "Test Author", 300, "123-4567890123", BookGenre.OTHER);
        when(bookRepository.findAll()).thenReturn(List.of(book));

        List<Book> books = bookService.getAllBooks();
        assertEquals(1, books.size());
        assertEquals("Test Book", books.get(0).getName());
    }

    @Test
    void testCreateBook() {
        Book book = new Book(null, "Test Book", "Test Author", 300, "123-4567890123", BookGenre.OTHER);
        when(bookRepository.save(book)).thenReturn(new Book(1L, "Test Book", "Test Author", 300, "123-4567890123", BookGenre.OTHER));

        Book createdBook = bookService.createBook(book);
        assertEquals(1L, createdBook.getId());
    }

    @Test
    void testGetBookById() {
        Book book = new Book(1L, "Test Book", "Test Author", 300, "123-4567890123", BookGenre.OTHER);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.getBookById(1L);
        assertTrue(foundBook.isPresent());
        assertEquals("Test Book", foundBook.get().getName());
    }

    @Test
    void testUpdateBook() {
        Book book = new Book(1L, "Test Book", "Test Author", 300, "123-4567890123", BookGenre.OTHER);
        when(bookRepository.save(book)).thenReturn(book);

        Book updatedBook = bookService.updateBook(book);
        assertEquals("Test Book", updatedBook.getName());
    }

    @Test
    void testDeleteBook() {
        Long bookId = 1L;
        bookService.deleteBook(bookId);
        verify(bookRepository).deleteById(bookId);
    }
}
