package by.academy.controller.extractor;

import javax.servlet.http.HttpServletRequest;

public interface Extractor<T> {
    void extract(HttpServletRequest request);
}
