package expense.resource;

import com.fasterxml.jackson.databind.node.ObjectNode;
import expense.core.ExpenseService;
import expense.model.Expense;
import expense.model.exceptions.NotFoundByIdException;
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

    @GetMapping("/mappedExpenseTypeDescription")
    public ResponseEntity<List<ObjectNode>> getMappedExpenseTypeDescription() {
        return new ResponseEntity<>(this.expenseService.getExpenseWithExpenseTypeDescription(), HttpStatus.OK);
    }

    @PostMapping()
    //TODO: Replace persistent entity with POJO or DTO Object
    public ResponseEntity createExpense(@RequestBody() Expense expense){
        this.expenseService.createExpense(expense);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("expenseId") Integer expenseId, @RequestBody() Expense expense){
        Optional<Expense> existingExpense = this.expenseService.getExpenseById(expenseId);
        if (existingExpense.isPresent()){
            this.expenseService.updateExpense(expenseId, expense);
            return new ResponseEntity<>(expense, HttpStatus.OK);
        } else {
            throw new NotFoundByIdException(expenseId);
        }
    }

    @DeleteMapping("/{expenseId}")
    public void deleteExpense(@PathVariable("expenseId") Integer expenseId){
        Optional<Expense> existingExpense = this.expenseService.getExpenseById(expenseId);
        if (existingExpense.isPresent()){
            this.expenseService.deleteExpense(expenseId);
        } else {
            throw new NotFoundByIdException(expenseId);
        }
    }

}
