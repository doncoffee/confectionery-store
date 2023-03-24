package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.StoreExtractor;
import by.academy.service.AddressService;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.AddressServiceImpl;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToAddStoreCommand implements Command {
    private final Extractor<StoreDTO> extractor = new StoreExtractor();
    private final AddressService addressService = new AddressServiceImpl();
    private final PhoneNumberService phoneNumberService = new PhoneNumberServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        List<AddressDTO> addressList = addressService.readAllAddresses();
        List<PhoneNumberDTO> phoneNumberList = phoneNumberService.readAllPhoneNumbers();
        request.setAttribute("addresses", addressList);
        request.setAttribute("phoneNumbers", phoneNumberList);
        extractor.extract(request);
        return "/jsp/add/addStore.jsp";
    }
}
