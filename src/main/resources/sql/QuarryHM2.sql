SELECT
    COUNT(*),
    COUNT(sales),
    COUNT(quota)
FROM
    salesreps;

SELECT
    SUM(sales),
    SUM(quota),
    ( SUM(sales) - SUM(quota) ),
    ( SUM(sales - quota) )
FROM
    salesreps;

-- Сколько различных названий рапортов существует в нашей компании? 

SELECT
    COUNT(DISTINCT title)
FROM
    salesreps;

--В скольких офисах есть служащие превысившие плановые объемы продаж?

SELECT
    COUNT(DISTINCT rep_office)
FROM
    salesreps
WHERE
    sales > quota;

SELECT
    AVG(amount)
FROM
    orders;

--Какова средняя стоимость заказа для каждого служащего?

SELECT
    rep,
    AVG(amount)
FROM
    orders
GROUP BY
    rep;

--Каков диапазон плановых объемов продаж для каждого офиса?

SELECT
    rep_office,
    MIN(quota),
    MAX(quota)
FROM
    salesreps
GROUP BY
    rep_office;

--Сколько служащих работают в каждом офисе?

SELECT
    rep_office,
    COUNT(*)
FROM
    salesreps
GROUP BY
    rep_office;

--Сколько клиентов обслуживает каждый служащий? 

SELECT
    COUNT(DISTINCT cust_num),
    'CUSTOMERS FOR SALESREPS',
    cust_rep
FROM
    customers
GROUP BY
    cust_rep;

--Подсчитать общее количество заказов по каждому клиенту для каждого служащего.

SELECT
    rep,
    cust,
    SUM(amount)
FROM
    orders
GROUP BY
    rep,
    cust;

--Подсчитать общее количество заказов по каждому клиенту для каждого служащего; отсортировать результаты запроса по клиентам и служащим.

SELECT
    rep,
    cust,
    SUM(amount)
FROM
    orders
GROUP BY
    rep,
    cust
ORDER BY
    rep,
    cust;

--Подсчитать общее количество заказов для каждого служащего.

SELECT
    empl_num,
    name,
    SUM(amount)
FROM
    orders
    INNER JOIN salesreps ON rep = empl_num
GROUP BY
    empl_num,
    name;

CREATE TABLE coloris (
    nm     VARCHAR2(50),
    hair   VARCHAR2(50),
    eyes   VARCHAR2(50)
);

COMMIT;

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Cindy',
    'Brown',
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Louise',
    NULL,
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Harry',
    NULL,
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Samantha',
    NULL,
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Joanne',
    NULL,
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'George',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Mary',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Paula',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Kevin',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Joel',
    'Brown',
    'Brown'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Susan',
    'Blonde',
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Marie',
    'Blonde',
    'Blue'
);

COMMIT;

SELECT
    hair,
    eyes,
    COUNT(*)
FROM
    coloris
GROUP BY
    hair,
    eyes;

--Какова средняя стоимость заказа для каждого служащего из числа тех, у которых общая стоимость заказов превышает $300?

SELECT
    rep,
    AVG(amount)
FROM
    orders
GROUP BY
    rep
HAVING
    SUM(amount) > 300;

--Для каждого офиса, в котором работают два и более человек, вычислить общий плановый и фактический объем продаж для всех служащих офиса.

SELECT
    city,
    SUM(quota),
    SUM(emp.sales)
FROM
    offices     o
    INNER JOIN salesreps   emp ON o.office = emp.rep_office
GROUP BY
    city
HAVING
    COUNT(*) >= 2;

--Показать цену, количество на складе и общее количество заказанных единиц для каждого наименования товара, 
--если для него общее количество заказанных единиц превышает 75 процентов от количества товара на складе.

SELECT
    description,
    price,
    qty_on_hand,
    SUM(ord.qty)
FROM
    products   p
    INNER JOIN orders     ord ON ord.mfr = p.mfr_id
GROUP BY
    p.mfr_id,
    p.product_id,
    p.description,
    p.price,
    p.qty_on_hand
HAVING
    SUM(ord.qty) > ( 0.75 * p.qty_on_hand )
ORDER BY
    p.qty_on_hand DESC;

--1. Скільки яких товірів купляли (скільки штук і чого купили всього)

SELECT
    description,
    SUM(ord.qty)
FROM
    products   p
    INNER JOIN orders     ord ON p.product_id = ord.product
