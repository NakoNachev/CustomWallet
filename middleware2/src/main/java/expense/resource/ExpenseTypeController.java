package expense.resource;

import expense.core.ExpenseTypeService;
import expense.model.ExpenseType;
import expense.model.exceptions.NotFoundByIdException;
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

    @GetMapping("/{expenseTypeId}")
    public ResponseEntity<Optional<ExpenseType>> getExpenseById(@PathVariable("expenseTypeId") Integer expenseTypeId ) {
        return new ResponseEntity<>(this.expenseTypeService.getExpenseTypeById(expenseTypeId), HttpStatus.OK);
    }

    @PostMapping()
    //TODO: Replace persistent entity with POJO or DTO Object
    public ResponseEntity createExpenseType(@RequestBody() ExpenseType expenseType){
        this.expenseTypeService.createExpenseType(expenseType);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{expenseTypeId}")
    public ResponseEntity<ExpenseType> updateExpenseType(@PathVariable("expenseTypeId") Integer expenseTypeId, ExpenseType expenseType){
        Optional<ExpenseType> existingExpenseType = this.expenseTypeService.getExpenseTypeById(expenseTypeId);
        if (existingExpenseType.isPresent()) {
            this.expenseTypeService.updateExpenseType(expenseTypeId, expenseType);
            return new ResponseEntity<>(expenseType, HttpStatus.OK);
        } else {
            throw new NotFoundByIdException(expenseTypeId);
        }
    }

    @DeleteMapping("/{expenseTypeId}")
    public void deleteExpenseType(@PathVariable("expenseTypeId") Integer expenseTypeId){
        Optional<ExpenseType> existingExpenseType = this.expenseTypeService.getExpenseTypeById(expenseTypeId);
        if (existingExpenseType.isPresent()) {
            this.expenseTypeService.deleteExpenseType(expenseTypeId);
        } else {
            throw new NotFoundByIdException(expenseTypeId);
        }
    }
}
