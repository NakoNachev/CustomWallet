package expense.resource;

import expense.core.ExpenseTypeService;
import expense.model.ExpenseType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/expense-type")
public class ExpenseTypeController {

    private final ExpenseTypeService expenseTypeService;

    public ExpenseTypeController(ExpenseTypeService expenseTypeService) {
        this.expenseTypeService = expenseTypeService;
    }

    @GetMapping()
    public ResponseEntity<List<ExpenseType>> getAll() {
        return new ResponseEntity<>(this.expenseTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{expenseId}")
    public ResponseEntity<Optional<ExpenseType>> getExpenseById(@PathVariable("expenseId") Long expenseTypeId ) {
        return new ResponseEntity<>(this.expenseTypeService.getExpenseTypeById(expenseTypeId), HttpStatus.OK);
    }

    @PostMapping()
    //TODO: Replace persistent entity with POJO or DTO Object
    public ResponseEntity createExpenseType(@RequestBody() ExpenseType expenseType){
        this.expenseTypeService.createExpenseType(expenseType);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
