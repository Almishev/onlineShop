package online.handsmade.shop.controllers;

import online.handsmade.shop.model.Order;
import online.handsmade.shop.model.Product;
import online.handsmade.shop.service.ProductService;
import online.handsmade.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PanelController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/panel/order/send/{id}")
    public String orderSend(@PathVariable("id") Long id,  Model model) {
        model.addAttribute("activePage", "viewOrders");
        Order order = orderService.getOne(id);
        if(order.isSend()) {
            order.setSend(false);
        } else {
            order.setSend(true);
        }
        orderService.save(order);
        List<Order> orders = new ArrayList<>();
        orderService.findAll().forEach(o -> orders.add(o));
        model.addAttribute("orders",orders);
        return "orders";
    }
    @GetMapping("/panel")
    public String viewHomePage(Model model) {
        model.addAttribute("activePage", "adminPanel");

        return findPaginated(1, "name", "asc", model);
    }
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Product> page = productService.findAll2(pageNo, pageSize, sortField, sortDir);
        List < Product > products = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("products", products);
        return "panel";
    }
/*
    @GetMapping("/panel")
    public String getAllProducts(Model model, @Param("sortField") String sortField,
                                 @Param("sortDir") String sortDir) {
        model.addAttribute("product",new Product());


        model.addAttribute("price", sortField);
        model.addAttribute("asc", sortDir);
       // model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        List<Product> products = new ArrayList<>();
        productService.findAll2(sortField,sortDir).forEach(product -> products.add(product));
        model.addAttribute("products",products);
        return "panel";
    }


 */
    @GetMapping("/panel/orders")
    public String getOrders(Model model) {
        model.addAttribute("activePage", "viewOrders");
        List<Order> orders = new ArrayList<>();
        orderService.findAll().forEach(order -> orders.add(order));
        model.addAttribute("orders",orders);
        return "orders";
    }

    @RequestMapping("/panel/orders/delete/{id}")
    public String deleteOrder(@PathVariable(name = "id") Long id) {
        orderService.deleteById(id);
        return "redirect:/panel/orders";
    }
}
