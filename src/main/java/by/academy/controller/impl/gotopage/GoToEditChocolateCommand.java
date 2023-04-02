package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.ChocolateExtractor;
import by.academy.service.BrandService;
import by.academy.service.ChocolateService;
import by.academy.service.StoreService;
import by.academy.service.SupplierService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.dto.ChocolateDTO;
import by.academy.service.dto.StoreDTO;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.BrandServiceImpl;
import by.academy.service.impl.ChocolateServiceImpl;
import by.academy.service.impl.StoreServiceImpl;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.academy.controller.constants.ControllerConstants.*;

public class GoToEditChocolateCommand implements Command {
    private final ChocolateService service = new ChocolateServiceImpl();
    private final Extractor extractor = new ChocolateExtractor();
    private final BrandService brandService = new BrandServiceImpl();
    private final StoreService storeService = new StoreServiceImpl();
    private final SupplierService supplierService = new SupplierServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        List<BrandDTO> brandList = brandService.readAllBrands();
        List<StoreDTO> storeList = storeService.readAllStores();
        List<SupplierDTO> supplierList = supplierService.readAllSuppliers();
        ChocolateDTO chocolateDTO = service.selectChocolateById(id);
        request.setAttribute(BRANDS, brandList);
        request.setAttribute(STORES, storeList);
        request.setAttribute(SUPPLIERS, supplierList);
        request.setAttribute(CHOCOLATE, chocolateDTO);
        extractor.extract(request);
        return JSP_EDIT_EDIT_CHOCOLATE_JSP;
    }
}
