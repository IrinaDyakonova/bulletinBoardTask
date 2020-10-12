<h1>Bulletin Board</h1>
<h1>Table of Contents</h1>
<ul>
<li><a href="#project_purpose">Project purpose</a> </li>
<li><a href="#project_structure">Project structure</a> </li>
<li><a href="#for_developer">For developer</a> </li>
<li><a href="#">Author</a> </li>
</ul>
<h1 id="project_purpose">Project purpose</h1>
Development of bulletin board
<hr>

<p>
Registration and logging are required to use the application.<p>
<p>List of available endpoints:</p>
<ul>
<li> 
Personal account. Link: GET /personal-area
</li>
<li> 
Home page. Link: GET /home-page
</li>
<li> 
Create a new advertisement. Link: POST /users/ad-advertisement
</li>
<li> 
Update account. Link: POST /users/update
</li>
</ul>
<h1 id="project_structure">Project structure</h1>
<ul>
<li>Java 11</li>
<li>Maven 3.6.0</li>
<li>maven-checkstyle-plugin 3.1.1</li>
<li>Spring Boot 2.3.1.RELEASE</li>
<li>Spring Security</li>
<li>H2 as main database</li>
<li>Spring Data JPA</li>
<li>Lombok</li>
</ul>

<h1 id="for_developer">For developer</h1>
<ol>
<li>Open the project in your IDE.</li>
<li>Add Java SDK 11 or above in Project Structure.</li>
<li>Connect the database via link http://localhost:8080/h2-console.
<br>username = sa</li>
<li>Change the save files link to the location of the project on your machine in application.properties and UserController</li>
<li>Run the project.</li>
</ol>
<h1 id="author">Author</h1>
Irina Dyakonova: https://github.com/IrinaDyakonova

