package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SupplierExtractor;
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
    private final SupplierService service = new SupplierServiceImpl();
    private final Extractor<SupplierDTO> extractor = new SupplierExtractor();
    private final AddressService addressService = new AddressServiceImpl();
    private final PhoneNumberService phoneNumberService = new PhoneNumberServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<AddressDTO> addressList = addressService.readAllAddresses();
        List<PhoneNumberDTO> phoneNumberList = phoneNumberService.readAllPhoneNumbers();
        SupplierDTO supplierDTO = service.selectSupplierById(id);
        request.setAttribute("addresses", addressList);
        request.setAttribute("phoneNumbers", phoneNumberList);
        request.setAttribute("supplier", supplierDTO);
        extractor.extract(request);
        return "/jsp/edit/editSupplier.jsp";
    }
}
