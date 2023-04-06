package EZ.nomargin.repository;

import EZ.nomargin.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item save(Item item);
    Optional<Item> findById(Long id);
    List<Item> findTop();
    void update(Long productId, Item updateProduct);
    void delete(Long productId);
}
