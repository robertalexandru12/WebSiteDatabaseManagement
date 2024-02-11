<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
      <%@ page import="java.util.List" %>
      <%@page import="java.util.ArrayList" %>
      <%@page import="pojo.Clienti" %>
      <%@page import="DAOImpl.ClientiDaoImpl" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="utf-8">
          <meta content="width=device-width, initial-scale=1.0" name="viewport">

          <title>Proiect PIBD</title>
          <meta content="" name="description">
          <meta content="" name="keywords">

          <link href="assets/img/favicon.png" rel="icon">
          <link rel="preconnect" href="https://fonts.googleapis.com">
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
          <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Roboto:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Work+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet">

          <link href="assets/bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet">
          <link href="assets/bootstrap/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
          <link href="assets/bootstrap/fontawesome-free/css/all.min.css" rel="stylesheet">
          <link href="assets/bootstrap/aos/aos.css" rel="stylesheet">
          <link href="assets/bootstrap/glightbox/css/glightbox.min.css" rel="stylesheetc">
          <link href="assets/bootstrap/swiper/swiper-bundle.min.css" rel="stylesheet">


          <link href="assets/css/main.css" rel="stylesheet">
          <link href="assets/css/style_clienti.css" rel="stylesheet">

        </head>

        <body>

          <% ClientiDaoImpl clientDaoImpl=new ClientiDaoImpl(); 
          List<Clienti> listaClienti = new ArrayList();
          listaClienti = clientDaoImpl.afiseazaClienti();
            request.setAttribute("listaClienti", listaClienti);
            %>
          <header id="header" class="header d-flex align-items-center">
            <div class="container-fluid container-xl d-flex align-items-center justify-content-between">

              <a href="index.html" class="logo d-flex align-items-center">

                <h1><span></span></h1>
              </a>

              <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
              <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
              <nav id="navbar" class="navbar">
                <ul>
                  <li><a href="index.html">Pagina Principala</a></li>
                  <li><a class="active" href="Clienti.jsp">Clienti</a></li>
                  <li><a href="Constructori.jsp">Constructori</a></li>
                  <li><a href="Lucrari.jsp">Lucrari</a></li>
                </ul>
              </nav>

            </div>
          </header>

          <section id="hero" class="hero">
            <div class="container">
              <table class="table-scroll small-first-col">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Nume</th>
                    <th>Prenume</th>
                    <th>Adresa</th>
                    <th>Buget</th>
                    <th>Actiune</th>
                  </tr>
                </thead>
                <tbody class="body-half-screen">
                  <c:forEach var="clienti" items="${listaClienti}">
                    <tr>
                      <td>${clienti.idclient}</td>
                      <td>${clienti.nume}</td>
                      <td>${clienti.prenume}</td>
                      <td>${clienti.adresa}</td>
                      <td>${clienti.buget}</td>
                      <td>
                        <button class="deleteButtonClass" name="${clienti.idclient}" onclick="clickDeleteButton(this)">
                          <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="none" viewBox="0 0 24 24"
                            stroke="currentColor" stroke-width="2">
                            <path stroke-linecap="round" stroke-linejoin="round"
                              d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                          </svg>
                        </button>
                        <button class="editButtonClass" name="${clienti.idclient}" onclick="clickEditButton(this)">
                          <img src="assets/img/edit_button.svg" width="25" height="25" alt="Icon">
                        </button>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>

            <div class="signupSection">
              <div class="info2">
                <h2>Adauga lucrari</h2>
                <i class="icon ion-ios-ionic-outline" aria-hidden="true"></i>
                <p>in baza de date</p>
                <p>destinata acestora</p>
              </div>
              <form id="myForm" action="ClientiController" method="POST" class="signupForm" name="signupform"
                onsubmit="return validateForm()">
                <h2></h2>
                <ul class="noBullet">
                  <li>
                    <label for="nume"></label>
                    <input type="text" class="inputFields" id="nume" name="nume" placeholder="Nume" value="">
                  </li>
                  <li>
                    <label for="prenume"></label>
                    <input type="text" class="inputFields" id="prenume" name="prenume" placeholder="Prenume" value="">
                  </li>
                  <li>
                    <label for="adresa"></label>
                    <input type="text" class="inputFields" id="adresa" name="adresa" placeholder="Adresa" value="">
                  </li>
                  <li>
                    <label for="buget"></label>
                    <input type="text" class="inputFields" id="buget" name="buget" placeholder="Buget" value="">
                  </li>
                  <br>
                  <li id="center-btn">
                    <input type="submit" id="ptAdaugat" class="join-btn" name="adaugaClient" alt="Adauga Client"
                      value="Adauga Client">
                  </li>
                </ul>
              </form>
            </div>

            <div id="id01" class="modal">
              <span onclick="closeDeleteModal(this)" class="close" title="Close Modal">×</span>
              <form class="modal-content" action="ClientiController" method="POST">
                <div class="containerModal">
                  <h1>Sterge Client</h1>
                  <p id="textModalConfirmation">Esti sigur ca vrei sa stergi clientul cu id-ul %ID%?</p>

                  <div class="clearfix">
                    <input type="hidden" name="idclient" id="idclient" value="123" />
                    <button id="confirmButton" type="button" onclick="closeDeleteModal(this)"
                      class="cancelbtn">Anuleaza</button>
                    <button id="confirmButton" type="submit" name="stergeClient" class="deletebtn">Sterge</button>
                  </div>
                </div>
              </form>
            </div>
            <!---  Fereastra de edit care ar trebui implementata + adaugat css cu denumirile noi --->
            <div id="id02" class="modal2">
              <span onclick="closeEditModal(this)" class="close2" title="Anuleaza">×</span>
              <form class="modal-content2" action="ClientiController" method="POST">
                <div class="containerModal2">
                  <div class="form">
                    <div class="title">Fereastra de editare</div>
                    <div class="subtitle">
                      <p id="textModalEdit">pentru clientul cu id-ul %ID%</p>
                    </div>
                    <input type="hidden" name="idclientEdit" id="idclientEdit" value="1234" />
                      <label for="numeEdit" ></label>
                      <input id="numeEdit" name="numeEdit" class="input" type="text" placeholder="Nume"/>    

                      <label for="prenumeEdit"></label>
                      <input id="prenumeEdit"  name="prenumeEdit" class="input" type="text" placeholder="Prenume" />

                      <label for="adresaEdit" ></label>
                      <input id="adresaEdit" name="adresaEdit" class="input" type="text" placeholder="Adresa" />

                      <label for="bugetEdit"></label>
                      <input id="bugetEdit" name="bugetEdit" class="input" type="text" placeholder="Buget" />
                      <label> </label>
                    <button type="submit" name="modificaClient" class="submit">Modifica</button>
                  </div>
                </div>
              </form>
            </div>

            <div id="hero-carousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="5000">

              <div class="carousel-item active" style="background-image: url(assets/img/background1.jpg)"></div>
              <div class="carousel-item" style="background-image: url(assets/img/background2.jpg)"></div>
              <div class="carousel-item" style="background-image: url(assets/img/background3.jpg)"></div>
              <div class="carousel-item" style="background-image: url(assets/img/background4.jpg)"></div>
              <div class="carousel-item" style="background-image: url(assets/img/background5.jpg)"></div>

              <a class="carousel-control-prev" href="#hero-carousel" role="button" data-bs-slide="prev">
                <span class="carousel-control-prev-icon bi bi-chevron-left" aria-hidden="true"></span>
              </a>

              <a class="carousel-control-next" href="#hero-carousel" role="button" data-bs-slide="next">
                <span class="carousel-control-next-icon bi bi-chevron-right" aria-hidden="true"></span>
              </a>

            </div>
          </section>


          <script>
            function submitForm() {
              // Adaugă aici codul pentru afișarea datelor

              // Trimite formularul programatic
              document.getElementById('myForm').submit();
            }
            function validateForm() {
              var inputFields = document.querySelectorAll('#myForm input[type="text"]');

              // Verifică dacă toate câmpurile obligatorii au text, dar ignoră butonul pentru afișarea datelor
              for (var i = 0; i < inputFields.length; i++) {
                if (inputFields[i].value.trim() === "" && event.submitter.id !== "ptAfisat") {
                  alert("Completează toate câmpurile obligatorii înainte de a adăuga un client!");
                  return false; // Oprire trimitere formular
                }
              }

              // Continuă cu trimiterea formularului dacă toate câmpurile sunt completate
              return true;
            }
          </script>


          <script>
            //fereastra de DELETE
            var modal = document.getElementById('id01');
            var modal2 = document.getElementById('id02')
            var elementMesaj = document.getElementById("textModalConfirmation");
            var editModalMsg = document.getElementById("textModalEdit")


            var originalMessage = elementMesaj.innerHTML;
            var originalMsgEdit = editModalMsg.innerHTML;

            function clickDeleteButton(button) {
              var btnId = button.name;
              elementMesaj.innerHTML = elementMesaj.innerHTML.replace('%ID%', btnId);
              var modal1 = document.getElementById('id01');
              var idclientInput = document.getElementById("idclient");
              idclientInput.value = btnId;
              modal1.style.display = "block";
            }

            function closeDeleteModal(button) {
              modal.style.display = "none";
              elementMesaj.innerHTML = originalMessage;
            }
            window.onclick = function (event) {                
              if (event.target == modal) {

                elementMesaj.innerHTML = originalMessage;
                modal.style.display = "none";
                
              }
              if(event.target == modal2){
                editModalMsg.innerHTML = originalMsgEdit;
                modal2.style.display="none";
              }
            }

          </script>
          <script>
            //fereastra edit


            function clickEditButton(button) {
              var btnId = button.name;
              editModalMsg.innerHTML = editModalMsg.innerHTML.replace('%ID%',btnId);
              var idclientInput = document.getElementById("idclientEdit");
              idclientInput.value = btnId;
              modal2.style.display = "block";
            }
            function closeEditModal(button) {
              editModalMsg.innerHTML = originalMsgEdit;
              modal2.style.display = "none";
            }
          </script>


          <script src="assets/bootstrap/bootstrap/js/bootstrap.bundle.min.js"></script>
          <script src="assets/bootstrap/aos/aos.js"></script>
          <script src="assets/bootstrap/glightbox/js/glightbox.min.js"></script>
          <script src="assets/bootstrap/swiper/swiper-bundle.min.js"></script>
          <script src="assets/bootstrap/purecounter/purecounter_vanilla.js"></script>

          <script src="assets/js/main.js"></script>
        </body>

        </html>