GROUP BY
    p.description;

--2. Вивести товари, які купили більше 3-оьх разів (були в трьох і більше замовленнях)

SELECT
    description,
    COUNT(o.product)
FROM
    orders     o
    INNER JOIN products   p ON p.product_id = o.product
GROUP BY
    p.description
HAVING
    COUNT(o.product) > 3;

--3. Вивести офіси в яких працює більше трьох менеджерів

SELECT
    office,
    city,
    COUNT(mng.rep_office)
FROM
    offices     o
    INNER JOIN salesreps   mng ON o.office = mng.rep_office
GROUP BY
    o.office,
    o.city
HAVING
    COUNT(mng.rep_office) > 3;

--4. Вивести середній вік по офісу

SELECT
    AVG(age),
    o.city
FROM
    salesreps   emp
    INNER JOIN offices     o ON o.office = emp.rep_office
GROUP BY
    o.city;

--5. Дати перелік виробників що виготовляють більше 4-ьох товарів

SELECT
    p.mfr_id,
    COUNT(product_id)
FROM
    products p
GROUP BY
    p.mfr_id
HAVING
    COUNT(p.product_id) > 4;

--6. Дати загальну кільсть товарів, що зберігаються на складі по виробникам що виготовляють більше 4-ьох товарів

SELECT
    mfr_id,
    SUM(qty_on_hand),
    COUNT(product_id)
FROM
    products
GROUP BY
    mfr_id
HAVING
    COUNT(product_id) > 4;

--7. Вивести імя компанії, скільки вона тратила в середньому на покупки товарів виробників, котрі виготовляють більше 4-ьох товарів

SELECT
    company,
    AVG(amount)
FROM
    customers   cus
    INNER JOIN orders      o ON cus.cust_num = o.cust
    INNER JOIN products    p ON o.product = p.product_id
WHERE
    o.mfr IN (
        SELECT
            mfr_id
        FROM
            products
        GROUP BY
            mfr_id
        HAVING
            COUNT(product_id) > 4
    )
GROUP BY
    cus.company,
    o.mfr; 

--8. Вивести скільки мінімально і максимально замовлень (ордерів) виконували менеджери що мають в прямому підпорядкуванні більше двух людей

SELECT
    MIN(num_ord),
    MAX(num_ord)
FROM
    (
        SELECT
            COUNT(order_num) AS num_ord
        FROM
            orders
        WHERE
            rep IN (
                SELECT
                    manager
                FROM
                    salesreps
                GROUP BY
                    manager
                HAVING
                    COUNT(empl_num) > 2
            )
        GROUP BY
            rep
    );

--9. Знайти продукти в яких буква "а" зустрічається більше 2-ух раз
--I tried it, but it does not work. I do not know why.

SELECT
    *
FROM
    products p
WHERE
    REGEXP_LIKE ( p.description,'а{2,}' );

select* from products where description like '%а%а%';
                  
--на табличках girls|boys зробить insert|update|delete. По два запити кожного типу з різною логікою

INSERT INTO boys (
    nm,
    name,
    city
) VALUES (
    '7',
    'Sanya',
    'Kyiv'
);

INSERT INTO girls (
    nm,
    name,
    city
) VALUES (
    '12',
    'Lessya',
    'Kyiv'
);

UPDATE boys
SET
    city = 'Minsk'
WHERE
    name = 'George'
    OR name = 'Sanya';

UPDATE girls
SET
    city = 'kiev'
WHERE
    nm IN (
        SELECT
            b.nm
        FROM
            boys b
        WHERE
            b.nm > 5
    );

DELETE FROM girls
WHERE
    city IS NULL;

DELETE FROM boys
WHERE
    name = 'George';
    
-- зробити пару прикладів з селектами    
    SELECT
    *
FROM
    customers
WHERE
    cust_num IN (
        SELECT
            cust_num
        FROM
            customers
        WHERE
            credit_limit > '30,000'
    );

--виберемо всі замовлення з таблиці Orders, додавши до них інформацію про товар:

SELECT
    order_date,
    product,
    (
        SELECT
            description
        FROM
            products p
        WHERE
            p.product_id = orders.product
    ) AS product
FROM
    orders;

--всі компаннії у яких немає замовлень

SELECT
    *
FROM
    customers
WHERE
    cust_num NOT IN (
        SELECT
            cust
        FROM
            orders
    );