package expense.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer expenseId;
    @Column(name="expense_amount")
    private Integer expenseAmount;
    @Column(name="expense_description")
    private String expenseDescription;
    @Column(name="expense_date")
    private Date expenseDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_type_id")
    private ExpenseType expenseType;
}
