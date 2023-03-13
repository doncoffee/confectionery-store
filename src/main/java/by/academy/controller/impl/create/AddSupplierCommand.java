package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.service.SupplierService;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddSupplierCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        SupplierService supplierService = new SupplierServiceImpl();
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        int phoneNumberId = Integer.parseInt(request.getParameter("phoneNumberId"));
        SupplierDTO supplier = SupplierDTO.builder()
                .id(null)
                .name(request.getParameter("name"))
                .contactPerson(request.getParameter("contactPerson"))
                .addressId(addressId)
                .phoneNumberId(phoneNumberId)
                .build();
        supplierService.createSupplier(supplier);
        List<SupplierDTO> list = supplierService.readAllSuppliers();
        request.setAttribute("suppliers", list);
        return "/jsp/lists/suppliers.jsp";
    }
}
