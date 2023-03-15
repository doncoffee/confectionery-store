package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.service.ChocolateService;
import by.academy.service.dto.ChocolateDTO;
import by.academy.service.impl.ChocolateServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReadChocolateCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        ChocolateService chocolateService = new ChocolateServiceImpl();
        List<ChocolateDTO> list = chocolateService.readAllChocolates();
        request.setAttribute("chocolates", list);
        return "/jsp/lists/chocolates.jsp";
    }
}
