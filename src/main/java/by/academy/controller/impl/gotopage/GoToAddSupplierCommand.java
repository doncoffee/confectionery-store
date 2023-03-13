package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.service.AddressService;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.impl.AddressServiceImpl;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToAddSupplierCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        AddressService addressService = new AddressServiceImpl();
        PhoneNumberService phoneNumberService = new PhoneNumberServiceImpl();
        List<AddressDTO> addressList = addressService.readAllAddresses();
        request.setAttribute("addresses", addressList);
        List<PhoneNumberDTO> phoneNumberList = phoneNumberService.readAllPhoneNumbers();
        request.setAttribute("phoneNumbers", phoneNumberList);
        return "/jsp/add/addSupplier.jsp";
    }
}
