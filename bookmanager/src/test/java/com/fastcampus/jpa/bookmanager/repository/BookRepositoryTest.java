package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.HwUser;
import com.fastcampus.jpa.bookmanager.domain.Publisher;
import com.fastcampus.jpa.bookmanager.domain.Review;
import com.fastcampus.jpa.bookmanager.repository.dto.BookStatus;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();

        var user = userRepository.findByEmail("martin@fastcampus.com");
        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview() {
            givenReview(givenUser(),givenBook(givePublisher()));
    }

    private HwUser givenUser() {
        return userRepository.findByEmail("martin@fastcampus.com");
    }

    private Book givenBook(Publisher publisher) {
        var book = new Book();
        book.setName("JPA 초격차 패키지");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private Publisher givePublisher() {
        var publisher = new Publisher();
        publisher.setName("패스트 캠퍼스");
        return publisherRepository.save(publisher);

    }

    private void givenReview(HwUser user , Book book) {
        Review review = new Review();
        review.setTitle("내 인생을 바꾼 책");
        review.setContent("너무너무 재미있고 즐거운 책이었어요.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    @Test
    void bookCascadeTest() {
        var book = new Book();
        book.setName("JPA 초격차 패키지");

        var publisher = new Publisher();
        publisher.setName("패스트캠퍼스");

        book.setPublisher(publisher);
        bookRepository.save(book);

//        publisher.addBook(book);
//        publisherRepository.save(publisher);

//        publisher.setBooks((Lists.newArrayList(book)));


        System.out.println("books :" +bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        var book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("슬로우캠퍼스");
        bookRepository.save(book1);
        System.out.println("publishers : " + publisherRepository.findAll());

        var book2 = bookRepository.findById(1L).get();
//        bookRepository.delete(book2);

        var book3 = bookRepository.findById(1L).get();
        book3.setPublisher(null);
        bookRepository.save(book3);


        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());
        System.out.println("book3-publisher : " + bookRepository.findById(1L).get().getPublisher());
    }

    @Test
    void bookRemoveCascadeTest() {
        bookRepository.deleteById(1L);
        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void softDelete() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println(bookRepository.findById(3L));
        bookRepository.findByCategoryIsNull().forEach(System.out::println);
//        bookRepository.findAllByDeletedFalse().forEach(System.out::println);
//        bookRepository.findByCategoryIsNullAndDeletedFalse().forEach(System.out::println);
    }

    @Test
    void queryTest() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println("findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual :" +
                bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(
                        "JPA 초격차 패키지",
                        LocalDateTime.now().minusDays(1L),
                        LocalDateTime.now().minusDays(1L)
                ));
        System.out.println("findByNameRecently : " + bookRepository.findByNameRecently("JPA 초격차 패키지" ,
                LocalDateTime.now().minusDays(1L) ,
                LocalDateTime.now().minusDays(1L)
            ));

        System.out.println(bookRepository.findBookNameAndCategory());
        bookRepository.findBookNameAndCategory().forEach(b -> {System.out.println(b.getName() +" : "+ b.getCategory());});
        bookRepository.findBookNameAndCategory(PageRequest.of(1,1)).forEach(bookNameAndCategory -> {System.out.println(bookNameAndCategory.getName() + " : "+bookNameAndCategory.getCategory());});
        bookRepository.findBookNameAndCategory(PageRequest.of(0,1)).forEach(bookNameAndCategory -> {System.out.println(bookNameAndCategory.getName() + " : "+bookNameAndCategory.getCategory());});
    }

    @Test
    void nativeQueryTest() {
//        bookRepository.findAll().forEach(System.out::println);
//        bookRepository.findAllCustom().forEach(System.out::println);

        List<Book> books = bookRepository.findAll();

        for(Book book : books){
            book.setCategory("IT전문서");
        }
        bookRepository.saveAll(books);
        System.out.println(bookRepository.findAll());
        System.out.println("affected rows: " + bookRepository.updatedCategories());
        bookRepository.findAllCustom().forEach(System.out::println);
        System.out.println(bookRepository.showTables());
    }

    @Test
    void converterTest() {
        bookRepository.findAll().forEach(System.out::println);
        var book = new Book();
        book.setName("또다른 IT전문서적");
        book.setStatus(new BookStatus(200));
        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
        System.out.println(bookRepository.findRawRecord().values());
    }
}
