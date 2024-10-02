package com.alexk.spring_book_library;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void testBookGettersAndSetters(){
        Book book = new Book();
        book.setId(1L);
        book.setName("Test Book");
        book.setAuthor("Test Author");
        book.setPages(200);
        book.setIsbn("123-456789-0");
        book.setGenre(BookGenre.OTHER);

        assertEquals(1L, book.getId());
        assertEquals("Test Book", book.getName());
        assertEquals("Test Author", book.getAuthor());
        assertEquals(300, book.getPages());
        assertEquals("123-4567890123", book.getIsbn());
        assertEquals(BookGenre.OTHER, book.getGenre());
    }
}
