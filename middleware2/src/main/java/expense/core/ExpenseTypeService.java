package expense.core;

import expense.data.ExpenseTypeRepository;
import expense.model.ExpenseType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseTypeService {

    private final ExpenseTypeRepository expenseTypeRepository;

    public ExpenseTypeService(ExpenseTypeRepository expenseTypeRepository) {
        this.expenseTypeRepository = expenseTypeRepository;
    }

    public List<ExpenseType> findAll(){
        return this.expenseTypeRepository.findAll();
    }

    public Optional<ExpenseType> getExpenseTypeById(Integer expenseTypeId){
        return this.expenseTypeRepository.findById(expenseTypeId);
    }

    public Optional<ExpenseType> getExpenseTypeByDescription(String expenseTypeDescription){
        return this.expenseTypeRepository.getByDescription(expenseTypeDescription);
    }

    public void createExpenseType(ExpenseType expenseType){
        this.expenseTypeRepository.save(expenseType);
    }

    public ExpenseType updateExpenseType(Integer expenseTypeId, ExpenseType expenseType){
        Optional<ExpenseType> existingExpenseType = this.expenseTypeRepository.findById(expenseTypeId);
        if(existingExpenseType.isPresent()){
            this.expenseTypeRepository.save(expenseType);
        }
        return expenseType;
    }

    public void deleteExpenseType(Integer expenseTypeId){
        Optional<ExpenseType> existingExpenseType = this.expenseTypeRepository.findById(expenseTypeId);
        if(existingExpenseType.isPresent()) {
            this.expenseTypeRepository.delete(existingExpenseType.get());
        }
    }
}
