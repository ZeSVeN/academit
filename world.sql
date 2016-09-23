-- Все строки, но только столбцы name и district
SELECT Name, District FROM city;
-- Только русские города отсортированные по имени
SELECT Name FROM city
WHERE CountryCode='RUS'
ORDER BY Name;
-- Города из Испании, Португалии и Греции отсортированные по имение в обратном порядке
SELECT Name, CountryCode FROM city
WHERE CountryCode='ESP' OR CountryCode='PRT' OR CountryCode='GRC'
ORDER BY Name desc;
-- Города с населением от 300000 до 500000
SELECT Name, Population FROM city
WHERE Population BETWEEN 300000 AND 500000;
-- Города начинающиеся с буквы "А"
SELECT Name FROM CITY
WHERE Name LIKE 'a%';
-- Города, в названии которых есть "А"
SELECT Name FROM city
WHERE Name LIKE '%a%';