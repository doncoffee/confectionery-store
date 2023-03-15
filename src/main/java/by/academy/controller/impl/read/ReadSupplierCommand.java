package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.service.SupplierService;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReadSupplierCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        SupplierService supplierService = new SupplierServiceImpl();
        List<SupplierDTO> list = supplierService.readAllSuppliers();
        request.setAttribute("suppliers", list);
        return "/jsp/lists/suppliers.jsp";
    }
}
