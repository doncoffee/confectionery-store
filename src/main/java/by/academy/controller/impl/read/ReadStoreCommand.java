package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.StoreExtractor;
import by.academy.service.dto.StoreDTO;

import javax.servlet.http.HttpServletRequest;

public class ReadStoreCommand implements Command {
    private final Extractor<StoreDTO> extractor = new StoreExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return "/jsp/lists/stores.jsp";
    }
}
