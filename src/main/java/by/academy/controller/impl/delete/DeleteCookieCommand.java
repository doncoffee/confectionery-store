package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.CookieExtractor;
import by.academy.service.CookieService;
import by.academy.service.impl.CookieServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.ID;
import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_COOKIES_JSP;

public class DeleteCookieCommand implements Command {
    private final CookieService service = new CookieServiceImpl();
    private final Extractor extractor = new CookieExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        service.deleteCookie(id);
        extractor.extract(request);
        return JSP_LISTS_COOKIES_JSP;
    }
}
