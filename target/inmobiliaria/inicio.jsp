<!DOCTYPE jsp>
<jsp lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

	<!-- title -->
	<title>Inmobiliaria</title>

	<!-- favicon -->
	<link rel="shortcut icon" type="image/png" href="assets/img/favicon.png">
	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
	<!-- fontawesome -->
	<link rel="stylesheet" href="assets/css/all.min.css">
	<!-- bootstrap -->
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
	<!-- owl carousel -->
	<link rel="stylesheet" href="assets/css/owl.carousel.css">
	<!-- magnific popup -->
	<link rel="stylesheet" href="assets/css/magnific-popup.css">
	<!-- animate css -->
	<link rel="stylesheet" href="assets/css/animate.css">
	<!-- mean menu css -->
	<link rel="stylesheet" href="assets/css/meanmenu.min.css">
	<!-- main style -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- responsive -->
	<link rel="stylesheet" href="assets/css/responsive.css">

	<style>
        .single-product-item {
            text-align: center;
        }

        .single-product-item h2 {
            text-align: center;
        }
    </style>
	
</head>
<body>
	
	<!--PreLoader-->
    <div class="loader">
        <div class="loader-inner">
            <div class="circle"></div>
        </div>
    </div>
    <!--PreLoader Ends-->
	
	<!-- header -->
	<div class="top-header-area" id="sticker">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12 text-center">
					<div class="main-menu-wrap">
						<!-- logo -->
						<div class="site-logo">
							<a href="index.jsp">
								<img src="assets/img/sassari.jpg" alt="">
							</a>
						</div>
						<!-- logo -->

						<!-- menu start -->
						<nav class="main-menu">
							<ul>
								<li class="current-list-item"><a href="#">Home</a>
									<ul class="sub-menu">
										<li><a href="redireccion.jsp">Redireccionar</a></li>

									</ul>
								</li>
								<li><a href="subasta.jsp">Subasta</a></li>
								<li><a href="#">Usuario</a>
									<ul class="sub-menu">
										<li><a href="registro.jsp">Registro</a></li>
									</ul>
								</li>
								<li><a href="news.jsp">Inventario</a>
									<ul class="sub-menu">
										<li><a href="news.jsp">Inventario de Famosos</a></li>
									</ul>
								</li>
								<li>
									<div class="header-icons">
										<a class="shopping-cart" href="cart.jsp"><i class="fas fa-shopping-cart"></i></a>
										<a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
									</div>
								</li>
							</ul>
						</nav>
						<a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
						<div class="mobile-menu"></div>
						<!-- menu end -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end header -->

	<!-- search area -->
	<div class="search-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<span class="close-btn"><i class="fas fa-window-close"></i></span>
					<div class="search-bar">
						<div class="search-bar-tablecell">
							<h3>Search For:</h3>
							<input type="text" placeholder="Keywords">
							<button type="submit">Search <i class="fas fa-search"></i></button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end search arewa -->
	
	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<p>Tu hogar perfecto, nuestro compromiso.</p>
						<h1>Inmobiliaria</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- products -->
	<div class="product-section mt-150 mb-150">
		<div class="container">

			<div class="row">
                <div class="col-md-12">
                    <div class="product-filters">
                        <ul>
                            <li class="active" data-filter="*">Todos</li>
                            <li data-filter=".casa">Casas</li>
                            <li data-filter=".apartamento">Apartamentos</li>
                            <li data-filter=".terreno">Terrenos</li>
                        </ul>
                    </div>
                </div>
            </div>

			<div class="row product-lists">
				<div class="col-lg-4 col-md-6 text-center casa">
					<div class="single-product-item">
						<div class="product-image">
							<a href="single-product.jsp"><img src="assets/img/products/house1.jpg" alt=""></a>
						</div>
						<h3>Residencia RH1</h3>
						<p class="product-price"><span>Residencia Tipo Casa</span> $1.990.000.000COP </p>
						<a href="cart.jsp" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 text-center casa">
					<div class="single-product-item">
						<div class="product-image">
							<a href="single-product.jsp"><img src="assets/img/products/house2.jpg" alt=""></a>
						</div>
						<h3>Residencia RH2</h3>
						<p class="product-price"><span>Residencia Tipo Casa</span> $3.740.112.450COP </p>
						<a href="cart.jsp" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 text-center apartamento">
					<div class="single-product-item">
						<div class="product-image">
							<a href="single-product.jsp"><img src="assets/img/products/apto1.jpg" alt=""></a>
						</div>
						<h3>Apartamento AP1</h3>
						<p class="product-price"><span>Residencia Tipo Apartamento</span> $770.000.000COP </p>
						<a href="cart.jsp" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 text-center apartamento">
					<div class="single-product-item">
						<div class="product-image">
							<a href="single-product.jsp"><img src="assets/img/products/apto2.jpg" alt=""></a>
						</div>
						<h3>Apartamento AP2</h3>
						<p class="product-price"><span>Residencia Tipo Apartamento</span> $1.238.400.000COP </p>
						<a href="cart.jsp" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 text-center terreno">
					<div class="single-product-item">
						<div class="product-image">
							<a href="single-product.jsp"><img src="assets/img/products/terreno2.png" alt=""></a>
						</div>
						<h3>Terreno TR1</h3>
						<p class="product-price"><span>Terreno de 10.000 m^2</span> $8.822.054.399COP </p>
						<a href="cart.jsp" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 text-center terreno">
					<div class="single-product-item">
						<div class="product-image">
							<a href="single-product.jsp"><img src="assets/img/products/terreno1.jpg" alt=""></a>
						</div>
						<h3>Terreno TR2</h3>
						<p class="product-price"><span>Terreno de 40.000 m^2</span> $4.644.000.000COP</p>
						<a href="cart.jsp" class="cart-btn"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
					</div>
				</div>
			</div>
	<!-- end products -->
	
	<!-- jquery -->
	<script src="assets/js/jquery-1.11.3.min.js"></script>
	<!-- bootstrap -->
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- count down -->
	<script src="assets/js/jquery.countdown.js"></script>
	<!-- isotope -->
	<script src="assets/js/jquery.isotope-3.0.6.min.js"></script>
	<!-- waypoints -->
	<script src="assets/js/waypoints.js"></script>
	<!-- owl carousel -->
	<script src="assets/js/owl.carousel.min.js"></script>
	<!-- magnific popup -->
	<script src="assets/js/jquery.magnific-popup.min.js"></script>
	<!-- mean menu -->
	<script src="assets/js/jquery.meanmenu.min.js"></script>
	<!-- sticker js -->
	<script src="assets/js/sticker.js"></script>
	<!-- main js -->
	<script src="assets/js/main.js"></script>

</body>
</jsp>