#LABB2

## JSON FORMAT
{\
"id": 1,\
"name": "SO",\
"students": [\
{\
"email": "test4@test.se",\
"firstName": "123",\
"id": 2,\
"lastName": "Test4",\
"phoneNumber": "1234567891"\
},\
{\
"email": "test4@test.se",\
"firstName": "123",\
"id": 1,\
"lastName": "Test4",\
"phoneNumber": "1234567891"\
}\
],\
"teacher": {\
"firstName": "Oscar",\
"id": 1,\
"lastName": "Stjernfeldt"\
}\
}

## ENDPOINTS
####_______________________________________________________________

### Students
\
Create students: localhost:8080/sms/students/ (POST)

Get Students: localhost:8080/sms/students/ (GET)

Get students by lastname: localhost:8080/sms/students/query, med query "LastName" (GET)

Patch student: localhost:8080/sms/students/{id} (PATCH)

Update student: localhost:8080/sms/students/{id} (PUT)

Get student by ID: localhost:8080/sms/students/{id} (GET)

Delete student: localhost:8080/sms/students/{id} (DELETE)
####_______________________________________________________________


### Teacher
\
Create teachers: localhost:8080/sms/teachers/ (POST)

Get Students: localhost:8080/sms/teachers/ (GET)

Get teachers by lastname: localhost:8080/sms/teachers/query, med query "LastName" (GET)

Patch teacher: localhost:8080/sms/teachers/{id} (PATCH)

Update teacher: localhost:8080/sms/teachers/{id} (PUT)

Get teacher by ID: localhost:8080/sms/teachers/{id} (GET)

Delete teacher: localhost:8080/sms/teachers/{id} (DELETE)
####_______________________________________________________________

### Subject
\
Create subject: localhost:8080/sms/subjects/

Get all subjects: localhost:8080/sms/subjects/

Patch subject: localhost:8080/sms/subjects/{id}

Get subject by id: localhost:8080/sms/subjects/{id}

Get all students in subject: localhost:8080/sms/subjects/{id}/students

Delete subject: localhost:8080/sms/subjects/{id}
####_______________________________________________________________
##Order of endpoints
För att skapa ett subject behöver du skapa student och teacher. 
1. Skapa students
2. Skapa teacher 
3. Skapa subject
###_______________________________________________________________
#LABB1
## JSON FORMAT

{\
"email": "test4@test.se",\
"firstName": "123",\
"id": 1,\
"lastName": "Test4",\
"phoneNumber": "1234567891"\
}

## ENDPOINTS

Create teachers: localhost:8080/sms/students/ (POST)

Get Students: localhost:8080/sms/students/ (GET)

Get students by lastname: localhost:8080/sms/students/query, med query "LastName" (GET)

Patch student: localhost:8080/sms/students/{id} (PATCH)

Update student: localhost:8080/sms/students/{id} (PUT)

Get student by ID: localhost:8080/sms/students/{id} (GET)

Delete student: localhost:8080/sms/students/{id} (DELETE)

## GROUPMATE

Jag har jobbat tillsammans med Christian och vi har använt oss av code-with-me i IntelliJ.
Vi har skriv lite här och där så svårt att säga vilka metoder som är gjorda av vem. Men samarbetet funkade bra.

## PROBLEMS

Jag fick lite problem att lösa exceptions mot slutet. Att få rätt exceptions vid rätt fel ock så vidare.