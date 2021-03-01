# A task for nfq internship

First of all, I would like to emphasize that the assigned task requires the knowledge and skills I acquired while studying the program systems of Vilnius University. Reflecting on the final result, I compiled the task course: 

Technical choices:
Used spring boot as it is easy to start with;
Thymeleaf in HTML as it gives more dynamism;
Bootstrap for frontend for pages to look more esthetic.

Solution:
Created a spring boot template and set up a database with initial entities that I thought were necessary:
Project to keep track of the project and student that is linked to the project.

Then Realized I need two pages: a page where projects are shown and a page for each projects' status.

Project page:
At the top you can add a new project by inputting information and clicking the add project button.
Below Projects table with all created projects is shown.
To delete a project click a delete button by the project name.
To go to the projects' status page click on the project id or project name.

Status page:
The project information is shown at the top, Just below is the list of project students, you can add students by writing the name and clicking add student button.
Groups are shown to below the add student button.
To place a student into a group you need to select a group in dropdown and click submit changes button.
To remove: click x in the group by the student name.
To delete students from the project: click delete button in the students table.

All submit, delete, add and other requests were fulfilled by sending information through form action to a post method.
As ajax was not getting the information out of the same id inputs, adding student to group required more practical work, but the ability to take advantage of the existing information I choose an alternative way to send information to post methods.

To further optimize the web I would add a login and improve front-end.
