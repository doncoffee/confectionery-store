package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.CookieExtractor;
import by.academy.service.BrandService;
import by.academy.service.CookieService;
import by.academy.service.StoreService;
import by.academy.service.SupplierService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.dto.CookieDTO;
import by.academy.service.dto.StoreDTO;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.BrandServiceImpl;
import by.academy.service.impl.CookieServiceImpl;
import by.academy.service.impl.StoreServiceImpl;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToEditCookieCommand implements Command {
    private final CookieService cookieService = new CookieServiceImpl();
    private final Extractor<CookieDTO> extractor = new CookieExtractor();
    private final BrandService brandService = new BrandServiceImpl();
    private final StoreService storeService = new StoreServiceImpl();
    private final SupplierService supplierService = new SupplierServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<BrandDTO> brandList = brandService.readAllBrands();
        List<StoreDTO> storeList = storeService.readAllStores();
        List<SupplierDTO> supplierList = supplierService.readAllSuppliers();
        CookieDTO cookieDTO = cookieService.selectCookieById(id);
        request.setAttribute("brands", brandList);
        request.setAttribute("stores", storeList);
        request.setAttribute("suppliers", supplierList);
        request.setAttribute("cookie", cookieDTO);
        extractor.extract(request);
        return "/jsp/edit/editCookie.jsp";
    }
}
