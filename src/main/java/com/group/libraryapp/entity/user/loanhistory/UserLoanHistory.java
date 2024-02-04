package com.group.libraryapp.entity.user.loanhistory;

import com.group.libraryapp.entity.user.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    private String bookName;

    private boolean isReturn;

    protected UserLoanHistory() {

    }

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }

    public String getBookName() {
        return this.bookName;
    }
}
