package expense.data;

import expense.model.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType,Integer> {

    @Query("SELECT et from ExpenseType et where et.expenseTypeDescription = :description")
    public Optional<ExpenseType> getByDescription(@Param("description") String description);
}
