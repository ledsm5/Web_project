<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif;}
body, html {
  height: 100%;
  color: #777;
  line-height: 1.8;
 

}

/* Create a Parallax Effect */
.bgimg-1, .bgimg-2, .bgimg-3 {
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

/* First image (Logo. Full height) */
.bgimg-1 {
  background-image: url('images/tores.jpg');
  margin-top: 45px;
  
  min-height: 100%;
}

/* Second image (Portfolio) */
.bgimg-2 {
  background-image: url("/w3images/parallax2.jpg");
  min-height: 400px;
}

/* Third image (Contact) */
.bgimg-3 {
  background-image: url("/w3images/parallax3.jpg");
  min-height: 400px;
}

.w3-wide {letter-spacing: 10px;}
.w3-center w3-black w3-padding-64{
	background-color: black;
}

.table1{
  border-collapse: separate;
  border-spacing: 1px;
  text-align: left;
  line-height: 1.5;
  border-top: none;
  margin : 20px 10px;
  opacity:1;

  }
.td1{
  padding-right: 70px;
  }
.pd-list{
	width:100%;
	height:400px;
	background-image: url("images/campnu.jpg");
	opacity: 0.8;
}
/* Turn off parallax scrolling for tablets and phones */
@media only screen and (max-device-width: 1600px) {
  .bgimg-1, .bgimg-2, .bgimg-3 {
    background-attachment: scroll;
    min-height: 400px;
  }
}
</style>


<script>
function goodsBuy(prodNum){
	if(${authInfo == null}){
		alert("로그인을 하셔야 합니다.");
		return false;
	}else{
		location.href='prodInfo.gd?prodNum='+prodNum;
	}
}

//Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}

/* Change style of navbar on scroll */
window.onscroll = function() {myFunction()};
function myFunction() {
    var navbar = document.getElementById("myNavbar");
    if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
        navbar.className = "w3-bar" + " w3-card" + " w3-animate-top" + " w3-white";
    } else {
        navbar.className = navbar.className.replace(" w3-card w3-animate-top w3-white", "");
    }
}
/* Used to toggle the menu on small screens when clicking on the menu button */
function toggleFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}
</script>

</head>
<body>

  <!-- Navbar on small screens -->
  <!-- <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium">
    <a href="#about" class="w3-bar-item w3-button" onclick="toggleFunction()">ABOUT</a>
    <a href="#portfolio" class="w3-bar-item w3-button" onclick="toggleFunction()">PORTFOLIO</a>
    <a href="#contact" class="w3-bar-item w3-button" onclick="toggleFunction()">CONTACT</a>
    <a href="#" class="w3-bar-item w3-button">SEARCH</a>
   </div> -->
 



