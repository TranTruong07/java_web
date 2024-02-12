<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="../Views/index.jsp"><i class="fa-solid fa-phone"></i> PhoneBook</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="../Views/index.jsp"><i class="fa-solid fa-house"></i> Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
          <a class="nav-link" href="../Views/addPhone.jsp"><i class="fa-solid fa-square-plus "> &nbsp;</i>Add Phone No</a>
      </li>
      
      <li class="nav-item active">
          <a class="nav-link disabled" href="../Views/viewContact.jsp"><i class="fa-regular fa-eye">&nbsp;</i>View Contact</a>
      </li>
    </ul>
      
      <%User u = (User)session.getAttribute("user");%>
      <%if(u==null){%>
        <form class="form-inline my-2 my-lg-0">
        <a href="../Views/login.jsp" class="btn btn-outline-success "><i class="fa-solid fa-user"></i> Login<a/>
        <a href="../Views/register.jsp" class="btn btn-outline-primary mr-3 ml-2"><i class="fa-regular fa-user"></i> Register<a/>
        </form>
      
        <%}else{%>
        <form class="form-inline my-2 my-lg-0">
        <a href="../Views/index.jsp" class="btn btn-outline-success "><%= u.getName()%><a/>
        <a  data-toggle="modal" data-target="#exampleModal" class="btn btn-danger mr-3 ml-2">Logout<a/>
        </form>
        <%}%>
    
        <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Are you sure for Logout?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <i class="fa-solid fa-face-grin-squint"></i> <i class="fa-solid fa-face-grin-squint"></i> <i class="fa-solid fa-face-grin-squint"></i>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a href="../logout_servlet" type="button" class="btn-danger btn">Logout<a/>
      </div>
    </div>
  </div>
</div>
  </div>
</nav>