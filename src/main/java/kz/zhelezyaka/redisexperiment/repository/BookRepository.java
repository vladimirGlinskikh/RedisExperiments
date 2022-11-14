package kz.zhelezyaka.redisexperiment.repository;

import kz.zhelezyaka.redisexperiment.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
