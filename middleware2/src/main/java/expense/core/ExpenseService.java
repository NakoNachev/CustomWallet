package expense.core;

import expense.data.ExpenseRepository;
import expense.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {


    @Autowired
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAll(){
        return this.expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Integer expenseId){
        return this.expenseRepository.findById(expenseId);
    }

    public void createExpense(Expense expense){
        this.expenseRepository.save(expense);
    }

    public Expense updateExpense(Integer expenseId, Expense expense){
        Optional<Expense> existingExpense = this.expenseRepository.findById(expenseId);
        if (existingExpense.isPresent()){
            this.expenseRepository.save(expense);
        }
        return expense;
    }
    public void deleteExpense(Integer expenseId){
        Optional<Expense> existingExpense = this.expenseRepository.findById(expenseId);
        if (existingExpense.isPresent()){
            this.expenseRepository.delete(existingExpense.get());
        }
    }



}
