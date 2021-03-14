package expense.data;

import expense.model.Expense;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends PagingAndSortingRepository<Expense,Long> {

    List<Expense> findAll();

    //Optional<Expense> findById(Integer expenseId);
}
