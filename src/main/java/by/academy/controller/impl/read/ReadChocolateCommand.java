package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.ChocolateExtractor;
import by.academy.service.dto.ChocolateDTO;

import javax.servlet.http.HttpServletRequest;

public class ReadChocolateCommand implements Command {
    private final Extractor<ChocolateDTO> extractor = new ChocolateExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return "/jsp/lists/chocolates.jsp";
    }

}
