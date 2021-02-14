package model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Expense {

    private Integer expenseId;
    private Integer expenseAmount;
    private String expenseDescription;
    private Date expenseDate;
    private Integer expenseTypeId;
}
