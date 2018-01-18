/*
1) EMPLOYEE 테이블에서 이름(Last Name)에 “hae”를 포함하고 있는 사원들과 같은 부서에서 근무하고 있는 사원의 
EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPARTMENT_ID 를 출력하라. 
*/
select  e.employee_id,
        e.first_name,
        e.last_name,
        e.department_id
from employees e, (select department_id
                   from employees
                   where last_name like '%hae%') a
where  e.department_id = a.department_id 
order by employee_id desc;




/*
2) 각 도시(city)별 가장 연봉을 많이 받고 있는 사원의 도시 이름(City), First Name, Last Name, 급여를 조회하라. 
급여 순으로 오름차순 정렬하시오. (1-2.sql)
*/  
select l.city,
       e.first_name,
       e.last_name,
       e.salary
from employees e, 
     departments d,
     locations l,
     (select location_id, max(salary) maxs
      from employees e, departments d
      where e.department_id = d.department_id
      group by location_id) a
where  e.department_id = d.department_id
   and d.location_id = l.location_id
   and a.location_id = d.location_id
   and e.salary = a.maxs
order by salary asc;
