package com.mari.pm.be_template.domain.exception;

public class NoOceanException extends RuntimeException {
    public NoOceanException(long id) {
        super(id + " is no exists ocean");
    }
}
