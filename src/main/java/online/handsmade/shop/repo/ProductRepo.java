package online.handsmade.shop.repo;

import online.handsmade.shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    @Query(value = "SELECT * from product p Where p.category like %?1%",nativeQuery = true)
    public Page<Product> findAll(String keyword, Pageable pageable);

    @Query(value = "UPDATE PRODUCT SET STOCK=STOCK-?1 WHERE PRODUCT_ID=?2",nativeQuery = true)
    @Transactional
    @Modifying
    void reduceStock(int stock, Long id);


}
