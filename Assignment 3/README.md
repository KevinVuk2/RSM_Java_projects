# Project Title: Orange Inc. - Business Sales and Revenue Forecaster
A Java application that performs a business analysis task by calculating current revenue and forecasting future sales and revenue for a portfolio of products. This project was completed for the BMME008 - Programming for Managers course.

# Project Goal

This program simulates a business analyst's task for a fictional company, "Orange Inc." Using a given dataset of five products, the program calculates two key metrics:
1. Total Revenue for 2024: Based on the per-unit price and the number of units sold.
2. Projected Revenue for 2035: By first forecasting the sales volume for each product using its unique annual growth rate, and then calculating the resulting revenue.

# Core Logic & Implementation

The program uses fundamental programming concepts to model the business scenario:
1. Data Management: Three arrays are used to store the initial product data: productPrice, productSales2024, and growthRate.
2. Revenue Calculation: A for loop iterates through the products to calculate the revenue for each one in 2024, which are then summed to find the total.
3. Sales Projection: A dedicated method, ProjSales, calculates the projected sales for 2035 using the compound growth formula:

Generated code
ProjectedSales = BaseSales * (1 + growthRate / 100) ^ numberOfYears

The Math.pow() function is used for the exponentiation.

- Revenue Forecasting: A final loop uses the projected sales for 2035 and the original prices to calculate the total projected revenue.

# Input Data

The analysis is based on the following product data:

![image](https://github.com/user-attachments/assets/f731d0e1-ed34-429d-b2e7-6e57c550bba0)