<c:if test="${!empty authInfo }">
<!-- 로그인 되었을 때 -->
	<c:if test="${authInfo.grade ==1}">
		<!-- 일반 회원 -->
  		<div class="w3-bar" id="myNavbar">
    		<a class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right" href="javascript:void(0);" onclick="toggleFunction()" title="Toggle Navigation Menu">
      			<i class="fa fa-bars"></i>
   			</a> 		
		<!-- Navbar -->
			<a href="myPage.mem" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-user"></i> 마이페이지</a>
			<a href="goodsCartList.gd" class="w3-bar-item w3-button">장바구니</a>
			<a href="noticeMain.nt" class="w3-bar-item w3-button">공지사항</a>
			<a href="purchaseCon.gd" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-th"></i> 주문확인</a>
			<a href ="logout.sm" class="w3-bar-item w3-button"> 로그아웃 </a>
			<a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-hover-red"> <i class="fa fa-search"></i></a>
		</div>	
		
		
		
		<!-- 중간 제로원온라인 -->
			<div class="bgimg-1 w3-display-container w3-opacity-min" id="home">
 				<div class="w3-display-middle" style="white-space:nowrap;">
    				<span class="w3-center w3-padding-large w3-black w3-xlarge w3-wide w3-animate-opacity">01 <span class="w3-hide-small">online</span>  GAME</span>
  				</div>
			</div>
			
			
			
		<!-- Container (About Section) -->
			<div class="w3-content w3-container w3-padding-64" id="about">
			  <h3 class="w3-center">게임 소개</h3>
			  <p class="w3-center"><em>01 온라인</em></p>
			  <p align="center">본 게임은 실제 축구선수들을 이용해서 자신만의 개성있는 팀을 만드는 게임입니다. 상품으로 등록되어있는 선수들을 구매할수 있고, 구매한 선수는 스쿼드 전광판에서 
			  	자신에게 필요한 포지션에 위치시켜 팀을 완성해보세요. </p><br><br>
			 <div class="w3-row">
			    <div class="w3-col m6 w3-center w3-padding-large">
			      <p><b><i class="fa fa-user w3-margin-right"></i>Today's player</b></p><br>
			      <img src="images/neymar.jpeg" class="w3-round w3-image w3-opacity w3-hover-opacity-off" alt="Photo of Me" width="150" height="100">
			      <img src="images/suarez.jpeg" class="w3-round w3-image w3-opacity w3-hover-opacity-off" alt="Photo of Me" width="200" height="150">
			  </div>	
			  </div>
		 	</div>
			
		<!-- 상품리스트 -->
			<div class="pd-list">
				<table  class="table1">
					<tr>
						<c:forEach items ="${lists }" var="dto" varStatus="cnt">
							<td class="td1">
								<a href="javascript:goodsBuy('${dto.prodNum}')"><img width="200" height="200" src="goods/upload/${dto.prodImage.split(',')[0] }"><br>
								${dto.prodName } <br>
								가격:<fmt:formatNumber value="${dto.prodPrice }" type="currency"/> <br>
								</a>
							</td>
							
							<c:if test="${cnt.count % 3 == 0}">
						</tr>
						<tr>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>	
		<!-- Footer -->
			<footer class="w3-center w3-black w3-padding-64">
				<a href="login.sm" class="w3-button w3-light-grey"><i class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
				<div class="w3-xlarge w3-section">
					<i class="fa fa-facebook-official w3-hover-opacity"></i> 
					<i class="fa fa-instagram w3-hover-opacity"></i>
					<i class="fa fa-snapchat w3-hover-opacity"></i>
					<i class="fa fa-pinterest-p w3-hover-opacity"></i> 
					<i class="fa fa-twitter w3-hover-opacity"></i>
					<a href="https://www.github.com" target="_blank"><img src="images/git2.jpg" width="30" height="30"></a>
				</div>
				<p>
					Developed by <a href="https://www.github.com/ledsm5"
						title="W3.CSS" target="_blank" class="w3-hover-text-green">github.com/ledsm5</a>
				</p>
			</footer>
		</c:if>
	
	
	
	<!-- 직원페이지 시작   -->
	<c:if test="${authInfo.grade !=1 }">
		<!-- 직원 -->
			<a href="goodsList.gd">상품등록</a>
			<a href="myPage.em">마이페이지</a> 
			<a href="noticeMain.nt">공지사항</a>
			<a href ="salesTable.sl">판매현황</a>
			<a href ="logout.sm"> 로그아웃 </a>
			<!-- 관리자 -->
		<c:if test="${authInfo.userId ==111 }">
				<a href="empList.em">직원 리스트</a>
				<a href="memList.mem">회원 리스트</a>
		</c:if>
	</c:if>
</c:if>
</body>
</html>





















