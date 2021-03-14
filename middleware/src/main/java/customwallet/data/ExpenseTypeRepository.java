package customwallet.data;

import customwallet.model.ExpenseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeRepository extends PagingAndSortingRepository<ExpenseType,Long> {
}
