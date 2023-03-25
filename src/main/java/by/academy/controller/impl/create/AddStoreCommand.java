package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.StoreExtractor;
import by.academy.service.StoreService;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.*;

public class AddStoreCommand implements Command {
    private final StoreService service = new StoreServiceImpl();
    private final Extractor extractor = new StoreExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int addressId = Integer.parseInt(request.getParameter(ADDRESS_ID));
        int phoneNumberId = Integer.parseInt(request.getParameter(PHONE_NUMBER_ID));
        StoreDTO store = StoreDTO.builder()
                .id(null)
                .addressId(addressId)
                .phoneNumberId(phoneNumberId)
                .build();
        service.createStore(store);
        extractor.extract(request);
        return JSP_LISTS_STORES_JSP;
    }
}