<!-- 


 Hide this text on small devices 
    		<div class="w3-col m6 w3-hide-small w3-padding-large">
    		  <p>본 게임은 실제 축구선수들을 이용해서 자신만의 개성있는 팀을 만드는 게임입니다. 상품으로 등록되어있는 선수들을 구매할수 있고, 구매한 선수는 스쿼드 전광판에서 
			  	자신에게 필요한 포지션에 위치시켜 팀을 완성해보세요.</p>
   			 </div>			
   
  
  <p class="w3-large w3-center w3-padding-16">Im really good at:</p>
  <p class="w3-wide"><i class="fa fa-camera"></i>Photography</p>
  <div class="w3-light-grey">
    <div class="w3-container w3-padding-small w3-dark-grey w3-center" style="width:90%">90%</div>
  </div>
  <p class="w3-wide"><i class="fa fa-laptop"></i>Web Design</p>
  <div class="w3-light-grey">
    <div class="w3-container w3-padding-small w3-dark-grey w3-center" style="width:85%">85%</div>
  </div>
  <p class="w3-wide"><i class="fa fa-photo"></i>Photoshop</p>
  <div class="w3-light-grey">
    <div class="w3-container w3-padding-small w3-dark-grey w3-center" style="width:75%">75%</div>
  </div>
</div>

<div class="w3-row w3-center w3-dark-grey w3-padding-16">
  <div class="w3-quarter w3-section">
    <span class="w3-xlarge">14+</span><br>
    Partners
  </div>
  <div class="w3-quarter w3-section">
    <span class="w3-xlarge">55+</span><br>
    Projects Done
  </div>
  <div class="w3-quarter w3-section">
    <span class="w3-xlarge">89+</span><br>
    Happy Clients
  </div>
  <div class="w3-quarter w3-section">
    <span class="w3-xlarge">150+</span><br>
    Meetings
  </div>
</div>

Second Parallax Image with Portfolio Text
<div class="bgimg-2 w3-display-container w3-opacity-min">
  <div class="w3-display-middle">
    <span class="w3-xxlarge w3-text-white w3-wide">PORTFOLIO</span>
  </div>
</div>

Container (Portfolio Section)
<div class="w3-content w3-container w3-padding-64" id="portfolio">
  <h3 class="w3-center">MY WORK</h3>
  <p class="w3-center"><em>Here are some of my latest lorem work ipsum tipsum.<br> Click on the images to make them bigger</em></p><br>

  Responsive Grid. Four columns on tablets, laptops and desktops. Will stack on mobile devices/small screens (100% width)
  <div class="w3-row-padding w3-center">
    <div class="w3-col m3">
      <img src="/w3images/p1.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="The mist over the mountains">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p2.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Coffee beans">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p3.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Bear closeup">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p4.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Quiet ocean">
    </div>
  </div>

  <div class="w3-row-padding w3-center w3-section">
    <div class="w3-col m3">
      <img src="/w3images/p5.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="The mist">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p6.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="My beloved typewriter">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p7.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Empty ghost train">
    </div>

    <div class="w3-col m3">
      <img src="/w3images/p8.jpg" style="width:100%" onclick="onClick(this)" class="w3-hover-opacity" alt="Sailing">
    </div>
    <button class="w3-button w3-padding-large w3-light-grey" style="margin-top:64px">LOAD MORE</button>
  </div>
</div>

Modal for full size images on click
<div id="modal01" class="w3-modal w3-black" onclick="this.style.display='none'">
  <span class="w3-button w3-large w3-black w3-display-topright" title="Close Modal Image"><i class="fa fa-remove"></i></span>
  <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
    <img id="img01" class="w3-image">
    <p id="caption" class="w3-opacity w3-large"></p>
  </div>
</div>

Third Parallax Image with Portfolio Text
<div class="bgimg-3 w3-display-container w3-opacity-min">
  <div class="w3-display-middle">
     <span class="w3-xxlarge w3-text-white w3-wide">CONTACT</span>
  </div>
</div>


Footer
<footer class="w3-center w3-black w3-padding-64 w3-opacity w3-hover-opacity-off">
  <a href="#home" class="w3-button w3-light-grey"><i class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
  <div class="w3-xlarge w3-section">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
  </div>
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></p>
</footer> -->
 



