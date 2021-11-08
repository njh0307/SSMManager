package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Book;
import service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    // 展示全部的书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Book> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    // 跳转到新增书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBookPage(){
        return "addBook";
    }

    // 增加书籍
    @RequestMapping("/addBook")
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }

    // 跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Book book = bookService.queryBookByID(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Book book,Model model){
        bookService.updateBook(book);
        // 更新最新的书籍
        Book book1 = bookService.queryBookByID(book.getBookID());
        model.addAttribute("books",book1);
        return "redirect:/book/allBook";
    }

    // 删除书籍，使用Restful风格
    @RequestMapping("/del/{bookID}")
    public String delete(@PathVariable("bookID") int id){
        bookService.deleteBookByID(id);
        return "redirect:/book/allBook";
    }
}