package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.ChocolateExtractor;
import by.academy.service.ChocolateService;
import by.academy.service.dto.ChocolateDTO;
import by.academy.service.impl.ChocolateServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteChocolateCommand implements Command {
    private final ChocolateService service = new ChocolateServiceImpl();
    private final Extractor<ChocolateDTO> extractor = new ChocolateExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteChocolate(id);
        extractor.extract(request);
        return "/jsp/lists/chocolates.jsp";
    }
}
