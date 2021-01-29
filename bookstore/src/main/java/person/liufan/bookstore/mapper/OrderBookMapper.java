package person.liufan.bookstore.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import person.liufan.bookstore.entity.BookstoreAdmin;
import person.liufan.bookstore.entity.OrderBook;

@Repository
public interface OrderBookMapper extends JpaRepository<OrderBook, Long>, JpaSpecificationExecutor<OrderBook> {
}