package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataJpaItemRepository extends JpaRepository<Item,Long> {

    List<Item> findByItemNameLike(String itemName);
    List<Item> findByPriceLessThanEqual(int price);
    // 쿼리 메소드
    List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, int price);
    // 쿼리 직접 실행
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") int price);


}
