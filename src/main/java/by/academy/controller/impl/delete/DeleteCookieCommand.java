package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.service.CookieService;
import by.academy.service.dto.CookieDTO;
import by.academy.service.impl.CookieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteCookieCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        CookieService cookieService = new CookieServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        cookieService.deleteCookie(id);
        List<CookieDTO> list = cookieService.readAllCookies();
        request.setAttribute("cookies", list);
        return "/jsp/lists/cookies.jsp";
    }
}
