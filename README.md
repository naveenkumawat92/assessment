# assessment

Following are the Instructions to execute this code;
1. open cmd and run first mvn clean install
2. After successful build run this command - mvn spring-boot:run


3. ==========To generate a new question ================

curl --location --request GET 'http://localhost:8080/get/question'




4. =================To verify user answer =====================

curl --location --request POST 'http://localhost:8080/verify/answer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "answer": "22"
}'
