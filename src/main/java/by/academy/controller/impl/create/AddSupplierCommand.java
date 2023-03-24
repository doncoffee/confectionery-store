package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SupplierExtractor;
import by.academy.service.SupplierService;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class AddSupplierCommand implements Command {
    private final SupplierService service = new SupplierServiceImpl();
    private final Extractor<SupplierDTO> extractor = new SupplierExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        int phoneNumberId = Integer.parseInt(request.getParameter("phoneNumberId"));
        SupplierDTO supplier = SupplierDTO.builder()
                .id(null)
                .name(request.getParameter("name"))
                .contactPerson(request.getParameter("contactPerson"))
                .addressId(addressId)
                .phoneNumberId(phoneNumberId)
                .build();
        service.createSupplier(supplier);
        extractor.extract(request);
        return "/jsp/lists/suppliers.jsp";
    }
}
