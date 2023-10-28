![](https://github.com/vishalrajbanti/foodDeliveryPlatform/blob/main/food-delivery.jpg)

# Food Delivery Platform Application

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#Technologies-Used)
- [Data Models](#Data-Models)
- [Project Structure](#Project-Structure)
- [Controllers](#Controllers)
- [API Endpoints](#API-Endpoints)
- [Authentication](#Authentication)
- [Project Summary](#Project-Summary)

- [Acknowledgments](#Acknowledgments)
- [Support ](#Support)



### Overview
This Food Delivery Platform Application  is designed to handle various types of relationships ( many-to-one, and many-to-many) among data models and provide CRUD (Create, Read, Update, Delete) operations for each model. The portal includes models for Admin, User, FoodItem,  and Order, along with their relationships.

### Technologies Used
- Framework: Spring Boot
- Language: Java
- Database: MySQL
- Dependency Management: Maven
- Deployment : AWS
### Data Models
### User
- Represents a user of the application.
- Contains fields for user information:
    - id
    - Name
    - Email
    - Password
### Order
- Represents a user's order.
- Contains fields for order information:
    -  ID
    -  User (the associated user)
### Admin
- Represents a Admin of the application.
- Contains fields for Admin information:
    - id
    - Name
    - Email(@Admin)
    - Password
  ### FoodItem
- Represents FoodItem of the application.
- Contains fields for Fooditem information:
    - itemId
    - Name
    - Description
    - Password
    - Admin (the associated Admin)
### AuthenticationToken
- Represents an authentication token for user sessions.
- Contains fields for token information:
    - Token ID
    - Token
    - Token Creation Date
    - User (the associated user)

### Project Structure
The project structure is organized as follows:

- src/main/java: Contains the Java source code.
- com.example.FoodDeliveryApp.controller: Contains controller classes for handling HTTP requests.
- com.example.FoodDeliveryApp.model: Contains entity classes for the data models.
- com.example.FoodDeliveryApp.repository: Contains repository interfaces for database operations.
- com.example.FoodDeliveryApp.service: Contains service classes for business logic.
- src/main/resources: Contains application configuration files, including application.properties or application.yml.
- src/test: Contains test classes.
- Setup
  Clone the repository to your local machine:

- bash
- Copy code
- git clone
    - https://github.com/vishalrajbanti/foodDeliveryPlatform.git
- Open the project in your chosen IDE.

- Configure your database connection in the application.properties or application.yml file.

- Run the Spring Boot application.

## Controllers
### UserController
This controller handles user and order related operations:

- Sign In: Allows users to sign in by providing valid credentials.
- Sign Up: Allows new users to create an account.
- sign OUt: Allows signIn user to signOut.
- Update User Details: Enables users to update their profile information.
- Add order: only user allowed give an order.
### AdminController
This controller handles Admin and FoodItem related operations:

- Add Admin: add admin .
- Add FoodItem : only Admin can add FoodItems.
- Update FoodItem : only Admin can update foodItems.
- Delete FoodItem : only Admin can delete FoodItems.
## API Endpoints
### User Endpoints
- POST   user/signin : Sign in with user credentials.
- POST   user/signup: Create a new user account.
- DELETE user/signOut : sign out a sign in user.
- POST   placeorder : place order by order id.
- GET    order/user/id/{id} : get all order of a user by user id.
- DELETE order/id/{id} : delete a order by order id.

### Admin Endpoints
- POST admin : add a new admin.
- POST fooditem : add a fooditem by admin.
- PUT  foodItem/{itemId} : update a food item by admin using food item id.
- DELETE foodItem/{itemId} : delete a fooditem by admin using fooditem id.
- GET order : get all orders by admin.
## Authentication
- User authentication is required for most endpoints.
- Use the token received during sign-in for all user operations.



## Project Summary
- This Food Delivery Platform Application is built using Spring Boot and Java.
- It allows users to perform CRUD operations on User,Admin,Order and FoodItem entities.
- The project follows a structured architecture with controllers, services, and repositories.
- Data is stored in a MySQL database with appropriate relationships.
- Deployed on AWS server.

## Acknowledgments

We would like to express our gratitude to the following individuals and projects for their contributions and support to the Employee Address Application :

- **[Vishal Raj]**: Lead developer and project coordinator.
- **[Mainak Ghosh]**: Contributor to the project, helping with [SpringBoot to complete this project].
- **[maven]**: We utilized [maven] for [dependencies] in our project.
- **Stack Overflow Community**: For their invaluable assistance in resolving technical challenges.
- **SpringBoot Framework**: For providing a robust and efficient platform for building our application.
- **AWS**: for proving a public server to deploy the Application.

We appreciate the  effort and support that made this project possible.



## Support

For support, email vishalrajbanti@gmail.com.

## thank you.





