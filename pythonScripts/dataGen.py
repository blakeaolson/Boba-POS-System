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

# Generate 52 weeks of sales data
for week in range(1, 53):
    # Generate random sales data for each day in the week
    for _ in range(7):
        order_id = random.randint(1, 100000)
        # Generate order total with higher probability in the range of $5 to $15
        order_total = round(random.triangular(5, 15, 10), 2)
        date = start_date.strftime("%Y-%m-%d")
        cashier_name = random.choice(cashier_names)
        payment_method = random.choice(payment_methods)
        sales_data.append([order_id, order_total, date, cashier_name, payment_method])
        start_date += timedelta(days=1)

# Write the generated data to a CSV file
with open('sales_data_2023.csv', mode='w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['Order ID', 'Order Total', 'Date', 'Cashier Name', 'Payment Method'])
    writer.writerows(sales_data)

print("Sales data for 2023 generated and saved to 'sales_data_2023.csv'")