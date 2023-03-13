package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.service.SweetsService;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteSweetsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        SweetsService sweetsService = new SweetsServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        sweetsService.deleteSweets(id);
        List<SweetsDTO> list = sweetsService.readAllSweets();
        request.setAttribute("sweets", list);
        return "/jsp/lists/sweets.jsp";
    }
}
