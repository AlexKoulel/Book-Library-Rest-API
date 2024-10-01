# Spring Book Library REST API
Spring Book Library is a simple RESTful API built with **Spring Boot** that allows users to manage a collection of books using **CRUD** operations.

## Spring Dependencies Used

- Spring Data JPA
- H2 Database
- Jakarta Validation

## API Endpoints
- GET /api/library: Retrieves a list of all books.
- POST /api/library: Adds a new book to the library.
- PUT /api/library/{id}: Updates an existing book.
- DELETE /api/library/{id}: Deletes a book from the library.

## Request/Response Example

**Create a book (POST */api/library*):**
```sh
{
  "name" : "DUNE",
  "author": "Frank Herbert",
  "pages": 580,
  "isbn": "978-0-340-96019-6",
  "genre": "SCIENCE_FICTION"
}
```
**Response**:
```sh
{
  "id" : 1,
  "name" : "DUNE",
  "author": "Frank Herbert",
  "pages": 580,
  "isbn": "978-0-340-96019-6",
  "genre": "SCIENCE_FICTION"
}
```
