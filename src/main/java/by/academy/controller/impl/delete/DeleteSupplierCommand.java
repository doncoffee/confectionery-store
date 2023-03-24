package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SupplierExtractor;
import by.academy.service.SupplierService;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteSupplierCommand implements Command {
    private final SupplierService service = new SupplierServiceImpl();
    private final Extractor<SupplierDTO> extractor = new SupplierExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteSupplier(id);
        extractor.extract(request);
        return "/jsp/lists/suppliers.jsp";
    }
}
