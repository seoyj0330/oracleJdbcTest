/*
1)	평균 연봉(salary)이 가장 높은 나라는?
 */
select  country_name as "나라 이름",
        salary as "평균연봉"
from countries c,
     locations l,
     (select location_id, avg(salary) avgs
      from employees e, departments d
      where e.department_id = d.department_id
      group by location_id) a,
      (select max(avg(salary)) maxs
       from employees e, departments d 
       where e.department_id = d.department_id
       group by location_id) b
where e.department_id = d.department_id
  and d.location_id = l.location_id
  and l.country_id = c.country_id
  and a.location_id = l.location_id
  and a.avgs = b.maxs;
  

/*
2)	평균 연봉(salary)이 가장 높은 지역은?
*/
select region_name as "지역이름",
       b.maxs as "평균연봉"
from locations l,
     countries c,
     regions r,
    (select location_id, avg(salary) avgs
     from employees e, departments d
     where e.department_id= d.department_id
     group by location_id) a ,
     (select max(avg(salary)) maxs
      from employees e, departments d
      where e.department_id= d.department_id
      group by location_id) b
where a.avgs=b.maxs
  and a.location_id =l.location_id
  and l.country_id =c.country_id
  and c.region_id=r.region_id;
  

/*
3)	가장 많은 직원이 있는 부서는 어떤 부서인가요?
*/
select d.department_name as 부서이름 , mcem as 직원수
from ( select department_id, count(employee_id) cem
       from employees
       group by department_id ) a , 
       (select max(count(employee_id)) mcem
        from employees
        group by department_id) b, 
        departments d
where a.cem = b.mcem 
  and d.department_id = a.department_id;
