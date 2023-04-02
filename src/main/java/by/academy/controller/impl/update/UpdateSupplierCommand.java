package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SupplierExtractor;
import by.academy.service.SupplierService;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.*;

public class UpdateSupplierCommand implements Command {
    private final SupplierService service = new SupplierServiceImpl();
    private final Extractor extractor = new SupplierExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int addressId = Integer.parseInt(request.getParameter(ADDRESS_ID));
        int phoneNumberId = Integer.parseInt(request.getParameter(PHONE_NUMBER_ID));
        SupplierDTO supplier = SupplierDTO.builder()
                .id(Integer.valueOf(request.getParameter(ID)))
                .name(request.getParameter(NAME))
                .contactPerson(request.getParameter(CONTACT_PERSON))
                .addressId(addressId)
                .phoneNumberId(phoneNumberId)
                .build();
        service.updateSupplier(supplier);
        extractor.extract(request);
        return JSP_LISTS_SUPPLIERS_JSP;
    }
}
