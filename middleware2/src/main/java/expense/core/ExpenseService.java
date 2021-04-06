package expense.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import expense.data.ExpenseRepository;
import expense.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseService {


    @Autowired
    private final ExpenseRepository expenseRepository;
    private final ExpenseTypeService expenseTypeService;
    private final ObjectMapper objectMapper;

    public ExpenseService(ExpenseRepository expenseRepository, ExpenseTypeService expenseTypeService, ObjectMapper objectMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseTypeService = expenseTypeService;
        this.objectMapper = objectMapper;
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

    /**
     * Changes the expense type id inside the expense object with the description
     * @return
     */
    public List<ObjectNode> getExpenseWithExpenseTypeDescription() {
        List<Expense> allExpenses = this.getAll();
        List<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();

        for (Expense expense: allExpenses){
            ObjectNode node = this.objectMapper.createObjectNode();
            node.put("expenseId",expense.getExpenseId());
            node.put("expenseAmount",expense.getExpenseAmount());
            node.put("expenseDescription",expense.getExpenseDescription());
            node.put("expenseDate",expense.getExpenseDate().toString());
            node.put("expenseTypeDescription", this.expenseTypeService.getExpenseTypeById(expense.getExpenseTypeId()).get().getExpenseTypeDescription());
            objectNodeList.add(node);
        }
        return objectNodeList;

    }

}
