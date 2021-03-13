package data;

import model.ExpenseType;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseTypeRepository extends CrudRepository<ExpenseType,Long> {
}
