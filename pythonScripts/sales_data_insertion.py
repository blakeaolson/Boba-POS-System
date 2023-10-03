import csv
import psycopg2

# PostgreSQL database connection parameters
db_params = {
    "host": "csce-315-db.engr.tamu.edu",
    "database": "csce315331_08b_db",
    "user": "csce315_971_blakeolson",
    "password": "password",
}

# Open the CSV file for reading
with open("sales_data_2023.csv", "r") as csvfile:
    csvreader = csv.reader(csvfile)

    # Connect to the PostgreSQL database
    conn = psycopg2.connect(**db_params)
    cursor = conn.cursor()

    # Create a temporary table for bulk insert
    cursor.execute("""
            CREATE TABLE temp_sales_data (
                "Order ID" int,
                "Order Total" varchar(255),
                "Date" varchar(255),
                "Cashier Name" varchar(255),
                "Payment Method" varchar(255),
                "Customer ID" int,
                "Role" varchar(255),
                "Cashier Salary" varchar(255),
                "Customer Name" varchar(255)
            )
        """)

    cursor.copy_expert(
        sql='COPY temp_sales_data ("Order ID", "Order Total", "Date", "Cashier Name", "Payment Method", "Customer ID", "Role", "Cashier Salary", "Customer Name") FROM STDIN CSV HEADER',
        file=csvfile
    )

    # Insert data from the temporary table into Employees and Orders tables
    cursor.execute("""
            INSERT INTO Employees (ID, EmployeeName, Salary, EmployeeRole)
            SELECT "Customer ID", "Cashier Name", "Cashier Salary", "Role" FROM temp_sales_data
        """)

    cursor.execute("""
            INSERT INTO Orders (ID, TotalAmount, OrderDate, CashierName, PaymentMethod)
            SELECT "Order ID", "Order Total", "Date", "Cashier Name", "Payment Method" FROM temp_sales_data
        """)
    cursor.execute("""
                INSERT INTO Customer (ID, CustomerName, PaymentMethod)
                SELECT "Customer ID", "Customer Name", "Payment Method" FROM temp_sales_data
            """)

    # Commit the transaction
    conn.commit()

    # Close the database connection
    conn.close()

print("Data has been successfully inserted into the PostgreSQL database.")