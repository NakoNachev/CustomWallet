package expense.unit;

import expense.core.ExpenseService;
import expense.data.ExpenseRepository;
import expense.model.Expense;
import expense.model.ExpenseType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {

    @InjectMocks
    private ExpenseService expenseService;
    @Mock
    private ExpenseRepository expenseRepository;

    private static Expense expense1;
    private static Expense expense2;
    private static ExpenseType expenseType1;
    private static ExpenseType expenseType2;

    @BeforeAll
    public static void init(){
        expense1 = Expense.builder()
                .expenseId(1)
                .expenseAmount(200)
                .expenseDate(new Date(Calendar.getInstance().getTime().getTime()))
                .expenseDescription("Expense 1")
                .expenseType(expenseType1).build();

        expense2 = Expense.builder()
                .expenseId(2)
                .expenseAmount(300)
                .expenseDate(new Date(Calendar.getInstance().getTime().getTime()))
                .expenseDescription("Expense 2")
                .expenseType(expenseType2).build();

        expenseType1 = ExpenseType.builder()
                .expenseTypeId(1)
                .expenseTypeDescription("Expense Type 1")
                .build();

        expenseType2 = ExpenseType.builder()
                .expenseTypeId(1)
                .expenseTypeDescription("Expense Type 1")
                .build();

    }

    @Test()
    @DisplayName("should return correct object by id")
    void getById(){
        Mockito.when(expenseRepository.findById(1)).thenReturn(Optional.of(expense1));
        Mockito.when(expenseRepository.findById(2)).thenReturn(Optional.of(expense2));

        Optional<Expense> firstExpenseResult = expenseService.getExpenseById(1);
        Optional<Expense> secondExpenseResult = expenseService.getExpenseById(2);

        assertThat(firstExpenseResult.isPresent()).isTrue();
        assertThat(firstExpenseResult.get()).isNotNull();
        assert(firstExpenseResult.get()).equals(expense1);
        assertEquals(firstExpenseResult.get().getExpenseId(),Integer.valueOf(1));
        assertEquals(firstExpenseResult.get().getExpenseAmount(),expense1.getExpenseAmount());
        assertEquals(firstExpenseResult.get().getExpenseDate(),expense1.getExpenseDate());
        assertEquals(firstExpenseResult.get().getExpenseDescription(),expense1.getExpenseDescription());

        assertThat(secondExpenseResult.isPresent()).isTrue();
        assertThat(secondExpenseResult.get()).isNotNull();
        assert(secondExpenseResult.get()).equals(expense2);
        assertEquals(secondExpenseResult.get().getExpenseId(),expense2.getExpenseId());
        assertEquals(secondExpenseResult.get().getExpenseAmount(),expense2.getExpenseAmount());
        assertEquals(secondExpenseResult.get().getExpenseDate(),expense2.getExpenseDate());
        assertEquals(secondExpenseResult.get().getExpenseDescription(),expense2.getExpenseDescription());

        assertNotEquals(firstExpenseResult,secondExpenseResult);




    }
}
