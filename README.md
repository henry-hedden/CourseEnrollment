Programming II Final Project: Course Registration System
========================================================

Henry Hedden

Program Description:
--------------------

This is a **Course Registration System**, intended to be used by students to
sign up for classes. It will allow a student to sign in and view a course
listing. The student will then be able to select courses to add or drop. If
for some reason, the student is unable to add or drop the selected course--for
example, if the course number is mistyped--the program will refuse display
an error message explaining why.

Class Descriptions
------------------

The classes in this project are as follows:

+ [Person][]
  - [firstName][]: String
  - [lastName][]: String
+ [Student][] (inherits Person)
  - ID: int
  - password: String
  - major
+ [Teacher][] (inherits Person)
  - [office][]: Room
+ [Course][]
  - [dept][]: Department
  - [hall][]: Room
  - [name][]: String
  - [num][CourseNum]: int
  - [professor][]: Teacher
+ [Room][]
  - [bldg][]: String
  - [num][RoomNum]: int
+ [Department][] (enum)
+ [Time][] (used by Teacher and Course to represent schedules)
  *I might not need it*
+ [Client][] (driver class)
+ [GUIClient][] (driver class with GUI) *unused*
+ [Database][] (Stores data about classes, teachers, and students)

The `Person` class is a class that will be inherited by both the
`Student` and `Teacher` Classes. It will have two instance variables:
`firstName` and `lastName` (both Strings). It will have two subclasses:
`Teacher` and `Student`.

The `Course` class will have seven instance variables:
`name` (String), `number` (int), `teacher` (`Teacher` object), `room` (`Room`
object), `startTime` and `endTime` (`Time` objects), and `seats` (int).

The `Time` class will have two instance variables, `hours` and `minutes`. In
addition to the constructors and accessor methods, it will also have a
`compareTo` method, and a `toString` method which displays the time in hh:mm
format.

The `Client` class will handle input and output, and the user interface.
In addition to the `main` method, it will also contain global variables. The
`Student` class will also extend the `Person` class, will have the additional
instance variables `ID`, `passwords`, and `major`.

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

When the program is started, it will greet the user and ask them to log in. If
the user enters the correct login information, it will display the following
list of options:

* View Course Listing
* View a Course Description
* View Current Schedule
* Add a Course
* Drop a Course
* Quit

The program will notify the user if they attempt to perform an action that is
disallowed, for example dropping a course they haven't signed up for. When
they are done, the user can select the "Quit" option, at which point the
program will prompt them to make sure they are sure.

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

### Assumptions ###

* Courses start and end at the same time each day of the week.
* One section of each course
* No scheduling conflict for professors or rooms
* All courses are the same size (?)

### New Skills Needed ###

* Enum `toString()`

[Person]: javadoc/courseenrollment/Person.html "Person"
[firstName]: javadoc/courseenrollment/Person.html#firstName "Person.firstName"
[lastName]: javadoc/courseenrollment/Person.html#lastName "Person.lastName"

[Student]: javadoc/courseenrollment/Student.html "Student"

[Teacher]: javadoc/courseenrollment/Teacher.html "Teacher"
[office]: javadoc/courseenrollment/Teacher.html#office "Teacher.office"

[Course]: javadoc/courseenrollment/Course.html "Course"
[dept]: javadoc/courseenrollment/Course.html#dept "Course.dept"
[hall]: javadoc/courseenrollment/Course.html#hall "Course.hall"
[name]: javadoc/courseenrollment/Course.html#name "Course.name"
[CourseNum]: javadoc/courseenrollment/Course.html#num "Course.num"
[professor]: javadoc/courseenrollment/Course.html#professor "Course.professor"

[Room]: javadoc/courseenrollment/Room.html "Room"
[bldg]: javadoc/courseenrollment/Room.html#bldg "Room.bldg"
[RoomNum]: javadoc/courseenrollment/Room.html#num "Room.num"

[Department]: javadoc/courseenrollment/Department.html "Department"

[Time]: javadoc/courseenrollment/Time.html "Time"

[Client]: javadoc/courseenrollment/Client.html "Client"

[GUIClient]: javadoc/courseenrollment/GUIClient.html "GUIClient"

[Database]: javadoc/courseenrollment/Database.html "Database"
