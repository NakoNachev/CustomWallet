package expense.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="expense_type")
public class ExpenseType {

    @Id
    private Integer expenseTypeId;
    @Column(name="expense_type_description")
    private String expenseTypeDescription;
}
