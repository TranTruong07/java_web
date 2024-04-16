<nav class="navbar navbar-expand-lg text-white bg-dark sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand text-white" href="Home">BookStore</a>
        <div style="width: 400px" class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active text-white" aria-current="page" href="Home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="add">Add Book</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="myBook">My Book</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Category
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        
                        <%List<Category> listc = (List<Category>) request.getAttribute("listc");%>
                        <%if(listc != null){
                            for(Category c: listc){
                            %>
                            <li><a class="dropdown-item" href="getProductByCategory?id=<%=c.getId()%>"><%=c.getName()%></a></li>
                            <%
                        }
                        }%>
                    </ul>
                </li>
                
            </ul>

        </div>
        <div class=" me-5 pe-5" >
            <form action="search" method="get" class="d-flex me-5 ">
                <%String search = (String)request.getAttribute("search");%>
                <input required value="<%=search==null?"":search%>" name="search" class="form-control me-2" type="search" placeholder="Find name or author..." aria-label="Search">
                <button class="btn btn-secondary " type="submit">Search</button>
            </form>
        </div>
        
        <%User u = (User)session.getAttribute("user");%>
        <%if(u == null){
        %>
            <div class="ms-5 ps-5">
            <form class="form-inline my-2 my-lg-0">
                <a href="login" class="btn btn-outline-success "><i class="fa-solid fa-user"></i> Login<a/>
                <a href="register" class="btn btn-outline-primary mr-3 ml-2"><i class="fa-regular fa-user"></i> Register<a/>
            </form>
            </div>
        <%}else{%>
            <form class="form-inline my-2 my-lg-0">
            <a href="#" class="btn btn-outline-success "><%= u.getName()%><a/>
            <a stype="button" class="btn btn-danger mr-3 ml-2" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Logout
            </a>
            </form>

        <%}%>


        
      
    </div>
</nav>

