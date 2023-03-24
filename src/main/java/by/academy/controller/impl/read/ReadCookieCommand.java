package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.CookieExtractor;
import by.academy.service.dto.CookieDTO;

import javax.servlet.http.HttpServletRequest;

public class ReadCookieCommand implements Command {
    private final Extractor<CookieDTO> extractor = new CookieExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return "/jsp/lists/cookies.jsp";
    }
}
