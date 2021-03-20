package expense.resource;

import expense.core.ExpenseService;
import expense.model.Expense;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{expenseId}")
    public ResponseEntity<Optional<Expense>> getExpenseById(@PathVariable("expenseId") Integer expenseId ) {
        return new ResponseEntity<>(this.expenseService.getExpenseById(expenseId), HttpStatus.OK);
    }

    @PostMapping()
    //TODO: Replace persistent entity with POJO or DTO Object
    public ResponseEntity createExpense(@RequestBody() Expense expense){
        this.expenseService.createExpense(expense);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
