package service;

import dao.BookDao;
import pojo.Book;

import java.util.List;

public class BookServiceImpl implements BookService{

    // 组合
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public int addBook(Book books) {
        return bookDao.addBook(books);
    }

    @Override
    public int deleteBookByID(int id) {
        return bookDao.deleteBookByID(id);
    }

    @Override
    public int updateBook(Book books) {
        return bookDao.updateBook(books);
    }

    @Override
    public Book queryBookByID(int id) {
        return bookDao.queryBookByID(id);
    }

    @Override
    public List<Book> queryAllBook() {
        return bookDao.queryAllBook();
    }
}