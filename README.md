# E-Commerce-Backend
Java API using JPA, MySQL, and Spring
Project Note:
Please note that this API uses apitokens that are automatically generated. Please create admin account first and make sure username=”admin” (example below). To create admin account, use add user API below.
Before:
{
    "username": "admin",
    "password": "changing",
    "email": "null",
    "phone_number": 0
}

After
{
    "apitoken": 7071155170911479,
    "username": "admin",
    "password": "changing",
    "email": "null",
    "phone_number": 0
}

Database Setup:
CREATE DATABASE phase3project;
Create table product (productid int  AUTO_INCREMENT, season varchar(20), brand varchar(20), category varchar(20), price decimal(10,2), color varchar(20), createddate  date, discount int, PRIMARY KEY (productid));
 
Create table user (apitoken BIGINT, username varchar(20), password varchar(20), email varchar(40), phone_number BIGINT, PRIMARY KEY (apitoken));

Create table purchase(purchaseid int AUTO_INCREMENT, usertoken BIGINT, productid int, purchasedate date, category varchar(20), FOREIGN KEY (usertoken) REFERENCES user(apitoken), FOREIGN KEY (productid) REFERENCES product(productid), PRIMARY KEY (purchaseid));
 
To Run:
Maven clean -> Maven Install -> Spring Boot APP
Once project is running use links below to use API.
Link: http://localhost:8080/
product
* all
    * Description: Get all products
    * Link: http://localhost:8080/product/all
    * Type: GET
* {id}
    * Description: Find product using productid
    * Link: http://localhost:8080/product/{id}
    * Example: http://localhost:8080/product/1
    * Type: GET
* season/{season}
    * Description: Find Product based on season
    * Link: http://localhost:8080/product/season/{season}
    * Example: http://localhost:8080/product/season/fall
    * Type: GET
* brand/{brand}
    * Description: Find Product based on brand
    * Link: http://localhost:8080/product/brand/{brand}
    * Example: http://localhost:8080/product/brand/nike
    * Type: GET
* category/{category}
    * Description: Find product based on gender
    * Link: http://localhost:8080/product/category/{category}
    * Example: http://localhost:8080/product/category/male
    * Type: GET
* price/{price}
    * Description: Find product based on price
    * Link: http://localhost:8080/product/price/{price}
    * Example: http://localhost:8080/product/price/42069
    * Type: GET
* price/ascending
    * Description: Find product by price sorted ascending
    * Link: http://localhost:8080/product/price/ascending
    * Type: GET
* price/descending
    * Description: Find product by price sorted descending
    * Link: http://localhost:8080/product/price/descending
    * Type: GET
* color/{color}
    * Description: Find product by color
    * Link: http://localhost:8080/product/color/{color}
    * Example: http://localhost:8080/product/color/red
    * Type: GET
* date/{date}
    * Description: Find product by date
    * Link: http://localhost:8080/product/date/{date}
    * Example: http://localhost:8080/product/date/2021-09-08
    * Type: GET
* date/ascending
    * Description: Find product by date sorted ascending
    * Link: http://localhost:8080/product/date/ascending
    * Type: GET
* date/descending
    * Description: Find product by date sorted descending
    * Link: http://localhost:8080/product/date/descending
    * Type: GET
user:
* {token}/resetpassword
    * Description: Reset or change password for a user using apitoken
    * Link: http://localhost:8080/user/{token}/resetpassword
    * Example: http://localhost:8080/user/7071155170911479/resetpassword
    * Type: PUT
    * Example json:
{
    "username": "admin",
    "password":"admin",
    "email":"null",
    "phone_number": null
}

* {token}/allusers
    * Description: Admin only – Get all users
    * Link: http://localhost:8080/user/{token}/allusers
    * Example: http://localhost:8080/user/7071155170911479/allusers
    * Type: GET
* add
    * Description: Create a user. Note: Do not add apitoken as it is automatically generated
    * Link: http://localhost:8080/user/add
    * Example: http://localhost:8080/user/add
    * Type: POST
    * Example json:
{
    "username": "mrwish",
    "password":"hibachi",
    "email":"hibachiexpress@gmail.com",
    "phone_number": 911
}

* {token}
    * Description: Search for specific user
    * Link: http://localhost:8080/user/{token}
    * Example: http://localhost:8080/user/7071155170911479
    * Type: GET
* {token}/product/add
    * Description: Admin only – Create and add product
    * Link: http://localhost:8080/user/{token}/product/add
    * Example: http://localhost:8080/user/7071155170911479/product/add
    * Type: PUT
    * Example json:
{
   "season": "fall",
   "brand":"nike",
   "category":"transgender",
   "price":42069,
   "color":"fucsia",
   "createddate": "2021-09-07",
   "discount": 69
}
* {token}/product/all
    * Description: Admin only – Get all products
    * Link: http://localhost:8080/user/{token}/product/all
    * Example: http://localhost:8080/user/7071155170911479/product/all
    * Type: GET
* {token}/product/update/{id}
    * Description: Admin only – Update product details using product id
    * Link: http://localhost:8080/user/{token}/product/update/{id}
    * Example: http://localhost:8080/user/7071155170911479/product/update/1
    * Type: PUT
    * Example json:
{
   "season": "winter",
   "brand":"samsung",
   "category":"male",
   "price":690069,
   "color":"dark grey",
   "createddate": "2006-06-06",
   "discount": 42
}
* {token}/product/delete/{id}
    * Description: Admin only – Delete specified product using product id
    * Link: http://localhost:8080/user/{token}/product/delete/{id}
    * Example: http://localhost:8080/user/7071155170911479/product/delete/2
    * Type: DELETE
* {token}/purchase/{id}
    * Description: Any user can purchase product with product id
    * Link: http://localhost:8080/user/{token}/purchase/{id}
    * Example: http://localhost:8080/user/7071155170911479/purchase/2
    * Type: GET
* {token}/purchase/all/date/ascending
    * Description: Admin only – Get purchases based on date ascending
    * Link: http://localhost:8080/user/{token}/purchase/all/date/ascending
    * Example: http://localhost:8080/user/7071155170911479/purchase/all/date/ascending
    * Type: GET
* {token}/purchase/all/date/descending
    * Description: Admin only – Get purchases based on date descending
    * Link: http://localhost:8080/user/{token}/purchase/all/date/descending
    * Example: http://localhost:8080/user/7071155170911479/purchase/all/date/descending
    * Type: GET
* {token}/purchase/all/category/ascending
    * Description: Admin only – Get purchases based on category (gender) ascending
    * Link: http://localhost:8080/user/{token}/purchase/all/category/ascending
    * Example: http://localhost:8080/user/7071155170911479/purchase/all/category/ascending
    * Type: GET
* {token}/purchase/all/category/descending
    * Description: Admin only – Get purchases based on category (gender) descending
    * Link: http://localhost:8080/user/{token}/purchase/all/category/descending
    * Example: http://localhost:8080/user/7071155170911479/purchase/all/category/descending
    * Type: GET
