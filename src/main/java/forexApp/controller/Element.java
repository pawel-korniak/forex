package forexApp.controller;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
/**
 * class created only for better access to thymeleaf
 */
public class Element {
    private String request;
    private String response;

    public Element() {}

    @Override
    public String toString() {
        return request + " -> " + response;
    }
}