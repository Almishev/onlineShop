package online.handsmade.shop.repo;

import online.handsmade.shop.model.AddressAndPersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressAndPersonalData,Long> {
}
