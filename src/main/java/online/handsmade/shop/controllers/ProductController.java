package online.handsmade.shop.controllers;

import online.handsmade.shop.model.Cart;
import online.handsmade.shop.model.Product;
import online.handsmade.shop.repo.UserRepo;
import online.handsmade.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/products/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum, @Param("sortField") String sortField,
                           @Param("sortDir") String sortDir,@Param("keyWord") String keyWord) {

        Page<Product> page = productService.getAll(pageNum,sortField,sortDir,keyWord);

        List<Product> products = page.getContent();


        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("keyWord",keyWord);

        model.addAttribute("products", products);

        return "index";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model,@Param("keyWord") String keyWord) {
        model.addAttribute("activePage", "home");
        return viewPage(model,1, "name","asc",keyWord);
    }


    @RequestMapping("/product/new")
    public String showNewProductPage(Model model) {
        model.addAttribute("activePage", "newProduct");

        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            return "new_product";
        } else {
            productService.save(product);
            model.addAttribute("products",productService.findAll());
            return "panel";
        }
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,Model model) {

        if (bindingResult.hasErrors()) {
            return "edit_product";
        } else {
            productService.save(product);
            model.addAttribute("products",productService.findAll());
            return "panel";
        }
    }


    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
        return "redirect:/panel";
    }

    @RequestMapping("/product/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = productService.getOne(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/product/{id}")
    public ModelAndView showProduct(@PathVariable(name = "id") Long id ) {

        ModelAndView mav = new ModelAndView("product");
        mav.addObject("cart",new Cart());
        Product product = productService.getOne(id);
        mav.addObject("product", product);
        mav.addObject("tooMuch",false);
        return mav;
    }



}
