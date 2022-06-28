package com.nlu.bookonlinebe.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseObject {
    private int statuscode;
    private String message;
    private Object object;

    public ResponseObject(int statuscode, String message, Object object) {
        this.statuscode = statuscode;
        this.message = message;
        this.object = object;
    }
}
