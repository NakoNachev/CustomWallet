package expense.resource;

import expense.core.ExpenseService;
import expense.model.Expense;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping()
    public ResponseEntity<List<Expense>> getAll() {
        return new ResponseEntity<>(this.expenseService.getAll(), HttpStatus.OK);
    }

    /*@GetMapping("/{expenseId}")
    public ResponseEntity<Optional<Expense>> getExpenseById(@PathVariable("expenseId") Integer expenseId ) {
        return new ResponseEntity<>(this.expenseService.getExpenseById(expenseId), HttpStatus.OK);
    }*/

}
