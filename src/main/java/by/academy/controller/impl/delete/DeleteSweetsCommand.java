package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SweetsExtractor;
import by.academy.service.SweetsService;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteSweetsCommand implements Command {
    private final SweetsService service = new SweetsServiceImpl();
    private final Extractor<SweetsDTO> extractor = new SweetsExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteSweets(id);
        extractor.extract(request);
        return "/jsp/lists/sweets.jsp";
    }
}
