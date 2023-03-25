package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.StoreExtractor;
import by.academy.service.AddressService;
import by.academy.service.PhoneNumberService;
import by.academy.service.StoreService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.AddressServiceImpl;
import by.academy.service.impl.PhoneNumberServiceImpl;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.academy.controller.constants.ControllerConstants.*;

public class GoToEditStoreCommand implements Command {
    private final StoreService service = new StoreServiceImpl();
    private final Extractor extractor = new StoreExtractor();
    private final AddressService addressService = new AddressServiceImpl();
    private final PhoneNumberService phoneNumberService = new PhoneNumberServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        List<AddressDTO> addressList = addressService.readAllAddresses();
        List<PhoneNumberDTO> phoneNumberList = phoneNumberService.readAllPhoneNumbers();
        StoreDTO storeDTO = service.selectStoreById(id);
        request.setAttribute(ADDRESSES, addressList);
        request.setAttribute(PHONE_NUMBERS, phoneNumberList);
        request.setAttribute(STORE, storeDTO);
        extractor.extract(request);
        return JSP_EDIT_EDIT_STORE_JSP;
    }
}
