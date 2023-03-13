package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.service.AddressService;
import by.academy.service.PhoneNumberService;
import by.academy.service.SupplierService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.AddressServiceImpl;
import by.academy.service.impl.PhoneNumberServiceImpl;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToEditSupplierCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        SupplierService service = new SupplierServiceImpl();
        AddressService addressService = new AddressServiceImpl();
        PhoneNumberService phoneNumberService = new PhoneNumberServiceImpl();
        List<AddressDTO> addressList = addressService.readAllAddresses();
        request.setAttribute("addresses", addressList);
        List<PhoneNumberDTO> phoneNumberList = phoneNumberService.readAllPhoneNumbers();
        request.setAttribute("phoneNumbers", phoneNumberList);
        SupplierDTO supplierDTO = service.selectSupplierById(id);
        request.setAttribute("supplier", supplierDTO);
        return "/jsp/edit/editSupplier.jsp";
    }
}
