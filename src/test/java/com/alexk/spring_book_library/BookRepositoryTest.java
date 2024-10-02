package com.alexk.spring_book_library;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testSaveandSearchBook(){
        Book book = new Book(null, "Test Book", "Test Author", 300, "123-4567890123", BookGenre.OTHER);
        bookRepository.save(book);

        assertThat(bookRepository.findById(book.getId())).isPresent();
    }
}
