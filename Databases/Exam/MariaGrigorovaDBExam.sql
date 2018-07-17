/*
* DB Exam - Maria Grigorova 
*/

-- Write a SQL query to find the top 3 most expensive products. Display their product name and price.
SELECT p.`ProductName`, FORMAT(p.`UnitPrice`, 2) as UnitPrice
FROM products p
ORDER BY p.`UnitPrice` DESC
LIMIT 3;

-- Write a SQL query to find the top 5 (ordered alphabetically by product name) products along with their supplier company name.
SELECT p.`ProductName`, s.`CompanyName` 
FROM products p
JOIN suppliers s ON p.`SupplierID` = s.`SupplierID`
ORDER BY p.`ProductName`
LIMIT 5;

-- Write a SQL query to find all managers that have more than 2 employees. Display their first name and last name.
SELECT e.`FirstName`, e.`LastName`
FROM employees m
JOIN employees e ON m.`ReportsTo` = e.`EmployeeID`
GROUP BY m.`ReportsTo`
HAVING COUNT(*) > 2
ORDER BY e.`FirstName`;

-- Write a SQL query to find the product name, unit price and category name of the products (ordered by unit price) that have the max unit price in their category. 
SELECT p.`ProductName`, FORMAT(p.`UnitPrice`, 2) as UnitPrice, c.`CategoryName` 
FROM (SELECT MAX(pr.`UnitPrice`) as maxPrice, pr.categoryid
		FROM products pr
		GROUP by pr.categoryID) x
JOIN products p ON x.maxPrice = p.`UnitPrice` AND x.`CategoryID` = p.`CategoryID`
JOIN categories c ON p.`CategoryID` = c.`CategoryID`
ORDER BY p.`UnitPrice`;

-- Write a SQL query to display the shipper's company name with minimum orders.
-- Solution 1:
SELECT s.`CompanyName`
FROM  shippers s
JOIN orders o ON s.`ShipperID` = o.`ShipVia`
GROUP BY o.`ShipVia`
HAVING count(*) = (SELECT MIN(cnt) 
					FROM ( SELECT COUNT(*) as cnt
						FROM orders ord
						GROUP BY ord.`ShipVia`) x );

