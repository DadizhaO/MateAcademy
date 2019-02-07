SELECT
    order_num,
    amount,
    company,
    credit_limit
FROM
    orders      ord
    JOIN customers   cus ON ord.cust = cus.cust_num;

SELECT
    name,
    city,
    region
FROM
    offices     of1
    JOIN salesreps   sal ON of1.office = sal.rep_office;

SELECT
    city,
    name,
    title
FROM
    offices     of1
    JOIN salesreps   sal ON of1.mgr = sal.empl_num;

SELECT
    city,
    name,
    title
FROM
    offices     of1
    JOIN salesreps   sal ON of1.mgr = sal.empl_num
                          AND of1.target > 600;

SELECT
    order_num,
    amount,
    description
FROM
    orders     ord
    JOIN products   pr ON ord.product = pr.product_id
                        AND ord.mfr = pr.mfr_id;

SELECT
    order_num,
    amount,
    company,
    name
FROM
    orders      ord
    JOIN customers   cus ON ord.cust = cus.cust_num
    JOIN salesreps   sal ON ord.rep = sal.empl_num
                          AND ord.amount > 700;

SELECT
    order_num,
    amount,
    company,
    name
FROM
    orders      ord
    JOIN customers   cus ON ord.cust = cus.cust_num
    JOIN salesreps   sal ON cus.cust_rep = sal.empl_num
                          AND ord.amount > 700;

--Вывести список заказов стоимостью выше $700, включая имя клиента, 
--разместившего заказ и имя служащего, закрепленного за этим клиентом, а так же офис, в котором работает этот служащий.

SELECT
    order_num,
    amount,
    company,
    name,
    city
FROM
    orders      ord
    JOIN customers   cus ON ord.cust = cus.cust_num
    JOIN salesreps   sal ON cus.cust_rep = sal.empl_num
    JOIN offices     of1 ON of1.office = sal.rep_office
                        AND ord.amount > 700;

--Найти все заказы, полученные в тот день, когда на работу был принят новый служащий.

SELECT
    order_num,
    amount,
    order_date,
    name
FROM
    orders      ord
    JOIN salesreps   emp ON ord.order_date = emp.hire_date;

--Получить все комбинации служащих офисов, где плановый объем продаж служащего больше, чем план какого либо офиса.

SELECT
    name,
    quota,
    city,
    target
FROM
    salesreps   emp
    JOIN offices     of1 ON emp.quota > of1.target;

--Показать имя, офис, и объем продаж каждого служащего.

SELECT
    name,
    city,
    mng.sales
FROM
    offices     of1
    JOIN salesreps   emp ON emp.rep_office = of1.office;

--Сообщить всю информацию, о служащих и офисах где они работают.

SELECT
    *
FROM
    salesreps   emp
    JOIN offices     of1 ON emp.rep_office = of1.office;

--Сообщить всю информацию, о служащих и офисах где они работают.

SELECT
    mng.*,
    city,
    region
FROM
    salesreps   emp
    JOIN offices     of1 ON emp.rep_office = of1.office;

--Вывести список имен всех служащих и их руководителей.

SELECT
    emps.name,
    mng.name
FROM
    salesreps   emps
    JOIN salesreps   mng ON mng.empl_num = emps.manager;

--Вывести список служащих, планы которых превышают планы их руководителей.

SELECT
    salesreps.name,
    salesreps.quota,
    mng.quota
FROM
    salesreps
    JOIN salesreps mng ON mng.empl_num = salesreps.manager
                          AND salesreps.quota > mng.quota;

--Вывести список служащих, которые работают со своими руководителями в различных офисах, 
--включая имена и офисы как служащих,так и руководителей.

SELECT
    emp.name,
    emp_office.city,
    mng.name,
    mgr_office.city
FROM
    salesreps   emp
    JOIN salesreps   mng ON mng.empl_num = emp.manager
    JOIN offices     emp_office ON emp.rep_office = emp_office.office
    JOIN offices     mgr_office ON mng.rep_office = mgr_office.office
                               AND emp.rep_office != mng.rep_office;

SELECT
    AVG(quota),
    AVG(sales)
FROM
    salesreps;
    
--Каков средний процент выполнения плана в вашей компании?

SELECT
    AVG(100 *(sales / quota))
FROM
    salesreps;

SELECT
    AVG(100 *(sales / quota)) procent
FROM
    salesreps;

-- Каковы средний плановый и средний фактический объемы продаж, служащих нашей компании? 

SELECT
    SUM(quota),
    SUM(sales)
FROM
    salesreps;

--Какова сумма всех заказов принятых Димой Маликовым?

SELECT
    SUM(amount)
FROM
    orders      ord
    JOIN salesreps   emp ON emp.empl_num = ord.rep
                          AND emp.name = 'Дима Маликов';

--Вычислить среднюю цену товаров от производителя "ACI".

SELECT
    AVG(price)
FROM
    products
WHERE
    mfr_id = 'ACI';
    
--Вычислить среднюю стоимость заказа, размещенного компанией "Acme Mfg". (идентификатор клиента 2103)

SELECT
    AVG(amount)
FROM
    orders
WHERE
    cust = 2103;

SELECT
    MIN(quota),
    MAX(quota)
FROM
    salesreps;
    
--Когда был сделан самый первый из всех содержащихся в базе данных заказов?

SELECT
    MIN(order_date)
FROM
    orders;
    
--Каков наибольший процент выполнения плана среди всех служащих?

SELECT
    MAX(100 *(sales / quota))
FROM
    salesreps;
    
--Сколько клиентов у нашей компании? 

SELECT
    COUNT(cust_num)
FROM
    customers;
 
--Сколько служащих перевыполнили план?

SELECT
    COUNT(name)
FROM
    salesreps
WHERE
    sales > quota;

--Сколько имеется заказов стоимостью более $250 ?

SELECT
    COUNT(amount)
FROM
    orders
WHERE
    amount > 250;

SELECT
    COUNT(*)
FROM
    orders
WHERE
    amount > 250;
    
--Найти среднюю стоимость заказов, общую стоимость заказов, среднюю стоимость заказов в процентах от лимитов кредита клиентов, 
--а также среднюю стоимость заказов в процентах от плановых объемов продаж служащих.

SELECT
    AVG(ord.amount),
    SUM(ord.amount),
    ( 100 * AVG(ord.amount / credit_limit) ),
    ( 100 * AVG(ord.amount / quota) )
FROM
    orders      ord
    JOIN customers   cust ON cust.cust_num = ord.cust
    JOIN salesreps   sal ON sal.empl_num = ord.rep;