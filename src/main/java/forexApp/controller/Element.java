package forexApp.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Element {
    private String request;
    private String response;

    public Element() {}

    public Element(String request, String response) {
        this.request = request;
        this.response = response;

    }
    @Override
    public String toString() {
        return request + " -> " + response;
    }
}