CREATE table expense_type (

	expense_type_id int primary key not null,
	expense_description varchar(60)
);

CREATE table expense (

	expense_id int primary key,
	expense_amount float(2) not null,
	expense_description varchar(60),
	expense_date date,
	expense_type_id int,

	foreign key (expense_type_id) references expense_type(expense_type_id)
);