import random
import csv
from datetime import datetime, timedelta

# Define the possible values for cashier name and payment method
cashier_names = ["Sally", "Suzy", "Bob", "Brandon"]
payment_methods = ["cash", "card", "check"]

# Define the date range for 2023
start_date = datetime(2023, 1, 1)
end_date = datetime(2023, 12, 31)

# Create a list to store the sales data
sales_data = []

# Generate customer IDs (6-digit numbers)
customer_ids = [random.randint(100000, 999999) for _ in range(300)]

# Generate cashier salaries
cashier_salaries = {
    "Sally": round(random.uniform(50000, 70000), 2),
    "Suzy": round(random.uniform(50000, 70000), 2),
    "Bob": round(random.uniform(50000, 70000), 2),
    "Brandon": round(random.uniform(50000, 70000), 2)
}

# Generate sales data for the entire year 2023
while start_date <= end_date:
    num_orders = round(random.triangular(5, 200, (30+100)/2))  # Adjust the range as needed
    
    # Generate random sales data for each order on the same day
    for _ in range(num_orders):
        order_id = random.randint(10000, 99999)
        order_total = round(random.triangular(5, 25, 10), 2)
        date = start_date.strftime("%Y-%m-%d")
        cashier_name = random.choice(cashier_names)
        payment_method = random.choice(payment_methods)
        customer_id = random.choice(customer_ids)
        role = "cashier"
        cashier_salary = cashier_salaries[cashier_name]
        
        sales_data.append([order_id, order_total, date, cashier_name, payment_method, customer_id, role, cashier_salary])
    
    start_date += timedelta(days=1)

# Write the generated data to a CSV file
with open('sales_data_2023.csv', mode='w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['Order ID', 'Order Total', 'Date', 'Cashier Name', 'Payment Method', 'Customer ID', 'Role', 'Cashier Salary'])
    writer.writerows(sales_data)

print("Sales data for 2023 with varying order counts generated and saved to 'sales_data_2023.csv'")
