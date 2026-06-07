# 📦 Java Inventory Management System

A console-based Inventory Management System built in Java, developed as a university group project for **BCS 202 / SWS 316** at Canadian University Dubai. The system allows authenticated users to manage product inventory, process sales, track transaction history, view low-stock alerts, and generate revenue reports — all backed by persistent file storage.

---

## ✨ Features

- 🔐 **User Authentication** — Login with username/password validated against a stored user file
- ➕ **Add Products** — Add new products with ID, name, stock, and price
- ✏️ **Update Products** — Modify product ID, name, price, stock (restock), or process a sale
- 🗑️ **Remove Products** — Delete a product from inventory
- 📋 **View Inventory** — Display current stock levels for all products
- 🔍 **Product Detail** — Look up a specific product by ID
- ⚠️ **Low Stock Alerts** — Flag products with stock below threshold
- 📊 **Generate Report** — View a full report of products, quantities sold, and revenue
- 📜 **Transaction History** — Display all restocks and sales for a given product
- 💾 **Persistent Storage** — All data read from and written to flat files (`inventory.txt`, `user.txt`)

---

## 🏗️ Project Structure

```
├── FileHandler.java              # Base class: file read/write/edit operations
├── Product.java                  # Abstract class: product data + CRUD operations
├── Report.java                   # Extends Product, implements TransactionHistory
├── TransactionHistory.java       # Interface: transact, restock, displayHistory
├── Login.java                    # Static login validation from user.txt
├── InventoryManagementSystem.java # Entry point: main menu + user interaction
├── ProductNotFoundException.java  # Custom exception for missing products
├── InvalidLoginException.java     # Custom exception for bad login
├── inventory.txt                 # (required) Flat file storing product data
├── user.txt                      # (required) Flat file storing user credentials
└── test.java                     # Development scratch file (not part of final build)
```

---

## 🧱 Class Design & OOP Concepts

| Concept | Implementation |
|---|---|
| **Inheritance** | `Product` extends `FileHandler`; `Report` extends `Product` |
| **Abstraction** | `Product` is abstract with `generateReport()` as abstract method |
| **Interface** | `TransactionHistory` interface implemented by `Report` |
| **Exception Handling** | Custom `ProductNotFoundException` and `InvalidLoginException`; try-catch throughout |
| **File I/O** | `FileHandler` handles all read/write/edit operations on flat `.txt` files |
| **Arrays** | Products stored in `Object[][]`; transactions in `String[][]` |

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher
- A terminal / command prompt

### Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/java-inventory-management-system.git
   cd java-inventory-management-system
   ```

2. **Create the required data files** in the same directory as the compiled classes:

   **`inventory.txt`** — comma-separated: `id,name,stock,price,sold`
   ```
   p10001,Laptop,50,1200.0,10
   p10002,Mouse,200,25.0,40
   p10003,Keyboard,150,45.0,20
   p10004,Monitor,80,300.0,5
   ```

   **`user.txt`** — comma-separated: `username,password`
   ```
   admin,admin123
   ```

3. **Compile all Java files:**
   ```bash
   javac *.java
   ```

4. **Run the application:**
   ```bash
   java InventoryManagementSystem
   ```

---

## 🖥️ Usage

After logging in, you'll see the main menu:

```
WELCOME
Enter your choice number:
1. Add product
2. Remove Product
3. Update product
4. Display Inventory level
5. Generate Report
6. Product detail
7. Low Stock Products
8. Display transactions
9. EXIT
```

**Update Product** sub-options:
```
1. Product ID
2. Product Name
3. Add to Stock (restock)
4. Product Price
5. Process Sale
```

---

## ⚠️ Known Limitations

- Transaction history is stored **in-memory only** (the `transactions` array in `Report.java` is not persisted to a file between sessions).
- Product IDs must be manually entered and are not auto-generated.
- No duplicate ID validation when adding a new product.

---

## 👥 Team Members

| Student ID | Name |
|---|---|
| 20220002112 | Masa Dkak |
| 20210002264 | Hamdan Habib |
| 20210001983 | Leanne Jessica Rodrigo |
| 20220002458 | Aysha Ejaz |

**Course:** BCS 202 Introduction to Computer Science II / SWS 316 Programming II  
**Institution:** Canadian University Dubai
