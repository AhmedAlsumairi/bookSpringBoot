package com.book.exception;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails {
    private String message;
    private Date date;
    private String Description;
}
