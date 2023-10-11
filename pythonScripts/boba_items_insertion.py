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
with open("boba_items.csv", "r") as csvfile:
    csvreader = csv.reader(csvfile)

    # Connect to the PostgreSQL database
    conn = psycopg2.connect(**db_params)
    cursor = conn.cursor()

    # Iterate through the CSV rows and insert data into respective tables
    for row in csvreader:
        item_name, item_category, quantity = row

        # Insert data into the Inventory table
        cursor.execute("INSERT INTO Inventory (ItemId, ItemCategory, Quantity) VALUES (%s, %s, %s)",
                       (item_name, item_category, int(quantity)))

        # Insert data into the Suppliers table
        cursor.execute("INSERT INTO Suppliers (Item, Quantity) VALUES (%s, %s)",
                       (item_name, int(quantity)))

        # Commit the transaction after each row
        conn.commit()

    # Close the database connection
    conn.close()

print("Data has been successfully inserted into the PostgreSQL database.")