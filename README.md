# database
this demo describe on how you can connect a spring boot application to database
by using spring data JPA. The main implementation of JpaRepository is Hibernate System
implemented in spring boot framework.

#A list of command for testing these APIS.. i wrote on the way you can copy and paste
in your terminal

#curl -X GET http://electricapp.test:8080/books

#curl -X GET http://electricapp.test:8080/books/get?id=<any 1-5>

#curl -X POST http://electricapp.test:8080/books -H "content-type:application/json" -d "{\"title\":\"Data Structure\",\"author\":\" sandra pichal\"}"



#curl -X PUT http://electricapp.test:8080/books/update?id=<any 1-5>-H "content-type:application/json" -d "{\"title\":\"Data Structure\",\"author\":\" sandra pichal\"}"

