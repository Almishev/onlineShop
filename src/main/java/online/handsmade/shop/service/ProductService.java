package online.handsmade.shop.service;

import online.handsmade.shop.repo.ProductRepo;
import online.handsmade.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Page<Product> getAll(int pageNum , String sortField, String sortDir, String keyWord) {
        int pageSize = 5;

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        if(keyWord!=null){
            return productRepo.findAll(keyWord,pageable);
        }

        return productRepo.findAll(pageable);
    }


    public Product save(Product product) {
        return productRepo.save(product);
    }



    public Page <Product> findAll2(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.productRepo.findAll(pageable);
    }
    public List<Product> findAll() {


        return productRepo.findAll();
    }

    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    public Product getOne(Long id) {
        return productRepo.getOne(id);
    }

    public void reduceStock(int stock, Long id) {
        productRepo.reduceStock(stock,id);
    }
}
