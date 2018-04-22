package com.gr00shik.spring5webapp.bootstrap;

import com.gr00shik.spring5webapp.model.Author;
import com.gr00shik.spring5webapp.model.Book;
import com.gr00shik.spring5webapp.model.Publisher;
import com.gr00shik.spring5webapp.repositories.AuthorRepository;
import com.gr00shik.spring5webapp.repositories.BookRepository;
import com.gr00shik.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        Author erik = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Disign", "1234", publisher);
        erik.getBooks().add(ddd);
        ddd.getAuthors().add(erik);

        authorRepository.save(erik);
        bookRepository.save(ddd);

        Author rob = new Author("Rob", "Jahnson");
        Book noEJB = new Book("J2EE Development whithout EJb", "23444", publisher);
        rob.getBooks().add(noEJB);

        authorRepository.save(rob);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
