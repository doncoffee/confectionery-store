package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.CookieExtractor;
import by.academy.service.CookieService;
import by.academy.service.dto.CookieDTO;
import by.academy.service.impl.CookieServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteCookieCommand implements Command {
    private final CookieService service = new CookieServiceImpl();
    private final Extractor<CookieDTO> extractor = new CookieExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteCookie(id);
        extractor.extract(request);
        return "/jsp/lists/cookies.jsp";
    }
}
