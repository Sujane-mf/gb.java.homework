# №1 Создать VIEW на основе запросов, которые вы сделали в ДЗ к уроку 3
use geodata;
# создаю вьюшку для получения полной информации о городе
CREATE VIEW Town_info AS
SELECT *
FROM
(SELECT _cities.title as Город, _regions.title as Регион, _countries.title as Страна 
FROM _cities
left join (_countries)
on _cities.country_id = _countries.country_id
left join _regions
on _cities.region_id = _regions.region_id) as info

# проверяю выборку
select * from town_info

# вьюшка по средней зарплате по отделам
use employees
CREATE VIEW Avg_salarie AS
SELECT *
FROM
(select AVG(salary) as 'Средняя ЗП', dept_name from salaries
join employees
on salaries.emp_no = employees.emp_no
join dept_emp
on employees.emp_no = dept_emp.emp_no
join departments
on dept_emp.dept_no = departments.dept_no
where salaries.to_date = '9999-01-01' AND dept_emp.to_date = '9999-01-01' # ограничеваю по последней зп сотрудника и по признаку, что он еще работает в текущем департаменте
GROUP BY dept_name) as avg

# проверяю
select * from avg_salarie

# №2 Создать функцию, которая найдет табельный номер менеджера по имени(часть) и фамилии(часть) или выдаст "0"- если его нет такого.
CREATE FUNCTION tab_number (f char(20), l char (20)) RETURNS int(11)
RETURN (SELECT IF (
(SELECT dept_manager.emp_no from dept_manager
left join employees
on dept_manager.emp_no = employees.emp_no
where first_name like concat('%',f,'%') AND last_name like concat('%',l,'%')) IS NOT NULL, ((SELECT dept_manager.emp_no from dept_manager
left join employees
on dept_manager.emp_no = employees.emp_no
where first_name like concat('%',f,'%') AND last_name like concat('%',l,'%'))), 0))

SELECT * from dept_manager
left join employees
on dept_manager.emp_no = employees.emp_no
# проверяем
select tab_number ('irish', 'konfet')
select tab_number ('irish', 'enbru')

#3 Создать триггер, который при добавлении нового сотрудника происходит в таблицу employees
# будет выплачивать ему вступительный бонус, занося запись об этом в таблицу salary
# Может асбтрагироваться и для проставления полей дат использовать функцию curtdate() . 

DROP TRIGGER IF EXISTS `employees`.`employees_AFTER_INSERT`;

DELIMITER $$
USE `employees`$$
CREATE DEFINER = CURRENT_USER TRIGGER `employees`.`employees_AFTER_INSERT` AFTER INSERT ON `employees` FOR EACH ROW
BEGIN
INSERT INTO salaries
SET 
	emp_no = NEW.emp_no,
    salary = 5000,
    from_date = CURDATE(),
    to_date = CURDATE();
END$$
DELIMITER ;

# проверка 
INSERT INTO  employees (emp_no, birth_date, first_name, last_name, gender, hire_date)
VALUES (9999, '1987-12-01', 'Buksha', 'Kseniya', 'F', curdate());

select * from employees
where emp_no = '9999'; 

select * from salaries
where emp_no = '9999'