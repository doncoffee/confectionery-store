package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.service.SweetsService;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReadSweetsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        SweetsService sweetsService = new SweetsServiceImpl();
        List<SweetsDTO> list = sweetsService.readAllSweets();
        request.setAttribute("sweets", list);
        return "/jsp/lists/sweets.jsp";
    }
}
