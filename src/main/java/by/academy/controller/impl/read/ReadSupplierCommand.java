package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SupplierExtractor;
import by.academy.service.dto.SupplierDTO;

import javax.servlet.http.HttpServletRequest;

public class ReadSupplierCommand implements Command {
    private final Extractor<SupplierDTO> extractor = new SupplierExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return "/jsp/lists/suppliers.jsp";
    }
}
