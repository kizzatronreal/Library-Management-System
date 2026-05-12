# Library-Management-System

A Java-based library management system that allows users to manage their book collection, track purchases and borrowings, and maintain library card information.

## Features

- **User Profiles**: Create library user accounts with optional library card ownership
- **Book Management**: Track books that are purchased or borrowed
- **Library Card System**: Generate unique library IDs for card-holding members
- **Cost Tracking**: Monitor total spending on books and borrowed book values
- **Book Operations**: Add books, borrow books, return books, and view collections

## Classes

### Book
Represents a book with the following properties:
- `bookName`: Title of the book
- `authorsName`: Author of the book
- `cost`: Price of the book

### Library
Manages library user information and their book collections:
- `fullName`: User's full name
- `libraryId`: Unique ID (generated if library card is owned)
- `libraryCardOwned`: Whether the user has a library card
- `booksPurchased`: Collection of purchased books
- `booksBorrowed`: Collection of borrowed books
- Tracks total spending and costs

## Example Output

The program demonstrates:
- Creating a library user with a library card
- Adding books to purchased and borrowed collections
- Displaying user summary and book lists
- Returning borrowed books and updating totals
