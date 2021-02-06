# Online shop with cosmetics [![Build status](https://github.com/justynakuznikk/beauty-shop/workflows/Build/badge.svg)](https://github.com/justynakuznikk/beauty-shop/actions)

The project involves the creation of an application that allows adding products to the store via an administration panel. The system should enable the user to register and log in, as well as place an order.

## Main features of the system
* Login Panel.
* Admin:
  * Adding categories for products.
  * Category tree overview.
  * Adding products.
  * List of products + editing.
* User:
  * Registration.
  * Products list.
  
## General guidelines
Building a service using Spring Boot, JPA and Thymeleaf as view layer. Introducing division in application into commands , services, controllers and placing appropriate logic in each of them. Securing access to the application and functionality using Spring Security.  

## Entities
* Category
  * name
  * main and subordinate categories (location in the tree)
* User Account
  * login (email)
  * password (hash)
  * city
  * address (country, city, street, postcode)
  * roles (ADMIN/USER entity)
* Product
  * title
  * description
  * thumbnail (url)
  * category (entity)
  * price
  * product type (enum)
* Order
  * username
  * total cost
  * delivery address
  * user address
  * date submitted
  * order lines (entities)
  * customer (entity)
  * status (entity)
  
## Admin features
* Adding a category
* Category tree overview
* Adding a product
* List of products

## User features
* User registration
* Logging in
* List of products




  
