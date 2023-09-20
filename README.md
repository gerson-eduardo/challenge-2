<h1>CHALLENGE 2 - WEEK VIII</h1>
<h2>Microservices Design with Specific Interactions</h2>

<p>
  <h3>About ms-auth-and-auto</h3>
    <p>- The general aspect of this microservice is managing user registration and creating a link between a user added to the system and their authorization to a microservice.</p>
    <p>- Users can be added through the request made in the following path POST: /ms-auth-and-auto/api/users/. Your name, email and password must be provided.A Logic was implemented that does not allow the           addition of more than one user with the same email.</p>
    <p>- A user can be linked to a microservice through the following PUT request: /ms-auth-and-auto/api/users/{Id-user}/microsservice/{id_microservice}. Initially, the user will only be registered as a user         of the microservice to which it was added.</p>
    <p>-Via the GET request: /ms-auth-and-auto/api/users/. All users and the microservices to which they have access will be listed. Your role will also be returned. Data Access Objects (DTO) and Mappers           were used to enable the projection of users' sensitive data.</p>
    <p>- It is also possible to make the GET request: /ms-auth-and-auto/api/users/{id_user} to obtain the occurrence of a specific user.</p>
    <p>- It is possible to delete a user's occurrence using a delete request: /ms-auth-and-auto/api/users/{id_user}. Where the user will be deleted from the database and disconnected from all microservices.</p>

</p>

<p>
  <h3>About the ms-scholar-b</h3>
  <p>- The general purpose of the ms-scholar microservice is to consume functions provided by the core ms-auth-and-auto microservice.</p>
  <p>- Using Openfeign, other microservices can make a request to the center. That way:</p>
  <p>- With the GET request made in the following path: /ms-b/api/scholar/{id_user}/microsservice/{id_microserice}. It is possible to obtain permission from the user (user_id) entered and their role in the       microservice (if registered in it).</p>
  <p>- It is possible to obtain a list of all users and their roles in a given microservice through the GET request: /ms-b/api/scholar/microsservice/{id_microsservice}.</p>
  <p>- The role of a user registered in a microservice can be updated in the following POST request: ms-auth-and-auto/api/users/id_user/updateRole/id_microsservice/string_role. String role is "User" or "Admin".</p>

</p>
<p>
  <h3>About the ms-scholar-d</h3>
  <p>- The general purpose of the ms-scholar microservice is to consume functions provided by the core ms-auth-and-auto microservice.</p>
  <p>- Using Openfeign, other microservices can make a request to the center. That way:</p>
  <p>- With the GET request made in the following path: :8084/ms-d/api/scholar/{id_user}/microsservice/{id_microserice}. It is possible to obtain permission from the user (user_id) entered and their role in the       microservice (if registered in it).</p>
  <p>- It is possible to obtain a list of all users and their roles in a given microservice through the GET request: /ms-d/api/scholar/microsservice/{id_microsservice}.</p>
  <p>- The role of a user registered in a microservice can be updated in the following POST request: ms-auth-and-auto/api/users/id_user/updateRole/id_microsservice/string_role. String role is "User" or "Admin".</p>
</p>
