package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.service.ChocolateService;
import by.academy.service.dto.ChocolateDTO;
import by.academy.service.impl.ChocolateServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteChocolateCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        ChocolateService chocolateService = new ChocolateServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        chocolateService.deleteChocolate(id);
        List<ChocolateDTO> list = chocolateService.readAllChocolates();
        request.setAttribute("chocolates", list);
        return "/jsp/lists/chocolates.jsp";
    }
}
