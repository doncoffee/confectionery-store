package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.entity.Store;
import by.academy.entity.Supplier;
import by.academy.service.AddressService;
import by.academy.service.PhoneNumberService;
import by.academy.service.SupplierService;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.AddressServiceImpl;
import by.academy.service.impl.PhoneNumberServiceImpl;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UpdateSupplierCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        SupplierService supplierService = new SupplierServiceImpl();
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        int phoneNumberId = Integer.parseInt(request.getParameter("phoneNumberId"));
        SupplierDTO supplier = SupplierDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .name(request.getParameter("name"))
                .contactPerson(request.getParameter("contactPerson"))
                .addressId(addressId)
                .phoneNumberId(phoneNumberId)
                .build();
        supplierService.updateSupplier(supplier);
        List<SupplierDTO> list = supplierService.readAllSuppliers();
        request.setAttribute("suppliers", list);
        return "/jsp/lists/suppliers.jsp";
    }
}
