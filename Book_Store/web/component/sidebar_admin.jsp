<div class="row">
    <div  style="background-color: #171c1b; height: 100vh" class="col-md-2 ">
        <!-- Sidebar -->
        <div class="navbar-nav" >

            <!-- Sidebar - Brand -->
            <a class=" d-flex align-items-center justify-content-center mt-4 mb-4 text-white text-decoration-none fs-4" href="HomeAdmin">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Hello Admin</div>
            </a>

            <hr class="sidebar-divider my-0 text-white">
            <!-- Nav Item - Dashboard -->
            <a class="nav-link ms-3 mt-4 mb-3" href="HomeAdmin">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span>
            </a>
            <hr class="sidebar-divider text-white">


            <a class=" nav-link ms-3 mt-4 mb-1" data-bs-toggle="collapse" href="#collapseExample1" role="button" aria-expanded="false" aria-controls="collapseExample">
                <i class="fa-solid fa-user-gear"></i>
                <span>User Management</span>
            </a>

            <div class="collapse" id="collapseExample1">
                <div class="">
                    <a class="nav-link ms-5" href="UserManagement">
                        <i class="fa-solid fa-users"></i>
                        <span>Users</span> 
                    </a>
                </div>
                <div class="">
                    <a class="nav-link ms-5" href="RoleManagement">
                        <i class="fa-solid fa-circle-user"></i>
                        <span>Role</span> 
                    </a>
                </div>
            </div>


            <hr class="sidebar-divider text-white">


            <a class=" nav-link ms-3 mt-4 mb-1" data-bs-toggle="collapse" href="#collapseExample2" role="button" aria-expanded="false" aria-controls="collapseExample">
                <i class="fa-solid fa-book-bookmark"></i>
                <span>Books Management</span>
            </a>

            <div class="collapse" id="collapseExample2">
                <div class="">
                    <a class="nav-link ms-5" href="BookManagement">
                        <i class="fa-solid fa-book"></i>
                        <span>Book</span> 
                    </a>
                </div>
                <div class="">
                    <a class="nav-link ms-5" href="CategoryManagement">
                        <i class="fa-solid fa-layer-group"></i>
                        <span>Category</span> 
                    </a>
                </div>
            </div>


            <hr class="sidebar-divider text-white">

            <a class=" nav-link ms-3 mt-4 mb-1" data-bs-toggle="collapse" href="#collapseExample3" role="button" aria-expanded="false" aria-controls="collapseExample">
                <i class="fa-solid fa-cart-shopping"></i>
                <span>Orders Management</span>
            </a>

            <div class="collapse" id="collapseExample3">
                <div class="">
                    <a class="nav-link ms-5" href="OrderManagement">
                        <i class="fa-solid fa-cart-arrow-down"></i>
                        <span>Order</span> 
                    </a>
                </div>
                <div class="">
                    <a class="nav-link ms-5" href="OrderDetailsManagement">
                        <i class="fa-solid fa-layer-group"></i>
                        <span>Order Details</span> 
                    </a>
                </div>
            </div>
            <hr class="sidebar-divider d-none d-md-block text-white">

            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </div>
    </div>

    <!-- End of Sidebar -->
