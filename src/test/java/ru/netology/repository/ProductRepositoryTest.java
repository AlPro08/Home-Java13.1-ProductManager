package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.productManagepr.Book;
import ru.netology.productManagepr.ProductManager;
import ru.netology.productManagepr.Smartphone;
import ru.netology.productManager.Product;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "book 1", 10, "Stephen");
    Product book2 = new Smartphone(2, "book 2", 30, "King");
    Product book3 = new Book(3, "artBook 3", 50, "William");
    Product tel1 = new Smartphone(4, "tel 1", 100, "Panasonic");
    Product tel2 = new Smartphone(5, "tel 2 ", 550, "Sony");

    @Test
    public void shouldSaveFewProducts() {
        repository.save(book1);
        repository.save(book3);
        repository.save(tel1);
        repository.save(tel2);

        Product[] expected = {book1, book3, tel1, tel2};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSaveOneProduct() {
        repository.save(book2);

        Product[] expected = {book2};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveNoProducts() {

        Product[] expected = {};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(tel1);
        repository.save(tel2);
        repository.removeById(3);

        Product[] expected = {book1, book2, tel1, tel2};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldFindNoItem() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(tel1);
        repository.save(tel2);

        Product[] actual = manager.searchBy("smartBook");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneItem() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(tel1);
        repository.save(tel2);

        Product[] actual = manager.searchBy("artBook");
        Product[] expected = {book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFewItems() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(tel1);
        repository.save(tel2);

        Product[] actual = manager.searchBy("book");
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookAndTel() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(tel1);
        repository.save(tel2);

        Product[] actual = manager.searchBy("1");
        Product[] expected = {book1, tel1};

        Assertions.assertArrayEquals(expected, actual);
    }
}
