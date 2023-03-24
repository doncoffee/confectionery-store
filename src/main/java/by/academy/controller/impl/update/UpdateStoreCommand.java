package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.StoreExtractor;
import by.academy.service.StoreService;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UpdateStoreCommand implements Command {
    private final StoreService service = new StoreServiceImpl();
    private final Extractor<StoreDTO> extractor = new StoreExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        int phoneNumberId = Integer.parseInt(request.getParameter("phoneNumberId"));
        StoreDTO store = StoreDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .addressId(addressId)
                .phoneNumberId(phoneNumberId)
                .build();
        service.updateStore(store);
        extractor.extract(request);
        return "/jsp/lists/stores.jsp";
    }
}
