package com.group.libraryapp.service.book;

import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.entity.book.Book;
import com.group.libraryapp.entity.user.User;
import com.group.libraryapp.entity.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.repository.UserLoanHistoryRepository;
import com.group.libraryapp.repository.book.BookRepository;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository, UserLoanHistoryRepository userLoanHistoryRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    // 대출 기능
    @Transactional
    public void loanBook(BookLoanRequest request) {
        // 1. 책 정보 가져오기
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalAccessError::new);
        // 2. 대출 기록 조회, 대출 중인지 확인
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            // 2-1. 대출 중이라면, 예외 발생.
            throw new IllegalArgumentException("이미 대출되어 있는 책입니다.");
        }
        // 3. 대출 중이 아니라면, 대출
        // 3-1. 유저 정보 가져오기
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalAccessError::new);
        // 3-2. 유저 정보와 책 정보를 기반으로 UserLoanHistory 저장
        user.loanBook(book.getName());
    }

    // 반납 기능
    @Transactional
    public void returnBook(BookReturnRequest request) {
        // 1. 유저 정보 가져오기
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalAccessError::new);
        user.returnBook(request.getBookName());

    }


}
