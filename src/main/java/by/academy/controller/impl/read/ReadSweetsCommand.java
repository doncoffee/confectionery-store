package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SweetsExtractor;
import by.academy.service.dto.SweetsDTO;

import javax.servlet.http.HttpServletRequest;

public class ReadSweetsCommand implements Command {
    private final Extractor<SweetsDTO> extractor = new SweetsExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return "/jsp/lists/sweets.jsp";
    }
}
