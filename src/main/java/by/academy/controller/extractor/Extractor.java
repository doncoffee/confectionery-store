package by.academy.controller.extractor;

import javax.servlet.http.HttpServletRequest;

public interface Extractor {
    void extract(HttpServletRequest request);
}
