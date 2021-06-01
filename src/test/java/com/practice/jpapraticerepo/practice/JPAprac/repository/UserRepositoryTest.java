package com.practice.jpapraticerepo.practice.JPAprac.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.internal.JsonFormatter;
import com.practice.jpapraticerepo.practice.JPAprac.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserHistoryRepository userHistoryRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @Transactional
    void relationTest() throws JsonProcessingException {


        Author author = new Author();
        author.setName("황경욱");
        Author saveAuthor = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("황경욱 출판사");
        Publisher savePublisher = publisherRepository.save(publisher);


        Book book = new Book();
        book.setName("tiger book");
        book.setCategory("소설");
        book.setPublisher(publisher);
        Book tigerBook = bookRepository.save(book);


        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setReviewCount(3);
        bookReviewInfo.setAverageReviewScore(3.4f);
        bookReviewInfo.setBook(tigerBook);
        bookReviewInfoRepository.save(bookReviewInfo);


        Review review = new Review();
        review.setTitle("tiger book을 읽고");
        review.setScore(3.4f);
        review.setContent("정말 재밌다");
        review.setBook(tigerBook);

        Review save = reviewRepository.save(review);

        Review review1 = reviewRepository.findById(1L).orElseThrow(RuntimeException::new);


        User user = userRepository.findByEmail("tiger@gmail.com");

        user.getReviews().add(review);


        List<Review> reviews = user.getReviews();

        String s = objectMapper.writeValueAsString(reviews);

        System.out.println(JsonFormatter.prettyPrint(s));



        System.out.println("Book:" + user.getReviews().get(0).getBook());
        System.out.println("Publisher:" + user.getReviews().get(0).getBook().getPublisher());


        System.out.println(user);


    }

}